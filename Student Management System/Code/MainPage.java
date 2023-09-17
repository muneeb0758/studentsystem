import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPage extends JFrame {

    private JButton attendanceButton;
    private JButton gradesButton;
    private JButton profileButton;
    private JButton settingsButton;
    private JPanel panel;

    public MainPage() {
        super("Online Portal");

       
        setSize(800, 600);
        
        panel = new JPanel();
        panel.setLayout(null);

        // Create the attendance button
        attendanceButton = new JButton("Attendance");
        attendanceButton.setBounds(127, 266, 180, 150);
       
        attendanceButton.setBackground(Color.RED);
        attendanceButton.setForeground(Color.WHITE);
        attendanceButton.setFont(new Font("Arial", Font.BOLD, 24));
        attendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Go to the attendance page
            	Attendance attendence = new Attendance();
            	attendence.setVisible(true);
            }
        });

        // Create the grades button
        gradesButton = new JButton("Grades");
        gradesButton.setBounds(317, 266, 180, 150);
        gradesButton.setBackground(Color.GREEN);
        gradesButton.setForeground(Color.WHITE);
        gradesButton.setFont(new Font("Arial", Font.BOLD, 24));
        gradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Go to the grades page
            	Grades grades = new Grades();
            	grades.setVisible(true);
            }
        });

        // Create the profile button
        profileButton = new JButton("Profile");
        profileButton.setBounds(125, 76, 180, 150);
        profileButton.setBackground(Color.YELLOW);
        profileButton.setForeground(Color.BLACK);
        profileButton.setFont(new Font("Arial", Font.BOLD, 24));
        profileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Go to the profile page
            	
            	Profile profile = new Profile();
            	profile.setVisible(true);
            	
            }
        });

        // Create the settings button
        settingsButton = new JButton("Settings");
        settingsButton.setBounds(317, 76, 180, 150);
        settingsButton.setBackground(Color.BLUE);
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setFont(new Font("Arial", Font.BOLD, 24));
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                SettingsPage settings = new SettingsPage();
                settings.setVisible(true);
                dispose();
            }
        });  


        JButton back = new JButton("Back");
        back.setBackground(Color.white);
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		LoginPage log = new LoginPage();
        	}
        });
        back.setBounds(100, 499, 110, 41);
        
        
        //Picture
        
        String url = "mpg.jpeg";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(url));
        Image originalImage = imageIcon.getImage();
        
        int desiredWidth = 1000;
        int desiredHeight = 700;
        
        Image resizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel background = new JLabel(resizedIcon);
        background.setBounds(0, 0, 990, 700);
    



        panel.add(attendanceButton);
        panel.add(gradesButton);
        panel.add(profileButton);
        panel.add(settingsButton);
        panel.add(back);
        panel.add(background);

        // Add the panel to the window's content pane
        getContentPane().add(panel);
        
        // Center the window on the screen
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        

    		
    		
 
      
    }
}
