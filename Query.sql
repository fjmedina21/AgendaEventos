CREATE DATABASE AgendaEventos;
USE AgendaEventos;

CREATE TABLE IF NOT EXISTS Eventos(
							IdEvento INT NOT NULL AUTO_INCREMENT,
                     Nombre VARCHAR(40),
                     Detalle TEXT,
                     Fecha DATE,
                     HoraInicio TIME,
                     HoraFin TIME,
                     PRIMARY KEY (IdEvento)
							);
                     
SELECT * FROM Eventos WHERE IdEvento = 1 ;
truncate Eventos;