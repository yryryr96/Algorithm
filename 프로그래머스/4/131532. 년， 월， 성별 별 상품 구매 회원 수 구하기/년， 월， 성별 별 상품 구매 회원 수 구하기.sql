SELECT year(sales_date) as YEAR, month(sales_date) as MONTH, gender, count(distinct(o.user_id)) as COUNT
from online_sale as o
join user_info as u
on o.user_id = u.user_id
where gender is not null
group by year(sales_date), month(sales_date), u.gender
order by year(sales_date), month(sales_date), u.gender