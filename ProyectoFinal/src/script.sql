DROP SCHEMA IF EXISTS universidad;
CREATE SCHEMA universidad;
USE universidad;

CREATE TABLE Persona (
    cédula VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    ciudad_nacimiento VARCHAR(100) NOT NULL,
    pais_nacimiento VARCHAR(100) NOT NULL
);

CREATE TABLE Universidad (
    código VARCHAR(50) PRIMARY KEY,
    sede VARCHAR(100),
    cédula_rector VARCHAR(20) NOT NULL,
    ciudad VARCHAR(100),
    FOREIGN KEY (cédula_rector) REFERENCES Persona(cédula)
);

CREATE TABLE Facultad (
    código VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100),
    INDEX idx_nombre (nombre)
);

CREATE TABLE Profesor (
    id INT PRIMARY KEY,
    cédula VARCHAR(20),
    sueldo BIGINT,
    facultad_nombre VARCHAR(100),
    FOREIGN KEY (facultad_nombre) REFERENCES Facultad(nombre),
    FOREIGN KEY (cédula) REFERENCES Persona(cédula)
);

CREATE TABLE Carrera (
    código VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100),
    creditos_totales INT,
    semestres INT,
    nivel ENUM('pregrado', 'postgrado'),
    modalidad ENUM('virtual', 'presencial'),
    facultad_nombre VARCHAR(100) NOT NULL,
    FOREIGN KEY (facultad_nombre) REFERENCES Facultad(nombre)
);

CREATE TABLE Estudiante (
    código INT PRIMARY KEY,
    cédula VARCHAR(20),
    colegio VARCHAR(100),
    fecha_ingreso DATE,
    facultad_nombre VARCHAR(100) NOT NULL,
    FOREIGN KEY (facultad_nombre) REFERENCES Facultad(nombre),
    FOREIGN KEY (cédula) REFERENCES Persona(cédula)
);

CREATE TABLE Curso (
    código VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100),
    creditos INT,
    salon VARCHAR(50),
    edificio VARCHAR(50),
    facultad_nombre VARCHAR(100) NOT NULL,
    FOREIGN KEY (facultad_nombre) REFERENCES Facultad(nombre)
);

INSERT INTO Persona VALUES (1111, 'leonardo', 'villalobos', '1987-10-09', 'bogota', 'colombia');
INSERT INTO Persona VALUES (2222, 'julian', 'arango', '1978-05-20', 'cali', 'colombia');
INSERT INTO Persona VALUES (333, 'sandra', 'martinez', '1982-12-02', 'rosario', 'argentina');
INSERT INTO Persona VALUES (4444, 'maria', 'cardona', '1985-03-09', 'santiago', 'chile');

INSERT INTO Universidad VALUES ('ean-bog', 'chicó', 333, 'bogota');

INSERT INTO Facultad VALUES ('ean-ing-2010', 'ingenieria');

INSERT INTO Carrera VALUES ('ing-1', 'ingenieria de sistemas', 140, 10, 'pregrado', 'virtual', 'ingenieria');

INSERT INTO Profesor VALUES (101, 2222, 9500000, 'ingenieria');

INSERT INTO Estudiante VALUES (201, 4444, 'josé caldas', '2019-02-05', 'ingenieria');

INSERT INTO Curso VALUES ('java-2023', 'java', 10, 'A315', 'legacy', 'ingenieria');


