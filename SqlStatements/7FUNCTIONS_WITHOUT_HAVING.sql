-- 7 statements with aggregate functions and group by and without having

SELECT cus.first_name AS 'Clients', pur.total_spent AS 'Spent', COUNT(*) AS 'Sum of spent' FROM customers AS cus
INNER JOIN purchases AS pur ON cus.c_id=pur.customer_id GROUP BY cus.c_id;

SELECT ord.product AS 'Product', sup.s_name AS 'Supplier', COUNT(*) AS 'Sum of orders' FROM orders AS ord
INNER JOIN suppliers AS sup ON ord.o_id=sup.s_id GROUP BY ord.o_id; 

SELECT prod.p_name AS 'Product name', pr.discount AS 'Discount %' , COUNT(*) AS 'Sum of discounts' FROM products AS prod
INNER JOIN promos AS pr ON prod.prod_id=pr.p_id GROUP BY prod.prod_id;

SELECT dept.d_name AS 'Department name', pur.items AS 'Item', COUNT(*) AS 'Department sales amount' FROM departments AS dept
INNER JOIN purchases AS pur ON dept.d_id=pur.dept_id GROUP BY dept.d_id;

SELECT del.d_name AS 'Delivery name', pur.p_id AS 'Purchase ID', COUNT(*) AS 'Orders taken' FROM deliverys AS del
INNER JOIN purchases AS pur ON del.purchase_id = pur.p_id GROUP BY del.d_id; 

SELECT lic.license_type AS 'Type of license', del.d_name AS 'Owner', COUNT(*) AS 'Numbers of licenses' FROM licenses AS lic
INNER JOIN deliverys AS del ON lic.l_id = del.license_id GROUP BY lic.l_id;

SELECT br.b_name AS 'Branch name', man.first_name AS 'Manager of the branch', COUNT(*) AS 'Numbers of managers' FROM branches AS br
INNER JOIN managers AS man ON br.b_id = man.branch_id GROUP BY br.b_id;