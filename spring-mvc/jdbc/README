# Install oracle database on maven repository

**download**

 -  ojdbc7.jar [Certified with JDK7 and JDK 8](http://www.oracle.com/technetwork/database/features/jdbc/default-2280470.html)
 -  ojdbc6.jar [Certified with JDK 8, JDK 7 and JDK 6](http://www.oracle.com/technetwork/database/enterprise-edition/jdbc-112010-090769.html)
 -  ojdbc14.jar [Certified with JDK 1.4 and 1.5](http://www.oracle.com/technetwork/database/enterprise-edition/jdbc-10201-088211.html)
 -  classes12.jar [Certified with JDK 1.2 and JDK 1.3](http://www.oracle.com/technetwork/database/enterprise-edition/jdbc-10201-088211.html)

**install**

```
mvn install:install-file -Dfile=ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar
mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.4 -Dpackaging=jar
mvn install:install-file -Dfile=ojdbc14.jar -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.5 -Dpackaging=jar
mvn install:install-file -Dfile=classes12.jar -DgroupId=com.oracle -DartifactId=ojdbc12 -Dversion=10.2.0.5 -Dpackaging=jar
```
