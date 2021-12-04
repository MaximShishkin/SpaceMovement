package SecondProjectClass;
//библиотеки
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

public class MyPanel extends JPanel {
	// переменные для 1 игрока
	// глобальные переменные координат
	int x = 50, y = 50;
	// глобальная переменная для направления
	int napravlenie = 4;
	// скорость первого игрока
	int speed = 1;
	// счёт первого игрока
	int schet = 0;
	int allschet = 0;
	int winnerschet = 0;
	
	// переменные для второго игрока
	// глобальные переменные для второго игрока
	int x2 = 1080, y2 = 460;
	// глобальная переменная для направления для второго игрока
	int napravlenie2 = 8;
	// скорость первого игрока
    int speed2 = 1;
    // счёт втрого игрока
 	int schet2 = 0;
 	int allschet2 = 0;
 	int winnerschet2 = 0;
 	
    // глобальные переменные для метеора
    int xmeteor = 650, ymeteor = 350;
	int imagemeteor = 0;
    
	// глобальные переменные для хранения картинок
	Image fon;
	Image planeta;
	Image meteor [] = new Image [5];
	// глобальные переменные с таймерами для игроков
	Timer timer, timer2; 
	// конец игры
	// если gameover = 1, то проиграл 1 игрок
	// если gameover = 2, то проиграл 2 игрок
	int gameover = 3;
	
	
	// класс для взаимодействия с клавиатурой
	private class MyKey implements KeyListener{
		// метод, который срабатывает при нажатии на клавишу клавиатуры
		public void keyPressed(KeyEvent e) {
			// беру код нажатой клавиши
			int keyPress = e.getKeyCode();
			System.out.println(keyPress);
			//===========================
			// клавиши для управления первым игроком
			// клавиша w
			if (keyPress == 87) {
				napravlenie = 1;
			}
			// клавиша e
			if (keyPress == 69) {
				napravlenie = 2;
			}
			// клавиша d
			if (keyPress == 68) {
				napravlenie = 3;
			}
			// клавиша c
			if (keyPress == 67) {
				napravlenie = 4;
			}
			// клавиша s
			if (keyPress == 83) {
				napravlenie = 5;
			}
			// клавиша z
			if (keyPress == 90) {
				napravlenie = 6;
			}
			// клавиша a
			if (keyPress == 65) {
				napravlenie = 7;
			}
			// клавиша q
			if (keyPress == 81) {
				napravlenie = 8;
			}
			//===========================
			// клавиши для управления вторым игроком
			// клавиша на клавиатуре с символом 8
			if (keyPress == 104) {
				napravlenie2 = 1;
			}
			// клавиша на клавиатуре с символом 9
			if (keyPress == 105) {
				napravlenie2 = 2;
			}
			// клавиша на клавиатуре с символом 6
			if (keyPress == 102) {
				napravlenie2 = 3;
			}
			// клавиша на клавиатуре с символом 3
			if (keyPress == 99) {
				napravlenie2 = 4;
			}
			// клавиша на клавиатуре с символом 2
			if (keyPress == 98) {
				napravlenie2 = 5;
			}
			// клавиша на клавиатуре с символом 1
			if (keyPress == 97) {
				napravlenie2 = 6;
			}
			// клавиша на клавиатуре с символом 4
			if (keyPress == 100) {
				napravlenie2 = 7;
			}
			// клавиша на клавиатуре с символом 7
			if (keyPress == 103) {
				napravlenie2 = 8;
			}
			//===================================
			// запуск, перезапуск игры
			if (keyPress == 10 && gameover > 0)
			{
				// останавливаем таймеры
				timer.stop();
				timer2.stop();
				
				// переназначаем переменные направлений
				napravlenie = 4;
				napravlenie2 = 8;
				
				// переназначаем переменные координат
				x = 50; 
				y = 50;
				speed = 1;
				schet = 0;
				
				x2 = 1080; 
				y2 = 460;
				speed2 = 1;
				schet2 = 0;
			
				gameover = 0;
				
				// переназначаем переменные meteora
				Random rnd = new Random();
				xmeteor = 200 + rnd.nextInt(850);
				ymeteor = 200 + rnd.nextInt(250);
				imagemeteor = rnd.nextInt(4);
				
				// запускаем таймеры
				timer.start();
				timer2.start();
			}
			// выход из игры
			if (keyPress == 27 && gameover > 0)
			{
				System.exit(0);
			}
		}
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
	}
	
