DROP PROCEDURE IF EXISTS create_tables;

DELIMITER //
CREATE PROCEDURE create_tables()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE name VARCHAR(20);
    DECLARE amount INT DEFAULT (SELECT count(*) from employee);
    DECLARE employee_cursor CURSOR FOR SELECT employee.name FROM employee;
    DECLARE CONTINUE HANDLER FOR NOT FOUND
        SET done = TRUE;
    OPEN employee_cursor;

    employee_loop:
    LOOP
        FETCH employee_cursor INTO name;
        IF done = TRUE THEN
            LEAVE employee_loop;
        END IF;
        SET @table_count = 1;
        while_loop:
        WHILE @table_count < amount
            DO
                SET @new_table = CONCAT('CREATE TABLE IF NOT EXISTS ', name, '(id INT, name VARCHAR(20));');
                SELECT @new_table;
                PREPARE stmt FROM @new_table;
                EXECUTE stmt;
                SET @table_count = @table_count + 1;
            END WHILE;
    END LOOP;
    CLOSE employee_cursor;
END;
//

call create_tables();