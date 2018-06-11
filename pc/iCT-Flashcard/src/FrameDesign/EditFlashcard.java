package FrameDesign;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ClassDesign.Collection;
import ClassDesign.CollectionManagement;
import ClassDesign.Flashcard;
import ClassDesign.FlashcardManagement;
import ClassDesign.Success;
import ClassDesign.User;

public class EditFlashcard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditFlashcard frame = new EditFlashcard();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public EditFlashcard(Collection col, Flashcard flc) {
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
				Dashboard main = new Dashboard();
				main.setVisible(true);
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
		lbiCT.setBounds(0, 0, 629, 31);
		TopPanel.add(lbiCT);
		lbiCT.setForeground(new Color(255, 255, 255));
		lbiCT.setHorizontalAlignment(SwingConstants.CENTER);
		lbiCT.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(220, 43, 414, 276);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel BehindPanel = new JPanel();
		BehindPanel.setBounds(193, 13, 1, 1);
		panel.add(BehindPanel);
		BehindPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		BehindPanel.setBackground(Color.WHITE);
		BehindPanel.setLayout(null);

		
		JLabel lbPronunciation = new JLabel("Phi\u00EAn \u00E2m");
		lbPronunciation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbPronunciation.setBounds(24, 43, 66, 14);
		BehindPanel.add(lbPronunciation);
		
		
		JLabel lbMean = new JLabel("Ngh\u0129a");
		lbMean.setVerticalAlignment(SwingConstants.TOP);
		lbMean.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbMean.setBounds(24, 105, 46, 26);
		BehindPanel.add(lbMean);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(13, 0, 181, 234);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 181, 112);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnFlcPicture = new JButton("Thay hình");
		btnFlcPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				System.out.println(filename);
			}
		});
		btnFlcPicture.setForeground(new Color(0, 0, 0));
		btnFlcPicture.setBounds(48, 89, 89, 23);
		panel_5.add(btnFlcPicture);
		
		JLabel txtWord = new JLabel("T\u1EEB");
		txtWord.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtWord.setBounds(10, 123, 161, 32);
		panel_2.add(txtWord);
		
		JLabel txtPronun = new JLabel("Phi\u00EAn \u00E2m");
		txtPronun.setVerticalAlignment(SwingConstants.TOP);
		txtPronun.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPronun.setBounds(10, 154, 161, 40);
		panel_2.add(txtPronun);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(217, 0, 181, 234);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JTextPane txtMeaning = new JTextPane();
		txtMeaning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMeaning.setText("Nghĩa của từ");
		txtMeaning.setBounds(20, 26, 140, 173);
		txtMeaning.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.add(txtMeaning);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_6.setBackground(new Color(245, 245, 245));
		panel_6.setBounds(13, 233, 181, 32);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblMtTrc = new JLabel("Mặt trước");
		lblMtTrc.setForeground(new Color(128, 128, 128));
		lblMtTrc.setHorizontalAlignment(SwingConstants.CENTER);
		lblMtTrc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtTrc.setBounds(0, 0, 181, 32);
		panel_6.add(lblMtTrc);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_7.setBackground(new Color(245, 245, 245));
		panel_7.setBounds(217, 233, 181, 32);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblMtSau = new JLabel("Mặt sau");
		lblMtSau.setForeground(new Color(128, 128, 128));
		lblMtSau.setHorizontalAlignment(SwingConstants.CENTER);
		lblMtSau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtSau.setBounds(0, 0, 181, 32);
		panel_7.add(lblMtSau);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(23, 43, 176, 318);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 25, 176, 105);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		
		
		JTextArea DescriptionCol = new JTextArea();
		DescriptionCol.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DescriptionCol.setText(col.sgetDescription());
		DescriptionCol.setBorder(new LineBorder(Color.LIGHT_GRAY));
		DescriptionCol.setBackground(Color.WHITE);
		DescriptionCol.setBounds(10, 185, 156, 80);
		panel_1.add(DescriptionCol);
		
		JLabel lblTnGi = new JLabel("T\u00EAn g\u00F3i");
		lblTnGi.setText(col.getName());
		lblTnGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnGi.setBounds(10, 149, 156, 25);
		panel_1.add(lblTnGi);
		
		JButton btnLuThayi = new JButton("Lưu thay đổi");
		btnLuThayi.setBounds(335, 330, 156, 34);
		contentPane.add(btnLuThayi);
		btnLuThayi.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
			
				Success check;
				String word = txtWord.getText();
				String pronun = txtPronun.getText();
				String image = btnFlcPicture.toString();
				String meaning = txtMeaning.getText();
				FlashcardManagement mag = new FlashcardManagement();
				int order = flc.getOrder();
				try {
					order = mag.getAllFlashcardInfor(User.getUser().getUsername(), User.getUser().getToken(), col.getId()).getData().length;
					try {
						check = mag.updateFlashcard(User.getUser().getUsername(), User.getUser().getToken(), col.getId(), word, pronun, meaning, image, order);
						if(check.getSuccess().equals("true")) {
							AddWord add = new AddWord(col);
							add.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi thêm flashcard!!");
							dispose();
							AddWord add = new AddWord(col);
							add.setVisible(true);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		});
		btnLuThayi.setForeground(new Color(255, 255, 255));
		btnLuThayi.setBackground(new Color(100, 149, 237));
		btnLuThayi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		setUndecorated(true);
	}

}
