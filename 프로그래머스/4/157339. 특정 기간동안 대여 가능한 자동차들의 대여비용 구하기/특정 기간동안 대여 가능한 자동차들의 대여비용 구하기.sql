with car as (select car.car_id as car_id, car.car_type as car_type, car.daily_fee as daily_fee
from CAR_RENTAL_COMPANY_CAR as car
join (
SELECT DISTINCT h1.CAR_ID as car_id
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h1
WHERE NOT EXISTS (
    SELECT 1
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h2
    WHERE h1.CAR_ID = h2.CAR_ID
      AND h2.START_DATE <= '2022-11-30'
      AND h2.END_DATE >= '2022-11-01'
)) as history
on car.car_id = history.car_id
where car.car_type in ('SUV','세단')),
plan as (select car_type, DISCOUNT_RATE
from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
where car_type in ('SUV','세단') and DURATION_TYPE = '30일 이상')

select car.car_id as car_id, car.car_type as car_type, round(car.daily_fee * (1 - plan.DISCOUNT_RATE / 100.0) * 30) as fee
from car 
join plan 
on car.car_type = plan.car_type
WHERE car.daily_fee * (1 - plan.DISCOUNT_RATE / 100.0) * 30 >= 500000
  AND car.daily_fee * (1 - plan.DISCOUNT_RATE / 100.0) * 30 < 2000000
order by fee desc, car_type asc, car_id desc;


