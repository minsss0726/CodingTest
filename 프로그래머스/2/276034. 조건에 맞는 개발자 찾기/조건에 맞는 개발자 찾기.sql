SELECT distinct(id), email, first_name, last_name
FROM developers as A JOIN skillcodes as B ON A.skill_code & B.code = B.code
where name in ('Python', 'C#')
order by id;