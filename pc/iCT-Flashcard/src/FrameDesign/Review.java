package FrameDesign;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ClassDesign.Collection;

import javax.swing.JTextPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Review extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Review(Collection col) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 210, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel TopPanel = new JPanel();
		TopPanel.setBounds(0, 0, 700, 32);
		TopPanel.setBackground(new Color(119, 136, 153));
		contentPane.add(TopPanel);
		TopPanel.setLayout(null);
		
		JLabel Close = new JLabel("X");
		Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame frame = Dashboard.getInstance();
				frame.setVisible(true);
				dispose();
			}
		});
		Close.setForeground(new Color(255, 255, 255));
		Close.setFont(new Font("Tahoma", Font.BOLD, 15));
		Close.setHorizontalAlignment(SwingConstants.CENTER);
		Close.setBounds(641, 0, 59, 31);
		TopPanel.add(Close);
		
		JLabel Miniature = new JLabel("_");
		Miniature.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		Miniature.setHorizontalAlignment(SwingConstants.CENTER);
		Miniature.setForeground(new Color(255, 255, 255));
		Miniature.setFont(new Font("Tahoma", Font.BOLD, 16));
		Miniature.setBounds(609, 0, 46, 31);
		TopPanel.add(Miniature);
		
		JLabel lbiCT = new JLabel("iCT Flashcard");
		lbiCT.setBounds(0, 0, 690, 31);
		TopPanel.add(lbiCT);
		lbiCT.setForeground(new Color(255, 255, 255));
		lbiCT.setHorizontalAlignment(SwingConstants.CENTER);
		lbiCT.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 93, 150, 212);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 150, 89);
		panel.add(panel_1);
		
		JLabel lblTnGi = new JLabel("T\u00EAn g\u00F3i");
		lblTnGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnGi.setBounds(10, 109, 140, 23);
		panel.add(lblTnGi);
		
		JTextPane txtpnMT = new JTextPane();
		txtpnMT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnMT.setText("M\u00F4 t\u1EA3");
		txtpnMT.setBounds(10, 135, 140, 77);
		panel.add(txtpnMT);
		
		JLabel lblnTp = new JLabel("\u00D4N T\u1EACP");
		lblnTp.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblnTp.setHorizontalAlignment(SwingConstants.CENTER);
		lblnTp.setBounds(0, 50, 700, 32);
		contentPane.add(lblnTp);
		
		JPanel ReviewPanel = new JPanel();
		ReviewPanel.setBackground(new Color(245, 245, 245));
		ReviewPanel.setBounds(193, 93, 476, 273);
		contentPane.add(ReviewPanel);
		ReviewPanel.setLayout(new CardLayout(0, 0));
		
		JPanel Start = new JPanel();
		Start.setBackground(new Color(245, 245, 245));
		ReviewPanel.add(Start, "name_142653055316497");
		Start.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00D4n t\u1EADp flashcard");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(52, 58, 402, 36);
		Start.add(lblNewLabel);
		
		JTextPane txtpnChoMngBn = new JTextPane();
		txtpnChoMngBn.setBackground(new Color(245, 245, 245));
		txtpnChoMngBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnChoMngBn.setText("Ch\u00E0o m\u1EEBng b\u1EA1n \u0111\u1EBFn v\u1EDBi n\u1ED9i dung \u00F4n t\u1EADp. B\u1EA1n s\u1EBD c\u00F3 th\u1EDDi gian 56 gi\u00E2y \u0111\u1EC3 tr\u1EA3 l\u1EDDi 7 c\u00E2u h\u1ECFi li\u00EAn quan \u0111\u1EBFn c\u00E1c flashcard trong b\u1ED9 flashcard n\u00E0y. Khi b\u1EA1n s\u1EB5n s\u00E0ng, h\u00E3y \u1EA5n B\u1EAFt \u0111\u1EA7u");
		txtpnChoMngBn.setBounds(52, 94, 402, 54);
		Start.add(txtpnChoMngBn);
		
		JButton btnBtu = new JButton("B\u1EAFt \u0111\u1EA7u");
		
		btnBtu.setForeground(new Color(255, 255, 255));
		btnBtu.setBackground(new Color(100, 149, 237));
		btnBtu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBtu.setBounds(52, 171, 133, 36);
		Start.add(btnBtu);
		
		JPanel Question = new JPanel();
		Question.setBackground(new Color(245, 245, 245));
		ReviewPanel.add(Question, "name_142661532735132");
		Question.setLayout(null);
		
		JLabel lblnTp_1 = new JLabel("\u00D4n t\u1EADp");
		lblnTp_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnTp_1.setBounds(21, 0, 87, 38);
		Question.add(lblnTp_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(15);
		progressBar.setBounds(21, 36, 430, 14);
		Question.add(progressBar);
		
		JLabel lblCuHi = new JLabel("C\u00E2u h\u1ECFi:");
		lblCuHi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCuHi.setBounds(348, 61, 56, 27);
		Question.add(lblCuHi);
		
		JLabel lblThiGian = new JLabel("Th\u1EDDi gian: ");
		lblThiGian.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThiGian.setBounds(21, 61, 74, 27);
		Question.add(lblThiGian);
		
		textField = new JTextField();
		textField.setBounds(84, 61, 46, 27);
		Question.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(405, 61, 46, 27);
		Question.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(21, 114, 430, 55);
		Question.add(panel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(21, 180, 175, 33);
		Question.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(21, 224, 175, 33);
		Question.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(276, 180, 175, 33);
		Question.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(276, 224, 175, 33);
		Question.add(textField_5);
		btnBtu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReviewPanel.removeAll();
				ReviewPanel.add(Question);
				ReviewPanel.repaint();
				ReviewPanel.revalidate();
			}
		});
		
		setUndecorated(true);
	}

}
