plugins {
    kotlin("jvm") version "1.5.0"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    `maven-publish`
}

group = properties["group"]!!
version = properties["version"]!!

repositories {
    jcenter()
    maven("https://jitpack.io")
}

val shade = configurations.create("shade")
shade.extendsFrom(configurations.implementation.get())
tasks {

    javadoc {
        options.encoding = "UTF-8"
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "16"
    }

    create<Jar>("sourceJar") {
        archiveClassifier.set("source")
        from(sourceSets["main"].allSource)
    }

    jar {
        from (shade.map { if (it.isDirectory) it else zipTree(it) })
    }

    // From monun/tap-sample-plugin
    create<Copy>("copyToServer") {
        from(jar)
        val plugins = File(rootDir, ".server/plugins")
        if (File(shade.artifacts.files.asPath).exists()) {
            into(File(plugins, "update"))
        } else {
            into(plugins)
        }
    }
}
