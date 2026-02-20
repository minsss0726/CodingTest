-- 코드를 입력하세요
SELECT fh.flavor
from FIRST_HALF as fh
join (
select flavor, sum(total_order) as july_total_order
from july 
group by flavor) as ju
on fh.flavor = ju.flavor
order by fh.total_order + ju.july_total_order desc
limit 3;
