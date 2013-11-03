-- Get totale omzet ongeacht tickettype
SELECT SUM(result) FROM (
	SELECT (COUNT(t.ticket_type_id) * tt.prijs) AS result 
	FROM ticket AS t, ticket_type AS tt 
	WHERE t.ticket_type_id = tt.id 
	GROUP BY t.ticket_type_id
) AS A