import nu.studer.gradle.jooq.JooqEdition
import org.jooq.meta.jaxb.Logging
import org.jooq.meta.jaxb.Property
import org.jooq.meta.jaxb.ForcedType

plugins {
    id("nu.studer.jooq") version "8.2"
    id("java")
    id("org.openjfx.javafxplugin") version "0.0.14"

}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("mysql:mysql-connector-java:8.0.28")
    jooqGenerator("mysql:mysql-connector-java:8.0.28")
    implementation ("org.openjfx:javafx-controls:17")
    implementation("org.openjfx:javafx-fxml:17")
}

javafx {
    version = "17"
    modules("javafx.base", "javafx.controls", "javafx.fxml", "javafx.graphics")
}

jooq {
    version.set("3.18.4")
    edition.set(JooqEdition.OSS)

    configurations {
        create("main") {
            jooqConfiguration.apply {
                logging = Logging.WARN
                jdbc.apply {
                    driver = "com.mysql.cj.jdbc.Driver"
                    url = "jdbc:mysql://localhost:3306/karate_trophy"
                    user = "root"
                    password = "t0mn00k@c118"
                }
                generator.apply {
                    name = "org.jooq.codegen.DefaultGenerator"
                    database.apply {
                        name = "org.jooq.meta.mysql.MySQLDatabase"
                        inputSchema = "karate_trophy"
                        forcedTypes = listOf(
                                ForcedType().apply {
                                    name = "varchar"
                                    includeExpression = ".*"
                                    includeTypes = "JSONB?"
                                },
                                ForcedType().apply {
                                    name = "varchar"
                                    includeExpression = ".*"
                                    includeTypes = "INET"
                                }
                        )
                    }
                    generate.apply {
                        isDeprecated = false
                        isRecords = false
                        isImmutablePojos = false
                        isFluentSetters = false
                    }
                    target.apply {
                        packageName = "org.karatetrophy.jooq"
                        directory = "src/main/jooq"
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}
