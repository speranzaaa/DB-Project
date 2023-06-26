-- *********************************************
-- * SQL MySQL generation                      
-- *--------------------------------------------
-- * DB-MAIN version: 11.0.2              
-- * Generator date: Sep 14 2021              
-- * Generation date: Sun Jun 18 16:36:06 2023 
-- * LUN file: C:\Users\asper\Documents\uni\2.2\database\db project\DB Project - Rel - Copia.lun 
-- * Schema: Karate trophy/1 
-- ********************************************* 


-- Database Section
-- ________________ 

create database Karate_trophy;
use Karate_trophy;


-- Tables Section
-- _____________ 

create table AGE_RANGE (
     Min_age int not null,
     Max_age int not null,
     constraint IDAGE_RANGE primary key (Min_age));

create table BELT_RANGE (
     Min_level char(50) not null,
     Max_level char(50) not null,
     constraint IDBELT_RANGE primary key (Min_level));

create table CHALLENGE (
     Winner char not null,
     Start_date date not null,
     City char(50) not null,
     Name char(50) not null,
     Day date not null,
     Start_Time int not null,
     Poule_Number int not null,
     Karateka char(50) not null,
     constraint IDCOMPETITOR primary key (Start_date, City, Name, Day, Start_Time, Poule_Number, Karateka));

create table COMPETITION (
     Competition_Name char(50) not null,
     Start_date date not null,
     City char(50) not null,
     Tournament_Name char(50) not null,
     Day date not null,
     Competition_type char(50) not null,
     Start_Time int not null,
     End_Time int not null,
     Poule_Number int not null,
     Age_Range int not null,
     Level_Range char(50) not null,
     Weight_Range int,
     ID_Committee char(50) not null,
     constraint IDCOMPETITION_ID primary key (Start_date, City, Tournament_Name, Day, Start_Time, Poule_Number));

create table COMPETITON_DAY (
     Start_date date not null,
     City char(50) not null,
     Name char(50) not null,
     Day date not null,
     constraint IDCOMPETITON_DAY_ID primary key (Start_date, City, Name, Day));

create table COMPOSITION (
     Committee char(50) not null,
     Referee char(50) not null,
     constraint IDCOMPOSITION primary key (Committee, Referee));

create table DOJO (
     Address char(50) not null,
     Name char(50) not null,
     constraint IDDOJO primary key (Address, Name));

create table FEDERATION (
     Name char(50) not null,
     constraint IDFEDERATION primary key (Name));

create table KARATE_MASTER (
     Gender char(50) not null,
     Surname char(50) not null,
     Date_of_birth date not null,
     Name char(50) not null,
     Fiscal_Code char(50) not null,
     Dojo_Address char(50) not null,
     Dojo_Name char(50) not null,
     constraint IDKARATE_MASTER primary key (Fiscal_Code));

create table KARATEKA (
     Gender char(50) not null,
     Surname char(50) not null,
     Date_of_birth date not null,
     Name char(50) not null,
     Fiscal_Code char(50) not null,
     Age int not null,
     Weight int not null,
     Dan_acquired int,
     Belt_color char(50) not null,
     Karate_Master char(50) not null,
     constraint IDKARATEKA_ID primary key (Fiscal_Code));

create table PARTECIPATION (
     Tournament_Start_date date not null,
     Tournament_City char(50) not null,
     Tournament_Name char(50) not null,
     Dojo_Address char(50) not null,
     Dojo_Name char(50) not null,
     constraint IDPARTECIPATION primary key (Dojo_Address, Dojo_Name, Tournament_Start_date, Tournament_City, Tournament_Name));

create table REFEREE (
     Gender char(50) not null,
     Surname char(50) not null,
     Date_of_birth date not null,
     Name char(50) not null,
     Fiscal_Code char(50) not null,
     constraint IDREFEREE primary key (Fiscal_Code));

create table TENDER_COMMITTEE (
     ID_Committee char(50) not null,
     constraint IDTENDER_COMMITTEE primary key (ID_Committee));

