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
     * A futtathato hivando dolog
     */
    public Runnable toCall;

    /**
     * A menuItem konstruktora
     * @param n A menü item neve
     * @param t A toCall parameter erteke
     */
    public MenuItem(String n, Runnable t) {
        name = n;
        toCall = t;
    }
}
