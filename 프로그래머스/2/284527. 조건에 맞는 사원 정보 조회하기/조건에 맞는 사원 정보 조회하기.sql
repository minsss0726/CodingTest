-- 코드를 작성해주세요
select hg.score as score, he.emp_no as emp_no, he.emp_name as emp_name, he.position as position, he.email as email
from HR_EMPLOYEES as he join(
select emp_no, sum(score) as score
from hr_grade
group by emp_no 
order by score desc
limit 1) as hg
on he.emp_no = hg.emp_no

