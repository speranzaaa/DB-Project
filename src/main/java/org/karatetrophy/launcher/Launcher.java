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
    public static void main(String[] args) {

        Start.main(args);
    }
}
