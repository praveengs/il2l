#Replace the testschema with the new actual schema name
CREATE DATABASE newschema;

#Replace the newuser with the new actual user name and provide actual password for newpassword
#The % value is used so that the database can be accessed from any other host.
CREATE USER 'newuser'@'%' identified by 'password';

#Replace the teschema and newuser with values from above
GRANT CREATE, SELECT, INSERT, DELETE, UPDATE on newschema.* to 'newuser'@'%';
