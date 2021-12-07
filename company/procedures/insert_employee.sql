USE lab7_db;

DROP PROCEDURE IF EXISTS insert_employee;

DELIMITER //
CREATE PROCEDURE insert_employee(name VARCHAR(20),
                                 surname VARCHAR(20),
                                 id_number VARCHAR(10),
                                 passport_number VARCHAR(9),
                                 experience INT(2),
                                 birthday DATE,
                                 post VARCHAR(15),
                                 pharmacy_id INT)
BEGIN
    INSERT INTO employee(name, surname, id_number, passport_number, experience, birthday, post, pharmacy_id)
    VALUES (name, surname, id_number, passport_number, experience, birthday, post, pharmacy_id);
END //
DELIMITER ;