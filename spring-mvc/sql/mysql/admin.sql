DROP DATABASE IF EXISTS health_insurance;
CREATE DATABASE health_insurance;

GRANT ALL ON health_insurance.* TO 'insurance'@'%';
SET PASSWORD FOR 'insurance'@'%' = PASSWORD('insurance');
