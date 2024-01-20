# Write your MySQL query statement below

-- Customer (id int, name varchar(25), referee_id int)

-- Q - Find the names of the customer that are not referred by the customer with id = 2.

-- SELECT name 
-- FROM Customer 
-- WHERE referee_id != 2 OR referee_id is null;


SELECT name
FROM Customer
WHERE COALESCE(referee_id,0) <> 2;