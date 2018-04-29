import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String by extra { "1.2.41" }
group = "com.wr"
version = "1.0-SNAPSHOT"

plugins {
    java
    kotlin("jvm") version "1.2.41"
}
apply {
    plugin("kotlin")
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8", kotlinVersion))
    testCompile("org.testng:testng:6.9.9")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    "testNg"(Test::class) {
        useTestNG()
    }
}
val test by tasks
test.dependsOn("testNg")

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}