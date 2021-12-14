package project2_3;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class PuzzleGame extends JFrame implements ActionListener {
	JMenuBar mb = new JMenuBar();   //  n*n ������ �ϱ����� �޴��� 

	JMenu menu_game = new JMenu("����");
	JMenu menu_level = new JMenu("���̵�");
	JMenu menu_option = new JMenu("�ɼ�");

	JMenuItem menu_game_new = new JMenuItem("������");
	JMenuItem menu_game_start = new JMenuItem("���ӽ���");
	JMenuItem menu_game_exit = new JMenuItem("��������");            // �޴� 3���� ����

	JMenuItem menu_level_3 = new JMenuItem("3 X 3");
	JMenuItem menu_level_4 = new JMenuItem("4 X 4");
	JMenuItem menu_level_5 = new JMenuItem("5 X 5");
	JMenuItem menu_level_6 = new JMenuItem("6 X 6");
	JMenuItem menu_level_7 = new JMenuItem("7 X 7");
	JMenuItem menu_level_8 = new JMenuItem("8 X 8");
	JMenuItem menu_level_9 = new JMenuItem("9 X 9");          // ���� ������ ���� ���� 

	JMenuItem menu_option_score = new JMenuItem("�������");

	JMenuItem menu_option_full = new JMenuItem("�ϼ��׸�");
	JMenuItem menu_option_cho = new JMenuItem("���� ����ϱ�");

	JLabel scoreLabel = new JLabel("���� : 1000000", JLabel.CENTER);
	JLabel countLabel = new JLabel("�̵�ȸ�� : 0", JLabel.CENTER);               // �׷��� ����

	JPanel panel = new JPanel();

	String[][] name = new String[7][10];
	int[][] jumsu = new int[7][10];

	GamePan gp = new GamePan(name, jumsu, scoreLabel, countLabel);  // �̸��� ����, ���ھ ���� �� , �̵�Ƚ���� ���� ��

	public PuzzleGame() {
		super("�������");

		Container cp = getContentPane();

		menu_game.add(menu_game_new);
		menu_game.add(menu_game_start);
		menu_game.addSeparator();
		menu_game.add(menu_game_exit);

		menu_level.add(menu_level_3);
		menu_level.add(menu_level_4);
		menu_level.add(menu_level_5);
		menu_level.add(menu_level_6);
		menu_level.add(menu_level_7);
		menu_level.add(menu_level_8);
		menu_level.add(menu_level_9);

		menu_option.add(menu_option_score);

		menu_option.add(menu_option_full);

		mb.add(menu_game);
		mb.add(menu_level);
		mb.add(menu_option);                   // contentpane�� �޴��ٸ� �߰���Ŵ.

		setJMenuBar(mb);

		panel.setLayout(new GridLayout(1, 2));

		panel.add(scoreLabel);
		panel.add(countLabel);
		cp.add(panel, BorderLayout.NORTH);
		cp.add(gp, BorderLayout.CENTER);

		for (int a = 0; a < 7; a++) {            
			for (int b = 0; b < 10; b++) {
				name[a][b] = "";      // �̸�
				jumsu[a][b] = 0;       // ���� �ʱ�ȭ ��Ŵ
			}
		}

		setBounds(200, 200, 500, 500);

		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		menu_game_new.addActionListener(this);
		menu_game_start.addActionListener(this);
		menu_game_exit.addActionListener(this);

		menu_level_3.addActionListener(this);
		menu_level_4.addActionListener(this);
		menu_level_5.addActionListener(this);
		menu_level_6.addActionListener(this);
		menu_level_7.addActionListener(this);
		menu_level_8.addActionListener(this);
		menu_level_9.addActionListener(this);

		menu_option_score.addActionListener(this);

		menu_option_full.addActionListener(this);
		menu_option_cho.addActionListener(this);            // ActionListener�� �޴��� �����Ѱſ� �� ������.
	}

	public void actionPerformed(ActionEvent e) {         // �׼� ������
		Object o = e.getSource();

		if (o == menu_game_new) {      // ������
			gp.bStart = false;
			gp.bFull = true;
			gp.score = 1000000;
			gp.count = 0;

			gp.count = 0;

			gp.getRand();
			gp.getRect();
			gp.repaint();
			gp.scoreLabel.setText("���� : " + gp.score);
			gp.countLabel.setText("�̵�ȸ�� : " + gp.count);
		} else if (o == menu_game_start) {     // ���� �����ҽ� repaint�� �ٽ� �׸� �׸���
			gp.bStart = true;
			gp.bFull = false;
			gp.repaint();
		} else if (o == menu_game_exit) {      // ���� ������
			System.exit(0);
		} else if (o == menu_level_3) {       // 3*3 ����     chasu ������ ����ĭ�� ������
			gp.chasu = 3;
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_level_4) {      // 4*4����
			gp.chasu = 4;
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_level_5) {    // 5*5
			gp.chasu = 5;
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_level_6) {    // 6*6
			gp.chasu = 6;
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_level_7) {   // 7*7
			gp.chasu = 7; 
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_level_8) {    // 8*8
			gp.chasu = 8;
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_level_9) {    // 9*9
			gp.chasu = 9;
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_option_score) {
			ScoreList sl = new ScoreList(name, jumsu, gp.chasu - 3);
			sl.setVisible(true);
		} else if (o == menu_option_full || o == menu_option_cho) {
			if (!gp.bStart)
				return;

			if (gp.bFull) {
				menu_option_full.setText("�ϼ��׸� ������");

			} else {
				menu_option_full.setText("���� ����ϱ�");

			}

			gp.bFull = !gp.bFull;
			gp.repaint();
		}
	}

	public static void main(String[] args) {
		new PuzzleGame();
	}
}







