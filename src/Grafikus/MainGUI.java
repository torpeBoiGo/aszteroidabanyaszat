package Grafikus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A grafikus megjelenitesert felelos osztaly.
 * Itt találhatók a menupontok, a kirajzolt palya,
 * a telepes altal az adott korben elvegezheto lepesek, a telepes rakterenek tartalma.
 * A megfelelo menuelemet kivalasztva, vagy megfelelo gombot lenyomva megtortenik az elvart akcio
 */
public class MainGUI extends JFrame {
    /**
     * A letrejott objektumok neveit tarolo map
     */
    static HashMap<String, Object> NamesMap = new HashMap<>();
    /**
     * A soron levo telepes
     */
    static Telepes curr;
    /**
     * Reader a beolvasahoz
     */
    Reader readerInstance = new Reader();
    /**
     * Tarolja, hogy elkezdodott-e mar a jatek
     */
    boolean isStarted = false;

    /**
     * A fo JPanel
     */
    private JPanel pMain;
    /**
     * A furast indito gomb
     */
    private JButton bFur;
    /**
     * A banyaszast indito gomb
     */
    private JButton bBanyaszik;
    /**
     * A lehetseges szomszedos mezoket tartalmazó lista, itt lehet kivalasztani, hogy hova mozogjon a telepes.
     */
    private JComboBox<String> cboxMozog;
    /**
     * Az epitheto dolgok (teleportkapu, robot) kozul valaszthatunk, elinditja az epitest
     */
    private JComboBox<String> cboxEpit;
    /**
     * A rakterben levo nyersanyagok és teleportkapukat jeleníti meg, kivalasztasukkal megindul a lerakas muvelete
     */
    private JComboBox<String> cboxLerak;
    /**
     * Label a telepesfeliratnak
     */
    private JLabel lTelepes;
    /**
     * A tetlenseget vegrehajto gomb
     */
    private JButton bTetlen;
    /**
     * Label a mozgas feliratnak
     */
    private JLabel lMozog;
    /**
     * Label az epit feliratnak
     */
    private JLabel lEpit;
    /**
     * Label a lerak feliratnak
     */
    private JLabel lLerak;
    /**
     * Egy JPanel
     */
    private JPanel pTop;
    /**
     * Egy JPanel, ahol a palya rajzolas tortenik
     */
    private JPanel pGraphics;
    /**
     * Egy JPanel, a rakter kirajzolasahoz
     */
    private JPanel jspInventory;
    /**
     * A menubar a kepernyo tetejen
     */
    private JMenuBar menuBar;
    /**
     * Menu File felirattal
     */
    private JMenu mFile;
    /**
     * Elinditja a jatekot, az mFile menu alatt talalhato
     */
    private JMenuItem mItemStart;
    /**
     * Betolt egy inicializalo fajlt, az mFile menu alatt talalhato
     */
    private JMenuItem mItemLoad;
    /**
     * Lista a telepes rakterenek nyilvantartasara
     */
    private JList<String> inventory;
    /**
     * A rakteret megjeleníto lista adatmodellje
     */
    private DefaultListModel<String> model = new DefaultListModel<>();
    /**
     * A palyahoz tartozo grafika
     */
    private Grafika drawArea;

