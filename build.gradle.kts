import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String by extra { "1.2.40" }
group = "com.wr"
version = "1.0-SNAPSHOT"

buildscript {

    val kotlinVersion: String by extra { "1.2.40" }
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
    }
}

plugins {
    java
    kotlin("jvm") version "1.2.40"
}
apply {
    plugin("kotlin")
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8", kotlinVersion))
    testCompile("junit", "junit", "4.12")
    testCompile("org.testng", "testng", "6.9.9")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}