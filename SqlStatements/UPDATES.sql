use supermarket;
SET SQL_SAFE_UPDATES = 0;

UPDATE branches SET b_name = 'Supermarket', manager_id = 1 WHERE b_id = 1;
UPDATE customers SET first_name = 'Julian', last_name = 'Alvarez', bod = '2022-01-13', phone = '3624571698', email = 'jalvarez@gamil.com', address = 'Av. Chaco 200' WHERE c_id = 3;
UPDATE departments SET d_name = 'Tools' WHERE d_id = 3;
UPDATE employees SET first_name = 'Mariano', last_name = 'Flores', bod = '2022-05-02', phone = '3624158342', email = 'mflores@gmail.com', salary = 1500, dept_id = 3 WHERE e_id = 3;
UPDATE managers SET first_name = 'Luck', last_name = 'Skywalker' WHERE m_id = 4;
UPDATE orders SET o_date = '2022-10-21', quantity = 150, o_status = 1 WHERE o_id = 1;
UPDATE products SET quantity = 350, price = 12 WHERE prod_id = 1;
UPDATE promos SET discount = 30, product_id = 5 WHERE p_id = 1;
UPDATE purchases SET total_spent = 110, costumer_id = 3 WHERE p_id = 3;
UPDATE suppliers SET s_phone = '3624595214', s_email = 'vea_supplier@gmail.com' WHERE s_name = 'vea';