create table TOURNAMENT (
     Start_date date not null,
     End_Date date not null,
     Importance char(50) not null,
     City char(50) not null,
     Name char(50) not null,
     Federation_Name char(50) not null,
     Winner int not null,
     constraint IDTOURNAMENT_ID primary key (Start_date, City, Name));

create table WEIGHT_RANGE (
     Min_weight int not null,
     Max_weight int not null,
     constraint IDWEIGHT_RANGE primary key (Min_weight));


-- Constraints Section
-- ___________________ 

alter table CHALLENGE add constraint FKCom_COM_1
     foreign key (Start_date, City, Name, Day, Start_Time, Poule_Number)
     references COMPETITION (Start_date, City, Tournament_Name, Day, Start_Time, Poule_Number);

alter table CHALLENGE add constraint FKR_0
     foreign key (Karateka)
     references KARATEKA (Fiscal_Code);

-- Not implemented
-- alter table COMPETITION add constraint IDCOMPETITION_CHK
--     check(exists(select * from CHALLENGE
--                  where CHALLENGE.Start_date = Start_date and CHALLENGE.City = City and CHALLENGE.Name = Tournament_Name and CHALLENGE.Day = Day and CHALLENGE.Start_Time = Start_Time and CHALLENGE.Poule_Number = Poule_Number)); 

alter table COMPETITION add constraint FKR
     foreign key (Age_Range)
     references AGE_RANGE (Min_age);

alter table COMPETITION add constraint FKR_1
     foreign key (Level_Range)
     references BELT_RANGE (Min_level);

alter table COMPETITION add constraint FKR_2
     foreign key (Weight_Range)
     references WEIGHT_RANGE (Min_weight);

alter table COMPETITION add constraint FKEXECUTION
     foreign key (Start_date, City, Tournament_Name, Day)
     references COMPETITON_DAY (Start_date, City, Name, Day);

alter table COMPETITION add constraint FKJURY
     foreign key (ID_Committee)
     references TENDER_COMMITTEE (ID_Committee);

-- Not implementedcompetition
-- alter table COMPETITON_DAY add constraint IDCOMPETITON DAY_CHK
--     check(exists(select * from COMPETITION
--                  where COMPETITION.Start_date = Start_date and COMPETITION.City = City and COMPETITION.Tournament_Name = Name and COMPETITION.Day = Day)); 

alter table COMPETITON_DAY add constraint FKPLANNING
     foreign key (Start_date, City, Name)
     references TOURNAMENT (Start_date, City, Name);

alter table COMPOSITION add constraint FKCOM_REF
     foreign key (Referee)
     references REFEREE (Fiscal_Code);

alter table COMPOSITION add constraint FKCOM_TEN
     foreign key (Committee)
     references TENDER_COMMITTEE (ID_Committee);

alter table KARATE_MASTER add constraint FKDojo_Address
     foreign key (Dojo_Address, Dojo_Name)
     references DOJO (Address, Name);

-- Not implemented
-- alter table KARATEKA add constraint IDKARATEKA_CHK
--     check(exists(select * from CHALLENGE
--                  where CHALLENGE.Karateka = Fiscal_Code)); 

alter table KARATEKA add constraint FKRECRUITMENT
     foreign key (Karate_Master)
     references KARATE_MASTER (Fiscal_Code);

alter table PARTECIPATION add constraint FKPAR_DOJ
     foreign key (Dojo_Address, Dojo_Name)
     references DOJO (Address, Name);

alter table PARTECIPATION add constraint FKPAR_TOUR
     foreign key (Tournament_Start_date, Tournament_City, Tournament_Name)
     references TOURNAMENT (Start_date, City, Name);

-- Not implemented
-- alter table TOURNAMENT add constraint IDTOURNAMENT_CHK
--     check(exists(select * from COMPETITON_DAY
--                  where COMPETITON_DAY.Start_date = Start_date and COMPETITON_DAY.City = City and COMPETITON_DAY.Name = Name)); 

alter table TOURNAMENT add constraint FKORGANIZATION
     foreign key (Federation_Name)
     references FEDERATION (Name);


-- Index Section
-- _____________ 

