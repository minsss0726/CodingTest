-- 코드를 작성해주세요
select hd.dept_id as dept_id, hd.dept_name_en as dept_name_en, he.avg_sal as avg_sal
from HR_DEPARTMENT as hd join(
select dept_id, round(avg(sal)) as avg_sal
from HR_EMPLOYEES 
group by dept_id) as he
on hd.dept_id = he.dept_id
order by 3 desc;