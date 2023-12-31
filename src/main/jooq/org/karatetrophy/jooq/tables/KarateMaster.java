/*
 * This file is generated by jOOQ.
 */
package org.karatetrophy.jooq.tables;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
public class KarateMaster extends TableImpl<Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>karate_trophy.karate_master</code>
     */
    public static final KarateMaster KARATE_MASTER = new KarateMaster();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>karate_trophy.karate_master.Gender</code>.
     */
    public final TableField<Record, String> GENDER = createField(DSL.name("Gender"), SQLDataType.CHAR(50).nullable(false), this, "");

    /**
     * The column <code>karate_trophy.karate_master.Surname</code>.
     */
    public final TableField<Record, String> SURNAME = createField(DSL.name("Surname"), SQLDataType.CHAR(50).nullable(false), this, "");

    /**
     * The column <code>karate_trophy.karate_master.Date_of_birth</code>.
     */
    public final TableField<Record, LocalDate> DATE_OF_BIRTH = createField(DSL.name("Date_of_birth"), SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>karate_trophy.karate_master.Name</code>.
     */
    public final TableField<Record, String> NAME = createField(DSL.name("Name"), SQLDataType.CHAR(50).nullable(false), this, "");

    /**
     * The column <code>karate_trophy.karate_master.Fiscal_Code</code>.
     */
    public final TableField<Record, String> FISCAL_CODE = createField(DSL.name("Fiscal_Code"), SQLDataType.CHAR(50).nullable(false), this, "");

    /**
     * The column <code>karate_trophy.karate_master.Dojo_Address</code>.
     */
    public final TableField<Record, String> DOJO_ADDRESS = createField(DSL.name("Dojo_Address"), SQLDataType.CHAR(50).nullable(false), this, "");

    /**
     * The column <code>karate_trophy.karate_master.Dojo_Name</code>.
     */
    public final TableField<Record, String> DOJO_NAME = createField(DSL.name("Dojo_Name"), SQLDataType.CHAR(50).nullable(false), this, "");

    private KarateMaster(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private KarateMaster(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>karate_trophy.karate_master</code> table
     * reference
     */
    public KarateMaster(String alias) {
        this(DSL.name(alias), KARATE_MASTER);
    }

    /**
     * Create an aliased <code>karate_trophy.karate_master</code> table
     * reference
     */
    public KarateMaster(Name alias) {
        this(alias, KARATE_MASTER);
    }

    /**
     * Create a <code>karate_trophy.karate_master</code> table reference
     */
    public KarateMaster() {
        this(DSL.name("karate_master"), null);
    }

    public <O extends Record> KarateMaster(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, KARATE_MASTER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : KarateTrophy.KARATE_TROPHY;
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_KARATE_MASTER_PRIMARY;
    }

    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.asList(Keys.FKDOJO_ADDRESS);
    }

    private transient Dojo _dojo;

    /**
     * Get the implicit join path to the <code>karate_trophy.dojo</code> table.
     */
    public Dojo dojo() {
        if (_dojo == null)
            _dojo = new Dojo(this, Keys.FKDOJO_ADDRESS);

        return _dojo;
    }

    @Override
    public KarateMaster as(String alias) {
        return new KarateMaster(DSL.name(alias), this);
    }

    @Override
    public KarateMaster as(Name alias) {
        return new KarateMaster(alias, this);
    }

    @Override
    public KarateMaster as(Table<?> alias) {
        return new KarateMaster(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public KarateMaster rename(String name) {
        return new KarateMaster(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public KarateMaster rename(Name name) {
        return new KarateMaster(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public KarateMaster rename(Table<?> name) {
        return new KarateMaster(name.getQualifiedName(), null);
    }
}
