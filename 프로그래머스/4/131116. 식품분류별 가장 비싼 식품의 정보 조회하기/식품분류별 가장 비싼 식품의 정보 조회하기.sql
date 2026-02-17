-- 코드를 입력하세요
select fd2.category as category, fd2.max_price as max_price, fd1.product_name
from food_product as fd1 join
(SELECT category , max(price) as max_price
from food_product
where category in ('과자','국','김치','식용유')
group by category) as fd2
on fd1.category = fd2.category and price = max_price
order by max_price desc;