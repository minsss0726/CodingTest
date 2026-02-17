-- 코드를 입력하세요
select month(cr1.start_date) as month, cr1.car_id as car_id, count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as cr1
join (SELECT cr.car_id as car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as cr
where cr.start_date between '2022-08-01' and '2022-10-31'
group by cr.car_id
having count(*) >= 5) as cr2
where cr1.car_id = cr2.car_id and cr1.start_date between '2022-08-01' and '2022-10-31'
group by cr1.car_id, month(cr1.start_date)
order by month(cr1.start_date) asc, cr1.car_id desc;

# SELECT cr.car_id as car_id, count(*)
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY as cr
# where cr.start_date between '2022-08-01' and '2022-10-31'
# group by cr.car_id
# having count(*) >= 5