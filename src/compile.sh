#!/bin/bash
cd $(dirname $0)

# Set the CLASSPATH variable to include the servlet-api.jar file
CLASSPATH=../WEB-INF/lib/javax.servlet-3.0.jar

echo 'Compiling.......'
# Compile the Java Servlet program
javac -classpath $CLASSPATH PayrollCalculatorServlet.java


jar cmf manifest baraza.paye.jar PayrollCalculatorServlet.class 

echo 'Compile Done'

cp -f baraza.paye.jar WEB-INF/lib/

echo 'Deployed'
