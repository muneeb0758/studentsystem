import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.jar.Attributes.Name;
import java.awt.*;

public class Profile extends JFrame{


	String filepath = "data.csv";
	String Name;
	String Slogan;
	String Role;
	String email;

	public Profile()  {

		super("User Profile");


		FileReader fr;
		try {
			fr = new FileReader(filepath);


			BufferedReader br = new BufferedReader(fr);
			String line;

			try {
				while((line = br.readLine()) != null){
					String[] info = line.split(",");

					if(info[0].equals(LoginPage.getUsername())){
						Name = info[0];
						Slogan = info[11];
						Role = info[10];
						email = info[2];
					}


				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		setSize(1000,600);
		getContentPane().setLayout(null);

		JLabel heading = new JLabel("User Information");
		heading.setFont(new Font("Monospaced", Font.BOLD, 22));
		heading.setBounds(10, 30, 708, 39);
		getContentPane().add(heading);

		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setFont(new Font("San Francisco", Font.PLAIN, 16));
		firstNameLabel.setBounds(20, 89, 100, 25);
		getContentPane().add(firstNameLabel);

		JLabel firstName = new JLabel(Name);
		firstName.setFont(new Font("San Francisco", Font.PLAIN, 16));
		firstName.setBounds(130, 89, 200, 25);
		getContentPane().add(firstName);

		JLabel JSlogan = new JLabel("Slogan");
		JSlogan.setFont(new Font("San Francisco", Font.PLAIN, 16));
		JSlogan.setBounds(20, 128, 100, 25);
		getContentPane().add(JSlogan);

		JLabel slogan = new JLabel(Slogan);
		slogan.setFont(new Font("San Francisco", Font.PLAIN, 16));
		slogan.setBounds(130, 128, 300, 25);
		getContentPane().add(slogan);

		JLabel roleLabel = new JLabel("Role:");
		roleLabel.setFont(new Font("San Francisco", Font.PLAIN, 16));
		roleLabel.setBounds(20, 169, 100, 25);
		getContentPane().add(roleLabel);

		JLabel role = new JLabel(Role);
		role.setFont(new Font("San Francisco", Font.PLAIN, 16));
		role.setBounds(130, 169, 200, 25);
		getContentPane().add(role);

		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("San Francisco", Font.PLAIN, 16));
		emailLabel.setBounds(20, 219, 100, 25);
		getContentPane().add(emailLabel);

		JLabel Jemail = new JLabel(email);
		Jemail.setFont(new Font("San Francisco", Font.PLAIN, 16));
		Jemail.setBounds(130, 206, 546, 50);
		getContentPane().add(Jemail);

		JLabel adminNotesLabel = new JLabel("Admin Notes:");
		adminNotesLabel.setFont(new Font("San Francisco", Font.PLAIN, 16));
		adminNotesLabel.setBounds(20, 275, 100, 25);
		getContentPane().add(adminNotesLabel);

		JLabel adminNotes = new JLabel("Great team player. Recently completed on new framework.");
		adminNotes.setFont(new Font("San Francisco", Font.PLAIN, 16));
		adminNotes.setBounds(130, 228, 401, 118);
		getContentPane().add(adminNotes);

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
		back.setBounds(220, 487, 110, 41);
		getContentPane().add(back);



		String url = "prof.jpeg";
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(url));
		Image originalImage = imageIcon.getImage();

		int desiredWidth = 1100;
		int desiredHeight = 700;

		Image resizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);

		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		JLabel background = new JLabel(resizedIcon);
		background.setBounds(0, 0, 990, 700);


		getContentPane().add(background);


	}



}