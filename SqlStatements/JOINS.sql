-- 5 statements with left, right, inner, outer joins

SELECT * FROM customers AS cus LEFT JOIN purchases AS pur ON cus.c_id = pur.customer_id;
SELECT * FROM orders AS ord RIGHT JOIN suppliers AS sup ON ord.supplier_id = sup.s_id;
SELECT * FROM customers AS cus INNER JOIN purchases AS pur ON cus.c_id = pur.customer_id;
SELECT * FROM orders AS ord RIGHT JOIN products AS pr ON ord.product = pr.prod_id;
SELECT * FROM managers AS ma INNER JOIN departments AS dep ON ma.dept_id = dep.d_id; 