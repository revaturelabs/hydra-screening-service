--------------------------------------------------------
--  DDL for Sequence SCREENING_ID_SEQUENCE
--------------------------------------------------------
DROP SEQUENCE IF EXISTS SCREENING_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  SCREENING_SEQUENCE  MINVALUE 5600  INCREMENT BY 1 START WITH 5600;

Insert into SCREENING (SCREENING_ID, TRAINER_ID, TRAINEE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_ME_COMMENTARY, GENERAL_COMMENTARY, SOFT_SKILL_COMMENTARY,
START_DATE_TIME, END_DATE_TIME, SOFT_SKILL_VERDICT, STATUS) 
values (1 , 3 , 5500 , 2, 50.0, 'intoComment','generalComment','softskillComment', '2018-03-01', '2018-03-02', 0, 'Completed');
 
 Insert into SCREENING (SCREENING_ID, TRAINER_ID, TRAINEE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_ME_COMMENTARY, GENERAL_COMMENTARY, SOFT_SKILL_COMMENTARY,
 START_DATE_TIME, END_DATE_TIME, SOFT_SKILL_VERDICT, STATUS) 
values (2 , 3 , 5501 , 2, 50.0, 'intoComment2','generalComment2','softskillComment2', '2018-03-02', '2018-03-03', 0, 'Completed');

Insert into SCREENING (SCREENING_ID, TRAINER_ID, TRAINEE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_ME_COMMENTARY, GENERAL_COMMENTARY, SOFT_SKILL_COMMENTARY,
START_DATE_TIME, END_DATE_TIME, SOFT_SKILL_VERDICT, STATUS) 
values (3 , 4 , 5502 , 2, 50.0, 'intoComment3','generalComment3','softskillComment3', '2018-03-04', '2018-03-05', 0, 'Completed');

Insert into SCREENING (SCREENING_ID, TRAINER_ID, TRAINEE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_ME_COMMENTARY, GENERAL_COMMENTARY, SOFT_SKILL_COMMENTARY,
START_DATE_TIME, END_DATE_TIME, SOFT_SKILL_VERDICT, STATUS) 
values (4 , 5 , 5503 , 2, 50.0, 'intoComment4','generalComment4','softskillComment4', '2018-03-06', '2018-03-07', 0, 'Completed');

Insert into SCREENING (SCREENING_ID, TRAINER_ID, TRAINEE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_ME_COMMENTARY, GENERAL_COMMENTARY, SOFT_SKILL_COMMENTARY,
START_DATE_TIME, END_DATE_TIME, SOFT_SKILL_VERDICT, STATUS) 
values (5 , 5 , 5504 , 2, 50.0, 'intoComment5','generalComment5','softskillComment5', '2018-03-08', '2018-03-09', 1, 'Pending');

Insert into SCREENING (SCREENING_ID, TRAINER_ID, TRAINEE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_ME_COMMENTARY, GENERAL_COMMENTARY, SOFT_SKILL_COMMENTARY,
START_DATE_TIME, END_DATE_TIME, SOFT_SKILL_VERDICT, STATUS) 
values (6 , 5 , 5505 , 2, 50.0, 'intoComment6','generalComment6','softskillComment6', '2018-03-10', '2018-03-11', 1, 'Pending');

Insert into SCREENING (SCREENING_ID, TRAINER_ID, TRAINEE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_ME_COMMENTARY, GENERAL_COMMENTARY, SOFT_SKILL_COMMENTARY,
START_DATE_TIME, END_DATE_TIME, SOFT_SKILL_VERDICT, STATUS) 
values (7 , 3 , 5506 , 2, 50.0, 'intoComment7','generalComment7','softskillComment7', '2018-03-11', '2018-03-12', 0, 'Pending');

Insert into SCREENING (SCREENING_ID, TRAINER_ID, TRAINEE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_ME_COMMENTARY, GENERAL_COMMENTARY, SOFT_SKILL_COMMENTARY,
START_DATE_TIME, END_DATE_TIME, SOFT_SKILL_VERDICT, STATUS) 
values (8 , 3 , 5507 , 2, 50.0, 'intoComment8','generalComment8','softskillComment8', '2018-03-12', '2018-03-14', 1, 'Pending');
 
COMMIT;

--------------------------------------------------------
--  DDL for Sequence VIOLATION_SEQUENCE
--------------------------------------------------------
DROP SEQUENCE IF EXISTS VIOLATION_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  VIOLATION_SEQUENCE  MINVALUE 5600  INCREMENT BY 1 START WITH 5600;

Insert into VIOLATION_TYPE (VIOLATION_ID, VIOLATION, DESCRIPTION) 
values (1, 'using bad words', 'the participant used F words, B words, and/or S words');

