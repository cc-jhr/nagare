plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    `java-library` // Apply the java-library plugin for API and implementation separation.
    id("org.jetbrains.dokka") version "1.6.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(kotlin("bom")))
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation(kotlin("test"))
    implementation(kotlin("test-annotations-common"))

    testImplementation(kotlin("test-testng"))
    testImplementation("org.testng:testng:7.5")
}

tasks.withType<Test> {
    useTestNG()
    maxParallelForks = Runtime.getRuntime().availableProcessors()
}

tasks.dokkaHtml.configure {
    outputDirectory.set(buildDir.resolve("dokka"))
    dokkaSourceSets {
        configureEach {
            samples.from(
                "src/samples/kotlin/AnySamples.kt",
                "src/samples/kotlin/CharSequenceSamples.kt",
                "src/samples/kotlin/CollectionSamples.kt",
                "src/samples/kotlin/IntSamples.kt",
                "src/samples/kotlin/ThrowableSamples.kt",
            )
        }
    }
}