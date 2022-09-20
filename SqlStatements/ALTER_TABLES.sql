use supermarket;

ALTER TABLE employees ADD FOREIGN KEY (dept_id) REFERENCES departments(d_id) ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE managers ADD FOREIGN KEY (dept_id) REFERENCES departments(d_id) ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE products ADD FOREIGN KEY (supplier_id) REFERENCES suppliers(s_id) ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE customers MODIFY COLUMN phone VARCHAR(30) NOT NULL;
ALTER TABLE employees MODIFY COLUMN phone VARCHAR(30) NOT NULL;
ALTER TABLE managers MODIFY COLUMN phone VARCHAR(30) NOT NULL;
ALTER TABLE suppliers MODIFY COLUMN s_phone VARCHAR(30) NOT NULL;
ALTER TABLE promos DROP COLUMN consumptions;