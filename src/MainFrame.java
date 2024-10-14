import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    JTextField textField = new JTextField();
    ButtonsPanel buttonsPanel = new ButtonsPanel();
    boolean doneOp = false;

    public MainFrame() {
        super("Swing Calculator");
        setSize(400,600);

        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
        add(buttonsPanel,BorderLayout.CENTER);

        for (int i = 0; i < buttonsPanel.btns.length; ++i){
            for (int j = 0; j < buttonsPanel.btns[i].length; ++j){
                buttonsPanel.btns[i][j].addActionListener(this);
            }
        }

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("=")){
            String expression = textField.getText();

            if(expression.contains("+")){
                String[] nums = expression.split("[+]");
                int sum = 0;
                for (String num : nums){
                    sum += Integer.parseInt(num);
                }
                textField.setText(Integer.toString(sum));
            }

            if(expression.contains("-")){
                String[] nums = expression.split("[-]");
                int sub = Integer.parseInt(nums[0]);
                for (int i = 1; i < nums.length; i++){
                    sub -= Integer.parseInt(nums[i]);
                }
                textField.setText(Integer.toString(sub));
            }

            if(expression.contains("*")){
                String[] nums = expression.split("[*]");
                int multi = 1;
                for (String num : nums){
                    multi *= Integer.parseInt(num);
                }
                textField.setText(Integer.toString(multi));
            }

            if(expression.contains("/")){
                String[] nums = expression.split("[/]");
                try{
                    int div = Integer.parseInt(nums[0]);
                    for (int i = 1; i < nums.length; i++){
                        div /= Integer.parseInt(nums[i]);
                    }
                    textField.setText(Integer.toString(div));
                }catch (Exception ie){
                    textField.setText(ie.getMessage());
                }
            }

            doneOp = true; // Reset doneOp after performing the operation

        } else if (e.getActionCommand().equals("C")) {
            textField.setText("");
        } else {
            if(doneOp){
                textField.setText("");
                textField.setText(textField.getText() + e.getActionCommand());
                doneOp = false;
            } else {
                textField.setText(textField.getText() + e.getActionCommand());
            }
        }
    }
}
