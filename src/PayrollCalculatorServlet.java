import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/payroll-calculator")
public class PayrollCalculatorServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doPost(req, resp);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String payperiodValue = request.getParameter("payPeriod");
    String basicSalary = request.getParameter("basic-salary");
    String benefits = request.getParameter("benefits");

    // double payperiodValue = Double.parseDouble(payperiod);
    double basicSalaryValue = Double.parseDouble(basicSalary);
    double benefitsValue = Double.parseDouble(benefits);

    // Calculate NSSF contribution based on basic salary
    double nssfContribution;
    if (basicSalaryValue <= 10000) {
      nssfContribution = 360;
    } else if (basicSalaryValue <= 18000) {
      nssfContribution = 720;
    } else {
      nssfContribution = 1080;
    }
    double taxableIncomeValue = basicSalaryValue + benefitsValue - nssfContribution;
    double personalReliefValue;
    if (payperiodValue == "month") {
      personalReliefValue = 2400;
    } else {
      personalReliefValue = 28800;
    }
    double taxableIncomeAfterRelief = taxableIncomeValue - personalReliefValue;
    double payeValue;
    if (taxableIncomeAfterRelief <= 10000) {
      payeValue = taxableIncomeAfterRelief * 0.1;
    } else if (taxableIncomeAfterRelief <= 18000) {
      payeValue = taxableIncomeAfterRelief * 0.2;
    } else {
      payeValue = taxableIncomeAfterRelief * 0.3;
    }
    double nhifContributionValue;
    if (basicSalaryValue < 6000) {
      nhifContributionValue = 150;
    } else if (basicSalaryValue < 8000) {
      nhifContributionValue = 300;
    } else if (basicSalaryValue < 12000) {
      nhifContributionValue = 400;
    } else if (basicSalaryValue < 15000) {
      nhifContributionValue = 500;
    } else if (basicSalaryValue < 20000) {
      nhifContributionValue = 600;
    } else if (basicSalaryValue < 25000) {
      nhifContributionValue = 750;
    } else if (basicSalaryValue < 30000) {
      nhifContributionValue = 850;
    } else if (basicSalaryValue < 35000) {
      nhifContributionValue = 900;
    } else if (basicSalaryValue < 40000) {
      nhifContributionValue = 950;
    } else if (basicSalaryValue < 45000) {
      nhifContributionValue = 1000;
    } else if (basicSalaryValue < 50000) {
      nhifContributionValue = 1100;
    } else if (basicSalaryValue < 60000) {
      nhifContributionValue = 1200;
    } else if (basicSalaryValue < 70000) {
      nhifContributionValue = 1300;
    } else if (basicSalaryValue < 80000) {
      nhifContributionValue = 1400;
    } else if (basicSalaryValue < 90000) {
      nhifContributionValue = 1500;
    } else if (basicSalaryValue < 100000) {
      nhifContributionValue = 1600;
    } else {
      nhifContributionValue = 1700;
    }

    double netPayValue = basicSalaryValue + benefitsValue - nssfContribution - payeValue
        - nhifContributionValue;

    request.setAttribute("basic-salary", basicSalaryValue);
    request.setAttribute("benefits", benefitsValue);
    request.setAttribute("nssf-contribution", nssfContribution);
    request.setAttribute("taxable-income", taxableIncomeValue);
    request.setAttribute("personal-relief", personalReliefValue);
    request.setAttribute("paye", payeValue);
    request.setAttribute("nhif-contribution", nhifContributionValue);
    request.setAttribute("net-pay", netPayValue);
    request.setAttribute("payPeriod", payperiodValue);

    request.getRequestDispatcher("index.jsp").forward(request, response);
    // request.getRequestDispatcher("net-pay.jsp").forward(request, response);

  }

  public static void main(String[] args) {
    System.out.println("This is a main method added to the PayrollCalculatorServlet class");
  }
}
