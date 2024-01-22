# Write your MySQL query statement below

-- SELECT v.customer_id, COUNT(v.visit_id) AS count_no_trans 
-- from Visits v 
-- LEFT JOIN Transactions t ON v.visit_id = t.visit_id  
-- WHERE t.amount IS NULL 
-- GROUP BY v.customer_id; 

SELECT customer_id, COUNT(visit_id) as count_no_trans
FROM visits
WHERE visit_id NOT IN(SELECT visit_id FROM transactions)
GROUP BY customer_id;