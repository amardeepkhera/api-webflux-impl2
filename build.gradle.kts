plugins {
    kotlin("jvm") version "1.3.61"
    id("java")
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.11"
    id("org.springframework.boot") version "2.2.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
    jacoco
}


jacoco {
    toolVersion = "0.8.3"
}

group = "au.com.spike"
version = "1.0"

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR2")
    }
}

dependencies {

    implementation(kotlin("stdlib-jdk8"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")
}



tasks {

    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
        kotlin.sourceSets["main"].kotlin.srcDir("src/main/generated")
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    wrapper {
        gradleVersion = "5.3"
        distributionUrl = "https://services.gradle.org/distributions/gradle-$gradleVersion-all.zip"
    }
    test {
        useJUnitPlatform()
    }
    jacocoTestReport {
        dependsOn("test")
        reports {
            html.isEnabled = true
            xml.isEnabled = true
            xml.destination = file("$buildDir/reports/jacoco/jacocoTestReport.xml")
        }
    }
}
