-- 코드를 작성해주세요
select ed1.id as id, ed1.genotype as genotype, (select ed2.genotype
             from ecoli_data as ed2
             where ed1.parent_id = ed2.id
             and ed2.genotype = ed2.genotype & ed1.genotype) as PARENT_GENOTYPE
from ecoli_data as ed1
where exists (select 1
             from ecoli_data as ed2
             where ed1.parent_id = ed2.id
             and ed2.genotype = ed2.genotype & ed1.genotype)
order by id;
