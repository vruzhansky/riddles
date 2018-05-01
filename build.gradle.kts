import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// versions
val kotlinVersion = "1.2.41"
val junitVersion = "5.2.0"
val hamcrestVersion = "1.3"

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
    compile(kotlin("stdlib-jdk8:$kotlinVersion"))
    testCompile("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testCompile("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testCompile("org.hamcrest:hamcrest-all:$hamcrestVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val test: Test by tasks
test.useJUnitPlatform()

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}