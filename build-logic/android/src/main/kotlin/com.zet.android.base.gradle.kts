import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("kotlin-android")
}

configure<BaseExtension> {
    compileSdkVersion(34)

    defaultConfig {
        minSdk = 29
        targetSdk = 34

        vectorDrawables.useSupportLibrary = true
    }

    with(buildFeatures) {
        buildConfig = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "19"
    }
}
