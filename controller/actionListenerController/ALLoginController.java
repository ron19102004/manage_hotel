package controller.actionListenerController;

import asset.image.ProcessImage;
import database.JDBCUtil;
import view.LoginView;
import view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;

public class ALLoginController implements ActionListener {
    private LoginView loginView;
    private String passWord;
    public ALLoginController(LoginView loginView){
        this.loginView = loginView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Submit")) {
            ImageIcon errorIcon = ProcessImage.getInstance().setImageIcon("src/asset/image/loginIcon/error.png",60,60);
            if(this.loginView.getUsername().equals("") || Arrays.toString(this.loginView.getPassword()).equals("[]")){
                JFrame alertMessage = new JFrame("Cung cấp thông tin");
                JOptionPane.showMessageDialog(alertMessage,"Vui lòng cung cấp đầy đủ username và password.","Lỗi",JOptionPane.ERROR_MESSAGE,errorIcon);
            } else {
                int check = this.checkLogin(this.loginView.getUsername(),this.loginView.getPassword());
                switch (check){
                    case -1:
                        JFrame jFrameErrorPass = new JFrame("Lỗi đăng nhập");
                        JOptionPane.showMessageDialog(jFrameErrorPass,"Mật khẩu đăng nhập không khớp. Vui lòng kiểm tra lại","Lỗi đăng nhập",JOptionPane.ERROR_MESSAGE,errorIcon);
                        break;
                    case 1:
                        JFrame jFrameCongrats = new JFrame("Đăng nhập thành công");
                        ImageIcon checkOK = ProcessImage.getInstance().setImageIcon("src/asset/image/loginIcon/checkOK.png",60,60);
                        JOptionPane.showMessageDialog(jFrameCongrats,"Đăng nhập thành công. Hệ thống đã sẵn sàng sử dụng.","Đăng nhập thành công",JOptionPane.INFORMATION_MESSAGE,checkOK);
                        this.loginView.setVisible(false);
                        new MainView();
                        break;
                    case 0:
                        JFrame jFrameErrorUser = new JFrame("Lỗi đăng nhập");
                        JOptionPane.showMessageDialog(jFrameErrorUser,"Tên đăng nhập không khớp. Vui lòng kiểm tra lại","Lỗi đăng nhập",JOptionPane.ERROR_MESSAGE,errorIcon);
                        break;
                }
            }
        }
    }
    public int checkLogin(String username, char[] password){
        this.passWord = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql ="SELECT (password_MH) from account_login WHERE username = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               String pass = resultSet.getNString("password_MH");
               this.setPassWord(pass);
            }
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
        if(this.passWord == null){
            return 0;
        }else if(Arrays.equals(password,this.passWord.toCharArray())){
            return 1;
        } else return -1;
    }
    public void setPassWord(String p){
        this.passWord = p;
    }
}
