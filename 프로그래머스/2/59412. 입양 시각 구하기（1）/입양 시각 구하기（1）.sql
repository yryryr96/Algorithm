select hour(datetime) as hour, count(animal_id)
from animal_outs
where hour(datetime) between 9 and 19
group by hour(datetime)
order by hour;