-- 코드를 입력하세요
# select bk.category as category, sum(bs.total_sales) as total_sales
# from book as bk join (
# SELECT bs.book_id as book_id, count(*) as total_sales
# from book_sales as bs
# where bs.sales_date between '2022-01-01' and '2022-01-31'
# group by bs.book_id) as bs
# on bk.book_id = bs.book_id
# group by bk.category
# order by 1 asc;

select bk.category as category, sum(bs.total_sales) as total_sales
from (SELECT bs.book_id as book_id, sum(sales) as total_sales
from book_sales as bs
where bs.sales_date between '2022-01-01' and '2022-01-31'
group by bs.book_id) bs
join book as bk
on bs.book_id = bk.book_id
group by bk.category
order by 1 asc;

