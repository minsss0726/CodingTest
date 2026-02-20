-- 코드를 입력하세요
SELECT ai.animal_id as animal_id, ai.animal_type as animal_type, ai.name as name
from animal_ins as ai
join animal_outs as ao
on ai.animal_id = ao.animal_id
where ai.SEX_UPON_INTAKE in ('Intact Male','Intact female') and
    ao.SEX_UPON_OUTCOME in ('Spayed Female','Neutered Male')
order by 1 asc;