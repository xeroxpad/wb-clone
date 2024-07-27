plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.koin.core)
//    implementation(libs.koin.android)
//    implementation(libs.koin.compose)
//    implementation(libs.koin.navigation)
    implementation(platform(libs.koin.bom))
    testImplementation(libs.junit)
}
