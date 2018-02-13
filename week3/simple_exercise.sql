















5)
select student_id,subject_id,(ifnull (quarterly,0) + ifnull(half_yearly,0) + ifnull(annual,0))/3 as average,year from marks;

6)
select student_id,subject_id,(ifnull (quarterly,0) + ifnull(half_yearly,0) + ifnull(annual,0))/3 as average,year from marks where year=2004 or year=2003;