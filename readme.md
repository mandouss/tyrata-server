Great team!

We are on our schedule of Sprint 1!

We have:

1 set up all the environment we need in the vcm

2 built a MySQL database

3 had a java program that can read and write the db


Nice job team!!!!

Here are something we need to do in Sprint2:
1 ask Design team for the final database design and implement it
2 have a meeting with the android team and find out what kind of data would they sent
There are two kind of possibility:
They will use http protocol, if so we may use exist framework https://www.playframework.com/
They will simply sent rough data, if so we may use socket to connect with the client 
there is a socket example code inside the tyrata-server/sample directory

!!!! IMPORTANT  NOTE:
The connection tool between mySQL and java can be found here: https://dev.mysql.com/downloads/connector/j/ 
In the linux system to import a jar file to java is kind of problematic, I tried a lot of way and find for mysql-connector-java-5.1.45-bin.jar the only way to make it work is to put it in the following path:
/usr/lib/jvm/java-1.8.0-openjdk-amd64/jre/lib/ext
