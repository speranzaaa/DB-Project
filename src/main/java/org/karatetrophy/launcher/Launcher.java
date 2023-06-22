package org.karatetrophy.launcher;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.karatetrophy.jooq.tables.AgeRange;
import org.karatetrophy.jooq.tables.Karateka;

import java.sql.*;

import static org.jooq.impl.DSL.field;

public class Launcher {
    private Launcher() {}
    public static String userName = "root";
    public static String password = "t0mn00k@c118";
    public static String url = "jdbc:mysql://localhost:3306/karate_trophy";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);


            Table<? extends Record> AgeRange = new AgeRange();
            create.insertInto(AgeRange, field("min_age"), field("max_age"))
                    .values(10, 15)
                    .execute();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        Start.main(args);
    }
}
