import com.android.build.gradle.BaseExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import java.io.File

fun BaseExtension.common() {
    compileSdkVersion(Versions.compileSdkVersion)
    defaultConfig {
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
}

fun BaseExtension.ui() {
    compileSdkVersion(Versions.compileSdkVersion)
    defaultConfig {
        applicationId = "com.rwadada.navpractice"
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

fun BaseExtension.setUpBuildTypes() {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                File("proguard-rules.pro")
            )
        }
    }
}

fun BaseExtension.setUpDataBinding() {
    dataBinding {
        isEnabled = true
    }
}

fun DependencyHandler.implementation(dependency: Any) {
    add("implementation", dependency)
}

fun DependencyHandler.testImplementation(dependency: Any) {
    add("testImplementation", dependency)
}

fun DependencyHandler.kapt(dependency: Any) {
    add("kapt", dependency)
}

fun DependencyHandler.common() {
    implementation(Deps.Kotlin.kotlinStdlib)
    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.AndroidX.coreKtx)
}

fun DependencyHandler.ui() {
    implementation(Deps.AndroidX.constraintLayout)
}

fun DependencyHandler.dagger() {
    implementation(Deps.Dagger.dagger)
    kapt(Deps.Dagger.daggerCompiler)
    implementation(Deps.Dagger.daggerAndroid)
    implementation(Deps.Dagger.daggerAndroidSupport)
    kapt(Deps.Dagger.daggerAndroidProcessor)
}

fun DependencyHandler.navigation() {
    implementation(Deps.Navigation.navigationFragment)
    implementation(Deps.Navigation.navigationUi)
}

fun DependencyHandler.testing() {
    testImplementation(Deps.Testing.jUnit)
    testImplementation(Deps.Testing.coreTesting)

    add("androidTestImplementation", Deps.Testing.coreTesting)
    add("androidTestImplementation", Deps.Testing.testRunner)
    add("androidTestImplementation", Deps.Testing.espresso)
}