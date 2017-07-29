package eventsmain;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class MouseEvents extends JFrame {
    private JFrame mainframe;
    private JLabel status;
    private JPanel controlpanel;
    private JTextField createUID;
    private JPasswordField createPass;
    
    public MouseEvents(){
        prepareGUI();
        createAcc();
        validAndLogin();
    }
    
    private void prepareGUI(){
        mainframe = new JFrame();
        mainframe.setSize(400,400);
        mainframe.setLayout(new GridLayout(3,1));
        mainframe.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent windowevent){
                    System.exit(0);
                }
            });
        
        status = new JLabel("status",JLabel.CENTER);
        status.setSize(200,200);
        
        controlpanel = new JPanel();
        controlpanel.setLayout(new FlowLayout());
        mainframe.add(controlpanel);
        mainframe.add(status);
        mainframe.setVisible(true);
    }
    private void createAcc(){
        JLabel usertext = new JLabel("USER ID: ",JLabel.RIGHT);
        JLabel passtext = new JLabel("PASSWORD: ", JLabel.CENTER);
        createUID= new JTextField(6);
        createPass = new JPasswordField(6);
        
        JButton create = new JButton("Create");
        create.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String data ="User ID: " + createUID.getText();
                data +=" , Password: " + new String(createPass.getPassword());
                //status.setText(createUID.getText());
            }
        });
        
        controlpanel.add(usertext);
        controlpanel.add(createUID);
        controlpanel.add(passtext);
        controlpanel.add(createPass);
        controlpanel.add(create);
        mainframe.setVisible(true);
    }
    private void validAndLogin(){
        JLabel usertext = new JLabel("USER ID: ",JLabel.RIGHT);
        JLabel passtext = new JLabel("PASSWORD: ", JLabel.CENTER);
        
        JTextField checkUID = new JTextField(6);
        JPasswordField checkPass = new JPasswordField(6);

        
        JButton login = new JButton("Login");
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String data = "userID: " + checkUID.getText();
                data += " , password: " + new String(checkPass.getPassword());
                
                NewWindow NwObj = new NewWindow();
                boolean checkID = checkUID.getText().equals(createUID.getText());
                boolean checkPW = Arrays.equals(checkPass.getPassword(), createPass.getPassword());
                
                if(checkID && checkPW){
                    NwObj.sum();
                    status.setText(data);
                }
                else
                    status.setText("Invalid Login Details");
            }
        });
        
        controlpanel.add(usertext);
        controlpanel.add(checkUID);
        controlpanel.add(passtext);
        controlpanel.add(checkPass);
        controlpanel.add(login);
        mainframe.setVisible(true);
        
    }
}
