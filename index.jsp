<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Payroll Calculator</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <style>
      .period {
        background-color: white;
        display: flex;
        flex-direction: row;
        gap: 15px;
        margin: 10px 10px 10px 0;
      }
    </style>
  </head>

  <body>
    <form action="payroll-calculator" method="post">
      <div class="period" id="period">
        <div>
          <label>Pay Period:</label>
        </div>
        <div>
          <input type="checkbox" id="payPeriodMonth" name="payPeriod" value="month" checked>
        </div>
        <div>
          <label for="payPeriodMonth">Month</label>
        </div>
        <div>
          <input type="checkbox" id="payPeriodYear" name="payPeriod" value="year">
        </div>
        <div>
          <label for="payPeriodYear">Year</label>
        </div>


      </div>
      <div>
        <label>Basic Salary:</label>
        <input type="text" name="basic-salary" required>
      </div>
      <div>
        <label>Benefits (Allowances):</label>
        <input type="text" name="benefits" required>
      </div>
      <div>
        <input type="submit" value="Calculate">
      </div>
      <div>
        <label>NSSF Contribution: </label>
        <input type="text" name="nssf-contribution"  value="<%= request.getAttribute("nssf-contribution") %>">
      </div>
      <div>
        <label>Taxable Income:</label>
        <input type="text" name="taxable-income" value="<%= request.getAttribute("taxable-income") %>">
      </div>
      <div>
        <label>Personal Relief:</label>
        <input type="text" name="personal-relief" value="<%= request.getAttribute("personal-relief") %>">
      </div>
      <div>
        <label>PAYE:</label>
        <input type="text" name="paye" value="<%= request.getAttribute("paye") %>">
      </div>
      <div>
        <label>NHIF Contribution:</label>
        <input type="text" name="nhif-contribution" value="<%= request.getAttribute("nhif-contribution") %>">
      </div>
      <div>
        <label>Net Pay:</label>
        <input type="text" name="net-pay" value="<%= request.getAttribute("net-pay") %>">
      </div>

    </form>
  </body>
  <script>

    const monthlyCheckbox = document.getElementById('payPeriodMonth');
    const yearlyCheckbox = document.getElementById('payPeriodYear');

    monthlyCheckbox.addEventListener('change', () => {
      if (monthlyCheckbox.checked) {
        yearlyCheckbox.checked = false;
      }
    });

    yearlyCheckbox.addEventListener('change', () => {
      if (yearlyCheckbox.checked) {
        monthlyCheckbox.checked = false;
      }
    });

  </script>

  </html>