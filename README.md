# CRUD

Setting Up mysql: 

    1. Start up your mysql with the command 
        "mysql -u root -p"
    
    2. Put in your password to start up
    
    3. Type the command "show databases" to see all your databases
    4. Create a database called "CRUD" with the following command
    CREATE DATABASE CRUD; 
    5. Type the command "USE CRUD;" to start using this database
    6. Inside CRUD database create a Vehicles table with the following command
    "CREATE TABLE  Vehicle(Id INT(5),Year INT(5),Make VARCHAR(20),Model VARCHAR(20));"
    7. Update DB_Connection.java with your password
    