SET GLOBAL log_bin_trust_function_creators = 1;

DROP FUNCTION IF EXISTS find_min_experience;

DELIMITER //
CREATE FUNCTION find_min_experience() RETURNS INT
BEGIN
    RETURN (SELECT MIN(experience) FROM employee);
END //
DELIMITER ;

SELECT *
FROM employee
WHERE experience = find_min_experience();

