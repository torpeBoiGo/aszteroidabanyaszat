
package Grafikus;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {

        Jatek jatek = new Jatek();
		JFrame form = new MainGUI(jatek);
		form.setVisible(true);
        jatek.Indit();

	}
}

