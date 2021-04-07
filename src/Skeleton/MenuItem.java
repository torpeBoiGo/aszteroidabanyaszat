package Skeleton;

/**
 * A menu egy elemet irja le
 */
public class MenuItem {
    public String name;
    public Runnable toCall;

    public MenuItem(String n, Runnable t) {
        name = n;
        toCall = t;
    }
}
