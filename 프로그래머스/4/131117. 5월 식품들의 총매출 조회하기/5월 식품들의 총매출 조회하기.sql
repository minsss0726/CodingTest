-- 코드를 입력하세요
select fp.product_id as product_id, fp.product_name as product_name , fp.price * fo.total_amount as total_sales
from FOOD_PRODUCT as fp join(
SELECT product_id, sum(amount) as total_amount
from FOOD_ORDER
where year(PRODUCE_DATE) = 2022 and month(PRODUCE_DATE) = 5
group by product_id) as fo
on fp.product_id = fo.product_id
order by 3 desc, 1 asc;