-- 코드를 작성해주세요
with recursive gen as (
select ed1.id as id, ed1.parent_id as parent_id, 1 as generation
from ecoli_data as ed1
where ed1.parent_id is null
union all
select ed2.id as id, ed2.parent_id as parent_id, g.generation + 1 as generation
from ecoli_data as ed2
join gen as g
on ed2.parent_id = g.id)

select count(g1.id) as count, g1.generation as generation
from gen as g1
where not exists (select 1
             from ecoli_data as ed
             where g1.id = ed.parent_id)
group by g1.generation 
order by 2 asc;