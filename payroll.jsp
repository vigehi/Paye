<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payroll Calculator Results</title>
<link rel="stylesheet" type="text/css" href="css/results.css">
</head>
<body>
  <h1>Payroll Calculator Results</h1>
  <p>Pay Period: <%= request.getAttribute("pay-period") %></p>
  <p>Basic Salary: <%= request.getAttribute("basic-salary") %></p>
  <p>Benefits (Allowances): <%= request.getAttribute("benefits") %></p>
  <p>NSSF Contribution: <%= request.getAttribute("nssf-contribution") %></p>
  <p>Taxable Income: <%= request.getAttribute("taxable-income") %></p>
  <p>Personal Relief: <%= request.getAttribute("personal-relief") %></p>
  <p>PAYE: <%= request.getAttribute("paye") %></p>
  <p>NHIF Contribution: <%= request.getAttribute("nhif-contribution") %></p>
  <p>Net Pay:  <%= request.getAttribute("net-pay") %></p>
</body>
</html>
