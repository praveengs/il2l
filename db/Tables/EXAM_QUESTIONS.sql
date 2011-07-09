CREATE TABLE EXAM_QUESTIONS (
  EXAM_QUESTIONS_ID int(11) NOT NULL AUTO_INCREMENT,
  QUESTION varchar(4000) NOT NULL COMMENT 'The question',
  QUES_IMG blob COMMENT 'If there is any image file attached to the question',
  QNO_YEAR_MARKS varchar(2000) NOT NULL COMMENT 'The question number, year asked and marks in a comma separated string of the format ''Q5-2010-4/20,Q2-2009-10/20''',
  ANSWER varchar(4000) DEFAULT NULL COMMENT 'The answer to the question',
  ANSWER_IMG blob COMMENT 'If there is any image attached to the answer',
  QUES_IMG_NAME varchar(45) DEFAULT NULL,
  ANSWER_IMG_NAME varchar(45) DEFAULT NULL,
  LAST_MODIFIED_BY varchar(45) DEFAULT NULL,
  LAST_MODIFIED_DATE datetime DEFAULT NULL,
  LAST_MODIFIED_ROLE varchar(45) DEFAULT NULL,
  PRIMARY KEY (EXAM_QUESTIONS_ID)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COMMENT='Table to hold the questions and answers'

