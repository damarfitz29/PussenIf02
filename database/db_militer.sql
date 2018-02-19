/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     11 Feb 2018 11.03.13                         */
/*==============================================================*/


drop table if exists ANGGOTA;

drop table if exists DIVISI;

drop table if exists GOLONGAN;

drop table if exists PRESENSI;

/*==============================================================*/
/* Table: ANGGOTA                                               */
/*==============================================================*/
create table ANGGOTA
(
   ANGGOTA_ID           int not null,
   NRP                  varchar(15),
   NAMA                 varchar(50),
   ALAMAT               varchar(75),
   TGL_LAHIR            date,
   GOLONGAN_ID          int,
   DIVISI_ID            int,
   AGAMA                varchar(15),
   JENIS_KELAMIN        varchar(20),
   STATUS               varchar(20),
   FOTO                 blob,
   TGL_AKTIF            datetime,
   UPDATE_LAST          timestamp,
   primary key (ANGGOTA_ID)
);

/*==============================================================*/
/* Table: DIVISI                                                */
/*==============================================================*/
create table DIVISI
(
   DIVISI_ID            int not null,
   NAMA                 varchar(50),
   LEVEL                int,
   PARENT_ID            int,
   primary key (DIVISI_ID)
);

/*==============================================================*/
/* Table: GOLONGAN                                              */
/*==============================================================*/
create table GOLONGAN
(
   GOLONGAN_ID          int not null,
   NAMA                 varchar(50),
   primary key (GOLONGAN_ID)
);

/*==============================================================*/
/* Table: PRESENSI                                              */
/*==============================================================*/
create table PRESENSI
(
   PRESENSI_ID          int not null,
   ANGGOTA_ID           int,
   JAM                  time,
   primary key (PRESENSI_ID)
);

alter table ANGGOTA add constraint FK_REFERENCE_2 foreign key (GOLONGAN_ID)
      references GOLONGAN (GOLONGAN_ID) on delete restrict on update restrict;

alter table ANGGOTA add constraint FK_REFERENCE_3 foreign key (DIVISI_ID)
      references DIVISI (DIVISI_ID) on delete restrict on update restrict;

alter table PRESENSI add constraint FK_REFERENCE_4 foreign key (ANGGOTA_ID)
      references ANGGOTA (ANGGOTA_ID) on delete restrict on update restrict;

