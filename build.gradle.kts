import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val springVersion = "2.6.3"
	val springDependencyManagementVersion = "1.0.11.RELEASE"
	val kotlinPluginVersion = "1.6.10"

	id("org.springframework.boot") version springVersion
	id("io.spring.dependency-management") version springDependencyManagementVersion
	kotlin("jvm") version kotlinPluginVersion
	kotlin("plugin.spring") version kotlinPluginVersion
	kotlin("plugin.jpa") version kotlinPluginVersion
}

repositories {
	mavenCentral()
}

subprojects {
	val kotestVersion = "5.0.3"
	val kotestSpringExtensionVersion = "1.1.0"
	val mockkVersion = "1.12.1"
	val springmockkVersion = "3.1.0"

	group = "com.yuminkim"
	version = "0.0.1-SNAPSHOT"

	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "kotlin")
	apply(plugin = "kotlin-spring")
	apply(plugin = "kotlin-jpa")

	configurations {
		compileOnly {
			extendsFrom(configurations.annotationProcessor.get())
		}
	}

	repositories {
		mavenCentral()
	}

	dependencies {
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

		implementation("org.springframework.boot:spring-boot-starter")
		annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
		testImplementation("org.springframework.boot:spring-boot-starter-test") {
			exclude(group = "org.junit.jupiter")
			exclude(group = "org.mockito")
		}

		testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
		testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
		testImplementation("io.kotest:kotest-property:$kotestVersion")
		testImplementation("io.kotest.extensions:kotest-extensions-spring:$kotestSpringExtensionVersion")
		testImplementation("com.ninja-squad:springmockk:$springmockkVersion")
		testImplementation("io.mockk:mockk:$mockkVersion")
	}

	java.sourceCompatibility = JavaVersion.VERSION_11

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.bootJar {
		enabled = false
	}

	tasks.jar {
		enabled = false
	}
}
