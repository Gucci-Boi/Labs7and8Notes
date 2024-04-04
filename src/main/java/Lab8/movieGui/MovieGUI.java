package Lab8.movieGui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieGUI extends JFrame {
    private JTextField movieTitleTextField;
    private JCheckBox wouldSeeAgainCheckBox;
    private JSlider ratingSlider;
    private JPanel mainPanel;
    private JLabel sliderValueLabel;
    private JLabel movieOpinionLabel;
    private JButton quitButton;

    MovieGUI() {
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(400, 300));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        configureEventHandler();
    }

    private void configureEventHandler() {
        // adds event for the JSlider
        ratingSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String valueLabelText = ratingSlider.getValue() + " stars";
                sliderValueLabel.setText(valueLabelText);
                updateOpinion();
            }
        });

        wouldSeeAgainCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateOpinion();
            }
        });

        movieTitleTextField.getDocument().addDocumentListener(new DocumentListener() {
            // called when text is added to the text field
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateOpinion();
            }

            // called when text is removed from the ext field
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateOpinion();
            }

            // called when something about the tex is changed in the text field
            // will not be used
            @Override
            public void changedUpdate(DocumentEvent e) {
                // ignored
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // more readable to have this as a variable rather than in the if statement
                int quit = JOptionPane.showConfirmDialog(MovieGUI.this,
                        "Are you sure you want to quit?", "Quit", JOptionPane.OK_CANCEL_OPTION);
                // if statement to ask the user to confirm closing the JFrame
                if (quit == JOptionPane.OK_OPTION) {
                    // gets rid of the current JFrame
                    dispose();
                }

            }
        });
    }
    // method
    private void updateOpinion() {
        String movieName = movieTitleTextField.getText().strip();
        // checks whether the movie text field is empty
        if (movieName.isEmpty()) {
            movieOpinionLabel.setText("Movie opinion");
            return;
        } else {

            int rating = ratingSlider.getValue();
            boolean seeAgain = wouldSeeAgainCheckBox.isSelected();

            String template = "You rated %s %d stars. You %s see again.";

            String seeAgainString = "would";
            if (!seeAgain) {
                seeAgainString = "wouldn't";
            }

            // ternary operator. I found it interesting, seems cool
            // String seeAgainString = (seeAgain) ? "would" : "wouldn't";

            String opinion = String.format(template, movieName, rating, seeAgainString);
            movieOpinionLabel.setText(opinion);
        }
    }
}
