@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("com.zet.android.base")
}

val lintConfigFile = file("$rootDir/.config/lint/config.xml")

android {
    lint {
        checkReleaseBuilds = true
        checkDependencies = true
        abortOnError = false

        lintConfig = lintConfigFile
    }
}
