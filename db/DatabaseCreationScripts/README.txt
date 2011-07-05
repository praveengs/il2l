This file is intended for users to create the database with the needed objects.
Please follow the instructions carefully for avoiding accidental deletion of data
and inconsistent state of database.

The following directory structure is assumed
db/DatabaseCreationScripts
db/Tables

**********************************************************************************
**********		FOR DATABASE CREATION				**********
**********************************************************************************	

1. First take a command prompt and change directory to the place in which the sql file
CreateDatabase.sql is located. This is in db/DatabaseCreationScripts.

2. Now connect to mysql database as a root user. The syntax is as follows
%%mysql -u<user> -p<password> -h<hostname>

3. Edit the CreateSchema.sql file, and change the 'newuser', 'password' and 'schema'
to the needed names respectively. This step is important as it will determine the
database credentials. This script is used in the next step to create the user, password
and the schema for the database of the application.

4. Now run the CreateDatabase.sql as follows
mysql>source CreateDatabase.sql
This will create the entities as mentioned in the step 3

5. Type exit, hit enter and exit from root user.

6. Now connect to the new schema created, using the new username/password@schema combination 
as described below.
%%mysql -u<user> -p<password> -h<hostname> <schema>

7. Now run the CreateTables.sql as follows
mysql>source CreateTables.sql

8. Now the new db instance is ready

**********************************************************************************
**********		FOR DATABASE DELETION				**********
**********************************************************************************	
1. First take a command prompt and change directory to the place in which the sql file
DropSchema.sql is located. This is in db/DatabaseCreationScripts.

2. Now connect to mysql database as a root user. The syntax is as follows
%%mysql -u<user> -p<password> -h<hostname>

3. Edit the DropSchema.sql file, and change the 'newuser'and 'schema'
to the needed names respectively. This step is important as it will determine the
database credentials that will be dropeed. 

4. Run the DropSchema.sql file as follows
mysql>source DropSchema.sql

5. The DB Instance is dropped along with the user created
