package Grafikus;

/**
 * A menu egy elemet irja le
 */
public class MenuItem {
    /**
     * A menü item neve
     */
    public String name;
    /**
     * ?????? TODO
     */
    public Runnable toCall; //TODO ezt kommentezni

    /**
     * A menuItem konstruktora
     * @param n A menü item neve
     * @param t ??????? //TODO
     */
    public MenuItem(String n, Runnable t) {
        name = n;
        toCall = t;
    }
}
