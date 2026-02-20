-- 코드를 작성해주세요
select he.emp_no as emp_no, he.emp_name as emp_name, hg.grade as grade, case
    when hg.grade = 'S' then he.SAL * 0.2
    when hg.grade = 'A' then he.SAL * 0.15
    when hg.grade = 'B' then he.SAL * 0.1
    else 0 end as bonus
from HR_EMPLOYEES as he join (
select emp_no, avg(score), case 
    when avg(score) >= 96 then 'S'
    when avg(score) >= 90 then 'A'
    when avg(score) >= 80 then 'B'
    else 'C' end as grade
from hr_grade
group by emp_no) as hg
on he.emp_no = hg.emp_no
order by 1 asc