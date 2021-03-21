package Skeleton;

public class MenuItem {
    public String name;
    public Runnable toCall;

    public MenuItem(String n, Runnable t) {
        name = n;
        toCall = t;
    }
}
