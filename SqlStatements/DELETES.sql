use supermarket;

DELETE FROM customers where customers.c_id=7;
DELETE FROM branches WHERE b_id = 1;
DELETE FROM departments WHERE d_name = 'cleaning';
DELETE FROM employees WHERE salary > 2000 ;
DELETE FROM managers WHERE salary > 5000;
DELETE FROM orders WHERE o_id = 4;
DELETE FROM products WHERE quantity = 0;
DELETE FROM promos WHERE valid_till < GETDATE()-1;
DELETE FROM purchases WHERE total_spent = 100;
DELETE FROM suppliers WHERE s_id = 2;