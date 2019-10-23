object Versions {
    const val compileSdkVersion = 29
    const val minSdkVersion = 21
    const val targetSdkVersion = 29

    const val versionCode = 1
    const val versionName = "1.0.0"

    const val androidxVersion = "1.1.0"

    const val kotlinVersion = "1.3.50"
    const val gradleVersion = "3.5.0"

    const val espressoVersion = "3.2.0"
    const val androidxTestVersion = "1.2.0"
    const val junitVersion = "4.12"

    const val constraintVersion = "1.1.3"

    const val daggerVersion = "2.25.2"

    const val navVersion = "2.1.0"
}

object Deps {
    object Kotlin {
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    }
    object Gradle {
        const val gradle = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    }
    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.androidxVersion}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.androidxVersion}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintVersion}"
    }
    object Dagger {
        const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
        const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerVersion}"
        const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
        const val daggerAndroidProcesser = "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"
    }
    object Testing {
        const val jUnit = "junit:junit:${Versions.junitVersion}"
        const val testRunner = "androidx.test:runner:${Versions.androidxTestVersion}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
        const val coreTesting = "android.arch.core:core-testing:${Versions.androidxTestVersion}"
    }
    object Navigation {
        const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navVersion}"
        const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navVersion}"
        const val safeArgsGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navVersion}"
    }
}