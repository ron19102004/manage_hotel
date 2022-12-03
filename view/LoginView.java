package view;

import asset.image.ProcessImage;
import controller.actionListenerController.ALLoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField username;
    private JPasswordField password;
    public LoginView(){
        this.init();
        this.setVisible(true);
    }
    private void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,300);
        //Default size
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Login");
        ImageIcon iconLogin = new ImageIcon("src/asset/image/loginIcon/keyIcon.png");
        this.setIconImage(iconLogin.getImage());

        Font font = new Font("Cascadia",Font.ITALIC,20);
        Font fontTile = new Font("Cascadia",Font.BOLD,35);
        Font fontCheck = new Font("Cascadia",Font.BOLD,20);

        JPanel jPanelTitle = new JPanel();
        jPanelTitle.setLayout(new FlowLayout());
        JLabel title = new JLabel("Login - Hotel Management System");
        title.setFont(fontTile);
        jPanelTitle.add(title);

        ActionListener actionListener = new ALLoginController(this);
        JPanel jPanelUser = new JPanel();
        JPanel jPanelPass = new JPanel();
        JPanel jPanelCheck = new JPanel();
        JPanel jPanelLogin = new JPanel();

        jPanelUser.setLayout(new FlowLayout());
        jPanelPass.setLayout(new FlowLayout());
        jPanelCheck.setLayout(new FlowLayout());
        jPanelLogin.setLayout(new GridLayout(3,1));

        ImageIcon iconUser = ProcessImage.getInstance().setImageIcon("src/asset/image/loginIcon/userIcon3.png",45,50);
        JLabel jLabelUserName = new JLabel("Username:",iconUser,JLabel.CENTER);
        jLabelUserName.setFont(font);
        this.username = new JTextField(15);
        this.username.setFont(font);
        jPanelUser.add(jLabelUserName);
        jPanelUser.add(this.username);

        ImageIcon iconPass = ProcessImage.getInstance().setImageIcon("src/asset/image/loginIcon/passwordIcon1.png",45,50);
        JLabel jLabelPassWord = new JLabel("Password:",iconPass,JLabel.CENTER);
        jLabelPassWord.setFont(font);
        this.password = new JPasswordField(15);
        this.password.setFont(font);
        jPanelPass.add(jLabelPassWord);
        jPanelPass.add(this.password);


        JButton ok = new JButton("Submit");
        ok.setFont(fontCheck);
        ok.setBackground(Color.BLUE);
        ok.setBorderPainted(false);
        ok.setForeground(Color.WHITE);
        ok.addActionListener(actionListener);
        jPanelCheck.add(ok);

        jPanelLogin.add(jPanelUser);
        jPanelLogin.add(jPanelPass);
        jPanelLogin.add(jPanelCheck);

        JPanel jPanelView = new JPanel();
        jPanelView.setLayout(new BorderLayout());
        jPanelView.add(jPanelTitle,BorderLayout.NORTH);
        jPanelView.add(jPanelLogin,BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(jPanelView,BorderLayout.CENTER);
    }
    public String getUsername(){
        return this.username.getText().trim();
    }
    public char[] getPassword(){
        return this.password.getPassword();
    }
}
