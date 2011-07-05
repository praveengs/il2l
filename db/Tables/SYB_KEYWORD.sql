CREATE TABLE IF NOT EXISTS SYB_KEYWORD (
  SYB_KEYWORD_ID int(11) NOT NULL AUTO_INCREMENT,
  KEYWORD varchar(45) NOT NULL COMMENT 'The key word',
  QUANTITIES varchar(45) DEFAULT NULL COMMENT 'Holds the quantities associated with the keyword',
  SYMBOLS varchar(45) DEFAULT NULL COMMENT 'Holds the symbols associated with the keyword',
  UNITS varchar(45) DEFAULT NULL COMMENT 'Holds the Units associated with the keyword',
  FORMULAE varchar(45) DEFAULT NULL COMMENT 'Holds the formulae attached to the keyword',
  DATA varchar(45) DEFAULT NULL COMMENT 'Holds the data attached to the keyword',
  LAST_MODIFIED_BY varchar(45) DEFAULT NULL,
  LAST_MODIFIED_DATE datetime DEFAULT NULL,
  LAST_MODIFIED_ROLE varchar(45) DEFAULT NULL,
  PRIMARY KEY (SYB_KEYWORD_ID),
  KEY SYB_KEYWORD_IDX (KEYWORD)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Table to hold the key words'

