CREATE DATABASE supermarket;
USE supermarket;
CREATE TABLE customers(
	c_id INT PRIMARY KEY auto_increment,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    bod DATE NOT NULL,
    phone INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL
);
CREATE TABLE employees(
	e_id INT PRIMARY KEY auto_increment,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    bod DATE NOT NULL,
    phone INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    salary INT NOT NULL,
    dept_id INT NOT NULL
);
CREATE TABLE managers(
	m_id INT PRIMARY KEY auto_increment,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    bod DATE NOT NULL,
    phone INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    salary INT NOT NULL,
    dept_id INT NOT NULL
);
CREATE TABLE departments(
	d_id INT PRIMARY KEY auto_increment,
    d_name VARCHAR(50) NOT NULL
);
CREATE TABLE suppliers(
	s_id INT PRIMARY KEY auto_increment,
    s_name VARCHAR(50) NOT NULL,
    s_address VARCHAR (100) NOT NULL,
    s_phone INT NOT NULL,
    s_email VARCHAR(100) NOT NULL
);
CREATE TABLE products(
	prod_id INT PRIMARY KEY AUTO_INCREMENT,
    p_name VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    price INT NOT NULL,
    create_by INT NOT NULL,
    supplier_id INT NOT NULL
);

CREATE TABLE purchases(
	p_id INT PRIMARY KEY auto_increment,
    p_date DATE NOT NULL,
    total_spent INT NOT NULL,
    customer_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(c_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE promos(
	p_id INT PRIMARY KEY auto_increment,
    discount INT NOT NULL, -- percentage of discount
    valid_till DATE NOT NULL,
    product_id INT NOT NULL UNIQUE,
    FOREIGN KEY (product_id) REFERENCES products(prod_id) ON DELETE CASCADE ON UPDATE NO ACTION
);
CREATE TABLE orders(
	o_id INT PRIMARY KEY auto_increment,
    o_date DATE NOT NULL,
    product VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    department INT NOT NULL UNIQUE,
    supplier_id INT NOT NULL,
    o_status TINYINT NOT NULL,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(s_id) ON DELETE CASCADE ON UPDATE NO ACTION,
    FOREIGN KEY (department) REFERENCES departments(d_id) ON DELETE CASCADE ON UPDATE NO ACTION
);
CREATE TABLE branches(
	b_id INT PRIMARY KEY auto_increment,
    b_name VARCHAR(50) NOT NULL,
    b_address VARCHAR(100) NOT NULL,
    manager_id INT NOT NULL UNIQUE,
    FOREIGN KEY (manager_id) REFERENCES managers(m_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
-- FLUSH PRIVILEGES;
-- these commands fix a connection error within intellij and mysql localhost

SELECT * FROM customers; -- done
SELECT * FROM employees; -- done
SELECT * FROM managers; -- done
SELECT * FROM departments; -- done
SELECT * FROM suppliers; -- done
SELECT * FROM products; -- done
SELECT * FROM purchases; -- done
SELECT * FROM promos; -- done
SELECT * FROM orders; -- done
SELECT * FROM branches; -- done