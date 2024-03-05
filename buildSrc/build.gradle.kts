plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    // Ensure you have the Kotlin standard library if you're using Kotlin
    implementation(kotlin("stdlib"))
    // Add dependencies for Gradle API if necessary
    implementation(gradleApi())
}

// Apply Kotlin DSL plugin
apply<org.gradle.kotlin.dsl.plugins.precompiled.PrecompiledScriptPlugins>()