-- 코드를 입력하세요
select mp.member_name as member_name , rr1.review_text as review_text, date_format(rr1.review_date,'%Y-%m-%d') as review_date
from REST_REVIEW as rr1 join (
SELECT member_id
from REST_REVIEW
group by member_id 
order by count(review_id) desc
limit 1) as rr2
on rr1.member_id = rr2.member_id
join MEMBER_PROFILE as mp
on rr1.member_id = mp.member_id
order by 3 asc, 2 asc;
