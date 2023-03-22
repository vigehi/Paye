import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    String nssfRate = request.getParameter("nssf-rate"); // assuming the name of the radio button is "nssf-rate"

    double basicSalaryValue = Double.parseDouble(basicSalary);
    double benefitsValue = Double.parseDouble(benefits);

    // Calculate NSSF contribution based on basic salary
    double nssfContribution;

    if (nssfRate.equals("old")) { // check which radio button is selected
      float oldRate = nssfRates.getOldRate((float) basicSalaryValue);
      nssfContribution = (double) oldRate;
    } else {
      float newRate = nssfRates.getNewRate((float) basicSalaryValue);
      nssfContribution = (double) newRate;
    }
    double taxableIncomeValue =
      basicSalaryValue + benefitsValue - nssfContribution;
    double personalReliefValue;
    if (payperiodValue == "month") {
      personalReliefValue = 28800;
    } else {
      personalReliefValue = 2400;
    }
    double taxableIncomeAfterRelief = taxableIncomeValue - personalReliefValue;

    double payeValue = TaxCalculator.computePaye(
      (float) taxableIncomeAfterRelief
    );

    // Return the PAYE value divided by 12 (assuming the input values were annual)

    double nhifContributionValue;
    float nhifValue = nhif.getNHIF((float) basicSalaryValue);
    nhifContributionValue = (double) nhifValue;

    double netPayValue =
      basicSalaryValue +
      benefitsValue -
      nssfContribution -
      payeValue -
      nhifContributionValue;
    System.out.println("This is a  class");

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
    System.out.println(
      "This is a main method added to the PayrollCalculatorServlet class"
    );
  }
}
