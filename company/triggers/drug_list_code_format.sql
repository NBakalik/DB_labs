DROP TRIGGER IF EXISTS drug_list_code_format;
DROP TRIGGER IF EXISTS drug_list_code_format_upd;

DELIMITER //
CREATE
    TRIGGER drug_list_code_format
    BEFORE INSERT
    ON drug_list
    FOR EACH ROW
BEGIN
    IF NEW.code NOT REGEXP '[^МП]{2}-[0-9]{3}-[0-9]{2}' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'code must match format ##-###-##';
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE
    TRIGGER drug_list_code_format_upd
    BEFORE UPDATE
    ON drug_list
    FOR EACH ROW
BEGIN
    IF NEW.code NOT REGEXP '[^МП]{2}-[0-9]{3}-[0-9]{2}' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'code must match format ##-###-##';
    END IF;
END //
DELIMITER ;