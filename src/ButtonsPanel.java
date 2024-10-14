import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    JButton[][] btns = new JButton[4][4];
    String[][] btnLabels = {
            {"7", "8", "9", "+"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "*"},
            {"0", "C", "=", "/"},
    };

    public ButtonsPanel(){
        setLayout(new GridLayout(4,4));

        for (int i = 0; i < btns.length; ++i){
            for (int j = 0; j < btns[i].length; ++j){
                btns[i][j] = new JButton(btnLabels[i][j]);
                add(btns[i][j]);
            }
        }

    }
}
