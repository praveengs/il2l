1. Change directory and move into the location where the dump is placed.
2. Use the root acces to import the dump into a specified schema. 
Use the following command for the same, but please remember to change credentials
and the database_name
$$>mysql -u username -ppassword database_name < dump.sql


INFO
-----
Newer release of mysqldump uses UTF8 as its default charset if nothing is specified, 
while older versions (older than 4.1 typically) use Latin1 as default characterset. 
If you database charset is Latin1 and dump in UTF8 collation, the data may ends up 
become simply rubbish, garbled, or unreadable (frequently happen with WordPress blog). 
If this case, use -default-character-set=charset_name option to specify the character set 
or convert the database to UTF8.