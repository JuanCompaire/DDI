

CREATE TABLE IF NOT EXISTS LIBRO (
    id INT  NOT NULL AUTO_INCREMENT,
    isbn VARCHAR(25),
    fechaEdicion DATE,
    almacen_old INT,
    almacen_new INT,
    PRIMARY KEY (id)
);
