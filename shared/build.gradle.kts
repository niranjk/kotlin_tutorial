import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.dokka)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.kotlin.coroutines)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.niranjan.khatri.kotlintutorial"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

tasks.withType<DokkaTask>().configureEach {
    outputDirectory = buildDir.resolve("dokka") // Customize output directory
}