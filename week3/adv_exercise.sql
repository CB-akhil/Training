

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


/*	List the students who got less than 2 medals. This should also include the students who has not won any medals.
Format: name, grade, no_of_medals	*/


/*	List the students who has not yet received any medals but scored more than 90 marks in all the subjects in the annual exam for that year.
Format: name, year	*/


/*	List the records from the medals table for the students who had won more than 3 medals.
Format: name, game_id, medal_won, year, grade	*/


/*	List the number of medals and percentage of marks(based on total for the 5 subjects) scored in each year.
Format: name, medals, quarterly_per, half_yearly_per, annual_per, year, grade	*/


/*	Lets assign some rating for the total marks scored - S(450-500), A(400-449), B(350-399), C(300-349), D(250,299), E(200-249), F(below 200). List the students with the grade obtained in each year for each exam(quarterly, half-yearly and annual)
Format: name, quarterly_rating, half_yearly_rating, annual_rating, year, grade	*/

