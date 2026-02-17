-- 코드를 입력하세요
select b.writer_id, u.nickname, b.total_sales
from (SELECT b.writer_id as writer_id, sum(price) as total_sales
from USED_GOODS_BOARD as b
where b.status = 'DONE'
group by b.writer_id
having sum(price) >= 700000) b
join used_goods_user as u
on b.writer_id = u.user_id
order by 3 asc;
