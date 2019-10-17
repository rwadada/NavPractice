plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
    kotlin("android")
}

android {
    ui()
    setUpBuildTypes()
    setUpDataBinding()
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    common()
    ui()
    navigation()
    dagger()

    testing()

    implementation(project(":core"))
    implementation(project(":feature:main"))
    implementation(project(":feature:sub"))
}
