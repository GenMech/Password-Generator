import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PasswordGeneratorApp extends JFrame {

    private JTextField passwordField;
    private JCheckBox lowercaseCheckBox, uppercaseCheckBox, numbersCheckBox, symbolsCheckBox;
    private JButton generateButton;

    public PasswordGeneratorApp() {
        setTitle("Password Generator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        passwordField = new JTextField();
        passwordField.setEditable(false);

        lowercaseCheckBox = new JCheckBox("Lowercase");
        uppercaseCheckBox = new JCheckBox("Uppercase");
        numbersCheckBox = new JCheckBox("Numbers");
        symbolsCheckBox = new JCheckBox("Symbols");

        generateButton = new JButton("Generate Password");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePassword();
            }
        });

        setLayout(new GridLayout(5, 1));
        add(passwordField);
        add(lowercaseCheckBox);
        add(uppercaseCheckBox);
        add(numbersCheckBox);
        add(symbolsCheckBox);
        add(generateButton);
    }

    private void generatePassword() {
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String symbolChars = "!@#$%^&*()-_=+[]{}|;:'<>,.?/";

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        if (lowercaseCheckBox.isSelected()) {
            char randomChar = lowercaseChars.charAt(random.nextInt(lowercaseChars.length()));
            password.append(randomChar);
        }

        if (uppercaseCheckBox.isSelected()) {
            char randomChar = uppercaseChars.charAt(random.nextInt(uppercaseChars.length()));
            password.append(randomChar);
        }

        if (numbersCheckBox.isSelected()) {
            char randomChar = numberChars.charAt(random.nextInt(numberChars.length()));
            password.append(randomChar);
        }

        if (symbolsCheckBox.isSelected()) {
            char randomChar = symbolChars.charAt(random.nextInt(symbolChars.length()));
            password.append(randomChar);
        }

        int passwordLength = 8; // Default password length
        for (int i = password.length(); i < passwordLength; i++) {
            String selectedCharSet = concatenateSelectedCharSets();
            char randomChar = selectedCharSet.charAt(random.nextInt(selectedCharSet.length()));
            password.append(randomChar);
        }

        passwordField.setText(password.toString());
    }

    private String concatenateSelectedCharSets() {
        StringBuilder selectedCharSet = new StringBuilder();
        if (lowercaseCheckBox.isSelected()) {
            selectedCharSet.append("abcdefghijklmnopqrstuvwxyz");
        }
        if (uppercaseCheckBox.isSelected()) {
            selectedCharSet.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (numbersCheckBox.isSelected()) {
            selectedCharSet.append("0123456789");
        }
        if (symbolsCheckBox.isSelected()) {
            selectedCharSet.append("!@#$%^&*()-_=+[]{}|;:'<>,.?/");
        }
        return selectedCharSet.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PasswordGeneratorApp().setVisible(true);
            }
        });
    }
}
