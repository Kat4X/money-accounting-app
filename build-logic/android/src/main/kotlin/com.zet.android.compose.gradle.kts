import com.android.build.gradle.BaseExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import utils.implementation

val libs = the<LibrariesForLibs>()

configure<BaseExtension> {
    with(buildFeatures) {
        compose = true
    }
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        freeCompilerArgs.set(
            listOf(
                "-Xopt-in=androidx.compose.material3.ExperimentalMaterial3Api",
                "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi",
                "-Xopt-in=androidx.compose.foundation.layout.ExperimentalLayoutApi",
                "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi",
                "-Xopt-in=androidx.lifecycle.compose.ExperimentalLifecycleComposeApi",
            ) + freeCompilerArgs.get()
        )
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
}
