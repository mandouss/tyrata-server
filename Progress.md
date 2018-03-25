Track the progress of Tyrata Server Team on : https://trello.com/b/RIlT4NrQ/tyrata-team-sprint-2

<h1>Sprint 2 Report</h1>
<li>
    <item>Tomcat 8 Configuration</item>
</li>

<h2> Setting up the Database</h2>
Build the build-in database set-up java code.

User can simply run:
'1. javac database.java'
'2. java database'

Then the program will create a database named Tyrata and set up all the tables for you, and you can also characterize your user name and password simply by modifying 
line 8,9:
    static final String USER = "username you want";
    static final String PASS = "password you want";
<h1>Sprint 1 Report</h1>
<li>
<item>1-set up all the environment we need in the vcm </item>

<item>2-built a MySQL database</item>

<item>3-had a java program that can read and write the db </item>
</li>

FOR TEST TEAM:
When you need to test our code, please contact us because this is environment-related code. 
You cannot run our code on a inappropriate running environment.

Here are something we need to do in Sprint2:
1 ask Design team for the final database design and implement it
2 have a meeting with the android team and find out what kind of data would they sent
There are two kind of possibility:
They will use http protocol, if so we may use exist framework https://www.playframework.com/
They will simply sent rough data, if so we may use socket to connect with the client 
there is a socket example code inside the tyrata-server/sample directory

!!!! IMPORTANT  NOTE:
The connection tool between mySQL and java can be found here: https://dev.mysql.com/downloads/connector/j/ 
In the linux system to import a jar file to java is kind of problematic, I tried a lot of ways and found for mysql-connector-java-5.1.45-bin.jar the only way to make it work is to put it in the following path:
/usr/lib/jvm/java-1.8.0-openjdk-amd64/jre/lib/ext