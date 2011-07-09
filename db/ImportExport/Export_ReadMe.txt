For our purposes the first step (1) is the only one needed. Rest are kept for reference

1. How to Export or Backup or Dump A MySQL Database
-------------------------------------------------
To export a MySQL database into a dump file, simply type the following command syntax in the shell. 
You can use Telnet or SSH to remotely login to the machine if you don’t have access to the physical box.

mysqldump -u username -ppassword database_name > dump.sql

Replace username with a valid MySQL user ID, password with the valid password for the user 
(IMPORTANT: no space after -p and the password, else mysqldump will prompt you for password yet 
will treat the password as database name, so the backup will fail) and database_name with the 
actual name of the database you want to export. Finally, you can put whatever name you like for 
the output SQL dump file, here been dump.sql.

The whole data, tables, structures and database of database_name will be backed up into a SQL text file named dump.sql with the above command.

2. How to Export A MySQL Database Structures Only
----------------------------------------------

If you no longer need the data inside the database’s tables (unlikely), simply add -no-data switch to export only the tables’ structures. 
For example, the syntax is:

mysqldump -u username -ppassword -no-data database_name > dump.sql

3. How to Backup Only Data of a MySQL Database
-------------------------------------------

If you only want the data to be backed up, use -no-create-info option. 
With this setting, the dump will not re-create the database, tables, fields, and other structures when importing. 
Use this only if you pretty sure that you have a duplicate databases with same structure, where you only need to refresh the data.

mysqldump -u username -ppassword -no-create-info database_name > dump.sql

4. How to Dump Several MySQL Databases into Text File
---------------------------------------------------

-databases option allows you to specify more than 1 database. Example syntax:

mysqldump -u username -ppassword -databases db_name1 [db_name2 ...] > dump.sql

5. How to Dump All Databases in MySQL Server
-----------------------------------------

To dump all databases, use the -all-databases option, and no databases’ name need to be specified anymore.

mysqldump -u username -ppassword -all-databases > dump.sql

6. How to Online Backup InnoDB Tables
----------------------------------

Backup the database inevitable cause MySQL server unavailable to applications because when exporting, all tables 
acquired a global read lock using FLUSH TABLES WITH READ LOCK at the beginning of the dump until finish. 
So although READ statements can proceed, all INSERT, UPDATE and DELETE statements will have to queue due to locked tables, 
as if MySQL is down or stalled. If you’re using InnoDB, -single-transaction is the way to minimize this locking time duration 
to almost non-existent as if performing an online backup. It works by reading the binary log coordinates as soon as the lock 
has been acquired, and lock is then immediately released.

Syntax:

mysqldump -u username -ppassword -all-databases -single-transaction > dump.sql