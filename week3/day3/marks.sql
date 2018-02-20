              -- Marks Table

/*  Select the students who has not appeared in the annual exams.
Format: All columns of the “marks” table.    */
select * from marks where annual=NULL;

/*	Select the students who has not appeared in the annual exams during the year “2005”.
	Format: student_id, subject_id, year   */
select student_id,subject_id,year from marks where annual is null and year=2005;

/*	Select the students who has appeared in one of the exams - quarterly, half_yearly or annual.
	Format: student_id, subject_id, year    	   */
select student_id,subject_id,year from marks where quarterly is not null or half_yearly is not null or annual is not null;

/*	Select the students who has scored more than 90 in all the exams - quarterly, half_yearly and annual.
	Format: student_id, subject_id, year, quarterly, half_yearly, annual   */
select student_id,subject_id,year,quarterly,half_yearly,annual from marks where quarterly > 90 and half_yearly > 90 and annual > 90;

# 5) List the average marks(in quarterly, half_yearly & annual) for each subject scored for the year. Format: student_id, subject_id, average, year
select student_id,subject_id,(ifnull (quarterly,0) + ifnull(half_yearly,0) + ifnull(annual,0))/3 as average,year from marks;
/*
 6)List the average marks(in quarterly, half_yearly & annual) for each subject scored for the years 2003 & 2004
    Format: student_id, subject_id, average, year */
select student_id,subject_id,(ifnull (quarterly,0) + ifnull(half_yearly,0) + ifnull(annual,0))/3 as average,year from marks where year=2004 or year=2003;