package app;

import javax.swing.SwingUtilities;

import view.TelaClient;

public class Main {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaClient tela = new TelaClient();
                tela.setVisible(true);
            }
        });
    }
}
