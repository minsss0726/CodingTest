-- 코드를 작성해주세요
select id, 
    case 
    when SIZE_OF_COLONY > 1000 then 'HIGH'
    when SIZE_OF_COLONY <= 1000 and SIZE_OF_COLONY > 100 then 'MEDIUM'
    else 'LOW' end as size
from ecoli_data
order by id
