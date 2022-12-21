CREATE SCHEMA EXPRESS_CORREOS
DEFAULT CHARACTER SET utf8
COLLATE utf8_spanish2_ci;
USE EXPRESS_CORREOS;

CREATE TABLE cartero (
    dni_cartero VARCHAR(9) UNIQUE NOT NULL,
    nombre_cartero VARCHAR(250) NOT NULL,
    apellidos_cartero VARCHAR(250) NOT NULL,
    PRIMARY KEY (dni_cartero)
);

CREATE TABLE provincia (
    nombre_provincia VARCHAR(250) NOT NULL,
    PRIMARY KEY (nombre_provincia)
);

CREATE TABLE municipio (
    nombre_municipio VARCHAR(250) UNIQUE NOT NULL,
    nombre_provincia VARCHAR(250) NOT NULL,
    PRIMARY KEY (nombre_municipio),
    CONSTRAINT FOREIGN KEY (nombre_provincia)
        REFERENCES provincia (nombre_provincia)
        ON DELETE NO ACTION
);

CREATE TABLE centro_clasificacion (
	codigo_cc VARCHAR(250) UNIQUE NOT NULL,
	numMax INT NOT NULL,
	nombre_centro_clasificacion VARCHAR (250) UNIQUE NOT NULL,	
	nombre_municipio VARCHAR (250) UNIQUE NOT NULL,
    PRIMARY KEY (codigo_cc),
    CONSTRAINT FOREIGN KEY (nombre_municipio) REFERENCES municipio (nombre_municipio)
 
);

CREATE TABLE oficina (
    codigo_oficina VARCHAR(9) UNIQUE NOT NULL,
    nombre_municipio VARCHAR(250) UNIQUE NOT NULL,
    codigo_cc VARCHAR(250) UNIQUE NOT NULL,
    PRIMARY KEY (codigo_oficina),
    CONSTRAINT FOREIGN KEY (nombre_municipio)
        REFERENCES municipio (nombre_municipio),
    CONSTRAINT FOREIGN KEY (codigo_cc) REFERENCES centro_clasificacion(codigo_cc)
);

CREATE TABLE calle (
    nombre_calle VARCHAR(250) NOT NULL,
    nombre_municipio VARCHAR(250) NOT NULL,
    PRIMARY KEY (nombre_calle),
    CONSTRAINT FOREIGN KEY (nombre_municipio)
        REFERENCES municipio (nombre_municipio)
);

CREATE TABLE direccion (
    numero INTEGER NOT NULL,
    piso INTEGER NOT NULL,
    letra CHAR(1) NOT NULL,
    portal INTEGER NOT NULL,
    nombre_calle VARCHAR(250) NOT NULL,
    PRIMARY KEY (numero),
    CONSTRAINT FOREIGN KEY (nombre_calle) REFERENCES calle (nombre_calle)
);

CREATE TABLE usuario (
    id_usuario INT UNIQUE NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    apellidos VARCHAR(30) NOT NULL,
    numero INT NOT NULL,
    PRIMARY KEY (id_usuario),
    CONSTRAINT FOREIGN KEY (numero) REFERENCES direccion (numero)
);

CREATE TABLE coche (
    matricula VARCHAR(8) UNIQUE NOT NULL,
    capacidad INT NOT NULL,
    codigo_oficina VARCHAR(9) UNIQUE NOT NULL,
    PRIMARY KEY (matricula),
    CONSTRAINT FOREIGN KEY (codigo_oficina) REFERENCES oficina (codigo_oficina)
);

CREATE TABLE ruta (
    id_ruta INT UNIQUE NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id_ruta)
);

CREATE TABLE reparto (
    id_reparto INT UNIQUE NOT NULL,
    matricula VARCHAR(8)  NOT NULL,
    id_ruta INT UNIQUE NOT NULL,
    dni_cartero VARCHAR(250) NOT NULL,
    fecha_reparto DATE DEFAULT NULL,
    PRIMARY KEY (id_reparto),
   CONSTRAINT FOREIGN KEY (matricula) 
		REFERENCES coche  (matricula),
    CONSTRAINT FOREIGN KEY (id_ruta)
        REFERENCES ruta (id_ruta),
    CONSTRAINT FOREIGN KEY (dni_cartero)
        REFERENCES cartero (dni_cartero)
        ON DELETE CASCADE
        
);

