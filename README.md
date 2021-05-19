# Hospital

Posnetek z prikazom osnovnega delovanja Aplikacije
https://youtu.be/xnBHpQN2RIE

# Login
![image](https://user-images.githubusercontent.com/56089916/118777322-38ecb780-b889-11eb-851b-39f35ddbd94c.png)

# Registration
![image](https://user-images.githubusercontent.com/56089916/118777532-73eeeb00-b889-11eb-8989-28ba649a80af.png)

# Home
![image](https://user-images.githubusercontent.com/56089916/118777751-b0bae200-b889-11eb-8097-ad89c65bb2eb.png)

![image](https://user-images.githubusercontent.com/56089916/118777838-caf4c000-b889-11eb-990b-d414e4ad8499.png)

![image](https://user-images.githubusercontent.com/56089916/118777939-e95abb80-b889-11eb-83bd-0b326211dcd3.png)

# SQL koda

## User Account

```
CREATE TABLE `hospital_assistant`.`user_account` (
  `account_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `ime` varchar(45) NOT NULL,
  `priimek` varchar(45) NOT NULL,
  `specializacija` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefon` varchar(45) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
);

INSERT INTO `user_account` VALUES 
(1,'micomitja','fri123','Mitja','Sepec','nuklearna medicina','mitja@gmail.com','031456897'),
(2,'timotejtim','fri123','Tim','Rus','urgenta medicina','tim@gmail.com','040324123'),
(3,'babayaga','fri123','John','Wick','kirurg','john@mail.com','031456789');
```

## Pacienti
```
CREATE TABLE `hospital_assistant`.`pacienti` (
  `pacient_id` INT NOT NULL AUTO_INCREMENT,
  `pacient_ime` VARCHAR(45) NOT NULL,
  `pacient_priimek` VARCHAR(45) NOT NULL,
  `pacient_starost` VARCHAR(45) NOT NULL,
  `pacient_spol` VARCHAR(45) NOT NULL,
  `pacient_email` VARCHAR(45) NOT NULL,
  `pacient_naslov` VARCHAR(45) NOT NULL,
  `pacient_st_kartice` VARCHAR(45) NOT NULL,
  `account_id` INT,
  PRIMARY KEY (`pacient_id`),
  UNIQUE INDEX `pacient_id_UNIQUE` (`pacient_id` ASC) VISIBLE,
  CONSTRAINT `FK_dohtar` FOREIGN KEY (`account_id`)
  REFERENCES user_account(`account_id`)
);

INSERT INTO `hospital_assistant`.`pacienti` (`pacient_ime`, `pacient_priimek`, `pacient_starost`, `pacient_spol`, `pacient_email`, `pacient_naslov`, `pacient_st_kartice`, `account_id`) VALUES ('Jože', 'Novak', '60', 'moški', 'jozenovak@mail.com', 'slovenska cesta 10a, 100 Ljubljana', '032822733', '1');
INSERT INTO `hospital_assistant`.`pacienti` (`pacient_ime`, `pacient_priimek`, `pacient_starost`, `pacient_spol`, `pacient_email`, `pacient_naslov`, `pacient_st_kartice`, `account_id`) VALUES ('Marija', 'Slovenec', '70', 'ženski', 'marija@mail.com', 'titova cesta 10, 1000 Ljubljana', '032821231', '2');
INSERT INTO `hospital_assistant`.`pacienti` (`pacient_ime`, `pacient_priimek`, `pacient_starost`, `pacient_spol`, `pacient_email`, `pacient_naslov`, `pacient_st_kartice`, `account_id`) VALUES ('Jožica', 'Kovač', '70', 'ženski', 'jožica@mail.com', 'prešernoca cesta 10, 1000 Ljubljana', '032821231', '1');

```

## Pregled

```
CREATE TABLE `hospital_assistant`.`pregled` (
  `pregled_id` INT NOT NULL AUTO_INCREMENT,
  `diagnoza` VARCHAR(45) NOT NULL,
  `srcni_utrip` VARCHAR(45) NOT NULL,
  `pritisk` VARCHAR(45) NOT NULL,
  `kisik_v_krvi` VARCHAR(45) NOT NULL,
  `zdravilo` VARCHAR(45) NULL,
  `danasnji_datum` VARCHAR(45) NOT NULL,
  `datum_naslednjega_pregleda` VARCHAR(45) NOT NULL,
  `pacient_id` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `pregled_id_UNIQUE` (`pregled_id` ASC) VISIBLE,
  PRIMARY KEY (`pregled_id`)
  FOREIGN KEY (pacient_id) REFERENCES pacienti(pacient_id)
);

INSERT INTO `hospital_assistant`.`pregled` (`diagnoza`, `srcni_utrip`, `pritisk`, `kisik_v_krvi`, `zdravilo`, ``danasnji_datum` `datum_naslednjega_pregleda`, `pacient_id`) VALUES ('SARS-CoV-2', '75', '130/80', '96', 'Pfizer–BioNTech COVID-19 vaccine', '18/5/2021','31/1/2022', '1');

```
