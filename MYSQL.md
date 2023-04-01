# MySQL DB Setup
We will get a MySQL server running on our system at port 3306 (The default MySQL port), and create a database called `squares` with each of the tables we need.

## Setup MySQL Server
There are several ways to setup this MySQL server. I will walk through one of them.

### Method 1: Docker
#### 1. Follow instructions to install [Docker](https://docs.docker.com/get-docker) on your system.
> *Note: There are also many ways to install Docker on your system. If you install Docker Desktop, it should include a plugin called **Compose**, which will allow us to follow the rest of this section. Otherwise, you can follow other installation methods, or use a different method than Docker to setup the MySQL database.*

#### 2. Create the server and database using docker compose
There is a file called `docker-compose.yml` in the root of this directory with instructions for the plugin to install, run and start a MySQL server, and create a database called **squares**. Activate this by running the following:
```shell
docker compose up;
```
> *Note: The above command maybe different depending on the system or installation method.*
> 
#### 3. Access the mysql script in the docker container
```shell
docker exec -it squares-db-1 mysql -u root -p
```
> *Enter `squares` as the password when prompted. This was provided in `docker-compose.yml`*

## Setup the Database
Regardless of the method used to setup the MySQL server, at this point, you should be logged into it in a mysql shell, which should show you something like `mysql> ` while awaiting commands, and ready for the rest of this guide.

### 1. List Existing Databases
Enter the following to display a list of all existing databases:
```shell
show databases;
```

### 2. Select the `squares` Database
Enter the following to select the `squares` database to run queries on:
```shell
use squares;
```
> *Note: You should see some databases created by default. If you followed the above method to use the docker compose plugin, `squares` should be among them.*

### 3. Show Tables
Enter the following to show all the existing tables in the `squares` database:
```shell
show tables;
```
> *Note: This will be empty because we haven't created any tables yet*

### 4. Add Tables
We will create 3 tables for now. `grid` and `person`, which will each have an `id` that cannot be null, will auto-increment, and will serve as the primary key for the rows in the table, as well as any other columns that we'd like to store for each. And `squares`, which will serve only as a JOIN table to link `persons` to `grids` in our data.
```shell
CREATE TABLE `grid` (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY
);
```

```shell
CREATE TABLE `person` (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(255)
);
```

```shell
CREATE TABLE `square` (
    grid_id int,
    row int,
    col int,
    person_id int
);
```
> *Note: Now if you show tables again, you'll see our table created.*

At this point, we now should have our database setup and accessible from our Java application.

For Lesson 5, we need to add an id column to the squares table in order to let Spring Data register it as an entity
```shell
ALTER TABLE `square` ADD COLUMN id int NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
```