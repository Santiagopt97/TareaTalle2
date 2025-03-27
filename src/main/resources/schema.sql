CREATE TABLE IF NOT EXISTS cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL,
    create_at DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS encabezado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    descuento DOUBLE NOT NULL,
    total DOUBLE NOT NULL,
    cliente_id INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS detalles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT NOT NULL,
    precio DOUBLE NOT NULL,
    subtotal DOUBLE NOT NULL,
    encabezado_id INT NOT NULL,
    FOREIGN KEY (encabezado_id) REFERENCES encabezado(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    stock INT NOT NULL,
    precio DOUBLE NOT NULL,
    create_at DATE NOT NULL,
    detalle_id INT,
    FOREIGN KEY (detalle_id) REFERENCES detalles(id) ON DELETE SET NULL
);
