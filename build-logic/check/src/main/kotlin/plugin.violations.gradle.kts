import tasks.LocalViolationTask

plugins {
    id("se.bjurr.violations.violations-gradle-plugin")
}

val outputReportFile = file("$buildDir/reports/violations/code-climate.json")

tasks.register<LocalViolationTask>("violations") {
    codeClimateFile = outputReportFile
    maxViolations = 0
    violations = listOf(
        listOf("SARIF", buildDir.path, ".*/reports/detekt/report.sarif", "sarif"),
    )
}
