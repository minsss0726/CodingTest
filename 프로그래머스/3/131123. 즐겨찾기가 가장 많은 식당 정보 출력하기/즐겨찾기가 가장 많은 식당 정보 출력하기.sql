-- 코드를 입력하세요
select ri2.food_type as food_type, ri1.rest_id as rest_id, ri1.rest_name as rest_name, ri2.favorites as favorites
from rest_info as ri1 join
(SELECT ri.food_type as food_type, max(favorites) as favorites
from rest_info as ri
group by ri.food_type) as ri2
on ri1.food_type = ri2.food_type and ri1.favorites = ri2.favorites
order by ri1.food_type desc;
