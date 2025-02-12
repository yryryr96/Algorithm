select car_type, count(car_id) as CARS 
from CAR_RENTAL_COMPANY_CAR c 
where options like '%가죽시트%' or options like '%열선시트%' or options like '%통풍시트%'
group by car_type 
order by car_type;