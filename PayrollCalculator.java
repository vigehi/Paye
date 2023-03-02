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

  public PayrollCalculator() {
    super("Payroll Calculator");
    try {
      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Exception e) {
      // handle the exception
    }

    JPanel periodPanel = new JPanel(new GridLayout(1, 4));
    periodPanel.add(new JLabel("Pay Period:"));
    periodPanel.add(monthlyRadioButton);
    periodPanel.add(yearlyRadioButton);

    ButtonGroup periodButtonGroup = new ButtonGroup();
    periodButtonGroup.add(monthlyRadioButton);
    periodButtonGroup.add(yearlyRadioButton);

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
    buttonPanel.add(new JButton("Calculate"));


    JPanel wrappedFormPanel = new JPanel(new BorderLayout());
    wrappedFormPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
    wrappedFormPanel.add(periodPanel, BorderLayout.NORTH);
    wrappedFormPanel.add(formPanel, BorderLayout.CENTER);
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
