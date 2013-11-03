-- Get top 10 meest bezochte optredens
SELECT o.id AS optreden_id, COUNT(t.zone_id) AS counter FROM tracking t, optreden o
WHERE t.timestampIn < o.start_date AND t.timestampOut > o.eind_date 
OR t.timestampIn > o.start_date AND t.timestampIn <= o.eind_date 
GROUP BY o.id
ORDER BY counter DESC LIMIT 10