CREATE TABLE carta (
    id_carta VARCHAR(250) UNIQUE NOT NULL,
    formato CHAR(2),
    dni_cartero VARCHAR(250) NOT NULL,
    id_reparto INT UNIQUE NOT NULL,
    id_usuario INT UNIQUE NOT NULL auto_increment,
    fecha DATE DEFAULT NULL,
    hora TIME DEFAULT NULL,
    comentario TEXT,
    PRIMARY KEY (id_carta),
    CONSTRAINT FOREIGN KEY (dni_cartero)REFERENCES cartero (dni_cartero),
    CONSTRAINT FOREIGN KEY (id_reparto)REFERENCES reparto (id_reparto),
    CONSTRAINT FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
);

CREATE TABLE usuario_certificado (
    dni_usuarioCertificado VARCHAR(9) UNIQUE NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellidos VARCHAR(30) NOT NULL,
    email VARCHAR(250) UNIQUE NOT NULL,
    PRIMARY KEY (dni_usuarioCertificado)
);
CREATE TABLE recogida (
    id_recogida VARCHAR(250) UNIQUE NOT NULL,
    fecha_recogida DATE DEFAULT NULL,
    dni_cartero VARCHAR(250) NOT NULL,
    dni_usuarioCertificado VARCHAR(9) UNIQUE NOT NULL,
	dni_usuarioAutorizado VARCHAR(9) UNIQUE NOT NULL,
    numero INT NOT NULL,
    PRIMARY KEY (id_recogida),
    CONSTRAINT FOREIGN KEY (dni_cartero) REFERENCES cartero (dni_cartero),
    CONSTRAINT FOREIGN KEY (dni_usuarioCertificado)REFERENCES usuario_certificado (dni_usuarioCertificado),
    CONSTRAINT FOREIGN KEY (dni_usuarioAutorizado) REFERENCES usuario_certificado (dni_usuarioCertificado),
    CONSTRAINT FOREIGN KEY (numero) REFERENCES direccion (numero)
);
CREATE TABLE paquete (
    id_paquete VARCHAR(12) UNIQUE NOT NULL,
    dni_cartero VARCHAR(9) NOT NULL,
    id_usuario INT UNIQUE NOT NULL auto_increment,
	id_reparto INT UNIQUE NOT NULL,
    id_recogida VARCHAR(250) UNIQUE NOT NULL,
    peso INT NOT NULL,
    dimension1 INT NOT NULL,
    dimension2 INT NOT NULL,
	fecha DATE DEFAULT NULL,
    hora TIME DEFAULT NULL,
    comentario TEXT,
    PRIMARY KEY (id_paquete),
    CONSTRAINT FOREIGN KEY (dni_cartero) REFERENCES cartero (dni_cartero) ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
    CONSTRAINT FOREIGN KEY (id_reparto)REFERENCES reparto (id_reparto),
    CONSTRAINT FOREIGN KEY (id_recogida) REFERENCES recogida(id_recogida)
);

CREATE TABLE area_envio (
    id_area VARCHAR(12) UNIQUE NOT NULL,
    codigo_oficina VARCHAR(9)  NOT NULL,
    PRIMARY KEY (id_area),
    CONSTRAINT FOREIGN KEY (codigo_oficina) REFERENCES oficina (codigo_oficina)
);

CREATE TABLE incluye (
    id_area1 VARCHAR(12) UNIQUE NOT NULL,
    id_area2 VARCHAR(12) UNIQUE NOT NULL,
	PRIMARY KEY (id_area1 , id_area2),
    CONSTRAINT FOREIGN KEY (id_area1) REFERENCES area_envio (id_area),
	CONSTRAINT FOREIGN KEY (id_area2) REFERENCES area_envio (id_area)
);

CREATE TABLE segmento (
    orden INT UNIQUE NOT NULL,
    numIni INT NOT NULL,
    numFin INT NOT NULL,
    nombre_calle VARCHAR(250) NOT NULL,
    id_area VARCHAR(12) UNIQUE NOT NULL,
    PRIMARY KEY (orden),
    CONSTRAINT FOREIGN KEY (id_area) REFERENCES area_envio (id_area),
    CONSTRAINT FOREIGN KEY (nombre_calle) REFERENCES calle (nombre_calle)
);

CREATE TABLE ruta_contiene (
    id_ruta INT UNIQUE NOT NULL,
    orden INT UNIQUE NOT NULL,
    PRIMARY KEY (id_ruta , orden),
    CONSTRAINT FOREIGN KEY (id_ruta) REFERENCES ruta (id_ruta),
    CONSTRAINT FOREIGN KEY (orden) REFERENCES segmento (orden)
);

 CREATE TABLE tiene_c (
    dni_cartero VARCHAR(250) UNIQUE NOT NULL,
    id_area VARCHAR(12) UNIQUE NOT NULL,
    PRIMARY KEY (dni_cartero , id_area),
    CONSTRAINT FOREIGN KEY (dni_cartero)
        REFERENCES cartero (dni_cartero),
    CONSTRAINT FOREIGN KEY (id_area)
        REFERENCES area_envio (id_area)
 );
