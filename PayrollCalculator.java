import java.awt.*;
import javax.swing.*;

public class PayrollCalculator extends JFrame {
  private JTextField basicSalaryField = new JTextField(10);
  private JTextField benefitsField = new JTextField(10);
  private JTextField nssfContributionField = new JTextField(10);
  private JTextField taxableIncomeField = new JTextField(10);
  private JTextField personalReliefField = new JTextField(10);
  private JTextField payeField = new JTextField(10);
  private JTextField nhifContributionField = new JTextField(10);
  private JTextField netPayField = new JTextField(10);

  private JRadioButton monthlyRadioButton = new JRadioButton("Month", true);
  private JRadioButton yearlyRadioButton = new JRadioButton("Year");
  private JRadioButton newRate = new JRadioButton("New NSSF Rate", true);
  private JRadioButton oldRate = new JRadioButton("Old NSSF Rate");

  public PayrollCalculator() {
    super("Payroll Calculator");
    try {
    //   UIManager.setLookAndFeel(new SubstanceLookAndFeel());
    } catch (Exception e) {
      // handle the exception
    }

    JPanel periodPanel = new JPanel(new GridLayout(1, 0));
    periodPanel.add(new JLabel("Pay Period:"));
    periodPanel.add(monthlyRadioButton);
    periodPanel.add(yearlyRadioButton);

    ButtonGroup periodButtonGroup = new ButtonGroup();
    periodButtonGroup.add(newRate);
    periodButtonGroup.add(oldRate);

    JPanel ratePanel = new JPanel(new GridLayout(1, 1));
    ratePanel.add(new JLabel("Rates:"));
    ratePanel.add(newRate);
    ratePanel.add(oldRate);

    ButtonGroup rateButtonGroup = new ButtonGroup();
    rateButtonGroup.add(newRate);
    rateButtonGroup.add(oldRate);

    JPanel formPanel = new JPanel(new GridLayout(8, 2));
    formPanel.add(new JLabel("Basic Salary:"));
    formPanel.add(basicSalaryField);
    formPanel.add(new JLabel("Benefits (Allowances):"));
    formPanel.add(benefitsField);
    formPanel.add(new JLabel("NSSF Contribution:"));
    formPanel.add(nssfContributionField);
    formPanel.add(new JLabel("Taxable Income:"));
    formPanel.add(taxableIncomeField);
    formPanel.add(new JLabel("Personal Relief:"));
    formPanel.add(personalReliefField);
    formPanel.add(new JLabel("PAYE:"));
    formPanel.add(payeField);
    formPanel.add(new JLabel("NHIF Contribution:"));
    formPanel.add(nhifContributionField);
    formPanel.add(new JLabel("Net Pay:"));
    formPanel.add(netPayField);
    JPanel buttonPanel = new JPanel();
    JButton calculateButton = new JButton("Calculate");
    buttonPanel.add(calculateButton);

    // Create a container panel to hold the ratePanel and formPanel
    JPanel centerPanel = new JPanel(new GridLayout(2, 1));
    centerPanel.add(ratePanel);
    centerPanel.add(formPanel);
    JPanel wrappedFormPanel = new JPanel(new BorderLayout());
    wrappedFormPanel.setBorder(
      BorderFactory.createEmptyBorder(100, 100, 100, 100)
    );
    wrappedFormPanel.add(periodPanel, BorderLayout.NORTH);
    wrappedFormPanel.add(centerPanel, BorderLayout.CENTER);
    wrappedFormPanel.add(buttonPanel, BorderLayout.SOUTH);

    // add the wrapped form panel to the frame
    add(wrappedFormPanel, BorderLayout.CENTER);

    monthlyRadioButton.addActionListener(
      e -> {
        if (monthlyRadioButton.isSelected()) {
          yearlyRadioButton.setSelected(false);
        }
      }
    );

    yearlyRadioButton.addActionListener(
      e -> {
        if (yearlyRadioButton.isSelected()) {
          monthlyRadioButton.setSelected(false);
        }
      }
    );

    newRate.addActionListener(
      e -> {
        if (yearlyRadioButton.isSelected()) {

        }
      }
    );

    calculateButton.addActionListener(
      e -> {
        if (newRate.isSelected() && !basicSalaryField.getText().isEmpty()) {
            float basicSalary = Float.parseFloat(basicSalaryField.getText());
            float newRate = nssfRates.getNewRate(basicSalary);
            nssfContributionField.setText(String.format("%.2f", newRate));
        }
        else if(oldRate.isSelected() && !basicSalaryField.getText().isEmpty()){
            float basicSalary = Float.parseFloat(basicSalaryField.getText());
            float oldRate = nssfRates.getOldRate(basicSalary);
            nssfContributionField.setText(String.format("%.2f", oldRate));
        }
      }
    );

    setSize(800, 700);
    setPreferredSize(new Dimension(800, 700));

    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new PayrollCalculator().setVisible(true));
  }
}
