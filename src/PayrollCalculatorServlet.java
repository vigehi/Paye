import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayrollCalculatorServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
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

}