CREATE TABLE turno (
    jornada INT NOT NULL,
    hora_ini TIME DEFAULT NULL,
    hora_FIN TIME DEFAULT NULL,
    codigo_oficina VARCHAR(9) UNIQUE NOT NULL,
    PRIMARY KEY (jornada),
    CONSTRAINT FOREIGN KEY (codigo_oficina)
        REFERENCES oficina (codigo_oficina)
);




CREATE TABLE carta_certificada (
    Id_Cc VARCHAR(250) UNIQUE NOT NULL,
    NivelUrgencia INT NOT NULL, 
    dni_usuarioCertificado VARCHAR(9) UNIQUE NOT NULL,
    dni_usuarioCertificadoReceptor VARCHAR(9) UNIQUE NOT NULL,
	dni_cartero VARCHAR(9) NOT NULL,
    Id_reparto INT UNIQUE NOT NULL,
    fecha DATE DEFAULT NULL,
    hora TIME DEFAULT NULL,
    comentario TEXT,
    PRIMARY KEY (id_Cc),
    CONSTRAINT FOREIGN KEY (dni_usuarioCertificado)
        REFERENCES usuario_certificado (dni_usuarioCertificado),
	CONSTRAINT FOREIGN KEY (dni_usuarioCertificadoReceptor)
        REFERENCES usuario_certificado (dni_usuarioCertificado),
    CONSTRAINT FOREIGN KEY (id_reparto)
        REFERENCES reparto (id_reparto),
     CONSTRAINT FOREIGN KEY (dni_cartero)
        REFERENCES reparto (dni_cartero)   
);

CREATE TABLE trabaja (
    codigo_oficina VARCHAR(9) UNIQUE NOT NULL,
    dni_cartero VARCHAR(250) NOT NULL,
    jornada INT NOT NULL,
    fecha_comienzo_oficina DATE NOT NULL,
    PRIMARY KEY (codigo_oficina , dni_cartero , jornada , fecha_comienzo_oficina),
    CONSTRAINT FOREIGN KEY (codigo_oficina)
        REFERENCES oficina (codigo_oficina),
    CONSTRAINT FOREIGN KEY (dni_cartero)
        REFERENCES cartero (dni_cartero),
    CONSTRAINT FOREIGN KEY (jornada)
        REFERENCES turno (jornada)
);

CREATE TABLE asocia (
    id_area VARCHAR(12) UNIQUE NOT NULL,
    codigo_oficina VARCHAR(9) UNIQUE NOT NULL,
    PRIMARY KEY (id_area , codigo_oficina),
    CONSTRAINT FOREIGN KEY (id_area)
        REFERENCES area_envio (id_area),
    CONSTRAINT FOREIGN KEY (codigo_oficina)
        REFERENCES oficina (codigo_oficina)
);



CREATE TABLE entrega_cc (
    dni_cartero VARCHAR(9) UNIQUE NOT NULL,
    dni_usuarioCertificado VARCHAR(9) UNIQUE NOT NULL,
    Id_Cc VARCHAR(250) UNIQUE NOT NULL,
    fecha DATE DEFAULT NULL,
    hora TIME DEFAULT NULL,
    comentario TEXT,
    PRIMARY KEY (dni_cartero , dni_usuarioCertificado , id_Cc),
    CONSTRAINT FOREIGN KEY (dni_cartero)
        REFERENCES cartero (dni_cartero),
    CONSTRAINT FOREIGN KEY (dni_usuarioCertificado)
        REFERENCES usuario_certificado (dni_usuarioCertificado),
    CONSTRAINT FOREIGN KEY (id_Cc)
        REFERENCES carta_certificada (id_Cc)
);

CREATE TABLE vive_en (
    numero INT UNIQUE NOT NULL,
    dni_usuarioCertificado VARCHAR(9) UNIQUE NOT NULL,
    PRIMARY KEY (numero),
    CONSTRAINT FOREIGN KEY (numero) REFERENCES direccion (numero),
    CONSTRAINT FOREIGN KEY (dni_usuarioCertificado) REFERENCES usuario_certificado (dni_usuarioCertificado)
);

