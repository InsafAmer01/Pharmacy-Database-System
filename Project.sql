-- create database pharmacy;
 use pharmacy;

 create table Doctor (
 Doctor_ID int primary key,
 dname varchar (20),
 Phone int,
 address varchar (100)
);

create table Patients (
Patient_ID int primary key,
pname varchar(20),
age int,
gender varchar(7),
pPhone int, 
siknesname varchar(30),
drug_ID int,
Doctor_ID int,
foreign key (Doctor_ID) references Doctor(Doctor_ID)
);

 insert into Doctor values (4, 'Cathy Cook', '12345695', 'Tucson');
 insert into Doctor values (14, 'james blue', '59774623', 'ramallah');

 create table PatientsdoctorPatients (
 Patient_ID int primary key,
 foreign key (Patient_ID) references Patients(Patient_ID),
 pname varchar(20),
 age int,
 gender varchar(7),
 pPhone int, 
 siknesname varchar(30),
 drug_ID int,
 foreign key (drug_ID) references drugs(drug_ID),
 Doctor_ID int,
 foreign key (Doctor_ID) references Doctor(Doctor_ID)
 );

insert into PatientsdoctorPatients values (3, 'Cathy Cook', '22', 'f','12698534','very bad desise','545400','4');

 create table Reports(
 report_ID int primary key,
 purchase_ID int,
 foreign key (purchase_ID) references purchasing(purchase_ID),
 drug_ID int,
 foreign key (drug_ID) references drugs(drug_ID),
 Patient_ID int,
 foreign key (Patient_ID) references Patients(Patient_ID),
 date varchar(20),
 Doctor_ID int,
 foreign key (Doctor_ID) references Doctor(Doctor_ID)
 );

 create table sales (
 sales_ID int primary key,
 Patient_ID int,
 foreign key (Patient_ID) references Patients(Patient_ID),
 drug_ID int,
 foreign key (drug_ID) references drugs(drug_ID),
 phar_com varchar(20),
 saleprice int,
 count int,
 pharmacy_ID int,
 foreign key (pharmacy_ID) references pharmacy(pharmacy_ID)
 );

 create table pharmacy (
 pharmacy_ID int primary key,
 phname varchar(20) not null,
 address varchar(30),
 phPhone int
 );

 create table Company (
 comp_ID int primary key,
 comname varchar(20),
 cPhone int
 );

 create table drugs (
drug_ID int primary key,
drname varchar(20),
drprice varchar(5),
description varchar (40),
production_Date varchar(20),
expiry_date varchar(20),
Quantity int,
Doctor_ID int,
Patient_ID int,
comp_ID int,
foreign key (comp_ID) references Company(comp_ID)
);

 create table purchasing (
 purchase_ID int primary key,
 patient_ID int,
 foreign key (patient_ID) references drugs(patient_ID),
 drug_ID int,
 foreign key (drug_ID) references drugs(drug_ID)
 );

 create table drugs_IDpatients_Drugs (
 patients_Drugs_ID int primary key,
 Patient_ID int,
 foreign key (Patient_ID) references Patients(Patient_ID),
 drug_ID int,
 foreign key (drug_ID) references drugs(drug_ID),
 Quantity int,
 date varchar(20)
 );
 
 