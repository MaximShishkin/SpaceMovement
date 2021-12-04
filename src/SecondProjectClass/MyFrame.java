package SecondProjectClass;
//библиотеки
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MyFrame {
	// конструктор класса
	public MyFrame() {
		// создание окна и добавление имени
		JFrame window = new JFrame("Моя первая игра!");
		// установим размеры
		window.setBounds(10, 10, 1300, 700);
		// запретить изменять размер окна
		window.setResizable(false);
		//создание изображения
		Image icon = null;
		try {
			icon = ImageIO.read(MyPanel.class.getResource("/SecondProjectClass/m2.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//установка иконки
		window.setIconImage(icon);

		// создаём панель
		MyPanel mypanel = new MyPanel();
		// создаём и добавляем панель к окну
		window.add(mypanel);
					
		// установим видимость
		window.setVisible(true);
		// закрытие программы
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
