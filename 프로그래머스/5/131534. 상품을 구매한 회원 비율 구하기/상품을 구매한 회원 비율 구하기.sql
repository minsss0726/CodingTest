with ui as (
select user_id
from user_info
where year(joined) = 2021),
count_user_2021 as (
select count(ui.user_id) as count
from ui)

select year(sales_date) as year, month(sales_date) as month, 
    count(distinct os.user_id) as PURCHASED_USERS, 
    round(count(distinct os.user_id)/count_user_2021.count,1) as PUCHASED_RATIO
from online_sale as os join ui
on ui.user_id = os.user_id
join count_user_2021
group by year(sales_date), month(sales_date)
order by year, month