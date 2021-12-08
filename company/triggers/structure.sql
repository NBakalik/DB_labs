DROP TRIGGER IF EXISTS pharmacy_street_fk;
DROP TRIGGER IF EXISTS employee_post_fk;
DROP TRIGGER IF EXISTS post_delete;
DROP TRIGGER IF EXISTS street_delete;
DROP TRIGGER IF EXISTS effect_zone_delete;
DROP TRIGGER IF EXISTS drugs_delete;
DROP TRIGGER IF EXISTS pharmacy_delete;

DELIMITER //
CREATE TRIGGER pharmacy_street
    BEFORE INSERT
    ON pharmacy
    FOR EACH ROW
BEGIN
    IF (NEW.street NOT IN (SELECT name from street))
    THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No such street in street table';
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER employee_post
    BEFORE INSERT
    ON employee
    FOR EACH ROW
BEGIN
    IF (NEW.post NOT IN (SELECT name from post))
    THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No such post in post table';
    END IF;

    IF (NEW.pharmacy_id NOT IN (SELECT id from pharmacy))
    THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No such pharmacy in pharmacy table';
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER post_delete
    BEFORE DELETE
    ON post
    FOR EACH ROW
BEGIN
    IF (OLD.name IN (SELECT post FROM employee))
    THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cant delete post';
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER street_delete
    BEFORE DELETE
    ON street
    FOR EACH ROW
BEGIN
    IF (OLD.name IN (SELECT street FROM pharmacy))
    THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cant delete street';
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER effect_zone_delete
    BEFORE DELETE
    ON effect_zone
    FOR EACH ROW
BEGIN
    IF (OLD.id IN (SELECT id_zone FROM drug_zone_joint))
    THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cant delete effect zone';
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER drugs_delete
    BEFORE DELETE
    ON drug_list
    FOR EACH ROW
BEGIN
    IF (OLD.id IN (SELECT id_drug FROM drug_zone_joint))
    THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cant delete drug from drug_zone_joint';
    END IF;

    IF (OLD.id IN (SELECT id_drug FROM pharmacy_drug_joint))
    THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cant delete drug from pharmacy_drug_joint';
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER pharmacy_delete
    BEFORE DELETE
    ON pharmacy
    FOR EACH ROW
BEGIN
    IF (OLD.id IN (SELECT id_pharmacy FROM pharmacy_drug_joint))
    THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cant delete pharmacy from pharmacy_drug_joint';
    END IF;
END //
DELIMITER ;
