Follow our progress on : https://trello.com/b/mUTN1Ihj/tyrata-team-sprint-3
# Tyrata Server

One Paragraph of project description goes here

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

- Java 8
- Tomcat

The Apache Tomcat® software is an open source implementation of the Java Servlet, JavaServer Pages, Java Expression Language and Java WebSocket technologies. The Java Servlet, JavaServer Pages, Java Expression Language and Java WebSocket specifications are developed under the [Java Community Process](http://jcp.org/en/introduction/overview).

Here's the instructions to install Tomcat.

```bash
sudo apt-get update
sudo apt-get install tomcat8
sudo apt-get install tomcat8-docs tomcat8-admin tomcat8-examples tomcat8-user #suggested
```

- MySql

MySQL is a common open source relational database for creating, reading, updating and deleting data.

We need to install the `mysql-server` package, which downloads the required files, configures the initial database set up and handles running MySQL as a system service. Run this `apt` command to get the process started.

```bash
sudo apt-get install mysql-server
```

Enter 'y' when prompted with whether or not you want to install the new package.

An administrative screen asking for a new root password will appear in the middle of the package installation process. Enter your chosen new password twice and the installation will continue.

MySQL is installed with a basic configuration meant for development and testing purposes. However, the configuration is not secure for production enviroments, therefore it comes with a utility to handle basic security. Run the following command and answer the questions based on your environment requirements.

```bash
sudo mysql_secure_installation
```

Our MySQL instance has basic security in place but we need to create a non-root user for applications to interact with the database.

To create a non-root user, connect to the MySQL instance with the `mysql` command line client.

```bash
mysql -u root -p
```

Now use the `CREATE USER` command to generate a new user. Make sure to change "mynewuser" and "goodPassword" with your own values.

```mysql
CREATE USER 'mynewuser'@'localhost' IDENTIFIED BY 'goodPassword';
GRANT ALL PRIVILEGES ON * . * TO 'mynewuser'@'localhost';
FLUSH PRIVILEGES;
```

We're set to connect to the database with our new user. Exit the MySQL client with "Ctrl-d". Reconnect using a slightly different command than we used earlier.

```bash
mysql -u mynewuser -p
```

Create a new database with the `CREATE DATABASE` command. Connect to the new database with the `USE` command.

```mysql
CREATE DATABASE Tyrata;
use Tyrata;
```



### Deployment

- Enable nessassary library

```bash
sudo mv javax.servlet-api-3.0.1.jar /usr/lib/jvm/java-1.8.0-openjdk-i386/jre/lib/ext/
sudo mv mysql-connector-java-5.1.45-bin.jar /var/lib/tomcat8/lib
```

```bash
sudo nano /etc/profile
export CATALINA_HOME="/usr/share/tomcat8"
export CATALINA_BASE="/var/lib/tomcat8"
```

* Configure Tomcat server

##### Set the TCP Port Number

```Bash
cd /var/lib/tomcat8/conf
sudo nano server.xml
```

The default TCP port number configured in Tomcat is 8080, you may choose any number between 1024 and 65535, which is not used by an existing application. We shall choose 9999 in this document. (For production server, you should use port 80, which is pre-assigned to HTTP server as the default port number.)

Locate the following lines (around Line 69) that define the HTTP connector, and change `port="8080"` to `port="9999"`.

```xml
<!-- A "Connector" represents an endpoint by which requests are received
      and responses are returned. Documentation at :
      Java HTTP Connector: /docs/config/http.html
      Java AJP  Connector: /docs/config/ajp.html
      APR (HTTP/AJP) Connector: /docs/apr.html
      Define a non-SSL HTTP/1.1 Connector on port 8080
-->
<Connector port="9999" protocol="HTTP/1.1"
           connectionTimeout="20000"
           redirectPort="8443" />
```

##### **Enabling Directory Listing**

```Bash
sudo nano web.xml
```

We shall enable directory listing by changing "`listings`" from "`false`" to "`true`" for the "`default`" servlet. This is handy for test system, but not for production system for security reasons.

Locate the following lines (around Line 108) that define the "default" servlet; and change the "listings" from "`false`" to "`true`".

```Xml
<servlet>
  <servlet-name>default</servlet-name>
  <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>
  <init-param>
    <param-name>debug</param-name>
    <param-value>0</param-value>
  </init-param>
  <init-param>
    <param-name>listings</param-name>
    <param-value>true</param-value>
  </init-param>
  <load-on-startup>1</load-on-startup>
</servlet>
```

##### **Enabling Automatic Reload**

```Bash
sudo nano context.xml
```

We shall add the attribute `reloadable="true"` to the `<Context>` element to enable automatic reload after code changes. Again, this is handy for test system but not for production, due to the overhead of detecting changes.

Locate the `<Context>` start element (around Line 19), and change it to `<Context reloadable="true">`.

```Xml
<Context reloadable="true">
   ......
   ......
</Context>
```

- ​

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Built With

* [Tomcat](http://tomcat.apache.org) - The web framework used
* [MySql](https://www.mysql.com) - Database

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [GitLab](https://gitlab.oit.duke.edu) for versioning. For the versions available, see the [tags on this repository](git@gitlab.oit.duke.edu:ECE651_S18/tyrata-server.git). 

## Authors

* Arda I
* Da Xue
* Weiyu Yan
* Yiwei Li
* Zizhao Fang

See also the list of [contributors](https://gitlab.oit.duke.edu/ECE651_S18/tyrata-server/graphs/master) who participated in this project.

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc

