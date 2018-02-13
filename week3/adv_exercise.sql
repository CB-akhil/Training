select name from students inner join marks on students.id=student_id where annual is null and quarterly is null and half_yearly is null;

select name,sum(annual) as total,year from students inner join marks on students.id=student_id group by student_id,year;

select name,sum(quarterly) as total,grade from students inner join marks on students.id=student_id where year=2003 group by student_id;











