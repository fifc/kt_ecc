import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val gradle_version = "6.8-milestone-3"

buildscript {
	extra.apply {
		set("kotlinVersion", "1.4.20")
	}
	repositories {
		mavenCentral()
		maven { url = uri("https://repo.spring.io/snapshot") }
		maven { url = uri("https://repo.spring.io/milestone") }
	}
	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${property("kotlinVersion")}")
		classpath("org.jetbrains.kotlin:kotlin-allopen:${property("kotlinVersion")}")
	}
}

plugins {
	application
	kotlin("jvm") version "${property("kotlinVersion")}"
}

group = "com.my"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_15

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "15"
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/snapshot") }
	maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
	implementation("com.google.guava:guava:+")
	implementation("org.bouncycastle:bcprov-jdk15on:+")
	implementation("org.bouncycastle:bcpkix-jdk15on:+")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
}

defaultTasks = listOf("run")
application.mainClassName = "com.my.ecc.MainKt"

tasks.wrapper {
    gradleVersion = gradle_version
    distributionType = Wrapper.DistributionType.ALL
}
