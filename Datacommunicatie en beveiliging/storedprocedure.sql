DELIMITER $$
DROP PROCEDURE IF EXISTS get_name $$
CREATE PROCEDURE get_name(vName VARCHAR)
BEGIN
  SELECT `name` into @ver FROM `name` WHERE `name` = vName LIMIT 1;  
END $$
DELIMITER ;