INSERT INTO cartero (dni_cartero, nombre_cartero, apellidos_cartero) VALUES
('12345678A', 'Juan', 'Sanchez'),
('12345678B', 'Jose', 'Perez'),
('12345678C', 'Maria', 'Garcia'),
('12345678D', 'Elena', 'Lopez');

INSERT INTO provincia (nombre_provincia) VALUES
('Madrid'),
('Malaga'),
('Barcelona'),
('Valencia');

INSERT INTO municipio (nombre_municipio, nombre_provincia) VALUES
('Rivas', 'Madrid'),
('Vicalvaro', 'Madrid'),
('Alcorcon', 'Madrid'),
('Alcobendas', 'Madrid');

INSERT INTO centro_clasificacion (codigo_cc, numMax, nombre_centro_clasificacion, nombre_municipio) VALUES
('CC1234', 200,'Centro Alcobendas','Alcobendas'),
('CC1235', 200,'Centro Rivas','Rivas'),
('CC1236', 200,'Centro Alcorcon','Alcorcon'),
('CC1237', 200,'Centro Vicalvaro','Vicalvaro');

INSERT INTO oficina (codigo_oficina, nombre_municipio, codigo_cc) VALUES
('OF-MAD-O1', 'Alcobendas', 'CC1234'),
('OF-MAD-O2', 'Rivas', 'CC1235'),
('OF-MAD-O3', 'Alcorcon','CC1236'),
('OF-MAD-O4', 'Vicalvaro', 'CC1237');


INSERT INTO calle (nombre_calle, nombre_municipio) VALUES 
('Avenida de Hola', 'Rivas'),
('Paseo de Tabla', 'Vicalvaro'),
('Avenida America', 'Alcorcon'),
('Paseo de Limon', 'Alcobendas');


INSERT INTO direccion (numero, piso, letra, portal, nombre_calle) VALUES 
(1, 1, 'A' , 1, 'Avenida de Hola'),
(2, 2, 'B' , 2, 'Paseo de Tabla'),
(3, 3, 'C' , 3, 'Avenida America'),
(4, 4, 'D' , 4, 'Paseo de Limon');

INSERT INTO usuario (nombre, apellidos, numero) VALUES 
('Jaime', 'Gonzalez', 01),
('Estela', 'Martinez', 02),
('Alberto', 'Jimenez', 03),
('Marta', 'Jose', 01);

INSERT INTO coche (matricula, capacidad, codigo_oficina) VALUES 
('2485 SXY', 0.059, 'OF-MAD-O1'),
('1282 SCG', 0.058, 'OF-MAD-O2'),
('5164 BSF', 0.100, 'OF-MAD-O3'),
('9742 IXZ', 0.080, 'OF-MAD-O4');

INSERT INTO ruta (id_ruta) VALUES
('10'),
('11'),
('12'),
('13');

INSERT INTO reparto (id_reparto, matricula, id_ruta, dni_cartero, fecha_reparto) VALUES
(1,'2485 SXY',10,'12345678A','2022-11-29'),
(2,'1282 SCG',11,'12345678A','2019-06-02'),
(3,'5164 BSF',12,'12345678C','2020-05-19'),
(4,'9742 IXZ',13,'12345678D','2020-10-20');

INSERT INTO carta (id_carta, formato, dni_cartero, id_reparto, fecha, hora, comentario) VALUES
('CT1234567890', 'A4', '12345678A', 1, '2022-11-29', null, 'entregado'),
('CT7348939478', 'A4', '12345678B', 2, null, null, 'entregado'),
('CT3489473273', 'A3', '12345678C', 3, null, null, 'entregado'),
('C9583738949', 'A3', '12345678D', 4, null, null, 'entregado');

INSERT INTO usuario_certificado (dni_usuarioCertificado, nombre, apellidos, email) VALUES
('12345678P', 'Alejandro', 'Gomez Perez', 'alejandrogom@email.com'),
('89372789R', 'Rosa', 'Alono Dominguez', 'rosadominguez@email.com'),
('43894389L', 'Roberto', 'Torres Gonzalez', 'robtorres@email.com'),
('68489372H', 'Luis', 'Martinez Costa', 'luismartinez@email.com');

INSERT INTO recogida (id_recogida, fecha_recogida, dni_cartero, dni_usuarioCertificado, DNI_usuarioAutorizado,numero) VALUES 
('AB1234', '2000-01-01', '12345678A', '12345678P', '68489372H',1),
('BC2345', '2000-02-02', '12345678B', '89372789R', '12345678P',2),
('CD3456', '2000-03-03', '12345678C', '43894389L', '43894389L',3),
('DE4567', '2000-04-04', '12345678D', '68489372H', '89372789R',4);

