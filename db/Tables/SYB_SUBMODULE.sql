CREATE TABLE IF NOT EXISTS SYB_SUBMODULE (
  SYB_SUB_SUBMODULE_ID int(11) NOT NULL AUTO_INCREMENT,
  SUBMODULE_NAME varchar(45) NOT NULL COMMENT 'Name of the submodule',
  SUBMODULE_DESC varchar(45) DEFAULT NULL COMMENT 'A short description for the submodule',
  MODULE_REF int(11) NOT NULL COMMENT 'Holds the reference to which module it belongs to',
  LAST_MODIFIED_BY varchar(45) DEFAULT NULL,
  LAST_MODIFIED_DATE datetime DEFAULT NULL,
  LAST_MODIFIED_ROLE varchar(45) DEFAULT NULL,
  PRIMARY KEY (SYB_SUB_SUBMODULE_ID),
  KEY SUBMODULE_NAME_IDX (SUBMODULE_NAME),
  KEY MODULE_NAME_REF_FK (MODULE_REF),
  CONSTRAINT MODULE_NAME_REF_FK FOREIGN KEY (MODULE_REF) REFERENCES syb_module (SYB_SUB_MODULE_ID) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COMMENT='Table to hold the submodules associated to a module'

