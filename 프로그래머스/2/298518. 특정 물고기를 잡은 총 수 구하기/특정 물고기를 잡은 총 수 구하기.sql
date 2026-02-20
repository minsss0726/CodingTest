-- 코드를 작성해주세요
select count(*) as fish_count
from FISH_INFO as fi join(
select fish_type 
from fish_name_info
where fish_name in ('BASS','SNAPPER')) as fni
on fi.fish_type = fni.fish_type;