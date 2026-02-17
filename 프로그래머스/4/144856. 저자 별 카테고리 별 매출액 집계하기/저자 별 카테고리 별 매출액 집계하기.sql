-- 코드를 입력하세요



select b.author_id, a.author_name as author_name, b.category as category, sum(b.price * bs.sales) as total_sales
from (SELECT bs.book_id as book_id, sum(sales) as sales
from book_sales as bs
where bs.sales_date between '2022-01-01' and '2022-01-31'
group by bs.book_id) as bs
join book as b
on bs.book_id = b.book_id
join author as a
on a.author_id = b.author_id
group by b.author_id, b.category
order by author_id asc, category desc;