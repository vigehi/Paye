import javax.swing.*;
import java.awt.*;

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

        add(periodPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        monthlyRadioButton.addActionListener(e -> {
            if (monthlyRadioButton.isSelected()) {
                yearlyRadioButton.setSelected(false);
            }
        });

        yearlyRadioButton.addActionListener(e -> {
            if (yearlyRadioButton.isSelected()) {
                monthlyRadioButton.setSelected(false);
            }
        });

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PayrollCalculator().setVisible(true));
    }
}

