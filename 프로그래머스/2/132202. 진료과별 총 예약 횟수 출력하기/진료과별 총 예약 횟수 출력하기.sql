-- 코드를 입력하세요
SELECT ap.mcdp_cd as '진료과코드', count(distinct pt_no) as '5월예약건수'
from appointment as ap
where ap.apnt_ymd between '2022-05-01 00:00:00' and '2022-05-31 23:59:59'
group by ap.mcdp_cd
order by 2 asc, 1 asc;