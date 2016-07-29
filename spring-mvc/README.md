# Spring MVC project example

**Use**

- angulaJS
- rest
- hibernate
- spring mvc

**database**

- mysql
- mariadb
- postgresql
- oracle (optional)

**profiles**

- mysql
- mariadb
- postgresql
- oracle

**dependency**

 mvn dependency:tree

**build**

 mvn clean package

**config tomcat to deploy**

 edit **/etc/tomcat7/tomcat-users.xml**

``` xml
<tomcat-users>
 ...
    <role rolename="manager-gui"/>
    <role rolename="manager-script"/>
    <user username="admin" password="password" roles="manager-gui,manager-script" />
</tomcat-users>
```

**config maven to deploy**

 edit **/etc/maven/settings.xml**

``` xml
<servers>
 ...
    <server>
      <id>TomcatServer</id>
      <username>admin</username>
      <password>password</password>
    </server>
</servers>
```

**deploy**

 mvn -P<profile> tomcat7:redeploy


