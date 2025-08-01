// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    id("org.jlleitschuh.gradle.ktlint") version "13.0.0" apply false
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

// Конфигурация репозиториев для всех проектов
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

// Конфигурация репозиториев для buildscript
buildscript {
    repositories {
        google()
        mavenCentral()
    }
}