INSERT INTO paquete (id_paquete, dni_cartero, id_reparto, id_recogida, peso, dimension1, dimension2, fecha, hora, comentario) VALUES
('PQ1234567890', '12345678A', '1', 'AB1234', 23, '135', '88', '2022-11-29', null, 'paquete entregado'),
('PQ7348939478', '12345678B', '2', 'BC2345', 15, '100', '70',  '2022-11-28', null, 'entregado'),
('PQ3489473273', '12345678C', '3', 'CD3456', 10, '92', '59',  '2022-11-27', null, 'paquete entregado'),
('PQ9583738949', '12345678D', '4', 'DE4567', 7, '110', '78',  '2022-11-29', null, 'paquete entregado');

INSERT INTO area_envio (id_area, codigo_oficina) VALUES 
('AR-MAD-O1', 'OF-MAD-O2'),
('AR-MAD-O2', 'OF-MAD-O1'),
('AR-MAD-O3', 'OF-MAD-O3'),
('AR-MAD-O4', 'OF-MAD-O4');


INSERT INTO incluye (id_area1, id_area2) VALUES 
('AR-MAD-O1', 'AR-MAD-O1'),
('AR-MAD-O2', 'AR-MAD-O2'),
('AR-MAD-O3', 'AR-MAD-O3'),
('AR-MAD-O4', 'AR-MAD-O4');

INSERT INTO segmento (orden, numIni, numFin, nombre_calle, id_area) VALUES 
(1, 13, 25,'Avenida de Hola', 'AR-MAD-O1'),
(2, 1, 12,'Paseo de Tabla', 'AR-MAD-O2'),
(3, 10, 22,'Avenida America', 'AR-MAD-O3'),
(4, 7, 18, 'Paseo de Limon', 'AR-MAD-O4');

INSERT INTO ruta_contiene (id_ruta, orden) VALUES
(10, 1),
(11, 2),
(12, 3),
(13, 4);

INSERT INTO tiene_c (dni_cartero, id_area) VALUES 
('12345678A', 'AR-MAD-O1'),
('12345678B', 'AR-MAD-O2'),
('12345678C', 'AR-MAD-O3'),
('12345678D', 'AR-MAD-O4');

INSERT INTO turno (jornada, hora_ini, hora_fin, codigo_oficina) VALUES
('2', '10:00', '16:00', 'OF-MAD-O1'),
('1', '8:00', '12:00', 'OF-MAD-O2'),
('3', '8:00', '16:00', 'OF-MAD-O3');


INSERT INTO carta_certificada (id_Cc, nivelUrgencia, dni_usuarioCertificado, dni_usuarioCertificadoReceptor, dni_cartero, id_reparto) VALUES
('CE1234567890', 1, '12345678P', '43894389L','12345678A', 1),
('CE3478028747', 2, '68489372H', '68489372H', '12345678A', 2),
('CE4398294794', 2, '89372789R','12345678P','12345678D', 3),
('CE3288934893', 3, '43894389L','89372789R','12345678C', 4);

INSERT INTO trabaja (codigo_oficina, dni_cartero, jornada, fecha_comienzo_oficina) VALUES
('OF-MAD-O1', '12345678A', 1, '2022-11-29'),
('OF-MAD-O2', '12345678B', 2, '2020-02-20'),
('OF-MAD-O3', '12345678C', 2, '2017-07-14'),
('OF-MAD-O4', '12345678D', 3, '2011-01-07');

INSERT INTO asocia (id_area, codigo_oficina) VALUES
('AR-MAD-O1', 'OF-MAD-O1'),
('AR-MAD-O2', 'OF-MAD-O2'),
('AR-MAD-O3', 'OF-MAD-O3'),
('AR-MAD-O4', 'OF-MAD-O4');

INSERT INTO entrega_cc (dni_cartero, dni_usuarioCertificado, id_Cc, fecha, hora, comentario) VALUES
('12345678A', '43894389L', 'CE1234567890','2022-11-29',null, 'entregado'),
('12345678B', '68489372H', 'CE3478028747','2022-11-28',null, 'entregado'),
('12345678C', '89372789R', 'CE4398294794','2022-11-28',null, 'entregado'),
('12345678D', '12345678P', 'CE3288934893','2022-11-29',null, 'entregado');

INSERT INTO vive_en (numero, dni_usuarioCertificado) VALUES
(01,'12345678P'),
(02,'89372789R'),
(03,'68489372H'),
(04,'43894389L');