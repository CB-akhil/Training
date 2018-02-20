create table students_summary(
student_id bigint,
student_name varchar(100),
year int,
percentage int,
no_of_medals_received int,
foreign key (student_id) references students(id)
);

insert into students_summary (student_id,student_name,no_of_medals_received,percentage,year)
select student_id,name as student_name,c.medals as no_of_medals_received,
c.annual_per as percentage,c.year
from students 
inner join (
select medals,annual_per,a.student_id,a.year,a.grade 
from (
select count(medal_won) as medals,student_id,year,grade 
from medals 
group by student_id,year
) as a 
inner JOIN (
select grade,avg(annual) as annual_per,student_id,year
from marks 
group by student_id,year
) as b 
on (a.student_id=b.student_id and a.year=b.year) 
) as c 
on c.student_id=students.id;


