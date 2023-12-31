/*
 * This file is generated by jOOQ.
 */
package org.karatetrophy.jooq.tables;


import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.karatetrophy.jooq.KarateTrophy;
import org.karatetrophy.jooq.Keys;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AgeRange extends TableImpl<Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>karate_trophy.age_range</code>
     */
    public static final AgeRange AGE_RANGE = new AgeRange();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>karate_trophy.age_range.Min_age</code>.
     */
    public final TableField<Record, Integer> MIN_AGE = createField(DSL.name("Min_age"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>karate_trophy.age_range.Max_age</code>.
     */
    public final TableField<Record, Integer> MAX_AGE = createField(DSL.name("Max_age"), SQLDataType.INTEGER.nullable(false), this, "");

    private AgeRange(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private AgeRange(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>karate_trophy.age_range</code> table reference
     */
    public AgeRange(String alias) {
        this(DSL.name(alias), AGE_RANGE);
    }

    /**
     * Create an aliased <code>karate_trophy.age_range</code> table reference
     */
    public AgeRange(Name alias) {
        this(alias, AGE_RANGE);
    }

    /**
     * Create a <code>karate_trophy.age_range</code> table reference
     */
    public AgeRange() {
        this(DSL.name("age_range"), null);
    }

    public <O extends Record> AgeRange(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, AGE_RANGE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : KarateTrophy.KARATE_TROPHY;
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_AGE_RANGE_PRIMARY;
    }

    @Override
    public AgeRange as(String alias) {
        return new AgeRange(DSL.name(alias), this);
    }

    @Override
    public AgeRange as(Name alias) {
        return new AgeRange(alias, this);
    }

    @Override
    public AgeRange as(Table<?> alias) {
        return new AgeRange(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public AgeRange rename(String name) {
        return new AgeRange(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AgeRange rename(Name name) {
        return new AgeRange(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public AgeRange rename(Table<?> name) {
        return new AgeRange(name.getQualifiedName(), null);
    }
}
