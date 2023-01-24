insert into address(city, state, zipcode) values('Fairfield','IA','52557');
insert into address(city, state, zipcode) values('Fairfield','IA','52556');

insert into course_details (id, credit, description, last_update, program) values(1,4,'Modern Programming Practices', null,'BSC');
insert into course_details (id, credit, description, last_update, program) values(2,4,'Web Application Architecture',null,'MSC');
insert into course_details (id, credit, description, last_update, program) values(3,4,'Modern Web Applications',null,'MSC');
insert into course_details (id, credit, description, last_update, program) values(4,4,'Enterprise Architecture',null,'MSC');
insert into course_details (id, credit, description, last_update, program) values(5,4,'Software Architecture',null,'MSC');

insert into course (id, name, course_details_id) values('CS-401','MPP', 1);
insert into course (id, name, course_details_id) values('CS-545','WAA', 2);
insert into course (id, name, course_details_id) values('CS-544','MWA', 3);
insert into course (id, name, course_details_id) values('CS-550','EA', 4);
insert into course (id, name, course_details_id) values('CS-590','SA', 5);

insert into student (gpa, name, address_id) values(3.5, 'Student 1',1);
insert into student (gpa, name, address_id) values(3.9, 'Student 2',1);
insert into student (gpa, name, address_id) values(4.0, 'Student 3',1);
insert into student (gpa, name, address_id) values(4.0, 'Student 4',1);
insert into student (gpa, name, address_id) values(3.6, 'Student 5',1);
insert into student (gpa, name, address_id) values(3.8, 'Student 6',1);
insert into student (gpa, name, address_id) values(3.9, 'Student 7',1);
insert into student (gpa, name, address_id) values(3.0, 'Student 8',1);
insert into student (gpa, name, address_id) values(2.8, 'Student 9',1);
insert into student (gpa, name, address_id) values(3.3, 'Student 10',1);

insert into student_courses(students_id, courses_id) values(1,'CS-401');
--insert into student_courses(students_id, courses_id) values(1,'CS-545');
--insert into student_courses(students_id, courses_id) values(1,'CS-544');
--insert into student_courses(students_id, courses_id) values(1,'CS-550');

insert into student_courses(students_id, courses_id) values(2,'CS-401');
insert into student_courses(students_id, courses_id) values(2,'CS-550');
insert into student_courses(students_id, courses_id) values(1,'CS-590');

insert into student_courses(students_id, courses_id) values(3,'CS-401');
insert into student_courses(students_id, courses_id) values(4,'CS-401');
insert into student_courses(students_id, courses_id) values(5,'CS-401');
insert into student_courses(students_id, courses_id) values(6,'CS-401');
insert into student_courses(students_id, courses_id) values(7,'CS-401');
insert into student_courses(students_id, courses_id) values(8,'CS-401');
insert into student_courses(students_id, courses_id) values(9,'CS-401');
insert into student_courses(students_id, courses_id) values(10,'CS-401');