create table dueno(
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(100) not null,
    PRIMARY KEY(id)
);

create table mascota(
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(100) not null,
    num_chip int NOT NULL,
    vacunado BOOLEAN,
    PRIMARY KEY(id)
)