-- 코드를 입력하세요
select year(os.sales_date) as year, month(os.sales_date) as month, gender, count(distinct os.user_id) as users
from ONLINE_SALE as os
join (select ui.user_id as user_id, ui.gender as gender
from user_info as ui
where ui.gender is not null) as ui
on os.user_id = ui.user_id
where ui.gender is not null
group by year(os.sales_date), month(os.sales_date), ui.gender
order by 1 asc,2 asc,3 asc;