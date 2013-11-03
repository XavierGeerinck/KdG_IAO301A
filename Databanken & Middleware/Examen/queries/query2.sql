-- Get top 10 meest bezochte optredens
SELECT o.id AS optreden_id, COUNT(A.zone_id) AS counter FROM (
	SELECT zone_id,
	MAX(CASE WHEN in_out=0 THEN timestamp ELSE NULL END) AS in_time,
	MAX(CASE WHEN in_out=1 THEN timestamp ELSE NULL END) AS out_time
	FROM tracking
	GROUP BY zone_id, trackingNummer
) AS A, optreden o
WHERE A.in_time < o.start_date AND A.out_time > o.eind_date
GROUP BY o.id
ORDER BY counter DESC LIMIT 10