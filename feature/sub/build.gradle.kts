plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    kotlin("android")
}

android {
    common()
    setUpBuildTypes()
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    common()
    app()
    navigation()

    testing()

    implementation(project(":core"))
}
