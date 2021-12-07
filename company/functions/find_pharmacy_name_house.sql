SET GLOBAL log_bin_trust_function_creators = 1;

DROP FUNCTION IF EXISTS find_pharmacy_name_house;

DELIMITER //
CREATE FUNCTION find_pharmacy_name_house(pharmacy_id INT) RETURNS VARCHAR(50)
BEGIN
    RETURN (SELECT CONCAT(name, ' ', house_number) FROM pharmacy WHERE id = pharmacy_id);
END //
DELIMITER ;

SELECT find_pharmacy_name_house(1)
FROM pharmacy
