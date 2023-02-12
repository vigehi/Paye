<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payroll Calculator</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
  <form>
    <div>
      <label>Pay Period:</label>
      <select>
        <option value="month">Month</option>
        <option value="year">Year</option>
      </select>
    </div>
    <div>
      <label>Basic Salary:</label>
      <input type="text" name="basic-salary">
    </div>
    <div>
      <label>Benefits (Allowances):</label>
      <input type="text" name="benefits">
    </div>
    <div>
      <label>NSSF Contribution:</label>
      <input type="text" name="nssf-contribution">
    </div>
    <div>
      <label>Taxable Income:</label>
      <input type="text" name="taxable-income">
    </div>
    <div>
      <label>Personal Relief:</label>
      <input type="text" name="personal-relief">
    </div>
    <div>
      <label>PAYE:</label>
      <input type="text" name="paye">
    </div>
    <div>
      <label>NHIF Contribution:</label>
      <input type="text" name="nhif-contribution">
    </div>
    <div>
      <label>Net Pay:</label>
      <input type="text" name="net-pay">
    </div>
    <div>
      <input type="submit" value="Calculate">
    </div>
  </form>
</body>
</html>

