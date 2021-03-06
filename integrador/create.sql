CREATE TABLE IF NOT EXISTS DOMICILIOS
            (id INT PRIMARY KEY AUTO_INCREMENT,
             calle VARCHAR(255),
             numero INT,
             localidad VARCHAR(255),
             provincia VARCHAR(255)
             );
CREATE TABLE IF NOT EXISTS PACIENTES
            (id INT PRIMARY KEY AUTO_INCREMENT,
             nombre VARCHAR(255),
             apellido VARCHAR(255),
             email VARCHAR(255),
             dni BIGINT,
             fecha_ingreso DATE,
             domicilio_id INT,
             foreign key (domicilio_id) references DOMICILIOS(id)
             );
CREATE TABLE IF NOT EXISTS ODONTOLOGOS
            (id INT PRIMARY KEY AUTO_INCREMENT,
             nombre VARCHAR(255),
             apellido VARCHAR(255),
             matricula INT
             );
CREATE TABLE IF NOT EXISTS TURNOS
            (id INT PRIMARY KEY AUTO_INCREMENT,
             fecha_hora DATETIME,
             paciente_id int,
             odontologo_id int,
             foreign key (paciente_id) references PACIENTES(id),
             foreign key (odontologo_id) references ODONTOLOGOS(id)
             );