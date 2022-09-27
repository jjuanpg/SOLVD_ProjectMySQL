use supermarket;

INSERT INTO customers (first_name, last_name, bod, phone, email, address) VALUES
('Juan Pablo', 'Gordillo', '2022-09-13', '3624881392', 'juanpablogordillo375@gmail.com', 'Av. Edison'),
('Cesáreo', 'Martinez', '2022-09-13', '3624455423', 'cesareomartinez@gmail.com', 'Av. Edison 1500'),
('Pablo', 'Aimar', '2022-07-13', '3624195312', 'pabloaimar@outlook.com', 'Av. Chaco 200'),
('Franco', 'Fernandez', '2022-05-23', '3624923812', 'franco2001@gmail.com', 'Av. 9 de Julio 1000'),
('Matias', 'Franco', '2022-10-13', '3624881392', 'matiasfranco@live.com.ar', 'Colon 1921');

INSERT INTO customers (first_name, last_name, bod, phone, email, address) VALUES
('MARTA', 'MARTA', '2022-10-13', '3624881392', 'matiasfranco@live.com.ar', 'Colon 1981');

INSERT INTO departments(d_name) VALUES
('Cleaning'),
('Food'),
('Kitchen'),
('Personal Care'),
('Greengrocery');

INSERT INTO employees(first_name, last_name, bod, phone, email, address, salary, dept_id) VALUES 
('Antonio', 'Banderas', '2022-05-13', '3624920267', 'antonio@gmail.com', 'Av. 25 de Mayo 100', 1500, 2),
('Walter', 'Farias', '2022-05-13', '3624574682', 'walter@gmail.com', 'Carrasco 1839', 1300, 1),
('Maria', 'Francesca', '2022-05-17', '3624314265', 'maria@gmail.com', 'Av. Piacentini 2000', 1300, 3),
('Julieta', 'Banderas', '2022-05-13', '3624674238', 'julieta@gmail.com', 'Av. 9 de Julio 1500', 1500, 5),
('Alejandro', 'Fernandez', '2022-05-17', '3624348265', 'alejandro@gmail.com', 'French 400', 1600, 4);

INSERT INTO managers(first_name, last_name, bod, phone, email, address, salary, dept_id) VALUES
('Andrew', 'Nazarenko', '2022-02-06', '3705154725', 'andrewn@gmail.com', 'Av. Sarmiento 1000', 3000, 1),
('Jose', 'Canavire', '2022-02-15', '3624182753', 'jcanavire@gmail.com', 'French 530', 3000, 2),
('Dzmitry', 'Prymudrau', '2022-02-08', '3624235725', 'dzmitry@gmail.com', 'Pecini 87', 3000, 3),
('Luciano', 'Merenda', '2022-02-22', '3705287453', 'luciano@outlook.com', 'Av. Castelli 2500', 3000, 5),
('Alesya', 'Milanovic', '2022-02-14', '3705496782', 'milanovic@live.com', 'Av. Soberania 2000', 3000, 4);

INSERT INTO suppliers(s_name, s_address, s_phone, s_email) VALUES
('Maxiconsumo', 'Ruta Nac.11, Km 1005', '3624464037', 'maxiconsumo@gmail.com'),
('Vea', 'Av. Alberdi 528', '0810-999-9832', 'vea@gmail.com'),
('Distributor Crokangol', 'Av. Alberdi 499', '3624441368', 'crokangol@live.com'),
('Libertad S.A.', ' Ruta Nacional 16 y Av. Sabin 3500', '3624458490', 'libertad@outlook.com'),
('Easy', ' RN16, H3500 Resistencia', '0810-999-3279', 'easy@gmail.com');

INSERT INTO products(p_name, quantity, price, create_by, supplier_id) VALUES
('Bread', 200, 10, 2, 2),
('Oliva oil', 100, 25, 1, 1),
('Cafe', 100, 12, 3, 3),
('Noodles', 200, 5, 4, 5),
('Sugar', 300, 10, 5, 4);

INSERT INTO purchases(p_date, total_spent, customer_id, dept_id, items) VALUES
('2022-09-20', 100, 3, 1, 'Bread'),
('2022-09-20', 55, 1, 2, 'Olive oil'),
('2022-09-20', 38, 5, 3, 'Sugar'),
('2022-09-20', 80, 4, 4, 'Cafe'),
('2022-09-20', 72, 2, 5, 'Noodles');

INSERT INTO promos(discount, valid_till, product_id) VALUES
(15, '2022-10-20', 5),
(20, '2022-09-28', 3),
(5, '2022-10-05', 1),
(10, '2022-11-01', 2),
(15, '2022-09-30', 4);

INSERT INTO orders(o_date, product, quantity, department, supplier_id, o_status) VALUES
('2022-10-20', 1, 50, 5, 2, 0),
('2022-10-20', 3, 100, 1, 5, 1),
('2022-10-20', 5, 30, 3, 3, 1),
('2022-10-20', 4, 200, 2, 1, 1),
('2022-10-20', 2, 150, 4, 4, 1);

INSERT INTO branches(b_name, b_address, manager_id) VALUES
('Supermarket 1', 'Av. Edison 1200', 1),
('Supermarket 2', 'Av. Chaco 1200', 5),
('Supermarket 3', 'Av. Sarmiento 1200', 3),
('Supermarket 4', 'Av. Alberdi 1100', 4),
('Supermarket 5', 'Av. Sabin 1200', 2);

INSERT INTO deliverys(d_name, vehicle, purchase_id) VALUES
('Martin Gonzales', 'BMW I8', 1),
('Veronica Gomez', 'Audi A5', 2),
('Lucas Perez', 'Volkswagen Golf', 3),
('Ramiro Leiva', 'Audi A1', 4),
('Pablo Romero', 'BMW M4', 5);

INSERT INTO licenses(license_type, delivery_id) VALUES
('Car', 11),
('Car', 12),
('Car', 13),
('Car', 14),
('Car', 15);
