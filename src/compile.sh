#!/bin/bash
cd $(dirname $0)

# Set the CLASSPATH variable to include the servlet-api.jar file
CLASSPATH=../WEB-INF/lib/jakarta.servlet-api-5.0.0.jar
echo 'Compiling.......'
# Compile the Java Servlet program
javac -classpath $CLASSPATH PayrollCalculatorServlet.java nhif.java nssfRates.java TaxCalculator.java


jar cmf manifest baraza.paye.jar PayrollCalculatorServlet.class nhif.class nssfRates.class TaxCalculator.class

echo 'Compile Done'

cp -f baraza.paye.jar ../WEB-INF/lib/

echo 'Deployed'
