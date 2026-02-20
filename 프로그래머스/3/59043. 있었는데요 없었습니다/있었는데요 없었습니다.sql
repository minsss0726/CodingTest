-- 코드를 입력하세요
SELECT ai.animal_id as animal_id, ai.name as name
from animal_ins as ai
join animal_outs as ao
on ai.animal_id = ao.animal_id
where ai.datetime > ao.datetime
order by ai.datetime asc;