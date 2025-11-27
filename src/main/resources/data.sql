INSERT INTO celda (id, codigo, ocupada) VALUES (1, 'A1', false);
INSERT INTO celda (id, codigo, ocupada) VALUES (2, 'A2', false);
INSERT INTO celda (id, codigo, ocupada) VALUES (3, 'B1', false);
INSERT INTO celda (id, codigo, ocupada) VALUES (4, 'B2', false);
INSERT INTO rol (id, nombre) VALUES (1, 'ADMIN');
INSERT INTO rol (id, nombre) VALUES (2, 'USER');


INSERT INTO usuario (id, username, password, rol_id) VALUES (1, 'admin', 'admin', 1);