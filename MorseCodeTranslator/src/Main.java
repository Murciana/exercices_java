import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // invoke later insures the GUI is created and updated in a thread-safe manner
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MorseCodeTranslatorGUI().setVisible(true);
            }
        });
    }
}