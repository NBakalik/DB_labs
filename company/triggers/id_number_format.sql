DROP TRIGGER IF EXISTS employee_id_number_format;

DELIMITER //
CREATE
    TRIGGER employee_id_number_format
    BEFORE INSERT
    ON employee
    FOR EACH ROW
BEGIN
    IF NEW.id_number RLIKE ('00$') THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'id number cannot end with 00';
    END IF;
END //
DELIMITER ;