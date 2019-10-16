// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(Deps.Gradle.gradle)
        classpath(Deps.Kotlin.kotlinGradle)
        classpath(Deps.Navigation.safeArgsGradlePlugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

task( "clean", type = Delete::class) {
    delete = setOf(rootProject.buildDir)
}
