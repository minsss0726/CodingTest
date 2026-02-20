-- 코드를 입력하세요
select p.product_code as product_code, p.price * os.total_sales_amount as sales
from product as p join(
SELECT product_id, sum(sales_amount) as total_sales_amount
from offline_sale 
group by product_id) as os
on p.product_id = os.product_id
order by 2 desc, 1 asc;