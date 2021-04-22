package Grafikus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.HashMap;


public class MainGUI extends JFrame{
    /**
     * A letrejott objektumok neveit tarolo map
     */
    static HashMap<String, Object> NamesMap = new HashMap<>();
    Jatek JatekInstance;
    static Telepes curr;

    public MainGUI(){
        super("Aszteroida Banyaszat");
        JatekInstance  = new Jatek();


        startButton.addActionListener(e -> {curr = (Telepes) Palya.NextTelepes(); changeTelepes(curr);});
        loadButton.addActionListener(e -> {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                Palya.Reset();
                File selectedFile = fileChooser.getSelectedFile();
                JatekInstance.loadPalyaFromFile(selectedFile.getAbsolutePath());
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            }
        });

        furButton.addActionListener(e -> {curr.Fur(); curr = (Telepes) Palya.NextTelepes(); changeTelepes(curr);});
        banyaszikButton.addActionListener(e -> {curr.Banyasz(); curr = (Telepes) Palya.NextTelepes(); changeTelepes(curr);});
        tetlenButton.addActionListener(e -> {curr = (Telepes) Palya.NextTelepes(); changeTelepes(curr);});

        MozogBox.addItemListener (arg0 -> {
            if (arg0.getStateChange() == ItemEvent.SELECTED && !MozogBox.getSelectedItem().equals("Mozog")) {
                System.out.print(curr.toString());
                curr.Mozog((Mezo) NamesMap.get((String)MozogBox.getSelectedItem()));
                MozogBox.setSelectedIndex(0);
                System.out.println();
                System.out.print(curr.toString());
                curr = (Telepes) Palya.NextTelepes();
                changeTelepes(curr);
            }
        });

        EpitBox.addItem("Epit");
        EpitBox.addItem("Teleportkapu");
        EpitBox.addItem("Robot");
        EpitBox.addItemListener (arg0 -> {
            if (arg0.getStateChange() == ItemEvent.SELECTED && !EpitBox.getSelectedItem().equals("Epit")) {
                if(EpitBox.getSelectedItem().equals("Teleportkapu")){
                    curr.TeleportEpit(new TeleportEpito());
                }else curr.RobotEpit(new RobotEpito());
                curr = (Telepes) Palya.NextTelepes();
                changeTelepes(curr);
            }
        });

        LerakBox.addItemListener (arg0 -> {
            if (arg0.getStateChange() == ItemEvent.SELECTED && !LerakBox.getSelectedItem().equals("Lerak")) {
                Object a = NamesMap.get(LerakBox.getSelectedItem());
                if(a.getClass().getSuperclass().equals(Nyersanyag.class)){
                    curr.AnyagVisszatesz((Nyersanyag) a);
                }else curr.KapuLerak((Teleportkapu) a);
                curr = (Telepes) Palya.NextTelepes();
                changeTelepes(curr);
            }
        });


        JatekInstance.loadPalyaFromFile("inputs" + File.separator + "default.txt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

    }

    public void changeTelepes(Leptetheto uj){
        telepesTxt.setText("Telepes " + Jatek.getKeyByValue(NamesMap, uj) + "  Kor: " + Palya.kor);
        MozogBox.removeAllItems();
        MozogBox.addItem("Mozog");
        for (Mezo t: ((Telepes)uj).aszteroida.getSzomszedok()) { //TODO itt az aszteroidanak nem kene szabad public-nak lennie tippre
            MozogBox.addItem(Jatek.getKeyByValue(NamesMap, t));
        }

        LerakBox.removeAllItems();
        LerakBox.addItem("Lerak");
        for (Szallithato t: ((Telepes)uj).getRakterek()) {
            LerakBox.addItem(Jatek.getKeyByValue(NamesMap, t));
        }
    }

    private JButton startButton;
    private JPanel mainPanel;
    private JButton loadButton;
    private JButton furButton;
    private JButton banyaszikButton;
    private JComboBox MozogBox;
    private JComboBox EpitBox;
    private JComboBox LerakBox;
    private JLabel telepesTxt;
    private JButton tetlenButton;
}
