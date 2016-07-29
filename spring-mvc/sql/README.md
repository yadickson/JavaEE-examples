#MariaDB and MySQL

**console**
```
 $ mysql -u<user> -p<password>
```
**list users**
```
mysql> SELECT USER FROM mysql.user;
```
**show databases**
```
mysql> show databases;
```
**run external sql file**
```
mysql> \. <fullpath sql file>
```
**connecte to database**
```
> use <database>;
```
#PostgreSQL

**login postgresql user**
```
$ sudo su
$ su postgres
```
**console**
```
$ psql
```
**list users**
```
psql> \du
```
**show databases**
```
psql> \l
```
**run external sql file**
```
psql> \i <fullpath sql file>
```
**connecte to database*
```
psql> \c <database>
```
**create database and user**
```
psql> \i <>/admin.sql
```
**exit normal user and create tables**
```
$ psql -h localhost -d health_insurance -U insurance
```
```
psql> \i <>/structure.sql
```
#For Oracle

**install**

[Debian process](http://www.javavault.it/2015/01/27/install-oracle-11g-xe-on-debian/)

**console**
```
$ sqlplus / as sysdba
sqlplus> @<>/admin.sql
```
```
$ sqlplus insurance/insurance
sqlplus>  @<>/structure.sql
```
Enjoy
