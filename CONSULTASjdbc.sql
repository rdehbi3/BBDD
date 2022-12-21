INSERT INTO oficina (codigo_oficina, nombre_municipio, codigo_cc) VALUES
('OF-MAD-O5', 'Alcorcon','CC1236');

INSERT INTO area_envio (id_area, codigo_oficina) VALUES 
('AR-MAD-O5', 'OF-MAD-O4');

INSERT INTO calle (nombre_calle, nombre_municipio) VALUES
('Alcalá de Madrid', 'Rivas');


INSERT INTO segmento (orden, numIni, numFin, nombre_calle, id_area) VALUES 
(5,4,6,'Alcalá de Madrid','AR-MAD-O5');

SELECT * 
FROM calle;

SELECT * 
FROM segmento;

SELECT area_envio.codigo_oficina
FROM area_envio INNER JOIN oficina ON oficina.codigo_oficina = area_envio.codigo_oficina;

SELECT area_envio.codigo_oficina
FROM area_envio INNER JOIN oficina ON oficina.codigo_oficina = area_envio.codigo_oficina
                INNER JOIN segmento ON area_envio.id_area = segmento.id_area;
                
SELECT area_envio.codigo_oficina
FROM area_envio INNER JOIN oficina ON oficina.codigo_oficina = area_envio.codigo_oficina
                INNER JOIN segmento ON area_envio.id_area = segmento.id_area
                INNER JOIN calle ON segmento.nombre_calle = calle.nombre_calle
 GROUP BY area_envio.codigo_oficina, calle.nombre_calle
  HAVING nombre_calle = "Alcalá de Madrid";                

SELECT area_envio.codigo_oficina, oficina.nombre_municipio, oficina.codigo_cc
FROM area_envio INNER JOIN oficina ON oficina.codigo_oficina = area_envio.codigo_oficina
                INNER JOIN segmento ON area_envio.id_area = segmento.id_area
                INNER JOIN calle ON segmento.nombre_calle = calle.nombre_calle
 GROUP BY area_envio.codigo_oficina, calle.nombre_calle
 HAVING nombre_calle = "Alcalá de Madrid";
 

INSERT INTO ruta (id_ruta) VALUES
(14);

INSERT INTO reparto (id_reparto, matricula, id_ruta, dni_cartero, fecha_reparto) VALUES
(5,'2485 SXY',14,'12345678A','2022-12-19');
SELECT *
FROM reparto;

SELECT *
FROM coche;

SELECT  DISTINCT cartero.dni_cartero
FROM coche INNER JOIN trabaja ON trabaja.codigo_oficina = trabaja.codigo_oficina
INNER JOIN cartero ON trabaja.dni_cartero = cartero.dni_cartero;

SELECT *
FROM cartero;
#INNER JOIN coche ON trabaja.codigo_oficina = trabaja.codigo_oficina;


SELECT  DISTINCT cartero.dni_cartero, nombre_cartero, apellidos_cartero
FROM cartero INNER JOIN trabaja ON trabaja.dni_cartero = cartero.dni_cartero
             INNER JOIN reparto ON reparto.dni_cartero = cartero.dni_cartero
             INNER JOIN coche ON trabaja.codigo_oficina = trabaja.codigo_oficina
WHERE CURDATE()-reparto.fecha_reparto<=7 ;           

SELECT dni_cartero, nombre_cartero, apellidos_cartero
FROM trabaja INNER JOIN trabaja ON trabaja.dni_cartero = cartero.dni_cartero
             
             INNER JOIN coche ON trabaja.codigo_oficina = trabaja.codigo_oficina
             








 
