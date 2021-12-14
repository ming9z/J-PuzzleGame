package project2_3;

import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


class ScoreList extends JFrame implements ItemListener {
	JLabel l1 = new JLabel("난이도별");
	JComboBox com = new JComboBox();

	String[][] data = new String[10][3]; // 랭킹 칸
	String[] cols = { "등수", "이름", "점수" };

	DefaultTableModel mod = new DefaultTableModel(data, cols);
	JTable table = new JTable(mod);

	String[][] name;
	int[][] jumsu;
	int chasu;

	public ScoreList(String[][] name, int[][] jumsu, int chasu) {
		super("리스트");

		this.name = name;
		this.jumsu = jumsu;
		this.chasu = chasu;

		Container cp = getContentPane();
		JScrollPane sp = new JScrollPane(table);

		com.addItem("3 X 3");
		com.addItem("4 X 4");
		com.addItem("5 X 5");
		com.addItem("6 X 6");
		com.addItem("7 X 7");
		com.addItem("8 X 8");
		com.addItem("9 X 9");

		JPanel p = new JPanel();
		p.add(l1);
		p.add(com);

		cp.add("North", p);
		cp.add("Center", sp);

		for (int a = 0; a < 10; a++) {
			data[a][0] = new Integer(a + 1).toString();
			data[a][1] = name[chasu][a];
			data[a][2] = new Integer(jumsu[chasu][a]).toString();
		}

		

		pack();

		com.addItemListener(this);
	}

	public void itemStateChanged(ItemEvent e) {       
		chasu = com.getSelectedIndex();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				data[i][j] = "";
			}
		}   // 이미지 데이터 파일을 반복문으로 체크

		for (int a = 0; a < 10; a++) {
			data[a][0] = new Integer(a + 1).toString();
			data[a][1] = name[chasu][a];
			data[a][2] = new Integer(jumsu[chasu][a]).toString();  // 문자열로 바꿈
		}

		
	}
}