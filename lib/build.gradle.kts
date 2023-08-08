/**
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.2/userguide/building_java_projects.html in the Gradle documentation.
 */

val libVersion = "1.4.0a"

plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    `maven-publish`
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

tasks.jar {
    // set filename
    archiveBaseName.set("jfloatwavio")
    archiveVersion.set(libVersion)
    // set Main-Class
    manifest.attributes["Main-Class"] = "jp.f_matano44.jfloatwavio.WavIO"
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = "jp.f-matano44"
            artifactId = "jfloatwavio"
            version = libVersion
        }
    }

    repositories {
        mavenLocal()
    }
}
