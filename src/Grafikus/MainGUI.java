package Grafikus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainGUI extends JFrame{
    Jatek JatekInstance;
    public MainGUI(Jatek jatek){
        super("Aszteroida Banyaszat");
        JatekInstance  = jatek;


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    JatekInstance.loadPalyaFromFile(selectedFile.getAbsolutePath());
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                }
            }
        });


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    private JButton startButton;
    private JPanel mainPanel;
    private JButton loadButton;
    private JButton furButton;
    private JButton banyaszikButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
}
