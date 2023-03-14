<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ</title>
<link rel="stylesheet" type="text/css" href="css/results.css">
</head>
<body>
  <h1>Payroll Calculator Results</h1>
  <p>Pay Period: <%= request.getParameter("pay-period") %></p>
  <p>Basic Salary: <%= request.getParameter("basic-salary") %></p>
  <p>Benefits (Allowances): <%= request.getParameter("benefits") %></p>
  <p>NSSF Contribution: <%= request.getParameter("nssf-contribution") %></p>
  <p>Taxable Income: <%= request.getParameter("taxable-income") %></p>
  <p>Personal Relief: <%= request.getParameter("personal-relief") %></p>
  <p>PAYE: <%= request.getParameter("paye") %></p>
  <p>NHIF Contribution: <%= request.getParameter("nhif-contribution") %></p>
  <p>Net Pay: <%= request.getParameter("net-pay") %></p>
</body>
</html>
