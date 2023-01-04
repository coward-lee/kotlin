plugins {
    java
    kotlin("jvm") version "1.8.0" //kotlin version to use
}



repositories {
    maven { url = uri("https://maven.aliyun.com/repository/public") }
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.0")

    implementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")

}