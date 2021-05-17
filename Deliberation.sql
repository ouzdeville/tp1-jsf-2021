/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  03/05/2021 21:21:57                      */
/*==============================================================*/


drop table if exists EC;

drop table if exists ETUDIANT;

drop table if exists ETUDIANT_PROMO;

drop table if exists EVALUATION;

drop table if exists FILIERE;

drop table if exists MOYENNE_EC;

drop table if exists MOYENNE_SE;

drop table if exists MOYENNE_UE;

drop table if exists NIVEAU;

drop table if exists NOTE;

drop table if exists PROFIL;

drop table if exists PROMO;

drop table if exists SEMESTRE;

drop table if exists UE;

drop table if exists USER;

/*==============================================================*/
/* Table : EC                                                   */
/*==============================================================*/
create table EC
(
   IDEC                 int not null AUTO_INCREMENT,
   IDUE                 int not null,
   VALEUR               numeric(20,0),
   COEFFICIENT          int,
   primary key (IDEC)
);

/*==============================================================*/
/* Table : ETUDIANT                                             */
/*==============================================================*/
create table ETUDIANT
(
   IDETUDIANT           int not null AUTO_INCREMENT,
   NOM                  char(30),
   PRENOM               char(30),
   NUMERO_CARTE         char(15),
   DATE                 date,
   EMAIL                char(30),
   TEL                  numeric(11,0),
   LIEU                 char(30),
   primary key (IDETUDIANT)
);

/*==============================================================*/
/* Table : ETUDIANT_PROMO                                       */
/*==============================================================*/
create table ETUDIANT_PROMO
(
   IDETUDIANTP          int not null AUTO_INCREMENT,
   IDPROMO              int not null,
   IDETUDIANT           int not null,
   MONTANT              float(11),
   primary key (IDETUDIANTP)
);

/*==============================================================*/
/* Table : EVALUATION                                           */
/*==============================================================*/
create table EVALUATION
(
   IDEVALUATION         int not null AUTO_INCREMENT,
   IDEC                 int not null,
   TYPE                 char(15),
   DATE                 date,
   primary key (IDEVALUATION)
);

/*==============================================================*/
/* Table : FILIERE                                              */
/*==============================================================*/
create table FILIERE
(
   IDFILIERE            int not null AUTO_INCREMENT,
   ID                   int not null,
   NOM                  char(30),
   primary key (IDFILIERE)
);

/*==============================================================*/
/* Table : MOYENNE_EC                                           */
/*==============================================================*/
create table MOYENNE_EC
(
   IDMEC                int not null AUTO_INCREMENT,
   IDETUDIANTP          int not null,
   IDEC                 int not null,
   VALEUR               numeric(20,0),
   primary key (IDMEC)
);

/*==============================================================*/
/* Table : MOYENNE_SE                                           */
/*==============================================================*/
create table MOYENNE_SE
(
   IDMSE                int not null AUTO_INCREMENT,
   IDETUDIANTP          int not null,
   IDSEMESTRE           int not null,
   VALEUR               int,
   ATTRIBUT_42          int,
   primary key (IDMSE)
);

/*==============================================================*/
/* Table : MOYENNE_UE                                           */
/*==============================================================*/
create table MOYENNE_UE
(
   IDMUE                int not null AUTO_INCREMENT,
   IDETUDIANTP          int not null,
   IDUE                 int not null,
   VALEUR               numeric(20,0),
   CREDIT               int,
   primary key (IDMUE)
);

/*==============================================================*/
/* Table : NIVEAU                                               */
/*==============================================================*/
create table NIVEAU
(
   IDNIVEAU             int not null AUTO_INCREMENT,
   IDFILIERE            int not null,
   NOM                  char(10),
   primary key (IDNIVEAU)
);

/*==============================================================*/
/* Table : NOTE                                                 */
/*==============================================================*/
create table NOTE
(
   IDNOTE               int not null AUTO_INCREMENT,
   IDETUDIANTP          int not null,
   IDEVALUATION         int not null,
   VALEUR               float(20),
   primary key (IDNOTE)
);

/*==============================================================*/
/* Table : PROFIL                                               */
/*==============================================================*/
create table PROFIL
(
   ID_PROFIL            int not null AUTO_INCREMENT,
   NOM                  char(10),
   primary key (ID_PROFIL)
);

