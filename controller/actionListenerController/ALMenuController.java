package controller.actionListenerController;

import view.MainView;
import view.componentView.MenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ALMenuController implements ActionListener {
    private MenuView menuView;
    public ALMenuController(MenuView menuView){
        this.menuView = menuView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if(src.equals("Exit")){
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            System.exit(1);
        }
    }
}
