select count(fi.id) as fish_count, fn.fish_name
from fish_info as fi
join fish_name_info as fn
on fi.fish_type = fn.fish_type
group by fn.fish_name
order by 1 desc;