/*==============================================================*/
/* Table : PROMO                                                */
/*==============================================================*/
create table PROMO
(
   IDPROMO              int not null AUTO_INCREMENT,
   IDNIVEAU             int not null,
   ANNEE_SCOLAIRE       char(10),
   primary key (IDPROMO)
);

/*==============================================================*/
/* Table : SEMESTRE                                             */
/*==============================================================*/
create table SEMESTRE
(
   IDSEMESTRE           int not null  AUTO_INCREMENT,
   VALEUR               int,
   primary key (IDSEMESTRE)
);

/*==============================================================*/
/* Table : UE                                                   */
/*==============================================================*/
create table UE
(
   IDUE                 int not null AUTO_INCREMENT,
   IDPROMO              int not null,
   IDSEMESTRE           int not null,
   CODE                 int,
   NOM                  char(30),
   CREDIT               int,
   primary key (IDUE)
);

/*==============================================================*/
/* Table : USER                                                 */
/*==============================================================*/
create table USER
(
   ID                   int not null AUTO_INCREMENT,
   ID_PROFIL            int not null,
   NOM                  char(30),
   PRENOM               char(30),
   TEL                  numeric(11,0),
   EMAIL                char(30),
   primary key (ID)
);

alter table EC add constraint FK_DEPENDRE foreign key (IDUE)
      references UE (IDUE) on delete restrict on update restrict;

alter table ETUDIANT_PROMO add constraint FK_FAIRE_PARTIR foreign key (IDETUDIANT)
      references ETUDIANT (IDETUDIANT) on delete restrict on update restrict;

alter table ETUDIANT_PROMO add constraint FK_INSCRIRE foreign key (IDPROMO)
      references PROMO (IDPROMO) on delete restrict on update restrict;

alter table EVALUATION add constraint FK_ENRICHIR foreign key (IDEC)
      references EC (IDEC) on delete restrict on update restrict;

alter table FILIERE add constraint FK_DIRIGER foreign key (ID)
      references USER (ID) on delete restrict on update restrict;

alter table MOYENNE_EC add constraint FK_ASSOCIATION_16 foreign key (IDEC)
      references EC (IDEC) on delete restrict on update restrict;

alter table MOYENNE_EC add constraint FK_OBTENIR foreign key (IDETUDIANTP)
      references ETUDIANT_PROMO (IDETUDIANTP) on delete restrict on update restrict;

alter table MOYENNE_SE add constraint FK_APPARTENIR foreign key (IDETUDIANTP)
      references ETUDIANT_PROMO (IDETUDIANTP) on delete restrict on update restrict;

alter table MOYENNE_SE add constraint FK_ASSOCIATION_18 foreign key (IDSEMESTRE)
      references SEMESTRE (IDSEMESTRE) on delete restrict on update restrict;

alter table MOYENNE_UE add constraint FK_ASSOCIATION_17 foreign key (IDETUDIANTP)
      references ETUDIANT_PROMO (IDETUDIANTP) on delete restrict on update restrict;

alter table MOYENNE_UE add constraint FK_CAPITALISER foreign key (IDUE)
      references UE (IDUE) on delete restrict on update restrict;

alter table NIVEAU add constraint FK_CONTENIR foreign key (IDFILIERE)
      references FILIERE (IDFILIERE) on delete restrict on update restrict;

alter table NOTE add constraint FK_AVOIR foreign key (IDETUDIANTP)
      references ETUDIANT_PROMO (IDETUDIANTP) on delete restrict on update restrict;

alter table NOTE add constraint FK_COMPOSER foreign key (IDEVALUATION)
      references EVALUATION (IDEVALUATION) on delete restrict on update restrict;

alter table PROMO add constraint FK_ENGLOPER foreign key (IDNIVEAU)
      references NIVEAU (IDNIVEAU) on delete restrict on update restrict;

alter table UE add constraint FK_FAIRE foreign key (IDPROMO)
      references PROMO (IDPROMO) on delete restrict on update restrict;

alter table UE add constraint FK_VALIDER foreign key (IDSEMESTRE)
      references SEMESTRE (IDSEMESTRE) on delete restrict on update restrict;

alter table USER add constraint FK_REPRESENTER foreign key (ID_PROFIL)
      references PROFIL (ID_PROFIL) on delete restrict on update restrict;

