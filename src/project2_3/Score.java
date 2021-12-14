package project2_3;

import java.awt.Container;
import java.awt.GridLayout;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//스코어를 위한 클래스

class Score extends JFrame {
	JLabel l1 = new JLabel("등        수");
	JLabel l2 = new JLabel("이동횟수");
	JLabel l3 = new JLabel("점        수");
	JLabel l4 = new JLabel("이        름");

	JTextField tf_rank = new JTextField(10);
	JTextField tf_count = new JTextField(10);
	JTextField tf_score = new JTextField(10);
	JTextField tf_name = new JTextField(10);      // 라벨 선언하고 스코어필드를 출력할 변수 선언

	JPanel[] p = new JPanel[4];
	JPanel p1 = new JPanel(new GridLayout(0, 1));

	public Score() {
		super("등록");

		Container cp = getContentPane();

		for (int a = 0; a < p.length; a++) {
			p[a] = new JPanel();
		}

		p[0].add(l1);
		p[0].add(tf_rank);
		p[1].add(l2);
		p[1].add(tf_count);
		p[2].add(l3);
		p[2].add(tf_score);
		p[3].add(l4);
		p[3].add(tf_name);

		for (int a = 0; a < p.length; a++)
			p1.add(p[a]);

		cp.add(p1);

		tf_rank.setEnabled(false);
		tf_count.setEnabled(false);
		tf_score.setEnabled(false);
		tf_name.requestFocus();

		pack();

	}
	
}
