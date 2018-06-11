package FrameDesign;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import ClassDesign.AllCollections;
import ClassDesign.Collection;
import ClassDesign.CollectionManagement;
import ClassDesign.ImageLoader;
import ClassDesign.Network;
import ClassDesign.Profile;
import ClassDesign.Success;
import ClassDesign.User;

import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;

public class Dashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private static Dashboard instance = null;
	private JTextField pfFname;
	private JTextField pfEmail;
	private JTextField new_fname;
	private JTextField new_email;
	private JPasswordField old_Password;
	private JPasswordField new_Password;
	
	public static synchronized Dashboard getInstance() {
		if (instance == null) {
            instance = new Dashboard();
        }
        return instance;
	}
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JFrame frame = Dashboard.getInstance();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	int i = 0;
	private void setColor(JPanel pane) {
		pane.setBackground(new Color(240,240,240));
	}
	
	private void resetColor(JPanel pane, JPanel indicator) {
		pane.setBackground(new Color(245,245,245));
		indicator.setOpaque(false);
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public Dashboard() {
		
		Collection[] col;
		col = AllCollections.getAllCollections().getCollection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 829, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel TopPanel = new JPanel();
		TopPanel.setBackground(new Color(119, 136, 153));
		TopPanel.setBounds(211, 0, 618, 37);
		contentPane.add(TopPanel);
		TopPanel.setLayout(null);
		
		JLabel Close = new JLabel("X");
		Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		Close.setHorizontalAlignment(SwingConstants.CENTER);
		Close.setFont(new Font("Tahoma", Font.BOLD, 16));
		Close.setForeground(new Color(255, 255, 255));
		Close.setBounds(562, 0, 46, 39);
		TopPanel.add(Close);
		
		JLabel Miniature = new JLabel("_");
		Miniature.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		Miniature.setHorizontalAlignment(SwingConstants.CENTER);
		Miniature.setFont(new Font("Tahoma", Font.BOLD, 16));
		Miniature.setForeground(new Color(255, 255, 255));
		Miniature.setBounds(515, 0, 46, 39);
		TopPanel.add(Miniature);
		
		JLabel lbiCT = new JLabel("iCT Flashcard");
		lbiCT.setHorizontalAlignment(SwingConstants.CENTER);
		lbiCT.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbiCT.setForeground(new Color(255, 255, 255));
		lbiCT.setBounds(239, -1, 141, 39);
		TopPanel.add(lbiCT);
		
		JPanel side_panel = new JPanel();
		side_panel.setBackground(new Color(245, 245, 245));
		side_panel.setBounds(0, 0, 212, 556);
		contentPane.add(side_panel);
		side_panel.setLayout(null);
		
		JLabel lblXinCho = new JLabel("");
		lblXinCho.setBackground(new Color(245, 245, 245));
		lblXinCho.setIcon(new ImageIcon(Dashboard.class.getResource("/images/imgonline-com-ua-shape-EoeaJBkEiNsZrG.png")));
		lblXinCho.setHorizontalAlignment(SwingConstants.CENTER);
		lblXinCho.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblXinCho.setBounds(0, 0, 202, 96);
		side_panel.add(lblXinCho);
		
		JPanel btnHome = new JPanel();
		btnHome.setBounds(0, 96, 212, 49);
		side_panel.add(btnHome);
		btnHome.setLayout(null);
		
		JPanel indHome = new JPanel();
		indHome.setBackground(Color.DARK_GRAY);
		indHome.setBounds(0, 0, 4, 49);
		btnHome.add(indHome);
		
		JLabel lbHome = new JLabel("   Trang ch\u1EE7");
		lbHome.setBounds(31, 0, 148, 49);
		btnHome.add(lbHome);
		lbHome.setIcon(new ImageIcon(Dashboard.class.getResource("/images/002-web-page-home.png")));
		lbHome.setBackground(new Color(70, 130, 180));
		lbHome.setForeground(Color.DARK_GRAY);
		lbHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbHome.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel btnAccount = new JPanel();
		btnAccount.setBackground(new Color(245, 245, 245));
		btnAccount.setBounds(0, 145, 212, 49);
		side_panel.add(btnAccount);
		btnAccount.setLayout(null);
		
		JPanel indAccount = new JPanel();
		indAccount.setBackground(Color.DARK_GRAY);
		indAccount.setOpaque(false);
		indAccount.setBounds(0, 0, 4, 49);
		btnAccount.add(indAccount);
		
		JLabel lbAccount = new JLabel("   T\u00E0i kho\u1EA3n");
		lbAccount.setBounds(34, 0, 148, 49);
		btnAccount.add(lbAccount);
		lbAccount.setIcon(new ImageIcon(Dashboard.class.getResource("/images/user (3).png")));
		lbAccount.setForeground(Color.DARK_GRAY);
		lbAccount.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbAccount.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel btnAbout = new JPanel();
		btnAbout.setBackground(new Color(245, 245, 245));
		btnAbout.setBounds(0, 193, 212, 49);
		side_panel.add(btnAbout);
		btnAbout.setLayout(null);
		
		JPanel indAbout = new JPanel();
		indAbout.setBackground(Color.DARK_GRAY);
		indAbout.setOpaque(false);
		indAbout.setBounds(0, 0, 4, 49);
		btnAbout.add(indAbout);
		
		JLabel lbAbout = new JLabel("   Th\u00F4ng tin");
		lbAbout.setBounds(33, 0, 153, 49);
		btnAbout.add(lbAbout);
		lbAbout.setIcon(new ImageIcon(Dashboard.class.getResource("/images/005-round.png")));
		lbAbout.setForeground(Color.DARK_GRAY);
		lbAbout.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbAbout.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel sub_title = new JPanel();
		sub_title.setBackground(new Color(255, 255, 255));
		sub_title.setBounds(211, 37, 618, 37);
		contentPane.add(sub_title);
		sub_title.setLayout(null);
		
		JButton btnTin = new JButton("T\u1EEB \u0111i\u1EC3n");
		btnTin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Dictionary dict = new Dictionary();
				dict.setVisible(true);
			}
		});
		btnTin.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnTin.setBackground(new Color(255, 255, 255));
		btnTin.setIcon(new ImageIcon(Dashboard.class.getResource("/images/book (1).png")));
		btnTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTin.setBounds(498, 11, 99, 26);
		sub_title.add(btnTin);
		
		JPanel DisplayCard = new JPanel();
		DisplayCard.setBackground(Color.WHITE);
		DisplayCard.setBounds(211, 77, 618, 479);
		contentPane.add(DisplayCard);
		DisplayCard.setLayout(new CardLayout(0, 0));
		
		JPanel Home = new JPanel();
		DisplayCard.add(Home, "name_1630474127553");
		Home.setBackground(Color.WHITE);
		Home.setLayout(null);
		
		JLabel lbHistory = new JLabel("Các bộ Flashcard bạn đang có");
		lbHistory.setBounds(34, 11, 551, 37);
		Home.add(lbHistory);
		lbHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		JPanel table_flashcard = new JPanel();
		table_flashcard.setBounds(34, 107, 551, 321);
		Home.add(table_flashcard);
		table_flashcard.setBackground(new Color(245, 245, 245));
		table_flashcard.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 321, 551, -319);
		table_flashcard.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(39, 13, 187, 284);
		table_flashcard.add(panel);
		panel.setLayout(null);
		
		JPanel picture_col = new JPanel();
		picture_col.setBackground(new Color(240, 255, 240));
		picture_col.setBounds(0, 0, 187, 101);
		panel.add(picture_col);
		
		JLabel image = new JLabel("");
		image.setBounds(0, 0, 187, 101);
		picture_col.add(image);
		ImageLoader img = new ImageLoader();
		try {
			img.saveImage(col[i].getPhoto(), "src/images/"+col[i].getId()+".jpg");
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/images/"+col[i].getId()+".jpg").getImage().getScaledInstance(187, 101, java.awt.Image.SCALE_SMOOTH));
			image.setIcon(imageIcon);
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		JLabel name_col = new JLabel();
		if(col[0] != null)
	    name_col.setText(col[0].getName());
		name_col.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name_col.setBounds(21, 112, 156, 26);
		panel.add(name_col);
		
		JTextPane description_col = new JTextPane();
		description_col.setEditable(false);
		description_col.setFont(new Font("Tahoma", Font.PLAIN, 14));
		if(col[0] != null)
		description_col.setText(col[0].sgetDescription());
		description_col.setBounds(21, 142, 156, 46);
		panel.add(description_col);
		
		JLabel show_col = new JLabel("Xem");
		show_col.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ShowCollections show;
				try {
					show = new ShowCollections(col[i]);
					show.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		show_col.setIcon(new ImageIcon(Dashboard.class.getResource("/images/004-eye-shape-variant-interface-view-symbol.png")));
		show_col.setForeground(new Color(0, 0, 205));
		show_col.setFont(new Font("Tahoma", Font.PLAIN, 14));
		show_col.setHorizontalAlignment(SwingConstants.CENTER);
		show_col.setBounds(10, 235, 57, 26);
		panel.add(show_col);
		
		JLabel review_col = new JLabel("Ôn tập");
		review_col.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Review review = new Review(col[i]);
				review.setVisible(true);
			}
		});
		review_col.setIcon(new ImageIcon(Dashboard.class.getResource("/images/002-review.png")));
		review_col.setForeground(new Color(0, 0, 205));
		review_col.setHorizontalAlignment(SwingConstants.CENTER);
		review_col.setFont(new Font("Tahoma", Font.PLAIN, 14));
		review_col.setBounds(93, 235, 94, 26);
		panel.add(review_col);
		
		JLabel edit_col = new JLabel("Thêm");
		edit_col.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AddWord add = new AddWord(col[i]);
				add.setVisible(true);
			}
		});
		edit_col.setIcon(new ImageIcon(Dashboard.class.getResource("/images/003-edit.png")));
		edit_col.setForeground(new Color(0, 0, 205));
		edit_col.setHorizontalAlignment(SwingConstants.CENTER);
		edit_col.setFont(new Font("Tahoma", Font.PLAIN, 14));
		edit_col.setBounds(0, 258, 83, 26);
		panel.add(edit_col);
		
		JLabel delete_col = new JLabel("Xóa");
		delete_col.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				CollectionManagement colmg = new CollectionManagement();
				Success check;
				try {
					check = colmg.deleteCol(User.getUser().getUsername(), User.getUser().getToken(), col[i].getId());
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
		delete_col.setIcon(new ImageIcon(Dashboard.class.getResource("/images/001-rubbish-bin.png")));
		delete_col.setForeground(new Color(0, 0, 205));
		delete_col.setHorizontalAlignment(SwingConstants.CENTER);
		delete_col.setFont(new Font("Tahoma", Font.PLAIN, 14));
		delete_col.setBounds(89, 258, 88, 26);
		panel.add(delete_col);
		
		JProgressBar ReviewProgressBar = new JProgressBar();
		if(col[0] != null)
		ReviewProgressBar.setValue(Integer.parseInt(col[0].getRemember_score()));
		ReviewProgressBar.setBounds(21, 222, 146, 14);
		panel.add(ReviewProgressBar);
		
		JLabel lblThuc = new JLabel("Đã thuộc:");
		lblThuc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThuc.setBounds(21, 199, 68, 21);
		panel.add(lblThuc);
		
		JLabel review_score = new JLabel("0%");
		if(col[0] != null)
		review_score.setText(col[0].getRemember_score()+"%");
		review_score.setFont(new Font("Tahoma", Font.PLAIN, 13));
		review_score.setBounds(89, 196, 46, 26);
		panel.add(review_score);
		
		JPanel col2 = new JPanel();
		col2.setLayout(null);
		col2.setBackground(Color.WHITE);
		col2.setBounds(280, 13, 187, 284);
		table_flashcard.add(col2);
		
		JPanel picture_col2 = new JPanel();
		picture_col2.setBackground(new Color(240, 255, 240));
		picture_col2.setBounds(0, 0, 187, 101);
		col2.add(picture_col2);
		picture_col2.setLayout(null);
		
		JLabel image2 = new JLabel("");
		image2.setBounds(0, 0, 187, 101);
		picture_col2.add(image2);
		try {
			img.saveImage(col[i+1].getPhoto(), "src/images/"+col[i+1].getId()+".jpg");
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/images/"+col[i+1].getId()+".jpg").getImage().getScaledInstance(187, 101, java.awt.Image.SCALE_SMOOTH));
			image2.setIcon(imageIcon);
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		JLabel name_col2 = new JLabel("Tên gói");
		if(col[1] != null)
		name_col2.setText(col[1].getName());
		name_col2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name_col2.setBounds(21, 112, 156, 26);
		col2.add(name_col2);
		
		JTextPane Describe_col2 = new JTextPane();
		Describe_col2.setEditable(false);
		if(col[1] != null)
		Describe_col2.setText(col[1].sgetDescription());
		Describe_col2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Describe_col2.setBounds(21, 142, 156, 46);
		col2.add(Describe_col2);
		
		JLabel show_2 = new JLabel("Xem");
		show_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ShowCollections show;
				try {
					show = new ShowCollections(col[i+1]);
					show.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		show_2.setIcon(new ImageIcon(Dashboard.class.getResource("/images/004-eye-shape-variant-interface-view-symbol.png")));
		show_2.setHorizontalAlignment(SwingConstants.CENTER);
		show_2.setForeground(new Color(0, 0, 205));
		show_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		show_2.setBounds(10, 235, 57, 26);
		col2.add(show_2);
		
		JLabel review_2 = new JLabel("Ôn tập");
		review_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Review review = new Review(col[i+1]);
				review.setVisible(true);
			}
		});
		review_2.setIcon(new ImageIcon(Dashboard.class.getResource("/images/002-review.png")));
		review_2.setHorizontalAlignment(SwingConstants.CENTER);
		review_2.setForeground(new Color(0, 0, 205));
		review_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		review_2.setBounds(93, 235, 94, 26);
		col2.add(review_2);
		
		JLabel edit_2 = new JLabel("Thêm");
		edit_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				AddWord add = new AddWord(col[i+1]);
				add.setVisible(true);
			}
		});
		edit_2.setIcon(new ImageIcon(Dashboard.class.getResource("/images/003-edit.png")));
		edit_2.setHorizontalAlignment(SwingConstants.CENTER);
		edit_2.setForeground(new Color(0, 0, 205));
		edit_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		edit_2.setBounds(0, 258, 83, 26);
		col2.add(edit_2);
		
		JLabel delete_2 = new JLabel("Xóa");
		delete_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CollectionManagement colmg = new CollectionManagement();
				Success check;
				try {
					check = colmg.deleteCol(User.getUser().getUsername(), User.getUser().getToken(), col[i+1].getId());
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
		delete_2.setIcon(new ImageIcon(Dashboard.class.getResource("/images/001-rubbish-bin.png")));
		delete_2.setHorizontalAlignment(SwingConstants.CENTER);
		delete_2.setForeground(new Color(0, 0, 205));
		delete_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		delete_2.setBounds(88, 258, 89, 26);
		col2.add(delete_2);
		
		JProgressBar ReviewprogressBar_2 = new JProgressBar();
		if(col[1] != null)
		ReviewprogressBar_2.setValue(Integer.parseInt(col[1].getRemember_score()));
		ReviewprogressBar_2.setBounds(21, 222, 146, 14);
		col2.add(ReviewprogressBar_2);
		
		JLabel label_6 = new JLabel("Đã thuộc:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(21, 199, 68, 21);
		col2.add(label_6);
		
		JLabel remember_score_2 = new JLabel("0%");
		if(col[1] != null)
		remember_score_2.setText(col[1].getRemember_score()+"%");
		remember_score_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		remember_score_2.setBounds(89, 196, 46, 26);
		col2.add(remember_score_2);
		
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				i = i +2;
				if(i >= col.length) {
					i = 0;
				}
				if(i < col.length) {
				if(col[i] != null) {
					name_col.setText(col[i].getName());
					description_col.setText(col[i].sgetDescription());
					review_score.setText(col[i].getRemember_score()+"%");
					ReviewProgressBar.setValue(Integer.parseInt(col[i].getRemember_score()));
					try {
						img.saveImage(col[i].getPhoto(), "src/images/"+col[i].getId()+".jpg");
						ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/images/"+col[i].getId()+".jpg").getImage().getScaledInstance(187, 101, java.awt.Image.SCALE_SMOOTH));
						image.setIcon(imageIcon);
						
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if(col[i+1] != null) {
						name_col2.setText(col[i+1].getName());
						Describe_col2.setText(col[i+1].sgetDescription());
						remember_score_2.setText(col[i+1].getRemember_score()+"%");
						ReviewprogressBar_2.setValue(Integer.parseInt(col[i+1].getRemember_score()));
						try {
							img.saveImage(col[i+1].getPhoto(), "src/images/"+col[i+1].getId()+".jpg");
							ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/images/"+col[i+1].getId()+".jpg").getImage().getScaledInstance(187, 101, java.awt.Image.SCALE_SMOOTH));
							image2.setIcon(imageIcon);
							
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					} else {
						name_col2.setText("");
						Describe_col2.setText("");
						remember_score_2.setText("");
						ReviewprogressBar_2.setValue(0);
					}	
				}
				}
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Dashboard.class.getResource("/images/right-arrow (1).png")));
		label.setBounds(489, 128, 52, 55);
		table_flashcard.add(label);
		
		JPanel divPanel = new JPanel();
		divPanel.setBounds(34, 45, 551, 3);
		Home.add(divPanel);
		divPanel.setBackground(new Color(245, 245, 245));
		
		JButton btnAddCard = new JButton("Tạo mới");
		btnAddCard.setBounds(34, 59, 130, 37);
		Home.add(btnAddCard);
		btnAddCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				AddWord add = new AddWord(null);
				add.setVisible(true);
			}
		});
		btnAddCard.setForeground(new Color(255, 255, 255));
		btnAddCard.setBackground(new Color(0, 204, 102));
		btnAddCard.setIcon(new ImageIcon(Dashboard.class.getResource("/images/plus-6-24.png")));
		btnAddCard.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel Account = new JPanel();
		DisplayCard.add(Account, "name_1638893159540");
		Account.setBackground(Color.WHITE);
		Account.setLayout(null);
		
		JLabel pfPicture = new JLabel("");
		pfPicture.setIcon(new ImageIcon(Dashboard.class.getResource("/images/user (2).png")));
		pfPicture.setHorizontalAlignment(SwingConstants.CENTER);
		pfPicture.setBounds(274, 57, 80, 73);
		Account.add(pfPicture);
		
		JLabel lbUsername = new JLabel(User.getUser().getUsername());
		lbUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lbUsername.setBounds(248, 24, 132, 22);
		Account.add(lbUsername);
		
		JLabel lbFname = new JLabel("Họ và tên");
		lbFname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbFname.setBounds(87, 168, 78, 22);
		Account.add(lbFname);
		
		JLabel lbDescription = new JLabel("Giới thiệu");
		lbDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDescription.setBounds(87, 214, 78, 22);
		Account.add(lbDescription);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbEmail.setBounds(87, 334, 78, 22);
		Account.add(lbEmail);
		
		pfFname = new JTextField();
		pfFname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pfFname.setBounds(175, 168, 290, 31);
		Account.add(pfFname);
		pfFname.setColumns(10);
		pfFname.setText(User.getUser().getFullname());
		pfFname.setEditable(false);
		
		pfEmail = new JTextField();
		pfEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pfEmail.setColumns(10);
		pfEmail.setBounds(175, 334, 290, 31);
		Account.add(pfEmail);
		pfEmail.setText(User.getUser().getEmail());
		pfEmail.setEditable(false);
		
		JLabel btnEditProfile = new JLabel("Chỉnh sửa thông tin cá nhân");
		btnEditProfile.setForeground(new Color(30, 144, 255));
		btnEditProfile.setHorizontalAlignment(SwingConstants.CENTER);
		btnEditProfile.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnEditProfile.setBounds(223, 397, 181, 22);
		Account.add(btnEditProfile);
		
		JLabel btnLogout = new JLabel("Đăng xuất");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(User.getUser().getToken());
				Network net = new Network();
				try {
					Success check = net.Logout(User.getUser().getUsername(), User.getUser().getToken());
					if(check.getSuccess().equals("true")) {
						JOptionPane.showMessageDialog(null, "Đăng xuất thành công!!");
						dispose();
						Login login = new Login();	
						login.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Đăng xuất thất bại", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnLogout.setHorizontalAlignment(SwingConstants.CENTER);
		btnLogout.setForeground(new Color(30, 144, 255));
		btnLogout.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnLogout.setBounds(223, 420, 181, 22);
		Account.add(btnLogout);
		
		JLabel btnChangPicture = new JLabel("Thay đổi ảnh đại diện");
		btnChangPicture.setHorizontalAlignment(SwingConstants.CENTER);
		btnChangPicture.setForeground(new Color(30, 144, 255));
		btnChangPicture.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnChangPicture.setBounds(223, 128, 181, 22);
		Account.add(btnChangPicture);
		
		JTextArea pfBio = new JTextArea();
		
		pfBio.setBorder(new LineBorder(new Color(176, 224, 230)));
		pfBio.setBounds(175, 219, 290, 93);
		Account.add(pfBio);
		pfBio.setText(User.getUser().getBio());
		pfBio.setEditable(false);
		pfBio.setLineWrap(true);
		pfBio.getScrollableTracksViewportHeight();
		
		JPanel ChangeInfo = new JPanel();
		ChangeInfo.setBackground(Color.WHITE);
		DisplayCard.add(ChangeInfo, "name_137938335816287");
		ChangeInfo.setLayout(null);
		
		JLabel Username = new JLabel(User.getUser().getUsername());
		Username.setBounds(248, 24, 132, 22);
		Username.setHorizontalAlignment(SwingConstants.CENTER);
		Username.setFont(new Font("Tahoma", Font.BOLD, 16));
		ChangeInfo.add(Username);
		
		JLabel label_10 = new JLabel("Họ và tên");
		label_10.setBounds(76, 98, 78, 22);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ChangeInfo.add(label_10);
		
		JLabel label_11 = new JLabel("Giới thiệu");
		label_11.setBounds(76, 144, 78, 22);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ChangeInfo.add(label_11);
		
		JLabel label_12 = new JLabel("Email");
		label_12.setBounds(76, 264, 78, 22);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ChangeInfo.add(label_12);
		
		new_fname = new JTextField();
		new_fname.setBounds(173, 98, 290, 31);
		new_fname.setText((String) null);
		new_fname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		new_fname.setColumns(10);
		ChangeInfo.add(new_fname);
		
		new_email = new JTextField();
		new_email.setBounds(173, 264, 290, 31);
		new_email.setText((String) null);
		new_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		new_email.setColumns(10);
		ChangeInfo.add(new_email);
		
		JTextArea new_bio = new JTextArea();
		new_bio.setBounds(173, 149, 290, 93);
		new_bio.setText((String) null);
		new_bio.setLineWrap(true);
		new_bio.setBorder(new LineBorder(new Color(176, 224, 230)));
		ChangeInfo.add(new_bio);
		
		JLabel lblMtKhuC = new JLabel("Mật khẩu cũ");
		lblMtKhuC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtKhuC.setBounds(76, 322, 78, 22);
		ChangeInfo.add(lblMtKhuC);
		
		JLabel lblMtKhuMi = new JLabel("Mật khẩu mới");
		lblMtKhuMi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtKhuMi.setBounds(76, 378, 89, 22);
		ChangeInfo.add(lblMtKhuMi);
		
		old_Password = new JPasswordField();
		old_Password.setBounds(173, 325, 290, 31);
		ChangeInfo.add(old_Password);
		
		new_Password = new JPasswordField();
		new_Password.setBounds(173, 381, 290, 31);
		ChangeInfo.add(new_Password);
		
		JButton btnLuThayi = new JButton("Lưu thay đổi");
		btnLuThayi.setForeground(new Color(255, 255, 255));
		btnLuThayi.setBackground(new Color(30, 144, 255));
		btnLuThayi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuThayi.setBounds(248, 423, 141, 31);
		ChangeInfo.add(btnLuThayi);
		

		
		JPanel About = new JPanel();
		DisplayCard.add(About, "name_1640839116004");
		About.setBackground(Color.WHITE);
		About.setLayout(null);
		
		JLabel lbiNameProgram = new JLabel("ICT FLASHCARD");
		lbiNameProgram.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbiNameProgram.setHorizontalAlignment(SwingConstants.CENTER);
		lbiNameProgram.setBounds(0, 23, 618, 25);
		About.add(lbiNameProgram);
		
		JLabel lbConsNVA = new JLabel("Nguyễn Việt Anh");
		lbConsNVA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbConsNVA.setHorizontalAlignment(SwingConstants.CENTER);
		lbConsNVA.setBounds(75, 336, 123, 25);
		About.add(lbConsNVA);
		
		JLabel lbConsTTT = new JLabel("Trần Thị Thoa");
		lbConsTTT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbConsTTT.setHorizontalAlignment(SwingConstants.CENTER);
		lbConsTTT.setBounds(224, 336, 174, 25);
		About.add(lbConsTTT);
		
		JLabel lbConsBTPA = new JLabel("Bùi Thị Phương Anh");
		lbConsBTPA.setHorizontalAlignment(SwingConstants.CENTER);
		lbConsBTPA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbConsBTPA.setBounds(408, 336, 143, 25);
		About.add(lbConsBTPA);
		
		JLabel lbConsTVH = new JLabel("Trần Vũ Hải");
		lbConsTVH.setHorizontalAlignment(SwingConstants.CENTER);
		lbConsTVH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbConsTVH.setBounds(161, 425, 135, 25);
		About.add(lbConsTVH);
		
		JLabel lbConsPNKP = new JLabel("Phạm Nguyên Khánh Phong");
		lbConsPNKP.setHorizontalAlignment(SwingConstants.CENTER);
		lbConsPNKP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbConsPNKP.setBounds(306, 425, 217, 25);
		About.add(lbConsPNKP);
		
		JLabel iconNVA = new JLabel("");
		iconNVA.setHorizontalAlignment(SwingConstants.CENTER);
		iconNVA.setIcon(new ImageIcon(Dashboard.class.getResource("/images/Webp.net-resizeimage.png")));
		iconNVA.setBounds(90, 260, 96, 77);
		About.add(iconNVA);
		
		JLabel iconTTT = new JLabel("");
		iconTTT.setIcon(new ImageIcon(Dashboard.class.getResource("/images/Webp.net-resizeimage (1).png")));
		iconTTT.setHorizontalAlignment(SwingConstants.CENTER);
		iconTTT.setBounds(263, 260, 96, 77);
		About.add(iconTTT);
		
		JLabel iconBTPA = new JLabel("");
		iconBTPA.setIcon(new ImageIcon(Dashboard.class.getResource("/images/Webp.net-resizeimage (2).png")));
		iconBTPA.setHorizontalAlignment(SwingConstants.CENTER);
		iconBTPA.setBounds(428, 260, 96, 77);
		About.add(iconBTPA);
		
		JLabel iconTVH = new JLabel("");
		iconTVH.setIcon(new ImageIcon(Dashboard.class.getResource("/images/Webp.net-resizeimage (3).png")));
		iconTVH.setHorizontalAlignment(SwingConstants.CENTER);
		iconTVH.setBounds(182, 348, 96, 77);
		About.add(iconTVH);
		
		JLabel iconPNKP = new JLabel("");
		iconPNKP.setIcon(new ImageIcon(Dashboard.class.getResource("/images/Webp.net-resizeimage (4).png")));
		iconPNKP.setHorizontalAlignment(SwingConstants.CENTER);
		iconPNKP.setBounds(354, 348, 96, 77);
		About.add(iconPNKP);
		
		JTextPane textPaneDescription = new JTextPane();
		textPaneDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPaneDescription.setText("Flash card by ICT K60 is a method that combining English word and a corresponding image to help people remembering words more easily and having fun with learning English.");
		textPaneDescription.setBounds(56, 52, 532, 57);
		About.add(textPaneDescription);
		
		JLabel lblMain = new JLabel("Main feature");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMain.setBounds(0, 108, 618, 30);
		About.add(lblMain);
		
		JTextPane txtpnVisualizeFlashcardsFlashcard = new JTextPane();
		txtpnVisualizeFlashcardsFlashcard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnVisualizeFlashcardsFlashcard.setText("- Visualize flashcards, Flashcard collections on the computer screen so that people can use to learning without buying their paper collections.");
		txtpnVisualizeFlashcardsFlashcard.setBounds(56, 137, 532, 42);
		About.add(txtpnVisualizeFlashcardsFlashcard);
		
		JTextPane txtpnBeAbleTo = new JTextPane();
		txtpnBeAbleTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnBeAbleTo.setText("- Be able to use in multiple platform (firstly on web and PC application) to learn every where.");
		txtpnBeAbleTo.setBounds(56, 179, 532, 42);
		About.add(txtpnBeAbleTo);
		
		JTextPane txtpnHelpPeopleIn = new JTextPane();
		txtpnHelpPeopleIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnHelpPeopleIn.setText("- Help people in using available Flashcard collections, creating/editing their own collections.");
		txtpnHelpPeopleIn.setBounds(56, 218, 532, 48);
		About.add(txtpnHelpPeopleIn);
		//Description.setLineWrap();
		
		
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setColor(btnHome);
				indHome.setOpaque(true);
				resetColor(btnAccount, indAccount);
				resetColor(btnAbout, indAbout);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DisplayCard.removeAll();
				DisplayCard.add(Home);
				DisplayCard.repaint();
				DisplayCard.revalidate();
			}
		});
		
		btnAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setColor(btnAccount);
				indAccount.setOpaque(true);
				resetColor(btnHome, indHome);
				resetColor(btnAbout, indAbout);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				DisplayCard.removeAll();
				DisplayCard.add(Account);
				DisplayCard.repaint();
				DisplayCard.revalidate();
			}
		});
		
		btnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setColor(btnAbout);
				indAbout.setOpaque(true);
				resetColor(btnAccount, indAccount);
				resetColor(btnHome, indHome);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				DisplayCard.removeAll();
				DisplayCard.add(About);
				DisplayCard.repaint();
				DisplayCard.revalidate();
			}
		});
		
		btnEditProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DisplayCard.removeAll();
				DisplayCard.add(ChangeInfo);
				DisplayCard.repaint();
				DisplayCard.revalidate();
				
			}
		});
		
		btnLuThayi.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				String fullname, bio, email, oldPassword, newPassword;
				fullname = new_fname.getText();
				bio = new_bio.getText();
				email = new_email.getText();
				oldPassword = old_Password.toString();
				newPassword = new_Password.toString();
				Network api = new Network();
				Success check;
				Profile newUserInfor = new Profile();
				newUserInfor.setBio(bio);
				newUserInfor.setEmail(email);
				newUserInfor.setFullname(fullname);
				newUserInfor.setNewPassword(newPassword);
				try {
					check = api.updateUserInfor(User.getUser().getUsername(), User.getUser().getToken(), oldPassword, newUserInfor);
					if(check.getSuccess().equals("true")) {
						JOptionPane.showMessageDialog(null, "Cập nhật thông tin thành công!!");
						User.getUser().setBio(bio);
						User.getUser().setEmail(email);
						User.getUser().setFullname(fullname);
						if(newPassword != null) {
							User.getUser().setPassword(newPassword);
						}
						DisplayCard.removeAll();
						DisplayCard.add(Account);
						DisplayCard.repaint();
						DisplayCard.revalidate();
					} else {
						JOptionPane.showMessageDialog(null, "Xảy ra lỗi trong quá trình cập nhật!!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		setUndecorated(true);
		
	}
}
