import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {
    private JTextField displayField;
    private double currentResult = 0.0;
    private String lastOperation = "=";
    private boolean startNewNumber = true;

    public CalculatorApp() {
        super("Calculator");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayField = new JTextField("0");
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));

            if (Character.isDigit(label.charAt(0)) || label.equals(".")) {
                button.addActionListener(new DigitButtonListener());
            }
            else {
                button.addActionListener(new OperationButtonListener());
            }

            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setSize(300, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class DigitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();

            if (startNewNumber) {
                if (input.equals(".")) {
                    displayField.setText("0.");
                } else {
                    displayField.setText(input);
                }
                startNewNumber = false;
            }
            else {
                if (input.equals(".") && displayField.getText().contains(".")) {
                    return;
                }
                displayField.setText(displayField.getText() + input);
            }
        }
    }

    private class OperationButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operation = e.getActionCommand();
            double number = 0.0;
            try {
                number = Double.parseDouble(displayField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ошибка ввода!", "Alert", JOptionPane.ERROR_MESSAGE);
                displayField.setText("0");
                currentResult = 0.0;
                lastOperation = "=";
                startNewNumber = true;
                return;
            }

            calculate(number);
            lastOperation = operation;
            startNewNumber = true;
        }
    }

    private void calculate(double number) {
        switch (lastOperation) {
            case "+":
                currentResult += number;
                break;
            case "-":
                currentResult -= number;
                break;
            case "*":
                currentResult *= number;
                break;
            case "/":
                if (number == 0) {
                    displayField.setText("Error");
                    currentResult = 0.0;
                    return;
                }
                currentResult /= number;
                break;
            case "=":
                currentResult = number;
                break;
        }

        if (currentResult == (long) currentResult) {
            displayField.setText(String.format("%d", (long) currentResult));
        } else {
            displayField.setText(String.valueOf(currentResult));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorApp();
            }
        });
    }
}
