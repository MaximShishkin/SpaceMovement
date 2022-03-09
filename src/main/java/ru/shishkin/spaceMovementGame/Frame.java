package ru.shishkin.spaceMovementGame;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Frame {
    public Frame() {
        JFrame window = new JFrame("Space Movement Game");
        window.setBounds(10, 10, 1300, 700);
        window.setResizable(false);

        Image icon = null;
        try {
            icon = ImageIO.read(getClass().getClassLoader().getResource("m2.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        window.setIconImage(icon);

        Panel mypanel = new Panel();
        window.add(mypanel);

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
