# DB-Project

This is a Java project for the Database course. 
Is is a simple application that allows the user to connect to a local MySQL database and manage it with a simple GUI. The program is written in Java and uses the JavaFX library for the GUI. The database is a MySQL database and the connection is made using JOOQ, a library that allows the user to write SQL queries in a simplified language in Java style. 
To correctly run the app, JOOQ need to be installed; then, with the Gradle build (follow the configurations I made in the build.gradle.kts file), the project can be built (the db tables are translated into Java classes) and run.