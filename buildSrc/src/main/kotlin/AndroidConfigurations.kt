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

fun BaseExtension.app() {
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

    testImplementation(Deps.Testing.jUnit)
    testImplementation(Deps.Testing.testRunner)
    testImplementation(Deps.Testing.espresso)
}

fun DependencyHandler.app() {
    implementation(Deps.AndroidX.constraintLayout)

    // Dagger
    implementation(Deps.Dagger.dagger)
    kapt(Deps.Dagger.daggerCompiler)
}

fun DependencyHandler.navigation() {
    implementation(Deps.Navigation.navigationFragment)
    implementation(Deps.Navigation.navigationUi)
}