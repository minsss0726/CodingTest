-- 코드를 입력하세요
SELECT ii.INGREDIENT_TYPE as INGREDIENT_TYPE, sum(total_order) as total_order
from first_half as fh
join icecream_info as ii
on fh.flavor = ii.flavor
group by INGREDIENT_TYPE
order by total_order asc;