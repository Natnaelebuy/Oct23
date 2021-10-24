import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class HelloMusic extends JFrame {

    public JButton play, choose;
    private String file;
    public static HelloMusic instance;

    public HelloMusic() {
        this.setSize(400, 400);
        this.setTitle("Drake - Girls Want Girls.wav");
        this.setComponents();
        this.setListeners();
    }

    public void setComponents() {
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
        pane.setBackground(Color.PINK);
        this.choose = new JButton("choose");
        this.play = new JButton("play");
        pane.add(choose);
        pane.add(play);
    }

    public void setListeners() {
        this.choose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(instance);
                fd.setMode(FileDialog.LOAD);
                fd.setVisible(true);
                String soubor = fd.getDirectory() + fd.getFile();
                if (soubor != null) {
                    file = soubor;
                }
            }
        });

        this.play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Music m = new Music(file);
            }
        });
    }

    public static Frame setup() {
        HelloMusic window = new HelloMusic();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        return window;
    }

    public static void main(String args[]) {
        HelloMusic.setup();
    }
}