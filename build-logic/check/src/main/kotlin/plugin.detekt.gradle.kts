import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.report.ReportMergeTask
import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    base
    id("io.gitlab.arturbosch.detekt")
}

val libs = the<LibrariesForLibs>()

dependencies {
    detektPlugins(libs.detekt.formatting)
    detektPlugins(libs.detekt.compose)
}

val configFile = files("$rootDir/.config/detekt/config.yml")
val baselineFile = file(".config/detekt/baseline.xml")
val mergedReportFile = file("${rootProject.buildDir}/reports/detekt/report.sarif")

/**
 * Must be named detekt
 * Workaround for https://github.com/detekt/detekt/issues/4192#issuecomment-946325201
 */
val outputReportFile = file("$buildDir/reports/detekt/detekt.sarif")

detekt {
    ignoreFailures = hasProperty("ignoreFailures")

    parallel = true

    config.setFrom(configFile)
    buildUponDefaultConfig = true
    basePath = rootDir.absolutePath

    baseline = baselineFile.takeUnless { hasProperty("ignoreBaseline") }
}

val reportMerge: TaskProvider<ReportMergeTask> = rootProject.registerMaybe("reportMerge") {
    description = "Runs merge of all detekt reports into single one"
    output.set(mergedReportFile)
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(false)
        md.required.set(false)
        sarif.required.set(true)
        txt.required.set(false)
        xml.required.set(false)
        sarif.outputLocation.set(outputReportFile)
    }
}

plugins.withType<DetektPlugin> {
    tasks.withType<Detekt> {
        finalizedBy(reportMerge)
        reportMerge.configure {
            input.from(sarifReportFile)
        }
    }
}

/**
 * Workaround to get [TaskProvider] by task name if it already exists in given [Project]
 * or register it otherwise
 *
 * [Github - Introduce TaskContainer.maybeNamed](https://github.com/gradle/gradle/issues/8057)
 */
inline fun <reified T : Task> Project.registerMaybe(
    taskName: String,
    configuration: Action<in T> = Action {},
): TaskProvider<T> {
    if (taskName in tasks.names) {
        return tasks.named(taskName, T::class, configuration)
    }
    return tasks.register(taskName, T::class, configuration)
}
