plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("android")
}

android {
    common()
    setUpBuildTypes()
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    common()
    ui()
    navigation()
    dagger()

    testing()

    implementation(project(":core"))
}
