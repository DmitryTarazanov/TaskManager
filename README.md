# TaskManager
A simple console application for working with project tasks. At startup, the application reads json data from a file into the PostgreSQL database. Using the console, you can work with project tasks.

The application works with PostgreSQL database. Set up the app. The repository contains a jar file with the postgreSQL driver, specify the path to it in the settings. In the Constans class, set the database connection variables to their actual values. 
The application automatically creates a table in the database at startup if it has not been created. In the JsonFileParser class there is a fileRoot variable, specify the path to the file from which the data will be read.
The repository has a json file SomeData, in which you can see the json data format. Using the console, you can insert, delete, update projects, clients, tasks and progress status.
