package guiTest;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GuiTest extends JFrame {
	public GuiTest() {
		super("버튼 테스트");
		JButton btn = new JButton("나 눌러줘!");

		setSize(500, 700);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (d.width - this.getWidth()) / 2;
		int y = (d.height - this.getHeight()) / 2;

		setLocation(x, y);
		setLayout(new FlowLayout());

		// GUI에선 이렇게 익명 클래스가 사용된다.
		btn.addActionListener(new ActionListener() {// ActionListener인터페이스 안에는 한가지의 메소드 뿐이 없다.

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("안녕 난 버튼이야!");
			}
		});

		add(btn);

		addWindowListener(new WindowAdapter() {// WindowListener인터페이스에는 많은 기능이 있는데 그 기능중 일부를 사용하기위해 adapter로 강제성을 없앴다
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("앙 닫혔어!");
				System.exit(0);
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {
		new GuiTest();
	}
}
