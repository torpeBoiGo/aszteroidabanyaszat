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
 *  Itt találhatók a menupontok, a kirajzolt palya,
 *  a telepes altal az adott korben elvegezheto lepesek, a telepes rakterenek tartalma.
 *  A megfelelo menuelemet kivalasztva, vagy megfelelo gombot lenyomva megtortenik az elvart akcio
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
        inventory = new JList<>( model);
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
     * @param map a hashmap, amiben keresi a kulcsot
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
     * @param uj a kovetkezo telepes
     */
    public void changeTelepes(Leptetheto uj) {
        //Palya frissitese
        drawArea.Update(Palya.aszteroidak);

        //Jatek vege
        if(uj == null){
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
