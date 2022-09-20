-- big statement to join all tables

SELECT cus.first_name AS 'Client', pur.p_date AS 'Date', pur.total_spent AS 'Total Spent', pr.p_name AS 'Product', pro.discount AS 'Discount %', pur.dept_id AS 'Department ID', em.first_name AS 'Employee', ma.first_name AS 'Manager', br.b_name AS 'Branch Name', su.s_name AS 'Supplier', ord.quantity AS 'Quantity Order' FROM customers AS cus 
INNER JOIN purchases AS pur ON cus.c_id = pur.customer_id
INNER JOIN employees AS em ON em.dept_id = pur.dept_id
INNER JOIN products AS pr ON pr.p_name = pur.items
INNER JOIN managers AS ma ON ma.dept_id = pur.dept_id
INNER JOIN promos AS pro ON pro.p_id = pr.prod_id
INNER JOIN branches AS br ON br.manager_id = ma.m_id
INNER JOIN suppliers AS su ON su.s_id = pr.prod_id
INNER JOIN orders AS ord ON ord.supplier_id = su.s_id
GROUP BY cus.c_id;