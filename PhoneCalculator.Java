import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PhoneCalculator 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Phone Calculator");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel label1 = new JLabel("Number 1:");
        JLabel label2 = new JLabel("Number 2:");
        JTextField numberField1 = new JTextField();
        JTextField numberField2 = new JTextField();
        topPanel.add(label1);
        topPanel.add(numberField1);
        topPanel.add(label2);
        topPanel.add(numberField2);
        JPanel centerPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("X");
        JButton divideButton = new JButton("/");
        JButton resetButton = new JButton("Reset");
        JButton resultButton = new JButton("=");
        centerPanel.add(addButton);
        centerPanel.add(subtractButton);
        centerPanel.add(multiplyButton);
        centerPanel.add(divideButton);
        centerPanel.add(resetButton);
        centerPanel.add(resultButton);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        bottomPanel.add(resultLabel, BorderLayout.WEST);
        bottomPanel.add(resultField, BorderLayout.CENTER);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        final String[] selectedOperation = {""};
        addButton.addActionListener(e -> selectedOperation[0] = "Add");
        subtractButton.addActionListener(e -> selectedOperation[0] = "Subtract");
        multiplyButton.addActionListener(e -> selectedOperation[0] = "Multiply");
        divideButton.addActionListener(e -> selectedOperation[0] = "Divide");
        resultButton.addActionListener(e -> 
        {
            try 
            {
                double num1 = Double.parseDouble(numberField1.getText());
                double num2 = Double.parseDouble(numberField2.getText());
                double result = 0;
                switch (selectedOperation[0]) 
                {
                    case "Add":
                        result = num1 + num2;
                        break;
                    case "Subtract":
                        result = num1 - num2;
                        break;
                    case "Multiply":
                        result = num1 * num2;
                        break;
                    case "Divide":
                        if (num2 == 0) 
                        {
                            JOptionPane.showMessageDialog(frame, "Division by zero is not allowed!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        result = num1 / num2;
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "Please select an operation first!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                resultField.setText(String.valueOf(result));
            } 
            catch (NumberFormatException ex) 
            {
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        resetButton.addActionListener(e -> 
        {
            numberField1.setText("");
            numberField2.setText("");
            resultField.setText("");
            selectedOperation[0] = "";
        });
        frame.setVisible(true);
    }
}