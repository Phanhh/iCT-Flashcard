package FrameDesign;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ClassDesign.Collection;
import ClassDesign.CollectionManagement;
import ClassDesign.Flashcard;
import ClassDesign.FlashcardInfor;
import ClassDesign.FlashcardManagement;
import ClassDesign.ImageLoader;
import ClassDesign.Success;
import ClassDesign.User;

import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.CardLayout;

public class ShowCollections extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	int i = 0;
	public ShowCollections(Collection col) throws IOException {
		FlashcardManagement management = new FlashcardManagement();
		Flashcard[] flc;
		FlashcardInfor all = management.getAllFlashcardInfor(User.getUser().getUsername(), User.getUser().getToken(), col.getId());
		if(all.getSuccess().equals("false")) {
			JOptionPane.showMessageDialog(null, "Xảy ra lỗi khi load flashcard!", "Error", JOptionPane.ERROR_MESSAGE);
			dispose();
		}
		flc = all.getData();
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
		panel.setBounds(24, 66, 162, 269);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 162, 89);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel picture_col = new JLabel("");
		picture_col.setBounds(0, 0, 162, 89);
		panel_1.add(picture_col);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/images/"+col.getId()+".jpg").getImage().getScaledInstance(187, 101, java.awt.Image.SCALE_SMOOTH));
		picture_col.setIcon(imageIcon);
		
		JLabel lblTnGi = new JLabel(col.getName());
		lblTnGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnGi.setBounds(10, 109, 140, 23);
		panel.add(lblTnGi);
		
		JTextPane txtpnMT = new JTextPane();
		txtpnMT.setEditable(false);
		txtpnMT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnMT.setText(col.sgetDescription());
		txtpnMT.setBounds(10, 135, 140, 50);
		panel.add(txtpnMT);
		
		JLabel lblThuc = new JLabel("\u0110\u00E3 thu\u1ED9c:");
		lblThuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThuc.setBounds(10, 196, 68, 21);
		panel.add(lblThuc);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(Integer.parseInt(col.getRemember_score()));
		progressBar.setBounds(10, 226, 140, 14);
		panel.add(progressBar);
		
		JLabel review_score = new JLabel(col.getRemember_score()+"%");
		review_score.setBounds(71, 196, 54, 21);
		panel.add(review_score);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(213, 66, 453, 295);
		panel_2.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel flashcard1 = new JPanel();
		flashcard1.setBackground(new Color(255, 255, 255));
		flashcard1.setBounds(10, 11, 167, 234);
		panel_2.add(flashcard1);
		flashcard1.setLayout(new CardLayout(0, 0));
		
		JPanel Pre = new JPanel();
		Pre.setBackground(new Color(255, 255, 255));
		flashcard1.add(Pre, "name_148749406577903");
		Pre.setLayout(null);
		
		JPanel Flashcash_picture = new JPanel();
		Flashcash_picture.setBounds(0, 0, 167, 105);
		Pre.add(Flashcash_picture);
		Flashcash_picture.setLayout(null);
		
		JLabel image = new JLabel("");
		image.setBounds(0, 0, 167, 105);
		Flashcash_picture.add(image);
		try {
			ImageLoader.saveImage(flc[i].getImage(), "src/images/"+flc[i].getWord()+".jpg");
			ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("src/images/"+flc[i].getWord()+".jpg").getImage().getScaledInstance(167,105, java.awt.Image.SCALE_SMOOTH));
			image.setIcon(imageIcon2);
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JTextPane pronun_1 = new JTextPane();
		pronun_1.setEditable(false);
		pronun_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		if (flc[i] != null)
		pronun_1.setText(flc[i].getPronunciation());
		pronun_1.setBounds(10, 140, 135, 32);
		Pre.add(pronun_1);
		
		JTextPane word_1 = new JTextPane();
		word_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		if(flc[i] != null)
		word_1.setText(flc[i].getWord());
		word_1.setBounds(10, 116, 135, 23);
		Pre.add(word_1);
		
		JLabel lblMtTrc = new JLabel("M\u1EB7t tr\u01B0\u1EDBc");
		
		lblMtTrc.setForeground(new Color(47, 79, 79));
		lblMtTrc.setIcon(new ImageIcon(ShowCollections.class.getResource("/images/share.png")));
		lblMtTrc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtTrc.setHorizontalAlignment(SwingConstants.CENTER);
		lblMtTrc.setBounds(0, 202, 167, 32);
		Pre.add(lblMtTrc);
		
		JPanel After = new JPanel();
		After.setBackground(new Color(255, 255, 255));
		flashcard1.add(After, "name_148774131462693");
		After.setLayout(null);
		
		JLabel word1 = new JLabel("T\u1EEB");
		if (flc[i] != null)
			word1.setText(flc[i].getWord());
		word1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		word1.setBounds(10, 28, 147, 23);
		After.add(word1);
		
		JLabel pronun1 = new JLabel("Phi\u00EAn \u00E2m");
		pronun1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pronun1.setBounds(10, 53, 147, 23);
		After.add(pronun1);
		if (flc[i] != null)
			pronun1.setText(flc[i].getWord());
		
		JTextPane mean_1 = new JTextPane();
		mean_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		if (flc[i] != null)
		mean_1.setText(flc[i].getMeaning());
		mean_1.setBounds(10, 78, 147, 60);
		
		After.add(mean_1);
		
		JLabel lblNewLabel = new JLabel("M\u1EB7t sau");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMtTrc.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						flashcard1.removeAll();
						flashcard1.add(Pre);	
						flashcard1.repaint();
						flashcard1.revalidate();
					}
				});
			}
		});
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setIcon(new ImageIcon(ShowCollections.class.getResource("/images/share.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 201, 167, 33);
		After.add(lblNewLabel);
		lblMtTrc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				flashcard1.removeAll();
				flashcard1.add(After);	
				flashcard1.repaint();
				flashcard1.revalidate();
			}
		});
		
		JPanel flashcard2 = new JPanel();
		flashcard2.setBackground(Color.WHITE);
		flashcard2.setBounds(212, 11, 167, 234);
		panel_2.add(flashcard2);
		flashcard2.setLayout(new CardLayout(0, 0));
		
		JPanel Pre_2 = new JPanel();
		Pre_2.setBackground(new Color(255, 255, 255));
		flashcard2.add(Pre_2, "name_150187464477425");
		Pre_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 167, 105);
		Pre_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel image2 = new JLabel("");
		image2.setBounds(0, 0, 167, 105);
		panel_3.add(image2);
		try {
			ImageLoader.saveImage(flc[i+1].getImage(), "src/images/"+flc[i+1].getWord()+".jpg");
			ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("src/images/"+flc[i+1].getWord()+".jpg").getImage().getScaledInstance(167, 105, java.awt.Image.SCALE_SMOOTH));
			image2.setIcon(imageIcon2);
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JTextPane pronun_2 = new JTextPane();
		pronun_2.setEditable(false);
		if(flc[i+1] != null)
		pronun_2.setText(flc[i+1].getPronunciation());
		pronun_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pronun_2.setBounds(11, 143, 146, 32);
		Pre_2.add(pronun_2);
		
		JTextPane word_2 = new JTextPane();
		if(flc[i+1] != null)
		word_2.setText(flc[i+1].getWord());
		word_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		word_2.setBounds(10, 116, 147, 23);
		Pre_2.add(word_2);
		
		JLabel label = new JLabel("M\u1EB7t tr\u01B0\u1EDBc");

		label.setIcon(new ImageIcon(ShowCollections.class.getResource("/images/share.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(47, 79, 79));
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(0, 201, 167, 32);
		Pre_2.add(label);
		
		JPanel After_2 = new JPanel();
		After_2.setBackground(new Color(255, 255, 255));
		flashcard2.add(After_2, "name_150195765135069");
		After_2.setLayout(null);
		
		JLabel word2 = new JLabel("T\u1EEB");
		word2.setBounds(10, 24, 147, 27);
		word2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		After_2.add(word2);
		if(flc[i+1] != null)
			word2.setText(flc[i+1].getWord());
		
		JLabel pronun2 = new JLabel("Phi\u00EAn \u00E2m");
		pronun2.setBounds(10, 50, 147, 27);
		pronun2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		After_2.add(pronun2);
		if(flc[i+1] != null)
			pronun2.setText(flc[i+1].getPronunciation());
		
		JTextPane mean_2 = new JTextPane();
		mean_2.setBounds(10, 76, 147, 27);
		if(flc[i+1] != null)
		mean_2.setText(flc[i+1].getMeaning());
		mean_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		After_2.add(mean_2);
		
		JLabel label_3 = new JLabel("M\u1EB7t sau");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMtTrc.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						flashcard2.removeAll();
						flashcard2.add(Pre_2);	
						flashcard2.repaint();
						flashcard2.revalidate();
					}
				});
			}
		});
		label_3.setIcon(new ImageIcon(ShowCollections.class.getResource("/images/share.png")));
		label_3.setBounds(0, 201, 167, 33);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(47, 79, 79));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		After_2.add(label_3);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMtTrc.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						flashcard2.removeAll();
						flashcard2.add(After_2);	
						flashcard2.repaint();
						flashcard2.revalidate();
					}
				});
			}
		});
		
		JLabel next = new JLabel("");
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i = i +2;
				if(i >= flc.length) {
					i = 0;
				}
				if(flc[i] != null) {
					word_1.setText(flc[i].getWord());
					pronun_1.setText(flc[i].getPronunciation());
					word1.setText(flc[i].getWord());
					pronun1.setText(flc[i].getPronunciation());
					mean_1.setText(flc[i].getMeaning());
					try {
						ImageLoader.saveImage(flc[i].getImage(), "src/images/"+flc[i].getWord()+".jpg");
						ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("src/images/"+flc[i].getWord()+".jpg").getImage().getScaledInstance(167, 105, java.awt.Image.SCALE_SMOOTH));
						image.setIcon(imageIcon2);
						
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if(flc[i+1] != null) {
						word_2.setText(flc[i+1].getWord());
						pronun_2.setText(flc[i+1].getPronunciation());
						word2.setText(flc[i+1].getWord());
						pronun2.setText(flc[i+1].getPronunciation());
						mean_2.setText(flc[i+1].getMeaning());
						try {
							ImageLoader.saveImage(flc[i+1].getImage(), "src/images/"+flc[i+1].getWord()+".jpg");
							ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("src/images/"+flc[i+1].getWord()+".jpg").getImage().getScaledInstance(167, 105, java.awt.Image.SCALE_SMOOTH));
							image2.setIcon(imageIcon2);
							
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					} else {
						word_2.setText("");
						pronun_2.setText("");
						word2.setText("");
						pronun2.setText("");
						mean_2.setText("");
					}	
				}
			}
		});
		next.setBounds(403, 117, 46, 55);
		panel_2.add(next);
		next.setHorizontalAlignment(SwingConstants.CENTER);
		next.setIcon(new ImageIcon(ShowCollections.class.getResource("/images/right-arrow (1).png")));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(10, 259, 167, 25);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblSa = new JLabel("S\u1EEDa");
		lblSa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblSa.setForeground(new Color(0, 0, 205));
		lblSa.setIcon(new ImageIcon(ShowCollections.class.getResource("/images/003-edit.png")));
		lblSa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSa.setHorizontalAlignment(SwingConstants.CENTER);
		lblSa.setBounds(0, 0, 82, 25);
		panel_4.add(lblSa);
		
		JLabel lblXa = new JLabel("X\u00F3a");
		lblXa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FlashcardManagement mag = new FlashcardManagement();
				Success check;
				try {
					check = mag.deleteFlashcard(User.getUser().getUsername(), User.getUser().getToken(), flc[i].getId());
					if(check.getSuccess().equals("true")) {
						JOptionPane.showMessageDialog(null, "Xóa gói flashcard thành công!!");
						dispose();
						Dashboard main = new Dashboard();
						main.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình xóa!!");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblXa.setForeground(new Color(0, 0, 205));
		lblXa.setIcon(new ImageIcon(ShowCollections.class.getResource("/images/001-rubbish-bin.png")));
		lblXa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXa.setHorizontalAlignment(SwingConstants.CENTER);
		lblXa.setBounds(85, 0, 82, 25);
		panel_4.add(lblXa);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(212, 259, 167, 25);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_4 = new JLabel("S\u1EEDa");
		label_4.setForeground(new Color(0, 0, 205));
		label_4.setIcon(new ImageIcon(ShowCollections.class.getResource("/images/003-edit.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(0, 0, 82, 25);
		panel_5.add(label_4);
		
		JLabel label_5 = new JLabel("X\u00F3a");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FlashcardManagement mag = new FlashcardManagement();
				Success check;
				try {
					check = mag.deleteFlashcard(User.getUser().getUsername(), User.getUser().getToken(), flc[i+1].getId());
					if(check.getSuccess().equals("true")) {
						JOptionPane.showMessageDialog(null, "Xóa gói flashcard thành công!!");
						dispose();
						Dashboard main = new Dashboard();
						main.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình xóa!!");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		label_5.setForeground(new Color(0, 0, 205));
		label_5.setIcon(new ImageIcon(ShowCollections.class.getResource("/images/001-rubbish-bin.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(85, 0, 82, 25);
		panel_5.add(label_5);
		
		setUndecorated(true);
	}

}
