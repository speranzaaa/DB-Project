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
public class Competition extends TableImpl<Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>karate_trophy.competition</code>
     */
    public static final Competition COMPETITION = new Competition();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>karate_trophy.competition.Competition_Name</code>.
     */
    public final TableField<Record, String> COMPETITION_NAME = createField(DSL.name("Competition_Name"), SQLDataType.CHAR(50).nullable(false), this, "");

    /**
     * The column <code>karate_trophy.competition.Start_date</code>.
     */
    public final TableField<Record, LocalDate> START_DATE = createField(DSL.name("Start_date"), SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>karate_trophy.competition.City</code>.
     */
    public final TableField<Record, String> CITY = createField(DSL.name("City"), SQLDataType.CHAR(50).nullable(false), this, "");

    /**
     * The column <code>karate_trophy.competition.Tournament_Name</code>.
     */
    public final TableField<Record, String> TOURNAMENT_NAME = createField(DSL.name("Tournament_Name"), SQLDataType.CHAR(50).nullable(false), this, "");

    /**
     * The column <code>karate_trophy.competition.Day</code>.
     */
    public final TableField<Record, LocalDate> DAY = createField(DSL.name("Day"), SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>karate_trophy.competition.Competition_type</code>.
     */
    public final TableField<Record, String> COMPETITION_TYPE = createField(DSL.name("Competition_type"), SQLDataType.CHAR(50).nullable(false), this, "");

    /**
     * The column <code>karate_trophy.competition.Start_Time</code>.
     */
    public final TableField<Record, Integer> START_TIME = createField(DSL.name("Start_Time"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>karate_trophy.competition.End_Time</code>.
     */
    public final TableField<Record, Integer> END_TIME = createField(DSL.name("End_Time"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>karate_trophy.competition.Poule_Number</code>.
     */
    public final TableField<Record, Integer> POULE_NUMBER = createField(DSL.name("Poule_Number"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>karate_trophy.competition.Age_Range</code>.
     */
    public final TableField<Record, Integer> AGE_RANGE = createField(DSL.name("Age_Range"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>karate_trophy.competition.Level_Range</code>.
     */
    public final TableField<Record, String> LEVEL_RANGE = createField(DSL.name("Level_Range"), SQLDataType.CHAR(50).nullable(false), this, "");

    /**
     * The column <code>karate_trophy.competition.Weight_Range</code>.
     */
    public final TableField<Record, Integer> WEIGHT_RANGE = createField(DSL.name("Weight_Range"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>karate_trophy.competition.ID_Committee</code>.
     */
    public final TableField<Record, String> ID_COMMITTEE = createField(DSL.name("ID_Committee"), SQLDataType.CHAR(50).nullable(false), this, "");

    private Competition(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Competition(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>karate_trophy.competition</code> table reference
     */
    public Competition(String alias) {
        this(DSL.name(alias), COMPETITION);
    }

    /**
     * Create an aliased <code>karate_trophy.competition</code> table reference
     */
    public Competition(Name alias) {
        this(alias, COMPETITION);
    }

    /**
     * Create a <code>karate_trophy.competition</code> table reference
     */
    public Competition() {
        this(DSL.name("competition"), null);
    }

    public <O extends Record> Competition(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, COMPETITION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : KarateTrophy.KARATE_TROPHY;
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_COMPETITION_PRIMARY;
    }

    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.asList(Keys.FKEXECUTION, Keys.FKR, Keys.FKR_1, Keys.FKR_2, Keys.FKJURY);
    }

    private transient CompetitonDay _competitonDay;
    private transient AgeRange _ageRange;
    private transient BeltRange _beltRange;
    private transient WeightRange _weightRange;
    private transient TenderCommittee _tenderCommittee;

    /**
     * Get the implicit join path to the
     * <code>karate_trophy.competiton_day</code> table.
     */
    public CompetitonDay competitonDay() {
        if (_competitonDay == null)
            _competitonDay = new CompetitonDay(this, Keys.FKEXECUTION);

        return _competitonDay;
    }

    /**
     * Get the implicit join path to the <code>karate_trophy.age_range</code>
     * table.
     */
    public AgeRange ageRange() {
        if (_ageRange == null)
            _ageRange = new AgeRange(this, Keys.FKR);

        return _ageRange;
    }

    /**
     * Get the implicit join path to the <code>karate_trophy.belt_range</code>
     * table.
     */
    public BeltRange beltRange() {
        if (_beltRange == null)
            _beltRange = new BeltRange(this, Keys.FKR_1);

        return _beltRange;
    }

    /**
     * Get the implicit join path to the <code>karate_trophy.weight_range</code>
     * table.
     */
    public WeightRange weightRange() {
        if (_weightRange == null)
            _weightRange = new WeightRange(this, Keys.FKR_2);

        return _weightRange;
    }

    /**
     * Get the implicit join path to the
     * <code>karate_trophy.tender_committee</code> table.
     */
    public TenderCommittee tenderCommittee() {
        if (_tenderCommittee == null)
            _tenderCommittee = new TenderCommittee(this, Keys.FKJURY);

        return _tenderCommittee;
    }

    @Override
    public Competition as(String alias) {
        return new Competition(DSL.name(alias), this);
    }

    @Override
    public Competition as(Name alias) {
        return new Competition(alias, this);
    }

    @Override
    public Competition as(Table<?> alias) {
        return new Competition(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Competition rename(String name) {
        return new Competition(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Competition rename(Name name) {
        return new Competition(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Competition rename(Table<?> name) {
        return new Competition(name.getQualifiedName(), null);
    }
}
