plugins {
    `kotlin-dsl`
}

group = "com.zet.buildlogic"

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}

dependencies {
    implementation(libs.detekt.gradlePlugin)
    implementation(libs.violations.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)

    // Workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
