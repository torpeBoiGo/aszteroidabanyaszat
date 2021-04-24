package Grafikus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndOfGame extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel text;

    public EndOfGame(String message) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        text.setText(message);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }
}
