/* Write a query to count the number of students across departments who has scored more than 80 marks.*/

select Department, COUNT(CASE WHEN marks > 80 then 1 else null end) as Dept_HighScore_Count From student group by Department;
