package view.componentView;

import controller.actionListenerController.ALMenuController;
import view.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuView extends JFrame {
    private MainView mainView;
    private ActionListener actionListener;
    private Font font;
    public MenuView(MainView mainView){
        this.mainView = mainView;
        this.actionListener = new ALMenuController(this);
        this.font = new Font("Cascadia Mono",Font.BOLD,15);
    }
    public JMenuBar initMenu(){
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenuFile = this.mFile();
        JMenu jMenuEdit = this.mEdit();
        JMenu jMenuHelp = this.mEdit();
        JMenu jMenuRefresh = this.mRefresh();

        jMenuBar.add(jMenuFile);
        jMenuBar.add(jMenuEdit);
        jMenuBar.add(jMenuHelp);

        JSeparator jSeparator = new JSeparator();
        jSeparator.getOrientation();

        jMenuBar.add(jSeparator);
        jMenuBar.add(jMenuRefresh);
        return jMenuBar;
    }
    public JMenu mFile(){
        JMenu jMenuFile = new JMenu("File");
        jMenuFile.setFont(this.font);

        ImageIcon exportIcon = new ImageIcon("src/asset/image/MenuIcon/export_to_file_21450.png");
        JMenuItem exportFile = new JMenuItem("Export File",exportIcon);
        exportFile.setFont(this.font);
        exportFile.addActionListener(this.actionListener);

        ImageIcon exitIcon= new ImageIcon("src/asset/image/MenuIcon/blue-turn-off-png-2.png");
        JMenuItem exit = new JMenuItem("Exit",exitIcon);
        exit.setFont(this.font);
        exit.addActionListener(this.actionListener);

        jMenuFile.add(exportFile);
        jMenuFile.addSeparator();
        jMenuFile.add(exit);
        return jMenuFile;
    }
    public JMenu mEdit(){
        JMenu jMenuEdit = new JMenu("Edit");
        jMenuEdit.setFont(this.font);

        return jMenuEdit;
    }
    public JMenu mHelp(){
        JMenu jMenuHelp = new JMenu("Help");
        jMenuHelp.setFont(this.font);
        return jMenuHelp;
    }
    public JMenu mRefresh(){
        ImageIcon refresh = new ImageIcon("src/asset/image/MenuIcon/refresh.png");
        JMenu jMenuRefresh = new JMenu("Refresh");
        jMenuRefresh.setIcon(refresh);
        jMenuRefresh.setFont(this.font);
        jMenuRefresh.addActionListener(this.actionListener);
        return jMenuRefresh;
    }
}
