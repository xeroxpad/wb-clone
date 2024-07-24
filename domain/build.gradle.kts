plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
//    testImplementation(libs.mockito.core)
//    testImplementation(libs.mockito.kotlin)

    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
    testImplementation("org.mockito:mockito-core:5.12.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.4.0")
//    testImplementation(libs.junit.jupiter.api)
//    testImplementation(libs.junit.jupiter.engine)
}
