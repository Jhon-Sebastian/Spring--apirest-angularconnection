INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Sebastian','Cagua','sebas@mail.com','2018-01-01');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Luisa','Gomez','gomez@mail.com','2018-01-02');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Ana','Maria','maria@mail.com','2018-01-03');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Karla','Lopez','lopez@mail.com','2018-01-04');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Luis','Garcia','garcia@mail.com','2018-01-05');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Venito','Molo','molo@mail.com','2018-01-06');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Musolinni','Venitt','venitt@mail.com','2018-01-07');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Chaves','Vene','vene@mail.com','2018-01-08');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Uribe','Paraco','paraco@mail.com','2018-01-09');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES ('Petro','Salvador','salvador@mail.com','2018-01-10');

INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('sebastian','$2a$10$EDGXnZgStC09UPZX2BerZO9tKopU8vhPsjq1QRZSdzxRe/yFPazx6',1, 'sebastian', 'cagua', 'sebas@mail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$h1mbnmLTtxUNmLPIt.21ceAlebsC0qoV7Q2IwgSnL1A1o6d4Ft5Vu',1, 'ADMIN', 'admin', 'admi@mail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);