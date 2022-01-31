dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.flywaydb:flyway-core")
    runtimeOnly("com.h2database:h2")

    implementation(project(":mole-provision"))
    implementation(project(":mole-deploy"))
}

tasks.bootJar {
    enabled = true
}
