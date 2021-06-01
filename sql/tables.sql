create database rubrica;
use rubrica;
drop database rubrica;
CREATE TABLE `contacts` (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  name varchar(25) DEFAULT NULL,
  surname varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `email` (
	id_email bigint unsigned NOT NULL,
	email varchar(50) DEFAULT NULL,
	foreign key (id_email) references contacts(id) ON DELETE CASCADE
);

CREATE TABLE `numero` (
	id_numero bigint unsigned NOT NULL,
	number varchar(10) DEFAULT null,
	foreign key (id_numero) references contacts(id) ON DELETE CASCADE
);

insert into contacts values(0,"Stanislao","Esposito");
insert into contacts values(0,"Mario","Rossi");

insert into email values(1,"stanislao.esposito@protom.com");
insert into email values(1,"stanislaoesposito25@gmail.com");
insert into email values(2,"mario.rossi@ntt.com");

insert into numero values(1,"3518651268");
insert into numero values(1,"0813903114");
insert into numero values(2,"3315678334");