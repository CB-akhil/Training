
              -- Students table

#Select all the students
select * from students; 

#Select all the students whose names starts with “H”
select * from students where students.name like 'h%';

#Select all the students whose name has the alphabet “a”
select * from students where students.name like '%a%';

#Select all the students and list the results sorted in alphabetical order(a-z).
select * from students order by name;

#List the first “2” students with the results sorted in the alphabetical order(a-z).
select * from students order by name limit 2;

#List the next “2” students(3rd and 4th) when they are sorted in the alphabetical order.
select * from students order by name limit 2 offset 2;
