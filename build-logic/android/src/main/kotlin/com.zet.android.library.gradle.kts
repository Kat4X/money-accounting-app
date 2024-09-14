plugins {
    id("com.android.library")
    id("com.zet.android.base")
}

android {
    lint {
        checkReleaseBuilds = false
    }
    packaging {
        resources {
            excludes.add("META-INF/AL2.0")
            excludes.add("META-INF/LGPL2.1")
        }
    }
}
