-- 코드를 작성해주세요
select ed1.id as id
from ECOLI_DATA as ed1
where exists (
    select 1
    from ECOLI_DATA as ed2
    where ed2.id = ed1.parent_id and exists
    (
    select 1
    from ECOLI_DATA as ed3
    where ed3.id = ed2.parent_id and ed3.parent_id is null))
order by 1;