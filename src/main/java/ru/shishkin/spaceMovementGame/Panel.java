package ru.shishkin.spaceMovementGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel {
    int x = 50, y = 50;
    int napravlenie = 4;
    int speed = 1;
    int schet = 0;
    int allschet = 0;
    int winnerschet = 0;

    int x2 = 1080, y2 = 460;
    int napravlenie2 = 8;
    int speed2 = 1;
    int schet2 = 0;
    int allschet2 = 0;
    int winnerschet2 = 0;

    int xmeteor = 650, ymeteor = 350;
    int imagemeteor = 0;

    Image fon;
    Image planeta;
    Image meteor[] = new Image[5];
    Timer timer, timer2;
    int gameover = 3;

    private class MyKey implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int keyPress = e.getKeyCode();
            System.out.println(keyPress);
            //===========================
            if (keyPress == 87) {
                napravlenie = 1;
            }
            if (keyPress == 69) {
                napravlenie = 2;
            }
            if (keyPress == 68) {
                napravlenie = 3;
            }
            if (keyPress == 67) {
                napravlenie = 4;
            }
            if (keyPress == 83) {
                napravlenie = 5;
            }
            if (keyPress == 90) {
                napravlenie = 6;
            }
            if (keyPress == 65) {
                napravlenie = 7;
            }
            if (keyPress == 81) {
                napravlenie = 8;
            }
            //===========================
            if (keyPress == 104) {
                napravlenie2 = 1;
            }
            if (keyPress == 105) {
                napravlenie2 = 2;
            }
            if (keyPress == 102) {
                napravlenie2 = 3;
            }
            if (keyPress == 99) {
                napravlenie2 = 4;
            }
            if (keyPress == 98) {
                napravlenie2 = 5;
            }
            if (keyPress == 97) {
                napravlenie2 = 6;
            }
            if (keyPress == 100) {
                napravlenie2 = 7;
            }
            if (keyPress == 103) {
                napravlenie2 = 8;
            }
            //===================================
            if (keyPress == 10 && gameover > 0) {
                timer.stop();
                timer2.stop();

                napravlenie = 4;
                napravlenie2 = 8;

                x = 50;
                y = 50;
                speed = 1;
                schet = 0;

                x2 = 1080;
                y2 = 460;
                speed2 = 1;
                schet2 = 0;

                gameover = 0;

                Random rnd = new Random();
                xmeteor = 200 + rnd.nextInt(850);
                ymeteor = 200 + rnd.nextInt(250);
                imagemeteor = rnd.nextInt(4);

                timer.start();
                timer2.start();
            }
            if (keyPress == 27 && gameover > 0) {
                System.exit(0);
            }
        }

        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
    }

    public Panel() {
        addKeyListener(new MyKey());
        setFocusable(true);

        //====================================================
        timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (x > 1135) {
                    if (napravlenie == 3) napravlenie = 7;
                    if (napravlenie == 4) napravlenie = 6;
                    if (napravlenie == 2) napravlenie = 8;
                    gameover = 1;
                }
                if (x < 0) {
                    if (napravlenie == 7) napravlenie = 3;
                    if (napravlenie == 6) napravlenie = 4;
                    if (napravlenie == 8) napravlenie = 2;
                }
                if (y < 0) {
                    if (napravlenie == 1) napravlenie = 5;
                    if (napravlenie == 2) napravlenie = 4;
                    if (napravlenie == 8) napravlenie = 6;
                }
                if (y > 510) {
                    if (napravlenie == 5) napravlenie = 1;
                    if (napravlenie == 4) napravlenie = 2;
                    if (napravlenie == 6) napravlenie = 8;
                    gameover = 1;
                }
                if (napravlenie == 1) {
                    y = y - speed;
                }
                if (napravlenie == 2) {
                    x = x + speed;
                    y = y - speed;
                }
                if (napravlenie == 3) {
                    x = x + speed;
                }
                if (napravlenie == 4) {
                    x = x + speed;
                    y = y + speed;
                }
                if (napravlenie == 5) {
                    y = y + speed;
                }
                if (napravlenie == 6) {
                    x = x - speed;
                    y = y + speed;
                }
                if (napravlenie == 7) {
                    x = x - speed;
                }
                if (napravlenie == 8) {
                    x = x - speed;
                    y = y - speed;
                }
                repaint();
            }
        });
        //====================================================
        //====================================================
        timer2 = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (x2 > 1135) {
                    if (napravlenie2 == 3) napravlenie2 = 7;
                    if (napravlenie2 == 4) napravlenie2 = 6;
                    if (napravlenie2 == 2) napravlenie2 = 8;
                }
                if (x2 < 0) {
                    if (napravlenie2 == 7) napravlenie2 = 3;
                    if (napravlenie2 == 6) napravlenie2 = 4;
                    if (napravlenie2 == 8) napravlenie2 = 2;
                    gameover = 2;
                }
                if (y2 < 0) {
                    if (napravlenie2 == 1) napravlenie2 = 5;
                    if (napravlenie2 == 2) napravlenie2 = 4;
                    if (napravlenie2 == 8) napravlenie2 = 6;
                    gameover = 2;
                }
                if (y2 > 510) {
                    if (napravlenie2 == 5) napravlenie2 = 1;
                    if (napravlenie2 == 4) napravlenie2 = 2;
                    if (napravlenie2 == 6) napravlenie2 = 8;
                }
                if (napravlenie2 == 1) {
                    y2 = y2 - speed2;
                }
                if (napravlenie2 == 2) {
                    x2 = x2 + speed2;
                    y2 = y2 - speed2;
                }
                if (napravlenie2 == 3) {
                    x2 = x2 + speed2;
                }
                if (napravlenie2 == 4) {
                    x2 = x2 + speed2;
                    y2 = y2 + speed2;
                }
                if (napravlenie2 == 5) {
                    y2 = y2 + speed2;
                }
                if (napravlenie2 == 6) {
                    x2 = x2 - speed2;
                    y2 = y2 + speed2;
                }
                if (napravlenie2 == 7) {
                    x2 = x2 - speed2;
                }
                if (napravlenie2 == 8) {
                    x2 = x2 - speed2;
                    y2 = y2 - speed2;
                }
                repaint();
            }
        });

        //====================================================
        try {
            planeta = ImageIO.read(getClass().getClassLoader().getResource("kartinka.png"));
            fon = ImageIO.read(getClass().getClassLoader().getResource("fon.jpg"));

            for (int i = 0; i < 5; i++) {
                meteor[i] = ImageIO.read(getClass().getClassLoader().getResource("m" + i + ".png"));
            }
			/*
			meteor [0] = ImageIO.read(MyPanel.class.getResource("/ru.shishkin.SecondProjectClass/m0.png"));
			meteor [1] = ImageIO.read(MyPanel.class.getResource("/ru.shishkin.SecondProjectClass/m1.png"));
			meteor [2] = ImageIO.read(MyPanel.class.getResource("/ru.shishkin.SecondProjectClass/m2.png"));
			meteor [3] = ImageIO.read(MyPanel.class.getResource("/ru.shishkin.SecondProjectClass/m3.png"));
			meteor [4] = ImageIO.read(MyPanel.class.getResource("/ru.shishkin.SecondProjectClass/m4.png"));
			*/
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);

        Font font = new Font("Verdana", Font.BOLD, 20);
        gr.setFont(font);

        gr.drawImage(fon, 0, 0, 1300, 700, null);

        gr.setColor(Color.RED);
        gr.fillRect(0, 0, 5, 700);
        gr.fillRect(0, 0, 1300, 5);

        gr.setColor(Color.YELLOW);
        gr.fillRect(1279, 0, 5, 700);
        gr.fillRect(0, 657, 1300, 5);

        gr.drawImage(meteor[imagemeteor], xmeteor, ymeteor, 50, 50, null);
        gr.setColor(Color.ORANGE);
        gr.drawRect(xmeteor, ymeteor, 50, 50);

        gr.drawImage(planeta, x, y, 150, 150, null);
        gr.setColor(Color.RED);
        gr.drawOval(x, y, 150, 150);

        gr.drawImage(planeta, x2, y2, 150, 150, null);
        gr.setColor(Color.YELLOW);
        gr.drawOval(x2, y2, 150, 150);

        if (gameover == 1) {
            gr.setColor(Color.YELLOW);
            gr.drawString("LOSER!", x + 40, y + 80);
            gr.drawString("WIN!", x2 + 50, y2 + 80);
            winnerschet2 = winnerschet2 + 1;
        }
        if (gameover == 2) {
            gr.setColor(Color.RED);
            gr.drawString("LOSER!", x2 + 40, y2 + 80);
            gr.drawString("WINNER!", x + 40, y + 80);
            winnerschet = winnerschet + 1;
        }
        if (gameover > 0) {
            gr.setColor(Color.ORANGE);
            gr.drawString("ESC - EXIT", 15, 620);
            gr.drawString("ENTER - START/RESTART", 15, 645);

            Font font1 = new Font("Verdana", Font.BOLD, 200);
            gr.setFont(font1);
            gr.drawString(winnerschet + " : " + winnerschet2, 400, 400);
        } else {

            gr.setColor(Color.ORANGE);
            gr.drawString("1 player score: " + schet + " (" + allschet + ")", 15, 25);
            gr.drawString("2 player score: " + schet2 + " (" + allschet2 + ")", 15, 50);
            gr.drawString("1 player win score: " + winnerschet, 900, 25);
            gr.drawString("2 player win score: " + winnerschet2, 900, 50);
        }

        checkgame();
    }

    public void checkgame() {
        if (x - 50 < xmeteor && xmeteor < x + 150 && y - 50 < ymeteor && ymeteor < y + 150) {
            Random rnd = new Random();
            xmeteor = 200 + rnd.nextInt(850);
            ymeteor = 200 + rnd.nextInt(250);
            imagemeteor = rnd.nextInt(4);

            speed2 = speed2 + 1;
            schet = schet + 1;
            allschet = allschet + 1;
        }

        if (x2 - 50 < xmeteor && xmeteor < x2 + 150 && y2 - 50 < ymeteor && ymeteor < y2 + 150) {
            Random rnd = new Random();
            xmeteor = 200 + rnd.nextInt(850);
            ymeteor = 200 + rnd.nextInt(250);
            imagemeteor = rnd.nextInt(4);

            speed = speed + 1;
            schet2 = schet2 + 1;
            allschet2 = allschet2 + 1;
        }

        if (gameover > 0) {
            timer.stop();
            timer2.stop();
        }
    }
}
