select distinct maker, type
from product
order by maker desc;

select *
from trip
where TIME(time_out) >= '12:00:00'
  and TIME(time_out) <= '17:00:00';

select maker, product.model, type, speed
from product,
     laptop
where product.model = laptop.model
  and speed > 600;

select distinct maker
from product
where type = 'PC'
  and maker = any (select maker from product where type = 'Laptop');

select name, launched, displacement
from ships
         join classes on ships.class = classes.class
where launched > 1922
  and displacement > 35000;

select concat('модель: ', model)    model,
       concat('швидкість: ', speed) speed,
       concat('ram: ', ram)         ram,
       concat('hd: ', hd)           hd,
       concat('cd: ', cd)           cd,
       concat('ціна: ', price)      price
from pc;

select date, count(date)
from pass_in_trip
         join trip on pass_in_trip.trip_no = trip.trip_no
where town_to = 'Moscow'
group by date;

select speed, avg(price)
from pc
where speed > 600
group by speed;

select maker, CASE when count(p.model) > 0 then concat('yes(', count(p.model), ')') else 'no' end as printer
from product
         left join printer p on product.model = p.model
group by maker;

select classes.class, count(name)
from classes
         right join (select name, class
                     from Ships
                     union
                     select ship, null
                     from outcomes) s on classes.class = s.class
group by classes.class