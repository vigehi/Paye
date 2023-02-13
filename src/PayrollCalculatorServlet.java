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
    String basicSalary = request.getParameter("basic-salary");
    String benefits = request.getParameter("benefits");
    String nssfContribution = request.getParameter("nssf-contribution");
    String taxableIncome = request.getParameter("taxable-income");
    String personalRelief = request.getParameter("personal-relief");
    String paye = request.getParameter("paye");
    String nhifContribution = request.getParameter("nhif-contribution");
    String netPay = request.getParameter("net-pay");

    double basicSalaryValue = Double.parseDouble(basicSalary);
    double benefitsValue = Double.parseDouble(benefits);
    double nssfContributionValue = Double.parseDouble(nssfContribution);
    double taxableIncomeValue = basicSalaryValue + benefitsValue - nssfContributionValue;
    double personalReliefValue = Double.parseDouble(personalRelief);
    double taxableIncomeAfterRelief = taxableIncomeValue - personalReliefValue;
    double payeValue = taxableIncomeAfterRelief * 0.3;
    double nhifContributionValue = Double.parseDouble(nhifContribution);
    double netPayValue = basicSalaryValue + benefitsValue - nssfContributionValue - payeValue
        - nhifContributionValue;

    request.setAttribute("basic-salary", basicSalaryValue);
    request.setAttribute("benefits", benefitsValue);
    request.setAttribute("nssf-contribution", nssfContributionValue);
    request.setAttribute("taxable-income", taxableIncomeValue);
    request.setAttribute("personal-relief", personalReliefValue);
    request.setAttribute("paye", payeValue);
    request.setAttribute("nhif-contribution", nhifContributionValue);
    request.setAttribute("net-pay", netPayValue);

    request.getRequestDispatcher("payroll.jsp").forward(request, response);
  }
  public static void main(String[] args) {
    System.out.println("This is a main method added to the PayrollCalculatorServlet class");
  }
}