	// конструктор класса
	public MyPanel() {
		// подключаем обработчик событий для клавиатуры
		addKeyListener(new MyKey());
		setFocusable(true);
		
		//====================================================
		// таймер и управление для первого игрока
		// создаём таймер
		timer = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// при касании правой грани
				if (x > 1135) {
					if (napravlenie == 3) napravlenie = 7;
					if (napravlenie == 4) napravlenie = 6;
					if (napravlenie == 2) napravlenie = 8;
					// первый игрок проигрывает
					gameover = 1;
				}
				// при касании левой грани
				if (x < 0) {
					if (napravlenie == 7) napravlenie = 3;  
					if (napravlenie == 6) napravlenie = 4;
					if (napravlenie == 8) napravlenie = 2;
				}
				// при касании верхней грани
				if (y < 0) {
					if (napravlenie == 1) napravlenie = 5;
					if (napravlenie == 2) napravlenie = 4;
					if (napravlenie == 8) napravlenie = 6;
				}
				// при касания нижней грани
				if (y > 510) {
					if (napravlenie == 5) napravlenie = 1;
					if (napravlenie == 4) napravlenie = 2;
					if (napravlenie == 6) napravlenie = 8;
					// первый игрок проигрывает
					gameover = 1;
				}
				// направление 1
				if(napravlenie == 1)
				{
					y = y - speed;
				}
				// направление 2
				if(napravlenie == 2)
				{
					x = x + speed; 
					y = y - speed;
				}
				// направление 3
				if(napravlenie == 3)
				{
					x = x + speed;  
				}
				// направление 4
				if(napravlenie == 4)
				{
					x = x + speed; 
					y = y + speed; 
				}
				// направление 5
				if(napravlenie == 5)
				{
					y = y + speed; 
				}
				// направление 6
				if(napravlenie == 6)
				{
					x = x - speed; 
					y = y + speed; 
				}
				// направление 7
				if(napravlenie == 7)
				{
					x = x - speed; 
				}
				// направление 8
				if(napravlenie == 8)
				{
					x = x - speed; 
					y = y - speed;
				}
				// переотрисовываем панель
				repaint();
		}});
		//====================================================
		
		//====================================================
		// таймер и управление для второго игрока
		// создаём таймер
		timer2 = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// при касании правой грани
				if (x2 > 1135) {
					if (napravlenie2 == 3) napravlenie2 = 7;
					if (napravlenie2 == 4) napravlenie2 = 6;
					if (napravlenie2 == 2) napravlenie2 = 8;
				}
				// при касании левой грани
				if (x2 < 0) {
					if (napravlenie2 == 7) napravlenie2 = 3;  
					if (napravlenie2 == 6) napravlenie2 = 4;
					if (napravlenie2 == 8) napravlenie2 = 2;
					// второй игрок проигрывает
					gameover = 2;
				}
				// при касании верхней грани
				if (y2 < 0) {
					if (napravlenie2 == 1) napravlenie2 = 5;
					if (napravlenie2 == 2) napravlenie2 = 4;
					if (napravlenie2 == 8) napravlenie2 = 6;
					// второй игрок проигрывает
					gameover = 2;
				}
				// при касания нижней грани
				if (y2 > 510) {
					if (napravlenie2 == 5) napravlenie2 = 1;
					if (napravlenie2 == 4) napravlenie2 = 2;
					if (napravlenie2 == 6) napravlenie2 = 8;	
				}
				// направление 1
				if(napravlenie2 == 1)
				{
					y2 = y2 - speed2;
				}
				// направление 2
				if(napravlenie2 == 2)
				{
					x2 = x2 + speed2; 
					y2 = y2 - speed2;
				}
				// направление 3
				if(napravlenie2 == 3)
				{
					x2 = x2 + speed2; 
				}
				// направление 4
				if(napravlenie2 == 4)
				{
					x2 = x2 + speed2; 
					y2 = y2 + speed2;
				}
				// направление 5
				if(napravlenie2 == 5)
				{
					y2 = y2 + speed2;
				}
				// направление 6
				if(napravlenie2 == 6)
				{
					x2 = x2 - speed2; 
					y2 = y2 + speed2;
				}
				// направление 7
				if(napravlenie2 == 7)
				{
					x2 = x2 - speed2; 
				}
				// направление 8
				if(napravlenie2 == 8)
				{
					x2 = x2 - speed2; 
					y2 = y2 - speed2;
				}
				// переотрисовываем панель
				repaint();
		}});
		//====================================================
		
		// запись картинок в переменные
		try {
			planeta = ImageIO.read(MyPanel.class.getResource("/SecondProjectClass/kartinka.png"));
			fon = ImageIO.read(MyPanel.class.getResource("/SecondProjectClass/fon.jpg"));
			
			// добавляем картинки через цикл
			for(int i = 0; i < 5 ; i++) {
				meteor [i] = ImageIO.read(MyPanel.class.getResource("/SecondProjectClass/m" + i + ".png"));
			}
			/*
			meteor [0] = ImageIO.read(MyPanel.class.getResource("/SecondProjectClass/m0.png"));
			meteor [1] = ImageIO.read(MyPanel.class.getResource("/SecondProjectClass/m1.png"));
			meteor [2] = ImageIO.read(MyPanel.class.getResource("/SecondProjectClass/m2.png"));
			meteor [3] = ImageIO.read(MyPanel.class.getResource("/SecondProjectClass/m3.png"));
			meteor [4] = ImageIO.read(MyPanel.class.getResource("/SecondProjectClass/m4.png"));
			*/	
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
			
	// метод для отрисвки графики
	public void paintComponent(Graphics gr) {
		// очищается панель от старых рисунков
		super.paintComponent(gr);
		
		// добавляем шрифт
		Font font = new Font("Verdana", Font.BOLD, 20);
		gr.setFont(font);
		
		// отрисовываем фон
		gr.drawImage(fon, 0, 0, 1300, 700, null);
		
		// отрисовываем безопасные стороны для игроков
		// для первого игрока
		gr.setColor(Color.RED);
		gr.fillRect(0, 0, 5, 700);
		gr.fillRect(0, 0, 1300, 5);	
		// для второго игрока
		gr.setColor(Color.YELLOW);
		gr.fillRect(1279, 0, 5, 700);
		gr.fillRect(0, 657, 1300, 5);
		
		// отрисовываем метеоры
		gr.drawImage(meteor[imagemeteor], xmeteor, ymeteor, 50, 50, null);
		gr.setColor(Color.ORANGE);
		gr.drawRect(xmeteor, ymeteor, 50, 50);
		
		// отрисовываем первый объект, которым управляем
		gr.drawImage(planeta, x, y, 150, 150, null);
		gr.setColor(Color.RED);
		gr.drawOval(x, y, 150, 150);
	
		// отрисовываем второй объект, которым управляем
		gr.drawImage(planeta, x2, y2, 150, 150, null);
		gr.setColor(Color.YELLOW);
		gr.drawOval(x2, y2, 150, 150);
		
		// отображение победителя
		// первый игрок проиграл, второй выиграл
		if (gameover == 1) {
			gr.setColor(Color.YELLOW);
			gr.drawString("LOSER!", x + 40 , y + 80);
			gr.drawString("WIN!", x2 + 50 , y2 + 80);
			winnerschet2 = winnerschet2 + 1;
		}
		// второй игрок проиграл, первый выиграл
		if (gameover == 2) {
			gr.setColor(Color.RED);
			gr.drawString("LOSER!", x2 + 40 , y2 + 80);
			gr.drawString("WINNER!", x + 40 , y + 80);
			winnerschet = winnerschet + 1;
		}
		
		// отрисовываем инструкцию, когда игра не активна
		if (gameover > 0) {
			gr.setColor(Color.ORANGE);
			gr.drawString("ESC - выход из игры", 15, 620);
			gr.drawString("ENTER - старт/рестарт игры", 15, 645);
			// добавляем шрифт
			Font font1 = new Font("Verdana", Font.BOLD, 200);
			gr.setFont(font1);
			gr.drawString(winnerschet + " : " + winnerschet2, 400,400);
		}
		else {
			// отрисовываем счёт игроков
			gr.setColor(Color.ORANGE);
			gr.drawString("Счёт красного игрока: " + schet + " (" + allschet + ")", 15, 25);
			gr.drawString("Счёт жёлтого игрока: " + schet2 + " (" + allschet2 + ")", 15, 50);
			gr.drawString("Счёт побед красного игрока: " + winnerschet, 900, 25);
			gr.drawString("Счёт побед жёлтого игрока: " + winnerschet2, 900, 50);
		}
		
		// проверки условий игры
		checkgame();
	}
	
	// метод для проверки условий игры
	public void checkgame() {
		// проверка для первого игрока
		if( x - 50 < xmeteor && xmeteor < x + 150 && y - 50 < ymeteor && ymeteor < y + 150) {
			// переназначаем переменные meteora
			Random rnd = new Random();
			xmeteor = 200 + rnd.nextInt(850);
			ymeteor = 200 + rnd.nextInt(250);
			imagemeteor = rnd.nextInt(4);
			// увеличиваем скорость противника
			speed2 = speed2 + 1;  
			schet = schet + 1;
			allschet = allschet + 1;
		}
		
		// проверка для второго игрока
		if( x2 - 50 < xmeteor && xmeteor < x2 + 150 && y2 - 50 < ymeteor && ymeteor < y2 + 150) {
			// переназначаем переменные meteora
			Random rnd = new Random();
			xmeteor = 200 + rnd.nextInt(850);
			ymeteor = 200 + rnd.nextInt(250);
			imagemeteor = rnd.nextInt(4);
			// увеличиваем скорость противника
			speed = speed + 1;
			schet2 = schet2 + 1;
			allschet2 = allschet2 + 1;
		}
		
		// остановка игры
		if (gameover > 0) {
			// останавливаем таймеры
			timer.stop();
			timer2.stop();
		}
	}
}
