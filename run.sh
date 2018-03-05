#!/bin/bash
javac -d bin -sourcepath src src/LoadDriver.java
java -cp bin: LoadDriver
rm bin/LoadDriver.class
