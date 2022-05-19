plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    `java-library` // Apply the java-library plugin for API and implementation separation.
    `maven-publish`
    id("org.jetbrains.dokka") version "1.6.21"
}

val githubUsername by extra { System.getenv("GH_USERNAME") ?: project.findProperty("GH_USERNAME") as String? ?: "cc-jhr" }
val githubReleaseToken by extra { System.getenv("GH_PACKAGES_RELEASE_TOKEN") ?: project.findProperty("GH_PACKAGES_RELEASE_TOKEN") as String? ?: "NOT_SET" }

group = "io.github.ccjhr"
version = project.findProperty("release.version") as String? ?: ""

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
    testImplementation("org.testng:testng:7.6.0")
}

tasks.withType<Test> {
    useTestNG()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17"
    }
}

tasks.dokkaHtml.configure {
    moduleName.set("${rootProject.name} $version")
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

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

val javaDoc by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
    from(sourceSets.main.get().allSource)
}

publishing {
    repositories {
        maven {
            name = rootProject.name
            url = uri("https://maven.pkg.github.com/$githubUsername/${rootProject.name}")
            credentials {
                username = githubUsername
                password = githubReleaseToken
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = rootProject.name
            version = project.version.toString()

            from(components["java"])
            artifact(sourcesJar.get())
            artifact(javaDoc.get())

            pom {
                packaging = "jar"
                name.set(rootProject.name)
                description.set("This is an assertion/matcher library for kotlin using infix functions.")
                url.set("https://github.com/$githubUsername/${rootProject.name}")

                licenses {
                    license {
                        name.set("Apache-2.0 License")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0")
                    }
                }

                scm {
                    connection.set("scm:git@github.com:$githubUsername/${rootProject.name}.git")
                    developerConnection.set("scm:git:ssh://github.com:$githubUsername/${rootProject.name}.git")
                    url.set("https://github.com/$githubUsername/${rootProject.name}")
                }
            }
        }
    }
}