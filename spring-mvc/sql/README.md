#MariaDB and MySQL

**console**
```
 $ mysql -u<user> -p<password>
```
**list users**
 SELECT USER FROM mysql.user;

**show databases**
 show databases;

**run external sql file**
 \. <fullpath sql file>

**connecte to database**
 use <database>;

#PostgreSQL

**login postgresql user**
 sudo su
 su postgres

**console**
 $ psql

**list users**
 \du

**show databases**
 \l

**run external sql file**
 \i <fullpath sql file>

**connecte to database*
 \c <database>

**create database and user**
 \i <>/admin.sql

**exit normal user and create tables**
```
$ psql -h localhost -d health_insurance -U insurance
```
 \i <>/structure.sql

#For Oracle

**install**
(Debian process)[http://www.javavault.it/2015/01/27/install-oracle-11g-xe-on-debian/]

**console**
 $ sqlplus / as sysdba
 @<>/admin.sql

 $sqlplus insurance/insurance
 @<>/structure.sql

Enjoy
