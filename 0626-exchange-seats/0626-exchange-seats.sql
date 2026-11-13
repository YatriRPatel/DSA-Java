# Write your MySQL query statement below
SELECT 
IF(id % 2 = 1, 
IF(id = (SELECT MAX(id) FROM Seat), id, id + 1), id - 1) AS id,student
FROM Seat
ORDER BY id;
