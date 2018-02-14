(select count(medal_won) as medals,student_id from medals group by student_id) as a
(select avg(annual) as percentage,student_id from marks group by student_id,grade) as b
(select medals,average,a.student_id  from a inner join b on a.student_id = b.student_id) as c
select name,c.medals,c.average  form c inner join students on c.student_id=students.id;
