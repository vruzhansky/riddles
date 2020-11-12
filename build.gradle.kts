import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.wr"
version = "1.0-SNAPSHOT"
// versions
val junitVersion = "5.2.0"
val hamcrestVersion = "1.3"

plugins {
    java
    kotlin("jvm") version "1.4.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testImplementation("org.hamcrest:hamcrest-all:$hamcrestVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "12"
    }
}
tasks.withType<Test> {
    useJUnitPlatform()
}