    /**
     * konstruktor, letrehozza az ablakot, elhelyezi a komponenseket, kirajzolja a palyat
     */
    public MainGUI() {
        super("Aszteroida Banyaszat");

        //Menu letrehozasa
        createMenu();
        setMenuListeners();
        createTelepesToolbar();

        //Rakter letrehozasa
        inventory = new JList<>(model);
        jspInventory.add(inventory);
        jspInventory.revalidate();

        //Palya betoltese
        readerInstance.loadPalyaFromFile("inputs" + File.separator + "default.txt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pMain);
        this.pack();

        //Palya kirajzolasa
        drawArea = new Grafika(pGraphics.getWidth(), pGraphics.getHeight(), Palya.aszteroidak.size());
        drawArea.Update(Palya.aszteroidak);

        pGraphics.add(drawArea);
        pGraphics.revalidate();
        this.setMinimumSize(new Dimension(800, 600));


        resetUI();

    }

    /**
     * Visszaadja a keresett elem kulcsát
     *
     * @param map   a hashmap, amiben keresi a kulcsot
     * @param value az elem, aminek keresi a kulcsat
     * @return az elemhez tartozo kulcs
     */
    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Alaphelyzetbe allitja a JComboBoxok kivalasztott elemet,
     * ha el van inditva a jatek, akkor a setEnabled(true) metodussal beallitja a gombokat és ComboBoxokat,
     * ha nincs elinditva, akkor setEnabled(false) metodust hiv
     */
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

    /**
     * Hozzaadja a gombokhoz egy-egy ActionListenert, amikkel vegrehajtjak az adott feladatot,
     * valamint feltolti a ComboBoxokat a megfelelo elemekkel.
     * A muvelet vegrehajtasa utan levaltja a jelenlegi telepest, mivel az mar lepett
     */
    private void createTelepesToolbar() {
        resetUI();
        //Furas
        bFur.addActionListener(e -> {
            curr.Fur();
            curr = (Telepes) Palya.NextTelepes();
            changeTelepes(curr);
        });
        //Banyaszas
        bBanyaszik.addActionListener(e -> {
            curr.Banyasz();
            curr = (Telepes) Palya.NextTelepes();
            changeTelepes(curr);
        });
        //Tetlen
        bTetlen.addActionListener(e -> {
            curr = (Telepes) Palya.NextTelepes();
            changeTelepes(curr);
        });

        //Mozgas
        cboxMozog.addItemListener(arg0 -> {
            if (arg0.getStateChange() == ItemEvent.SELECTED) {
                curr.Mozog((Mezo) NamesMap.get((String) cboxMozog.getSelectedItem()));
                cboxMozog.setSelectedIndex(-1);
                curr = (Telepes) Palya.NextTelepes();
                changeTelepes(curr);
            }
        });

        //Epites
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

        //Lerakas
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

    /**
     * Letrehozza a MenuBart, elhelyezi rajta a Start, Load menelemeket, valamint a File menut.
     */
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

    /**
     * Beallitja a menuItemek ActionListenerjeit, hogy azok rendeltetrsszeruen mukodjenek
     */
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

    /**
     * A kovetkezo telepesre valjta le a jelenlegi telepest.
     *
     * @param uj a kovetkezo telepes
     */
    public void changeTelepes(Leptetheto uj) {
        //Palya frissitese
        drawArea.Update(Palya.aszteroidak);

        //Jatek vege
        if (uj == null) {
            isStarted = false;
            resetUI();
            if (Palya.state == 1) {
                JOptionPane.showMessageDialog(this, "Jatek vege - gyozelem");
            } else if (Palya.state == 2) JOptionPane.showMessageDialog(this, "Jatek vege - veszteseg");

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
            if ("Uran".equals(t.getClass().getSimpleName())) {
                model.addElement(MainGUI.getKeyByValue(NamesMap, t) + " - Exp:" + ((Uran) t).expozicio);
            } else model.addElement(MainGUI.getKeyByValue(NamesMap, t));
        }

    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        pMain = new JPanel();
        pMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        pMain.setEnabled(true);
        final JSplitPane splitPane1 = new JSplitPane();
        splitPane1.setDividerLocation(34);
        splitPane1.setDividerSize(0);
        splitPane1.setOrientation(0);
        pMain.add(splitPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        pTop = new JPanel();
        pTop.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 6, new Insets(0, 0, 0, 0), 0, -1));
        pTop.setBackground(new Color(-1));
        splitPane1.setLeftComponent(pTop);
        cboxEpit = new JComboBox();
        pTop.add(cboxEpit, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(78, 30), null, 0, false));
        cboxLerak = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        cboxLerak.setModel(defaultComboBoxModel1);
        pTop.add(cboxLerak, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(78, 30), null, 0, false));
        lTelepes = new JLabel();
        lTelepes.setText("Telepes: ");
        pTop.add(lTelepes, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(150, 30), new Dimension(150, 30), null, 0, false));
        final JToolBar toolBar1 = new JToolBar();
        pTop.add(toolBar1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 20), null, 0, false));
        bTetlen = new JButton();
        bTetlen.setText("Tetlen");
        toolBar1.add(bTetlen);
        bFur = new JButton();
        bFur.setText("Fur");
        toolBar1.add(bFur);
        bBanyaszik = new JButton();
        bBanyaszik.setText("Banyaszik");
        toolBar1.add(bBanyaszik);
        lMozog = new JLabel();
        lMozog.setText("Mozog:");
        toolBar1.add(lMozog);
        cboxMozog = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        cboxMozog.setModel(defaultComboBoxModel2);
        cboxMozog.setToolTipText("Mozog");
        toolBar1.add(cboxMozog);
        lEpit = new JLabel();
        lEpit.setText("Epit: ");
        pTop.add(lEpit, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lLerak = new JLabel();
        lLerak.setText("Lerak:");
        pTop.add(lLerak, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JSplitPane splitPane2 = new JSplitPane();
        splitPane2.setContinuousLayout(true);
        splitPane2.setDividerLocation(588);
        splitPane1.setRightComponent(splitPane2);
        pGraphics = new JPanel();
        pGraphics.setLayout(new BorderLayout(0, 0));
        splitPane2.setLeftComponent(pGraphics);
        jspInventory = new JPanel();
        jspInventory.setLayout(new BorderLayout(0, 0));
        splitPane2.setRightComponent(jspInventory);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pMain;
    }
}
