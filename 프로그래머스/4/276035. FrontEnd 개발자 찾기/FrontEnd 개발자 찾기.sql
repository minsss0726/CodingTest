-- 코드를 작성해주세요
with front_skill as (
select code
from skillcodes
where category = 'Front End')

select de.id as id, de.email as email, de.first_name as first_name, de.last_name as last_name
from DEVELOPERS as de
join front_skill as fs
on de.skill_code & fs.code
group by de.id, de.email, de.first_name, de.last_name
order by 1 asc;