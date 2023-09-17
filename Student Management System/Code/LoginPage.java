import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class LoginPage {

  
  private static String Username;
  JFrame frame;
  JPanel panel;
  JLabel titleLabel, usernameLabel, passwordLabel;
  static JTextField usernameField;
  JPasswordField passwordField;
  JButton loginButton;
  String filepath = "data.csv";



  
  public LoginPage(){
    
    run();
  }
    
   

    public void run(){
      
    // Initialize frame
    frame = new JFrame("Student Management System");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);

    // Initialize panel
    panel = new JPanel();
    panel.setLayout(null);

    // Initialize labels
    titleLabel = new JLabel("Login");
    titleLabel.setBounds(330, 10, 180, 55);
    titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
    panel.add(titleLabel);

    usernameLabel = new JLabel("Username");
    usernameLabel.setBounds(200, 150, 80, 25);
    panel.add(usernameLabel);

    passwordLabel = new JLabel("Password");
    passwordLabel.setBounds(200, 200, 80, 25);  
    panel.add(passwordLabel);

    // Initialize text fields
    usernameField = new JTextField(20);
    usernameField.setBounds(280, 150, 165, 25);
    panel.add(usernameField);

    passwordField = new JPasswordField(20);
    passwordField.setBounds(280, 200, 165, 25);
    panel.add(passwordField);

    // Initialize buttons
    loginButton = new JButton("Enter");
    loginButton.setBounds(350, 250, 90, 25);
    loginButton.setBackground(Color.white);
loginButton.addActionListener(e -> {


 String username = usernameField.getText();
 String password = passwordField.getText();


 

 boolean valid = idCheck(username, password);

 if(valid){
  
   MainPage mainPage = new MainPage();
   mainPage.setVisible(true);
   frame.dispose();
 }
 else{
  JOptionPane.showMessageDialog(null, "Invalid username or password");
 }



    
});
    panel.add(loginButton);

    String url = "pic.jpeg";
    ImageIcon imageIcon = new ImageIcon(getClass().getResource(url));
		Image originalImage = imageIcon.getImage();

		int desiredWidth = 1500;
		int desiredHeight = 700;

		Image resizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);

		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		JLabel background = new JLabel(resizedIcon);
		background.setBounds(0, 0, 990, 700);
		panel.add(background);


    // Add panel to frame
		frame.setResizable(false);
    frame.add(panel);
    frame.setVisible(true);

  }

  

  
    
      

  public static String getUsername() {
      Username = usernameField.getText();
      return Username;
  }



  public boolean idCheck(String id, String password){
    
    boolean valid = false;

    try{
      
      FileReader reader = new FileReader(filepath);
      BufferedReader br = new BufferedReader(reader);
      String line;

  while((line = br.readLine()) != null){
    String[] info = line.split(",");
    String storedID = info[0];
    String storedPassword = info[1];

    if(id.equals(storedID) && password.equals(storedPassword)){
      valid = true;
      break;
    }
  }
    }
    catch(Exception e){
      System.out.println(e);
    }
    return valid;

  }

 

 

}