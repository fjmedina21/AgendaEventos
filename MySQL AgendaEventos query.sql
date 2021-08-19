-- CREATE DATABASE AgendaEventos;
-- USE AgendaEventos;

-- CREATE TABLE IF NOT EXISTS Eventos(
--                                     IdEvento INT NOT NULL AUTO_INCREMENT,
--                                      Nombre VARCHAR(40),
--                                      Detalle TEXT,
--                                      Lugar VARCHAR(50),
--                                      Fecha DATE,
--                                      HoraInicio TIME,
--                                      HoraFin TIME,
--                                      PRIMARY KEY (IdEvento)
--                                     );

-- TRUNCATE Eventos;

SELECT * FROM Eventos;

-- INSERT INTO Eventos (Nombre, Detalle, Lugar, Fecha, HoraInicio, HoraFin) 
--    VALUES ('','','','0000-00-00','00:00','00:00');