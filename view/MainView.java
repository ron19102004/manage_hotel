package view;

import controller.listObjectController.ListCustomerController;
import controller.listObjectController.ListRoomController;
import view.componentView.MenuView;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarFile;

public class MainView extends JFrame {
    private ListCustomerController listCustomerController;
    private ListRoomController listRoomController;
    public MainView(){
        this.listCustomerController = new ListCustomerController();
        this.listRoomController = new ListRoomController();
        this.init();
        this.setVisible(true);
    }

    public void init() {
        this.setTitle("Quản lý khách sạn");
        this.setSize(1200,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("src/asset/image/managerhotel.jpg");
        this.setIconImage(icon.getImage());

        MenuView menuView = new MenuView(this);
        JMenuBar jMenuBar = menuView.initMenu();

        this.setLayout(new BorderLayout());
        this.add(jMenuBar, BorderLayout.NORTH);
    }

}
