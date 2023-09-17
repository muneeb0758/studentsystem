import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Grades extends JFrame {

	JTable table;
	JScrollPane scrollPane;
	String filepath = "data.csv";
	String module1;
	String module2;
	String module3;
	String module4;
	String module5;
	String module6;
	String total;
	String grades;
	String grade1, grade2, grade3, grade4, grade5, grade6;
	String m1;
	int marks1, marks2, marks3, marks4, marks5, marks6, finale;

    public Grades() {
        getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

    	FileReader fr;
		try {
			fr = new FileReader( filepath );
			BufferedReader br = new BufferedReader(fr);
			String line;
			try {
				while ((line=br.readLine()) != null) {
					String [] info = line.split(",");
					
					
					if(info[0].equals(LoginPage.getUsername())){
						module1=info[4];
					module2=info[5];
					module3=info[6];
					module4=info[7];
					module5=info[8];
					module6=info[9];
					total=info[12];
					grades=info[13];
					
					
					
					 
				       marks1 = Integer.parseInt(info[4]);
				      if(marks1 >= 90){
				        grade1 = "A";  
				      }else if(marks1 >= 80){
				        grade1 = "B";
				      }else if(marks1 >= 70){
						  grade1 = "C";
						}else if(marks1 >= 60){
							grade1 = "D";
						}else{
							grade1 = "F";
						}


						marks2 = Integer.parseInt(info[5]);
				      if(marks2 >= 90){
				        grade2 = "A";  
				      }else if(marks2 >= 80){
				        grade2 = "B";
				      }else if(marks2 >= 70){
						  grade2 = "C";
						}else if(marks2 >= 60){
							grade2 = "D";
						}else{
							grade2 = "F";
						}


						marks3 = Integer.parseInt(info[6]);
				      if(marks3 >= 90){
				        grade3 = "A";  
				      }else if(marks3 >= 80){
				        grade3 = "B";
				      }else if(marks3 >= 70){
						  grade3 = "C";
						}else if(marks3 >= 60){
							grade3 = "D";
						}else{
							grade3 = "F";
						}


						marks4 = Integer.parseInt(info[7]);
				      if(marks4 >= 90){
				        grade4 = "A";  
				      }else if(marks4 >= 80){
				        grade4 = "B";
				      }else if(marks4 >= 70){
						  grade4 = "C";
						}else if(marks4 >= 60){
							grade4 = "D";
						}else{
							grade4 = "F";
						}


						marks5 = Integer.parseInt(info[8]);
				      if(marks5 >= 90){
				        grade5 = "A";  
				      }else if(marks5 >= 80){
				        grade5 = "B";
				      }else if(marks5 >= 70){
						  grade5 = "C";
						}else if(marks5 >= 60){
							grade5 = "D";
						}else{
							grade5 = "F";
						}


						marks6 = Integer.parseInt(info[9]);
				      if(marks6 >= 90){
				        grade6 = "A";  
				      }else if(marks6 >= 80){
				        grade6 = "B";
				      }else if(marks1 >= 70){
						  grade6 = "C";
						}else if(marks6 >= 60){
							grade6 = "D";
						}else{
							grade6 = "F";
						}

						finale = marks1 + marks2 + marks3 + marks4 + marks5 + marks6;


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

		setSize(1000, 660);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
        JLabel gradesLabel = new JLabel("Grades:");
        gradesLabel.setFont(new Font("San Francisco", Font.PLAIN, 22));
        gradesLabel.setBounds(20, 10, 100, 25);
        getContentPane().add(gradesLabel);
        
        String [] column = {"Module Name" , "Marks" , "Grade"};
        
        Object [][] data= {
        		
        		{"Module 1" , module1, grade1},
        		{"Module 2" , module2 , grade2},
        		{"Module 3" , module3 , grade3},
        		{"Module 4" , module4 , grade4},
        		{"Module 5" , module5 , grade5},
        		{"Module 6" , module6 , grade6} ,
        		{"Total %age: " ,finale+" MARKS" , total+"%"}
        };
        
        DefaultTableModel model = new DefaultTableModel(data , column);
        getContentPane().setLayout(null);
        
        table = new JTable(model);
        table.setRowHeight((int) (table.getRowHeight()*5));
        table.setOpaque(false);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 45, 766, 488);  // Adjust these dimensions as needed
        scrollPane.setOpaque(false);
        getContentPane().add(scrollPane);

        
        JButton back = new JButton("Back");
        back.setBackground(Color.LIGHT_GRAY);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPage mainPage = new MainPage();
                mainPage.setVisible(true);
                dispose();
            }

          
    
        });
        back.setBounds(10, 529, 110, 41);
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
