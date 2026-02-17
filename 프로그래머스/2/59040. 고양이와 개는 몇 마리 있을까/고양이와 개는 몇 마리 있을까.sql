-- 코드를 입력하세요
SELECT animal_type, count(*) as count
from ANIMAL_INS
where animal_type in ('Cat','Dog')
group by animal_type
order by 1 asc