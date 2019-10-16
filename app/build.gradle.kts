plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    kotlin("android")
}

android {
    app()
    setUpBuildTypes()
    setUpDataBinding()
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    common()
    app()
    navigation()

    implementation(project(":core"))
    implementation(project(":feature_main"))
    implementation(project(":feature_sub"))
}
