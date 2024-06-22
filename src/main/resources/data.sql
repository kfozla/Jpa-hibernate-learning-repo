INSERT INTO Course (id, name, last_updated_date, created_date,is_deleted)
VALUES (10001, 'JPA Course', '2020-05-05', '2020-05-05',false);
INSERT INTO Course (id, name, last_updated_date, created_date,is_deleted)
VALUES (10002, 'Spring Course', '2020-05-05', '2020-05-05',false);
INSERT INTO Course (id, name, last_updated_date, created_date,is_deleted)
VALUES (10003, 'Spring Boot Course', '2020-05-05', '2020-05-05',false);

INSERT INTO Passport (id, number)
VALUES (40001, 'E123');
INSERT INTO Passport (id, number)
VALUES (40002, 'E1234');
INSERT INTO Passport (id, number)
VALUES (40003, 'E12345');

INSERT INTO Student (id, name,passport_id)
VALUES (20001, 'Ranga',40001);
INSERT INTO Student (id, name,passport_id)
VALUES (20002, 'Adam',40002);
INSERT INTO Student (id, name,passport_id)
VALUES (20003, 'Jane',40003);

INSERT INTO Review (id, rating, description, course_id)
VALUES (50001, '5','Great course','10001');
INSERT INTO Review (id,rating ,description, course_id)
VALUES (50002, '3','OK course','10001');
INSERT INTO Review (id,rating, description, course_id)
VALUES (50003, '1','Bad course','10003');

INSERT INTO student_course(student_id,course_id)
VALUES(20001,10001);
INSERT INTO student_course(student_id,course_id)
VALUES(20002,10001);
INSERT INTO student_course(student_id,course_id)
VALUES(20003,10001);
INSERT INTO student_course(student_id,course_id)
VALUES(20001,10003);



