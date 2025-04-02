CREATE TABLE IF NOT EXISTS franquicia (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS sucursal (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    franquicia_id BIGINT,
    FOREIGN KEY (franquicia_id) REFERENCES franquicia(id)
);

CREATE TABLE IF NOT EXISTS producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    cantidad_en_stock INT NOT NULL,
    sucursal_id BIGINT,
    FOREIGN KEY (sucursal_id) REFERENCES sucursal(id)
);
