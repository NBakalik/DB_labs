USE lab7_db;

DROP PROCEDURE IF EXISTS insert_drug_zone_joint;

DELIMITER //
CREATE PROCEDURE insert_drug_zone_joint(id_drug INT, id_zone INT)
BEGIN
    IF (EXISTS(SELECT * FROM drug_list WHERE id = id_drug) AND
        EXISTS(SELECT * FROM effect_zone WHERE id = id_zone)) THEN
        INSERT INTO drug_zone_joint
        VALUES (id_drug, id_zone);
    end if;
END //
DELIMITER ;