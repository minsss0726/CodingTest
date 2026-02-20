-- 코드를 작성해주세요
select ed1.id as id, 
                (select count(ed2.id)
                from ECOLI_DATA as ed2
                where ed2.parent_id = ed1.id) as child_count
from ECOLI_DATA as ed1
order by 1 asc;
