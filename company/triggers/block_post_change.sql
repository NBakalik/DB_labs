DROP TRIGGER IF EXISTS block_post_change;

DELIMITER //
CREATE
    TRIGGER block_post_change
    BEFORE UPDATE
    ON post
    FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You can`t change post table';
END //
DELIMITER ;