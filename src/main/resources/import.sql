Insert into cliente(nombre,apellido,email,password,role,create_at) values('pepito','perez','pp@gmail.com','12345','ADMIN','2023-10-15');
Insert into cliente(nombre,apellido,email,password,role,create_at) values('carlos','jimenez','cj@gmail.com','abcde','USER','2023-10-16');
Insert into cliente(nombre,apellido,email,password,role,create_at) values('simon','ales','sa@gmail.com','qwerty','USER','2023-10-17');
Insert into cliente(nombre,apellido,email,password,role,create_at) values('ana','gomez','ag@gmail.com','pass123','USER','2023-10-18');
Insert into cliente(nombre,apellido,email,password,role,create_at) values('laura','martinez','lm@gmail.com','secure','ADMIN','2023-10-19');

-- Add detalle_id column to producto table
ALTER TABLE producto ADD COLUMN detalle_id INT;

-- Add foreign key constraint for detalle_id
ALTER TABLE producto ADD CONSTRAINT fk_detalle FOREIGN KEY (detalle_id) REFERENCES detalle(id);

Insert into producto(nombre,stock,precio,create_at) values('producto1',15,5500,'2023-10-15');
Insert into producto(nombre,stock,precio,create_at) values('producto2',9,10200,'2023-10-16');
Insert into producto(nombre,stock,precio,create_at) values('producto3',2,250,'2023-10-17');
Insert into producto(nombre,stock,precio,create_at) values('producto4',20,1500,'2023-10-18');
Insert into producto(nombre,stock,precio,create_at) values('producto5',5,3000,'2023-10-19');

Insert into detalle(cantidad,precio,subtotal,encabezado_id) values(2,5500,11000,1);
Insert into detalle(cantidad,precio,subtotal,encabezado_id) values(1,10200,10200,2);
Insert into detalle(cantidad,precio,subtotal,encabezado_id) values(3,250,750,3);
Insert into detalle(cantidad,precio,subtotal,encabezado_id) values(4,1500,6000,4);
Insert into detalle(cantidad,precio,subtotal,encabezado_id) values(1,3000,3000,5);

Insert into encabezado(fecha,descuento,total,cliente_id) values('2023-10-15',500,10500,1);
Insert into encabezado(fecha,descuento,total,cliente_id) values('2023-10-16',0,10200,2);
Insert into encabezado(fecha,descuento,total,cliente_id) values('2023-10-17',50,700,3);
Insert into encabezado(fecha,descuento,total,cliente_id) values('2023-10-18',200,5800,4);
Insert into encabezado(fecha,descuento,total,cliente_id) values('2023-10-19',100,2900,5);