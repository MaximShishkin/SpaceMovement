package SecondProjectClass;
//����������
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MyFrame {
	// ����������� ������
	public MyFrame() {
		// �������� ���� � ���������� �����
		JFrame window = new JFrame("��� ������ ����!");
		// ��������� �������
		window.setBounds(10, 10, 1300, 700);
		// ��������� �������� ������ ����
		window.setResizable(false);
		//�������� �����������
		Image icon = null;
		try {
			icon = ImageIO.read(MyPanel.class.getResource("/SecondProjectClass/m2.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//��������� ������
		window.setIconImage(icon);

		// ������ ������
		MyPanel mypanel = new MyPanel();
		// ������ � ��������� ������ � ����
		window.add(mypanel);
					
		// ��������� ���������
		window.setVisible(true);
		// �������� ���������
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
