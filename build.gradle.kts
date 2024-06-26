plugins {
    id("java")
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "org.store.booking"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

//configurations {
//    create("compileOnly") {
//        extendsFrom(configurations.getByName("annotationProcessor"))
//    }
//}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("io.springfox:springfox-swagger-ui:3.0.0")
    compileOnly("org.projectlombok:lombok")
    implementation("mysql:mysql-connector-java")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}