Insert into VIOLATION_TYPE (VIOLATION_ID, VIOLATION, DESCRIPTION) 
values (2, 'bad dress', 'no tie, no suit, no job');

Insert into VIOLATION_TYPE (VIOLATION_ID, VIOLATION, DESCRIPTION) 
values (3, 'not focused', 'Focused not on the question, the participant was.');

COMMIT;

--------------------------------------------------------
--  DDL for Sequence SOFT_SKILL_VIOLATION_SEQUENCE
--------------------------------------------------------
DROP SEQUENCE IF EXISTS SOFT_SKILL_VIOLATION_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  SOFT_SKILL_VIOLATION_SEQUENCE  MINVALUE 5600  INCREMENT BY 1 START WITH 5600;

Insert into SOFT_SKILL_VIOLATION (SOFT_SKILL_VIOLATION_ID, SCREENING_ID, VIOLATION_TYPE_ID, SOFT_SKILL_VIOLATION_COMMENT, TIME) 
values (1, 1, 1, 'After failing a question, candidate swore not unlike a sailor.', '2018-03-01');
Insert into SOFT_SKILL_VIOLATION (SOFT_SKILL_VIOLATION_ID, SCREENING_ID, VIOLATION_TYPE_ID, SOFT_SKILL_VIOLATION_COMMENT, TIME)  
values (2, 2, 1, 'Never before have I heard such a vile stream of expletives.', '2018-03-02');
Insert into SOFT_SKILL_VIOLATION (SOFT_SKILL_VIOLATION_ID, SCREENING_ID, VIOLATION_TYPE_ID, SOFT_SKILL_VIOLATION_COMMENT, TIME) 
values (3, 3, 2, 'Pajamas. Looked comfortable. Too bad he will not be comfortable at a new job.', '2018-03-03');
Insert into SOFT_SKILL_VIOLATION (SOFT_SKILL_VIOLATION_ID, SCREENING_ID, VIOLATION_TYPE_ID, SOFT_SKILL_VIOLATION_COMMENT, TIME) 
values (4, 4, 2, 'Not sure, but think he was not wearing pants. Awkward. Hard pass.', '2018-03-04');
Insert into SOFT_SKILL_VIOLATION (SOFT_SKILL_VIOLATION_ID, SCREENING_ID, VIOLATION_TYPE_ID, SOFT_SKILL_VIOLATION_COMMENT, TIME) 
values (5, 5, 2, 'Said he does not own a suit or tie. Too bad, so sad.', '2018-03-05');
Insert into SOFT_SKILL_VIOLATION (SOFT_SKILL_VIOLATION_ID, SCREENING_ID, VIOLATION_TYPE_ID, SOFT_SKILL_VIOLATION_COMMENT, TIME)  
values (6, 6, 3, 'He kept wandering off topic, and I think he might have been on Reddit.', '2018-03-06');
Insert into SOFT_SKILL_VIOLATION (SOFT_SKILL_VIOLATION_ID, SCREENING_ID, VIOLATION_TYPE_ID, SOFT_SKILL_VIOLATION_COMMENT, TIME) 
values (7, 7, 3, 'Could not keep a thought straight.', '2018-03-07');
 
--------------------------------------------------------
--  DDL for Sequence SCHEDULED_SCREENING
--------------------------------------------------------
DROP SEQUENCE IF EXISTS SCHEDULED_SCREENING_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  SCHEDULED_SCREENING_SEQUENCE  MINVALUE 5600  INCREMENT BY 1 START WITH 5600;

insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5501, 'SCREENED', '9/20/2017');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5502, 'SCREENED', '6/10/2017');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5503, 'SCREENED', '2/14/2018');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5504, 'PENDING', '6/29/2017');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5505, 'SCREENED', '9/1/2017');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5506, 'PENDING', '10/18/2017');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5507, 'PENDING', '3/1/2018');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5508, 'PENDING', '3/20/2018');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5509, 'SCREENED', '3/26/2018');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5510, 'PENDING', '7/23/2017');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5511, 'SCREENED', '3/22/2018');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5512, 'SCREENED', '3/11/2018');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5513, 'PENDING', '6/2/2017');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5514, 'SCREENED', '3/29/2018');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5515, 'PENDING', '11/22/2017');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5516, 'PENDING', '9/6/2017');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5517, 'PENDING', '2/6/2018');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5518, 'SCREENED', '3/22/2018');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5519, 'SCREENED', '7/3/2017');
insert into SCHEDULED_SCREENING (trainee, status, scheduledDate) values (5520, 'SCREENED', '2/7/2018');


COMMIT;
