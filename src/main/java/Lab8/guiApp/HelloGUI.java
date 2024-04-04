package Lab8.guiApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloGUI extends JFrame {
    private JPanel mainPanel;
    private JButton clickHereButton;
    private JLabel myFirstLabel;

    HelloGUI() {
        // tells IntelliJ that this JPanel is the main panel
        setContentPane(mainPanel);
        // sets the length and width of the panel
        setPreferredSize(new Dimension(300, 300));
        // packs and organizes the components
        pack();
        // makes the JFrame visible
        setVisible(true);
        // stops running the program when the panel is closed
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // adds an event that runs when the button is clicked
        clickHereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // changes the label's text
                myFirstLabel.setText("'Sup GUI programmers.");
            }
        });
    }
}
