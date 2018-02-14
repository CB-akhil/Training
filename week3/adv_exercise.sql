

		--joints and Subquries Exercise 2

/*	List the students who didn’t appear for any exams.
Format: name	*/
select name from students inner join marks on students.id=student_id where annual is null and quarterly is null and half_yearly is null;

/*	Find the total marks scored by each students in the annual exams. If the student hasn’t appeared for any annual exam, he should still be listed with total marks scored as “0”.
Format: name, marks, year	*/
select name,sum(annual) as total,year from students inner join marks on students.id=student_id group by student_id,year;

/*	List the students with the total marks scored in quarterly from all the subjects they had appeared during the year 2003.
Format: name, total, grade	*/
select name,sum(quarterly) as total,grade from students inner join marks on students.id=student_id where year=2003 group by student_id;

/*	List the 9th and 10th grade students who received more than 3 medals.
Format: name, grade, no_of_medals	*/
select name,grade,count(medal_won) as no_of_medals from students inner join medals on students.id=student_id where (grade = 9 or grade=10) group by student_id,grade having count(medal_won)>3;

/*	List the students who got less than 2 medals. This should also include the students who has not won any medals.
Format: name, grade, no_of_medals	*/
select name,grade,count(medal_won) as no_of_medals from students left join medals on students.id=student_id group by student_id,grade having count(medal_won)<3;

/*	List the students who has not yet received any medals but scored more than 90 marks in all the subjects in the annual exam for that year.
Format: name, year	*/
select name,medals.year from students inner join marks on students.id=student_id left join medals on students.id=medals.student_id and marks.year=medals.year where annual > 90 group by students.id,marks.year having count(medal_won)<1;

/*	List the records from the medals table for the students who had won more than 3 medals.
Format: name, game_id, medal_won, year, grade	*/
select name,game_id,medal_won,year,grade from students inner join medals on students.id=student_id group by name having count(medal_won)>3;
-- second one is exact one. need to find alternate simple way to do same thing. (count in filter part)
select s.name,m.game_id,m.medal_won,m.year,m.grade from students s, (select student_id from medals group by student_id having count(medal_won)>3) as a,medals as m where a.student_id=m.student_id and m.student_id=s.id;

/*	List the number of medals and percentage of marks(based on total for the 5 subjects) scored in each year.
Format: name, medals, quarterly_per, half_yearly_per, annual_per, year, grade	*/
select name,c.medals,c.quarterly_per,c.half_yearly_per,c.annual_per,c.year,c.grade 
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

/*	Lets assign some rating for the total marks scored - S(450-500), A(400-449), B(350-399), C(300-349), D(250,299), E(200-249), F(below 200). List the students with the grade obtained in each year for each exam(quarterly, half-yearly and annual)
Format: name, quarterly_rating, half_yearly_rating, annual_rating, year, grade	*/
select name,
If((sum(quarterly)<=500 and sum(quarterly)>=450) ,'S',If(
(sum(quarterly)<=449 and sum(quarterly)>=400),'A',IF(
(sum(quarterly)<=399 and sum(quarterly)>=350),'B',IF(
(sum(quarterly)<=349 and sum(quarterly)>=300),'C',IF(
(sum(quarterly)<=299 and sum(quarterly)>=250),'D',IF(
(sum(quarterly)<=249 and sum(quarterly)>=200),'E',IF(
sum(quarterly)<200,'F','f'))))))) as quarterly_rating,
If((sum(half_yearly)<=500 and sum(half_yearly)>=450) ,'S',If(
(sum(half_yearly)<=449 and sum(half_yearly)>=400),'A',IF(
(sum(half_yearly)<=399 and sum(half_yearly)>=350),'B',IF(
(sum(half_yearly)<=349 and sum(half_yearly)>=300),'C',IF(
(sum(half_yearly)<=299 and sum(half_yearly)>=250),'D',IF(
(sum(half_yearly)<=249 and sum(half_yearly)>=200),'E',IF(
sum(half_yearly)<200,'F','f'))))))) as half_yearly_rating,
If((sum(annual)<=500 and sum(annual)>=450) ,'S',If(
(sum(annual)<=449 and sum(annual)>=400),'A',IF(
(sum(annual)<=399 and sum(annual)>=350),'B',IF(
(sum(annual)<=349 and sum(annual)>=300),'C',IF(
(sum(annual)<=299 and sum(annual)>=250),'D',IF(
(sum(annual)<=249 and sum(annual)>=200),'E',IF(
sum(annual)<200,'F','f'))))))) as annual_rating,
year,
grade
from students
inner join marks
on students.id=student_id
group by student_id,grade;



