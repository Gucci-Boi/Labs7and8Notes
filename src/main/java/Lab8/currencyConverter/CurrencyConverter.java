package Lab8.currencyConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CurrencyConverter extends JFrame {
    private JTextField dollarsTextField;
    private JButton convertButton;
    private JLabel conversionResultLabel;
    private JPanel mainPanel;
    private JComboBox<String> currencyBox;
    // conversion rates
    private final String EUROS = "Euros";
    private final String POUNDS = "Pounds";
    // map to hold all the conversion rates
    private Map<String, Double> exchangeRates = Map.of(EUROS, 0.84, POUNDS, 0.75);
    // constructor
    CurrencyConverter() {
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(500, 300));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Allows the user to press Enter instead of clicking the button
        getRootPane().setDefaultButton(convertButton);
        // adds the currencies to the currency comboBox in the JPanel
        currencyBox.addItem(EUROS);
        currencyBox.addItem(POUNDS);
        // adds an event to when the button is clicked
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dollarString = dollarsTextField.getText();
                // try block for exception handing
                try {
                    double dollars = Double.parseDouble(dollarString);

                    // forces the object to a string
                    String toCurrency = (String) currencyBox.getSelectedItem();

                    double exchangeRate = exchangeRates.get(toCurrency);
                    double convertedValue = dollars * exchangeRate;
                    // tells the user the value of dollars in the selected currency
                    String resultString = String.format("%.2f dollars is equivalent to %.2f %s.",
                            dollars, convertedValue, toCurrency);
                    conversionResultLabel.setText(resultString);
                } catch (NumberFormatException nfe) {
                    // makes a pop-up pane that blocks user interaction with the parent pane until it's dismissed
                    JOptionPane.showMessageDialog(CurrencyConverter.this,
                            "Please enter a number with only digits.");
                }
            }
        });
    }

}
