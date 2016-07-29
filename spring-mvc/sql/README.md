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
**connecte to database**
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

**notes**

Fix __/sbin/chkconfig__

``` shell
#!/bin/bash
# Oracle 11gR2 XE installer chkconfig hack for Debian by Dude

file=/etc/init.d/oracle-xe

FOUND=$(head -n1 "${file}" | grep INIT)

if [ -z "${FOUND}" ]
then
echo >> $file
echo '### BEGIN INIT INFO' >> $file
echo '# Provides: OracleXE' >> $file
echo '# Required-Start: $remote_fs $syslog' >> $file
echo '# Required-Stop: $remote_fs $syslog' >> $file
echo '# Default-Start: 2 3 4 5' >> $file
echo '# Default-Stop: 0 1 6' >> $file
echo '# Short-Description: Oracle 11g Express Edition' >> $file
echo '### END INIT INFO' >> $file
fi

update-rc.d oracle-xe defaults 80 01
```


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
