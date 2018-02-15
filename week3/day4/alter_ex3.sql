create table students_summary(
student_id bigint,
student_name varchar(100),
year int,
percentage numeric(2,2),
no_of_medals_received int,
foreign key (student_id) references students(id)
);

insert into students_summary 
select name as student_name,c.medals as no_of_medals_received,
c.annual_per as percentage,c.year,c.grade 
from students 
inner join (
select medals,quarterly_per,half_yearly_per,annual_per,a.student_id,year,a.grade 
from (
select count(medal_won) as medals,student_id,year,grade 
from medals 
group by student_id,grade
) as a 
inner join (
select grade,avg(annual) as annual_per,avg(quarterly) as quarterly_per,avg(half_yearly) as half_yearly_per,student_id 
from marks 
group by student_id,grade
) as b 
on (a.student_id=b.student_id and a.grade=b.grade) 
) as c 
on c.student_id=students.id;