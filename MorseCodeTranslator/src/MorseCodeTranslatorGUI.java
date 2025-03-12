import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MorseCodeTranslatorGUI extends JFrame implements KeyListener {

    private MorseCodeController morseCodeController;
    private JTextArea textInputArea, morseCodeArea;

    public MorseCodeTranslatorGUI(){
        super("Morse Code Translator");

        setSize(new Dimension(540,660));
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#264653"));
        setLocationRelativeTo(null);

        morseCodeController = new MorseCodeController();

        addGuiComponents();
    }

    private void addGuiComponents() {

        JLabel titleLabel = new JLabel("Morse Code Translator");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0,0,540,100);

        JLabel textInputLabel = new JLabel("Text");
        textInputLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        textInputLabel.setForeground(Color.WHITE);
        textInputLabel.setBounds(20,100,200,30);

        textInputArea = new JTextArea();
        textInputArea.setFont(new Font("Dialog", Font.PLAIN, 18));
        textInputArea.addKeyListener(this);
        textInputArea.setBorder(BorderFactory.createEmptyBorder(10,10,10, 10));
        textInputArea.setLineWrap(true);
        textInputArea.setWrapStyleWord(true);
        JScrollPane textInputScroll = new JScrollPane(textInputArea);
        textInputScroll.setBounds(20, 132, 484, 230);

        JLabel morseCodeInputLabel = new JLabel("More Code");
        morseCodeInputLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        morseCodeInputLabel.setForeground(Color.WHITE);
        morseCodeInputLabel.setBounds(20,300,200,30);

        morseCodeArea = new JTextArea();
        morseCodeArea.setFont(new Font("Dialog", Font.PLAIN, 18));
        morseCodeArea.setBorder(BorderFactory.createEmptyBorder(10,10,10, 10));
        morseCodeArea.setEditable(false);
        morseCodeArea.setLineWrap(true);
        morseCodeArea.setWrapStyleWord(true);
        JScrollPane morseCodeScroll = new JScrollPane(morseCodeArea);
        morseCodeScroll.setBounds(20, 380, 484, 230);

        JButton playSoundButton = new JButton("PLay Sound");
        playSoundButton.setBounds(210,590,130, 30);
        playSoundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSoundButton.setEnabled(false);

                Thread playMorseCodeThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // attempt to play the morse sound
                        try {
                            String[] morseCodeMessage = morseCodeArea.getText().split(" ");
                            morseCodeController.playSound(morseCodeMessage);
                        } catch(LineUnavailableException lineUnavailableException) {
                            lineUnavailableException.printStackTrace();
                        } catch(InterruptedException interruptedException){
                            interruptedException.printStackTrace();
                        } finally {
                            //enable to play sound button
                            playSoundButton.setEnabled(true);
                        }
                    }
                });
                playMorseCodeThread.start();
            }
        });

        add(titleLabel);
        add(textInputLabel);
        add(textInputScroll);
        add(morseCodeInputLabel);
        add(morseCodeScroll);
        add(playSoundButton);


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // ingore shift key press
        if(e.getKeyCode() != KeyEvent.VK_SHIFT) {
            // retrieve text input
            String inputText = textInputArea.getText();

            morseCodeArea.setText(morseCodeController.translateToMorse(inputText));
        }

    }
}
