-- 코드를 입력하세요
with RECURSIVE hours as (
    select 0 as hour
    union all
    select hour + 1
    from hours
    where hour < 23
)

SELECT h.hour, count(ao.animal_id) as count
from hours as h left join ANIMAL_OUTS as ao
on h.hour = hour(ao.datetime)
group by h.hour
order by 1 asc;