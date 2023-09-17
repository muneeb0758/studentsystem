import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Attendance extends JFrame {

    JTable table;
    JScrollPane scrollPane;
    String filepath = "data.csv";
    String attendence;
    String percentage;
    String at1, at2, at3, at4, at5, at6;


    public Attendance() {
        setTitle("Attendance");

            FileReader fr;
            try {
                fr = new FileReader( filepath );
                BufferedReader br = new BufferedReader(fr);
                String line;
                try {
                    while ((line=br.readLine()) != null) {
                        String [] info = line.split(",");
                        
					if(info[0].equals(LoginPage.getUsername())){
                        attendence = info[20];
                        at1 = info[14];
                        at2 = info[15];
                        at3 = info[16];
                        at4 = info[17];
                        at5 = info[18];
                        at6 = info[19];
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

        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
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
        back.setBounds(30, 620, 150, 41);
        add(back);
        getContentPane().add(back);


        String[] columnNames = {"Module", "Attendance"};
        Object[][] data = {
            {"Module 1", at1+"%"},
            {"Module 2", at2+"%"},
            {"Module 3", at3+"%"},
            {"Module 4", at4+"%"},
            {"Module 5", at5+"%"},
            {"Module 6", at6+"%"},
            {"Total: ", attendence+"%"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        getContentPane().setLayout(null);
        
        
        table = new JTable(model);
        table.setRowHeight((int) (table.getRowHeight() * 5)); 
        table.setFont(table.getFont().deriveFont((float) table.getFont().getSize() * 1.3f)); // Increase font size by 30%
        table.setOpaque(true);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 986, 763);
        getContentPane().add(scrollPane);
        
        setLocationRelativeTo(null); // Center the frame on the screen
        
        
        
        String url = "atten.jpeg";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(url));
        Image originalImage = imageIcon.getImage();
        
        int desiredWidth = 1400;
        int desiredHeight = 700;
        
        Image resizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel background = new JLabel(resizedIcon);
        background.setBounds(0, 0, 990, 700);
    


        getContentPane().add(background);

        
        
    }


       
}

