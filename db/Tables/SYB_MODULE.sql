CREATE TABLE IF NOT EXISTS SYB_MODULE (
  SYB_SUB_MODULE_ID int(11) NOT NULL AUTO_INCREMENT,
  MODULE_NAME varchar(45) NOT NULL COMMENT 'Name of the Submodule',
  MODULE_DESC varchar(45) DEFAULT NULL COMMENT 'A short description for the submodule',
  MODULE_SUBJECT_REF int(11) NOT NULL COMMENT 'This refers to a subject from the SYB_SUBJECT table',
  LAST_MODIFIED_BY varchar(45) DEFAULT NULL,
  LAST_MODIFIED_DATE datetime DEFAULT NULL,
  LAST_MODIFIED_ROLE varchar(45) DEFAULT NULL,
  PRIMARY KEY (SYB_SUB_MODULE_ID),
  KEY SUB_MODULE_NAME_IDX (MODULE_NAME),
  KEY SUBJECT_REF_FK (MODULE_SUBJECT_REF),
  CONSTRAINT SUBJECT_REF_FK FOREIGN KEY (MODULE_SUBJECT_REF) REFERENCES syb_subject (idSYB_SUBJECT) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='This table holds the modules that are included in a particul'

