-- 코드를 입력하세요
SELECT name, datetime
from ANIMAL_INS 
where animal_id not in (select animal_id
                        from animal_outs)
order by datetime asc
limit 3;