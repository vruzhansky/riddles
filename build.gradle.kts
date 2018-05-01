import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.wr"
version = "1.0-SNAPSHOT"

// versions
val kotlinVersion = "1.2.41"
val junitVersion = "5.2.0"
val hamcrestVersion = "1.3"

plugins {
    java
    kotlin("jvm") version "1.2.41"
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

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

task<Wrapper>("wrapper") {
    gradleVersion = "4.7"
    distributionUrl = "https://services.gradle.org/distributions/gradle-$gradleVersion-all.zip"
}