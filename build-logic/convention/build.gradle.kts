plugins {
    `kotlin-dsl`
}

dependencies {
    api(libs.kotlin.gradlePlugin)
    api(libs.android.gradlePlugin)
    gradleApi()
}
