val coroutinesVersion: String by project
val junitVersion: String by project

plugins {
    java
    application
    kotlin("jvm") version "1.8.0"
}

group = "org.andrew"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation(kotlin("test-junit5"))
}

tasks.test {
    useJUnitPlatform()
    testLogging{
        events("passed", "skipped", "failed")
    }
}

application {
    mainClass.set("MainKt")
    applicationDefaultJvmArgs = listOf("-Dkotlinx.coroutines.debug")
}

configure<JavaPluginExtension> {
    sourceCompatibility = org.gradle.api.JavaVersion.VERSION_11
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}