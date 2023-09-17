import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SettingsPage extends JFrame {

    private JTextField firstNameField;
    private JTextField slogan;
    private JTextField roleField;
    private JTextArea Email;
    private JTextArea adminNotesArea;
    String filepath = "data.csv";
    String Name;
    String Slogan;
    String Role;
    String email;

    public SettingsPage() {

        initialize();
        image();
    }

    private void initialize() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        FileReader fr;
        try {
            fr = new FileReader(filepath);

            BufferedReader br = new BufferedReader(fr);
            String line;

            try {
                while ((line = br.readLine()) != null) {
                    String[] info = line.split(",");

                    if (info[0].equals(LoginPage.getUsername())) {
                        Name = info[0];
                        Slogan = info[11];
                        Role = info[10];
                        email = info[2];
                    }

                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        setSize(1000, 700);
        getContentPane().setLayout(null);

        JLabel heading = new JLabel("User Settings");
        heading.setFont(new Font("Monospaced", Font.BOLD, 22));
        heading.setBounds(10, 30, 708, 39);
        getContentPane().add(heading);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("San Francisco", Font.PLAIN, 16));
        firstNameLabel.setBounds(20, 89, 100, 25);
        getContentPane().add(firstNameLabel);

        firstNameField = new JTextField(Name);
        firstNameField.setFont(new Font("San Francisco", Font.PLAIN, 16));
        firstNameField.setBounds(130, 89, 350, 25);
        getContentPane().add(firstNameField);

        JLabel slog = new JLabel("Slogan");
        slog.setFont(new Font("San Francisco", Font.PLAIN, 16));
        slog.setBounds(20, 128, 100, 25);
        getContentPane().add(slog);

        slogan = new JTextField(Slogan);
        slogan.setFont(new Font("San Francisco", Font.PLAIN, 16));
        slogan.setBounds(130, 128, 350, 25);
        getContentPane().add(slogan);

        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setFont(new Font("San Francisco", Font.PLAIN, 16));
        roleLabel.setBounds(20, 169, 100, 25);
        getContentPane().add(roleLabel);

        roleField = new JTextField(Role);
        roleField.setFont(new Font("San Francisco", Font.PLAIN, 16));
        roleField.setBounds(130, 169, 350, 25);
        getContentPane().add(roleField);

        JLabel mail = new JLabel("Email:");
        mail.setFont(new Font("San Francisco", Font.PLAIN, 16));
        mail.setBounds(20, 219, 100, 25);
        getContentPane().add(mail);

        Email = new JTextArea(email);
        Email.setFont(new Font("San Francisco", Font.PLAIN, 16));
        Email.setBounds(130, 220, 491, 28);
        getContentPane().add(Email);

        JLabel adminNotesLabel = new JLabel("Admin Notes:");
        adminNotesLabel.setFont(new Font("San Francisco", Font.PLAIN, 16));
        adminNotesLabel.setBounds(20, 275, 100, 25);
        getContentPane().add(adminNotesLabel);

        adminNotesArea = new JTextArea("Great team player. Recently completed training on a new framework.");
        adminNotesArea.setFont(new Font("San Francisco", Font.PLAIN, 16));
        adminNotesArea.setBounds(130, 275, 491, 28);
        getContentPane().add(adminNotesArea);

        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("San Francisco", Font.PLAIN, 16));
        saveButton.setBackground(Color.white);
        saveButton.setBounds(220, 370, 110, 41);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }
        });
        getContentPane().add(saveButton);

        JButton back = new JButton("Back");
        back.setBackground(Color.white);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage mainPage = new MainPage();
                mainPage.setVisible(true);
                dispose();
            }

        });
        back.setBounds(20, 370, 110, 41);
        getContentPane().add(back);

    }

    private void saveChanges() {
        String firstName = firstNameField.getText();
        String sloganText = slogan.getText();
        String role = roleField.getText();
        String emailText = Email.getText();
    
        try {
            FileReader frd = new FileReader(filepath);
            BufferedReader brd = new BufferedReader(frd);
    
            String line;
            StringBuilder updatedContent = new StringBuilder();
    
            while ((line = brd.readLine()) != null) {
                String[] info = line.split(",");
    
                if (info[0].equals(LoginPage.getUsername())) {
                    info[0] = firstName;
                    info[11] = sloganText;
                    info[10] = role;
                    info[2] = emailText;
                }
    
                updatedContent.append(String.join(",", info)).append("\n");
            }
    
            brd.close();
            frd.close();
    
            FileWriter fw = new FileWriter(filepath, false); // Open in overwrite mode
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(updatedContent.toString());
            bw.close();
            fw.close();
    
            JOptionPane.showMessageDialog(this, "Changes saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while saving changes.");
        }
    }
    

    

    private void image() {
        String url = "settin.jpeg";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(url));
        Image originalImage = imageIcon.getImage();

        int desiredWidth = 1000;
        int desiredHeight = 700;

        Image resizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);

        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel background = new JLabel(resizedIcon);
        background.setBounds(0, 0, 990, 700);

        getContentPane().add(background);

    }

}
