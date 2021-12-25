DROP DATABASE IF EXISTS Productos;
CREATE DATABASE IF NOT EXISTS Productos;
USE Productos;

SELECT 'CREATING DATABASE STRUCTURE' as 'INFO';

CREATE TABLE productos (
    codigo      INT  AUTO_INCREMENT  NOT NULL, 
    nombre      VARCHAR(25)  UNIQUE  NOT NULL,
    precio      DOUBLE         		 NOT NULL,
    inventario  INT                  NOT NULL,    
    PRIMARY KEY (codigo)
);

ALTER TABLE productos AUTO_INCREMENT = 1;

-- INSERT PRODUCTS
INSERT INTO productos (nombre, precio, inventario) VALUES ('Tangelos', 9000.0, 67);
INSERT INTO productos (nombre, precio, inventario) VALUES ('Limones', 2500.0, 35);
INSERT INTO productos (nombre, precio, inventario) VALUES ('Peras', 2700.0, 65);
INSERT INTO productos (nombre, precio, inventario) VALUES ('Arandanos', 9300.0, 34);
INSERT INTO productos (nombre, precio, inventario) VALUES ('Tomates', 8100.0, 42);
INSERT INTO productos (nombre, precio, inventario) VALUES ('Fresas', 9100.0, 90);
INSERT INTO productos (nombre, precio, inventario) VALUES ('Helado', 4500.0, 41);
INSERT INTO productos (nombre, precio, inventario) VALUES ('Galletas', 700.0, 18);
INSERT INTO productos (nombre, precio, inventario) VALUES ('Chocolate', 4500.0, 80);
INSERT INTO productos (nombre, precio, inventario) VALUES ('Jamon', 11000.0, 55);


SELECT * FROM productos;
DELETE FROM productos WHERE codigo != 0;
ALTER TABLE productos auto_increment = 1;