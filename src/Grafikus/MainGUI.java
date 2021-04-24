package Grafikus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class MainGUI extends JFrame {
    /**
     * A letrejott objektumok neveit tarolo map
     */
    static HashMap<String, Object> NamesMap = new HashMap<>();
    static Telepes curr;
    Reader readerInstance = new Reader();
    boolean isStarted = false;

    private JPanel pMain;
    private JButton bFur;
    private JButton bBanyaszik;
    private JComboBox<String> cboxMozog;
    private JComboBox<String> cboxEpit;
    private JComboBox<String> cboxLerak;
    private JLabel lTelepes;
    private JButton bTetlen;
    private JLabel lMozog;
    private JLabel lEpit;
    private JLabel lLerak;
    private JPanel pTop;
    private JPanel pGraphics;
    private JPanel jspInventory;
    private JMenuBar menuBar;
    private JMenu mFile;
    private JMenuItem mItemStart;
    private JMenuItem mItemLoad;
    private JList<String> inventory;
    private DefaultListModel<String> model = new DefaultListModel<>();
    private Grafika drawArea;
    public MainGUI() {
        super("Aszteroida Banyaszat");


        createMenu();
        setMenuListeners();
        createTelepesToolbar();

        inventory = new JList<>( model);
        jspInventory.add(inventory);
        jspInventory.revalidate();

        readerInstance.loadPalyaFromFile("inputs" + File.separator + "default.txt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pMain);
        this.pack();

        drawArea = new Grafika(pGraphics.getWidth(), pGraphics.getHeight(), Palya.aszteroidak.size());
        drawArea.Update(Palya.aszteroidak);

        pGraphics.add(drawArea);
        pGraphics.revalidate();
        this.setMinimumSize(new Dimension(800, 600));


        resetUI();

    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    private void resetUI() {
        if (!isStarted) {
            lTelepes.setText("Telepes: -" + "  Kor: -");
            bTetlen.setEnabled(false);
            bFur.setEnabled(false);
            bBanyaszik.setEnabled(false);
            cboxLerak.setEnabled(false);
            cboxMozog.setEnabled(false);
            cboxEpit.setEnabled(false);
        } else {
            bTetlen.setEnabled(true);
            bFur.setEnabled(true);
            bBanyaszik.setEnabled(true);
            cboxLerak.setEnabled(true);
            cboxMozog.setEnabled(true);
            cboxEpit.setEnabled(true);
        }
        cboxMozog.setSelectedIndex(-1);
        cboxEpit.setSelectedIndex(-1);
        cboxLerak.setSelectedIndex(-1);
    }

    private void createTelepesToolbar() {
        resetUI();
        bFur.addActionListener(e -> {
            curr.Fur();
            curr = (Telepes) Palya.NextTelepes();
            changeTelepes(curr);
        });
        bBanyaszik.addActionListener(e -> {
            curr.Banyasz();
            curr = (Telepes) Palya.NextTelepes();
            changeTelepes(curr);
        });
        bTetlen.addActionListener(e -> {
            curr = (Telepes) Palya.NextTelepes();
            changeTelepes(curr);
        });
        cboxMozog.addItemListener(arg0 -> {
            if (arg0.getStateChange() == ItemEvent.SELECTED) {
                //System.out.print(curr.toString());
                curr.Mozog((Mezo) NamesMap.get((String) cboxMozog.getSelectedItem()));
                cboxMozog.setSelectedIndex(-1);
                //System.out.println();
                //System.out.print(curr.toString());
                curr = (Telepes) Palya.NextTelepes();
                changeTelepes(curr);
            }
        });

        cboxEpit.insertItemAt("Teleportkapu", cboxEpit.getItemCount());
        cboxEpit.insertItemAt("Robot", cboxEpit.getItemCount());
        cboxEpit.addItemListener(arg0 -> {
            if (arg0.getStateChange() == ItemEvent.SELECTED) {
                if (Objects.equals(cboxEpit.getSelectedItem(), "Teleportkapu")) {
                    curr.TeleportEpit(new TeleportEpito());
                } else curr.RobotEpit(new RobotEpito());
                curr = (Telepes) Palya.NextTelepes();
                changeTelepes(curr);
            }
        });

        cboxLerak.addItemListener(arg0 -> {
            if (arg0.getStateChange() == ItemEvent.SELECTED) {
                Object a = NamesMap.get(cboxLerak.getSelectedItem());
                if (a.getClass().getSuperclass().equals(Nyersanyag.class)) {
                    curr.AnyagVisszatesz((Nyersanyag) a);
                } else curr.KapuLerak((Teleportkapu) a);
                curr = (Telepes) Palya.NextTelepes();
                changeTelepes(curr);
            }
        });
    }

    private void createMenu() {
        menuBar = new JMenuBar();
        mFile = new JMenu("File");
        mItemStart = new JMenuItem("Start");
        mItemLoad = new JMenuItem("Load");
        mFile.add(mItemStart);
        mFile.add(mItemLoad);
        menuBar.add(mFile);
        this.setJMenuBar(menuBar);
    }

    private void setMenuListeners() {
        mItemStart.addActionListener(e -> {
            mItemStart.setEnabled(false);
            Palya.state = 0;
            isStarted = true;
            drawArea.Update(Palya.aszteroidak);
            curr = (Telepes) Palya.NextTelepes();
            changeTelepes(curr);

        });
        mItemLoad.addActionListener(e -> {
            mItemStart.setEnabled(true);
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                Palya.Reset();
                NamesMap.clear();
                File selectedFile = fileChooser.getSelectedFile();
                readerInstance.loadPalyaFromFile(selectedFile.getAbsolutePath());
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());

                resetUI();
            }
        });
    }

    public void changeTelepes(Leptetheto uj) {
        drawArea.Update(Palya.aszteroidak);
        if(uj == null){
            //System.out.println("////////////////////////JATEK VEGE//////////////////////////");
            isStarted = false;
            resetUI();
            if(Palya.state == 1){
                JOptionPane.showMessageDialog(this, "Jatek vege - gyozelem");
            }else if(Palya.state == 2) JOptionPane.showMessageDialog(this, "Jatek vege - veszteseg");

            return;
        }

        resetUI();
        lTelepes.setText("Telepes: " + MainGUI.getKeyByValue(NamesMap, uj) + "  Kor: " + Palya.kor);

        //Mozog menu feltoltese
        cboxMozog.removeAllItems();
        for (Mezo t : ((Telepes) uj).aszteroida.getSzomszedok()) { //TODO itt az aszteroidanak lehet nem kene public-nak lennie tippre
            cboxMozog.insertItemAt(MainGUI.getKeyByValue(NamesMap, t), cboxMozog.getItemCount());
        }

        //Lerak menu feltoltese
        cboxLerak.removeAllItems();
        for (Szallithato t : ((Telepes) uj).getRakterek()) {
            cboxLerak.insertItemAt(MainGUI.getKeyByValue(NamesMap, t), cboxLerak.getItemCount());
        }

        //Rakter megjelitese
        model.clear();
        for (Szallithato t : ((Telepes) uj).getRakterek()) {
            if("Uran".equals(t.getClass().getSimpleName())){
                model.addElement(MainGUI.getKeyByValue(NamesMap, t) + " - Exp:" + ((Uran)t).expozicio);
            }else model.addElement(MainGUI.getKeyByValue(NamesMap, t));
        }

    }


}
