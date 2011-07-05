CREATE TABLE IF NOT EXISTS SYB_SUBJECT (
  idSYB_SUBJECT int(11) NOT NULL AUTO_INCREMENT COMMENT 'The PK of the table',
  SUBJECT_NAME varchar(45) NOT NULL COMMENT 'The name of the subject',
  SUBJECT_DESCRIPTION varchar(45) DEFAULT NULL COMMENT 'TO hold a brief description on the subject',
  SUBJECT_WRITEUP blob COMMENT 'The detailed description of the subject, such a writeup is stored in this column',
  LAST_MODIFIED_BY varchar(45) DEFAULT NULL,
  LAST_MODIFIED_DATE datetime DEFAULT NULL,
  LAST_MODIFIED_ROLE varchar(45) DEFAULT NULL,
  PRIMARY KEY (idSYB_SUBJECT),
  KEY SYB_SUBJECT_SUBNM (SUBJECT_NAME)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='Table to store the Subject details'

