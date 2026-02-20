WITH ranked AS (
    SELECT id,
           ROW_NUMBER() OVER (ORDER BY size_of_colony DESC) AS rn,
           COUNT(*) OVER () AS total_count
    FROM ecoli_data
)

SELECT id,
       CASE
           WHEN rn <= total_count * 0.25 THEN 'CRITICAL'
           WHEN rn <= total_count * 0.50 THEN 'HIGH'
           WHEN rn <= total_count * 0.75 THEN 'MEDIUM'
           ELSE 'LOW'
       END AS COLONY_NAME
FROM ranked
ORDER BY id ASC;