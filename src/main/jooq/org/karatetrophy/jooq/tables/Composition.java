/*
 * This file is generated by jOOQ.
 */
package org.karatetrophy.jooq.tables;


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
public class Composition extends TableImpl<Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>karate_trophy.composition</code>
     */
    public static final Composition COMPOSITION = new Composition();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>karate_trophy.composition.Committee</code>.
     */
    public final TableField<Record, String> COMMITTEE = createField(DSL.name("Committee"), SQLDataType.CHAR(50).nullable(false), this, "");

    /**
     * The column <code>karate_trophy.composition.Referee</code>.
     */
    public final TableField<Record, String> REFEREE = createField(DSL.name("Referee"), SQLDataType.CHAR(50).nullable(false), this, "");

    private Composition(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Composition(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>karate_trophy.composition</code> table reference
     */
    public Composition(String alias) {
        this(DSL.name(alias), COMPOSITION);
    }

    /**
     * Create an aliased <code>karate_trophy.composition</code> table reference
     */
    public Composition(Name alias) {
        this(alias, COMPOSITION);
    }

    /**
     * Create a <code>karate_trophy.composition</code> table reference
     */
    public Composition() {
        this(DSL.name("composition"), null);
    }

    public <O extends Record> Composition(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, COMPOSITION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : KarateTrophy.KARATE_TROPHY;
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_COMPOSITION_PRIMARY;
    }

    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.asList(Keys.FKCOM_TEN, Keys.FKCOM_REF);
    }

    private transient TenderCommittee _tenderCommittee;
    private transient Referee _referee;

    /**
     * Get the implicit join path to the
     * <code>karate_trophy.tender_committee</code> table.
     */
    public TenderCommittee tenderCommittee() {
        if (_tenderCommittee == null)
            _tenderCommittee = new TenderCommittee(this, Keys.FKCOM_TEN);

        return _tenderCommittee;
    }

    /**
     * Get the implicit join path to the <code>karate_trophy.referee</code>
     * table.
     */
    public Referee referee() {
        if (_referee == null)
            _referee = new Referee(this, Keys.FKCOM_REF);

        return _referee;
    }

    @Override
    public Composition as(String alias) {
        return new Composition(DSL.name(alias), this);
    }

    @Override
    public Composition as(Name alias) {
        return new Composition(alias, this);
    }

    @Override
    public Composition as(Table<?> alias) {
        return new Composition(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Composition rename(String name) {
        return new Composition(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Composition rename(Name name) {
        return new Composition(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Composition rename(Table<?> name) {
        return new Composition(name.getQualifiedName(), null);
    }
}
