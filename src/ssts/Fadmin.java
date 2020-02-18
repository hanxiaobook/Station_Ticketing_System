package ssts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JMenu;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Fadmin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private CardLayout card = null;
	Vector data = new Vector();
	Vector name = new Vector();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Fadmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1196, 596);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("\u5207\u6362\u8868");
		menuBar.add(menu);
		JMenuItem usert = new JMenuItem("用户表");
		JMenuItem traint = new JMenuItem("车次表");
		JMenuItem passengert = new JMenuItem("乘客表");
		JMenuItem recordt = new JMenuItem("订单表");
		JMenuItem pricet = new JMenuItem("价格表");
		JMenuItem exitt = new JMenuItem("退出账号");
		menu.add(usert);
		menu.add(traint);
		menu.add(passengert);
		menu.add(recordt);
		menu.add(pricet);
		menu.addSeparator();
		menu.add(exitt);

		exitt.addActionListener(new ActionListener() { // 退出菜单触发器
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main.login = new login();
							Main.login.setVisible(true);
							Main.fadmin.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		card = new CardLayout(5, 5);
		contentPane = new JPanel(card);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, "userp");

		panel.setLayout(null);

		JButton button = new JButton("\u67E5\u8BE2");

		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(1000, 50, 114, 34);
		panel.add(button);

		JButton button_1 = new JButton("\u65B0\u5EFA\u7528\u6237");

		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(1000, 160, 114, 34);
		panel.add(button_1);

		JButton button_2 = new JButton("\u4FEE\u6539\u4FE1\u606F");

		button_2.setFont(new Font("宋体", Font.PLAIN, 18));
		button_2.setBounds(1000, 270, 114, 34);
		panel.add(button_2);

		JButton button_3 = new JButton("\u5220\u9664\u7528\u6237");

		button_3.setFont(new Font("宋体", Font.PLAIN, 18));
		button_3.setBounds(1000, 380, 114, 34);
		panel.add(button_3);

		textField = new JTextField();
		textField.setBounds(277, 53, 127, 30);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(539, 55, 127, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(800, 55, 127, 30);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(200, 50, 67, 39);
		panel.add(label);

		JLabel label_1 = new JLabel("\u6635\u79F0=");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(477, 48, 58, 39);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u7B49\u7EA7=");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(741, 50, 67, 39);
		panel.add(label_2);

		JLabel lblAnd = new JLabel("and");
		lblAnd.setFont(new Font("宋体", Font.PLAIN, 18));
		lblAnd.setBounds(428, 60, 58, 15);
		panel.add(lblAnd);

		JLabel lblAnd_1 = new JLabel("and");
		lblAnd_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblAnd_1.setBounds(691, 60, 58, 15);
		panel.add(lblAnd_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 110, 920, 386);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "trainp");
		panel_1.setLayout(null);

		JButton button_4 = new JButton("\u67E5\u8BE2");

		button_4.setFont(new Font("宋体", Font.PLAIN, 18));
		button_4.setBounds(1000, 50, 114, 34);
		panel_1.add(button_4);

		JButton button_5 = new JButton("\u589E\u52A0\u8F66\u6B21");

		button_5.setFont(new Font("宋体", Font.PLAIN, 18));
		button_5.setBounds(1000, 160, 114, 34);
		panel_1.add(button_5);

		JButton button_6 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		
		button_6.setFont(new Font("宋体", Font.PLAIN, 18));
		button_6.setBounds(1000, 270, 114, 34);
		panel_1.add(button_6);

		JButton button_7 = new JButton("\u5220\u9664\u8F66\u6B21");

		button_7.setFont(new Font("宋体", Font.PLAIN, 18));
		button_7.setBounds(1000, 380, 114, 34);
		panel_1.add(button_7);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 110, 920, 386);
		panel_1.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		textField_3 = new JTextField();
		textField_3.setBounds(277, 53, 127, 30);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(539, 55, 127, 30);
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(800, 55, 127, 30);
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		JLabel label_3 = new JLabel("\u8F66\u6B21\u53F7=");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(200, 50, 67, 39);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("\u7AD9\u70B9=");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		label_4.setBounds(477, 48, 58, 39);
		panel_1.add(label_4);

		JLabel label_5 = new JLabel("\u65F6\u523B=");
		label_5.setFont(new Font("宋体", Font.PLAIN, 18));
		label_5.setBounds(741, 50, 67, 39);
		panel_1.add(label_5);

		JLabel lblAnd_2 = new JLabel("and");
		lblAnd_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblAnd_2.setBounds(428, 60, 58, 15);
		panel_1.add(lblAnd_2);

		JLabel lblAnd_3 = new JLabel("and");
		lblAnd_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblAnd_3.setBounds(691, 60, 58, 15);
		panel_1.add(lblAnd_3);
		
		JLabel label_14 = new JLabel("\u8F66\u8F86\u7BA1\u7406\u754C\u9762");
		label_14.setFont(new Font("宋体", Font.PLAIN, 20));
		label_14.setBounds(10, 10, 164, 34);
		panel_1.add(label_14);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, "passengerp");
		panel_2.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(30, 110, 920, 386);
		panel_2.add(scrollPane_2);

		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);

		JButton btnNewButton = new JButton("\u67E5\u8BE2");

		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(1000, 50, 114, 34);
		panel_2.add(btnNewButton);

		JButton button_8 = new JButton("\u589E\u52A0\u4E58\u5BA2");

		button_8.setFont(new Font("宋体", Font.PLAIN, 18));
		button_8.setBounds(1000, 160, 114, 34);
		panel_2.add(button_8);

		JButton button_9 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		
		button_9.setFont(new Font("宋体", Font.PLAIN, 18));
		button_9.setBounds(1000, 270, 114, 34);
		panel_2.add(button_9);

		JButton button_10 = new JButton("\u5220\u9664\u4E58\u5BA2");

		button_10.setFont(new Font("宋体", Font.PLAIN, 18));
		button_10.setBounds(1000, 380, 114, 34);
		panel_2.add(button_10);

		textField_6 = new JTextField();
		textField_6.setBounds(277, 53, 127, 30);
		panel_2.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(539, 55, 127, 30);
		panel_2.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(800, 55, 127, 30);
		panel_2.add(textField_8);
		textField_8.setColumns(10);

		JLabel label_6 = new JLabel("\u59D3\u540D=");
		label_6.setFont(new Font("宋体", Font.PLAIN, 18));
		label_6.setBounds(212, 48, 58, 39);
		panel_2.add(label_6);

		JLabel label_7 = new JLabel("\u8BC1\u4EF6\u53F7=");
		label_7.setFont(new Font("宋体", Font.PLAIN, 18));
		label_7.setBounds(468, 48, 67, 39);
		panel_2.add(label_7);

		JLabel label_8 = new JLabel("\u8F66\u6B21\u53F7=");
		label_8.setFont(new Font("宋体", Font.PLAIN, 18));
		label_8.setBounds(732, 48, 67, 39);
		panel_2.add(label_8);

		JLabel lblAnd_4 = new JLabel("and");
		lblAnd_4.setFont(new Font("宋体", Font.PLAIN, 18));
		lblAnd_4.setBounds(428, 60, 58, 15);
		panel_2.add(lblAnd_4);

		JLabel lblAnd_5 = new JLabel("and");
		lblAnd_5.setFont(new Font("宋体", Font.PLAIN, 18));
		lblAnd_5.setBounds(691, 60, 58, 15);
		panel_2.add(lblAnd_5);
		
		JLabel label_15 = new JLabel("\u4E58\u5BA2\u7BA1\u7406\u754C\u9762");
		label_15.setFont(new Font("宋体", Font.PLAIN, 20));
		label_15.setBounds(10, 10, 173, 34);
		panel_2.add(label_15);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, "recordp");
		panel_3.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(30, 110, 920, 386);
		panel_3.add(scrollPane_3);

		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);

		JButton button_11 = new JButton("\u67E5\u8BE2");

		button_11.setFont(new Font("宋体", Font.PLAIN, 18));
		button_11.setBounds(1000, 50, 114, 34);
		panel_3.add(button_11);

		JButton button_14 = new JButton("\u5220\u9664\u8BB0\u5F55");

		button_14.setFont(new Font("宋体", Font.PLAIN, 18));
		button_14.setBounds(1000, 380, 114, 34);
		panel_3.add(button_14);

		textField_10 = new JTextField();
		textField_10.setBounds(277, 53, 127, 30);
		panel_3.add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(539, 55, 127, 30);
		panel_3.add(textField_11);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setBounds(800, 55, 127, 30);
		panel_3.add(textField_12);
		textField_12.setColumns(10);

		JLabel label_10 = new JLabel("\u8BC1\u4EF6\u53F7=");
		label_10.setFont(new Font("宋体", Font.PLAIN, 18));
		label_10.setBounds(200, 50, 67, 39);
		panel_3.add(label_10);

		JLabel label_11 = new JLabel("\u8BA2\u5355\u53F7=");
		label_11.setFont(new Font("宋体", Font.PLAIN, 18));
		label_11.setBounds(469, 48, 67, 39);
		panel_3.add(label_11);

		JLabel label_12 = new JLabel("\u8F66\u6B21\u53F7=");
		label_12.setFont(new Font("宋体", Font.PLAIN, 18));
		label_12.setBounds(733, 48, 67, 39);
		panel_3.add(label_12);

		JLabel lblAnd_6 = new JLabel("and");
		lblAnd_6.setFont(new Font("宋体", Font.PLAIN, 18));
		lblAnd_6.setBounds(428, 60, 58, 15);
		panel_3.add(lblAnd_6);

		JLabel lblAnd_7 = new JLabel("and");
		lblAnd_7.setFont(new Font("宋体", Font.PLAIN, 18));
		lblAnd_7.setBounds(691, 60, 58, 15);
		panel_3.add(lblAnd_7);
		
		JLabel label_16 = new JLabel("\u8BA2\u5355\u67E5\u770B\u754C\u9762");
		label_16.setFont(new Font("宋体", Font.PLAIN, 20));
		label_16.setBounds(10, 10, 153, 34);
		panel_3.add(label_16);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, "pricep");
		panel_4.setLayout(null);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(30, 110, 920, 386);
		panel_4.add(scrollPane_4);

		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);

		JButton button_15 = new JButton("\u67E5\u8BE2");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_15.setFont(new Font("宋体", Font.PLAIN, 18));
		button_15.setBounds(1000, 50, 114, 34);
		panel_4.add(button_15);

		JButton button_16 = new JButton("\u589E\u52A0\u8F66\u6B21");

		button_16.setFont(new Font("宋体", Font.PLAIN, 18));
		button_16.setBounds(1000, 160, 114, 34);
		panel_4.add(button_16);

		JButton button_17 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		
		button_17.setFont(new Font("宋体", Font.PLAIN, 18));
		button_17.setBounds(1000, 270, 114, 34);
		panel_4.add(button_17);

		JButton button_18 = new JButton("\u5220\u9664\u8F66\u6B21");

		button_18.setFont(new Font("宋体", Font.PLAIN, 18));
		button_18.setBounds(1000, 380, 114, 34);
		panel_4.add(button_18);

		textField_9 = new JTextField();
		textField_9.setBounds(800, 55, 127, 30);
		panel_4.add(textField_9);
		textField_9.setColumns(10);

		JLabel label_9 = new JLabel("\u8F66\u6B21\u53F7=");
		label_9.setFont(new Font("宋体", Font.PLAIN, 18));
		label_9.setBounds(730, 48, 67, 39);
		panel_4.add(label_9);
		
		JLabel label_17 = new JLabel("\u7968\u4EF7\u7BA1\u7406\u754C\u9762");
		label_17.setFont(new Font("宋体", Font.PLAIN, 20));
		label_17.setBounds(10, 10, 192, 34);
		panel_4.add(label_17);

		card.show(contentPane, "userp");
		table = Main.selecttable(table, scrollPane, Main.userrowname, 5, "[user]");
		
		JLabel label_13 = new JLabel("\u7528\u6237\u7BA1\u7406\u754C\u9762");
		label_13.setFont(new Font("宋体", Font.PLAIN, 20));
		label_13.setBounds(10, 10, 166, 30);
		panel.add(label_13);

		/**
		 * panel的各个按键触发器
		 * 
		 */
		usert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane, "userp");
				table = Main.selecttable(table, scrollPane, Main.userrowname, 5, "[user]");

			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rn1 = "userid";
				String sw1 = textField.getText();
				String rn2 = "username";
				String sw2 = textField_1.getText();
				String rn3 = "[level]";
				String sw3 = textField_2.getText();
				table = Main.selecttable3(table, scrollPane, Main.userrowname, 5, "[user]", rn1, sw1, rn2, sw2, rn3,
						sw3);
			}
		});

		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int r = table.getSelectedRow();
				// System.out.print(r);
				if (r >= 0) {
					String sw = table.getValueAt(r, 0).toString();
					// System.out.print(sw);
					Main.deletetable(table, "[user]", "userid", sw, r);
					table = Main.selecttable(table, scrollPane, Main.userrowname, 5, "[user]");
					JOptionPane.showMessageDialog(null, "删除成功！");
				} else {
					JOptionPane.showMessageDialog(null, "请选择要删除的数据！");
				}
			}
		});

		button_1.addActionListener(new ActionListener() { // 添加
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main.fuser = new Fuser(-1,table);
							Main.fuser.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				});

			}
		});

		button_2.addActionListener(new ActionListener() { // 修改按钮
			public void actionPerformed(ActionEvent arg0) {
				int r = table.getSelectedRow();
				if (r >= 0) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Main.fuser = new Fuser(r,table);
								Main.fuser.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}

						}
					});
				}
				else {
					JOptionPane.showMessageDialog(null, "请选择要修改的用户！");
				}
			}
			
		});

		/**
		 * panel_1的各个按键触发器
		 * 
		 */
		traint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane, "trainp");
				table_1 = Main.selecttable(table_1, scrollPane_1, Main.trainrowname, 8, "train");

			}
		});
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// int r = table_2.getSelectedRow();
				// System.out.print(r);
				String rn1 = "tno";
				String sw1 = textField_3.getText();
				String rn2 = "sstation";
				String sw2 = textField_4.getText();
				String rn3 = "stime";
				String sw3 = textField_5.getText();
				table_1 = Main.selecttable3(table_1, scrollPane_1, Main.trainrowname, 8, "train", rn1, sw1, rn2, sw2,
						rn3, sw3);
			}
		});
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int r = table_1.getSelectedRow();
				if (r >= 0) {
					String sw = table_1.getValueAt(r, 0).toString();
					// System.out.print(sw);
					Main.deletetable(table_1, "train", "tno", sw, r);
					table_1 = Main.selecttable(table_1, scrollPane_1, Main.trainrowname, 8, "train");
					JOptionPane.showMessageDialog(null, "删除成功！");
				} else {
					JOptionPane.showMessageDialog(null, "请选择要删除的数据！");
				}
			}
		});

		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main.ftrain = new Ftrain(-1,table_1);
							Main.ftrain.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int r=table_1.getSelectedRow();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main.ftrain = new Ftrain(r,table_1);
							Main.ftrain.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		
		
		/**
		 * panel_2的各个按键触发器
		 * 
		 */
		passengert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane, "passengerp");
				table_2 = Main.selecttable(table_2, scrollPane_2, Main.passengerrowname, 7, "passenger");

			}
		});

		btnNewButton.addActionListener(new ActionListener() { // 查询
			public void actionPerformed(ActionEvent arg0) {
				// int r = table_2.getSelectedRow();
				// System.out.print(r);
				String rn1 = "name";
				String sw1 = textField_6.getText();
				String rn2 = "idno";
				String sw2 = textField_7.getText();
				String rn3 = "tno";
				String sw3 = textField_8.getText();
				table_2 = Main.selecttable3(table_2, scrollPane_2, Main.passengerrowname, 7, "passenger", rn1, sw1, rn2,
						sw2, rn3, sw3);
				// int r = Main.table.getSelectedRow();
				// System.out.print(r+"\n");
				// System.out.print(table_2);
			}
		});

		button_10.addActionListener(new ActionListener() { // 删除
			public void actionPerformed(ActionEvent arg0) {
				int r = table_2.getSelectedRow();
				// System.out.print(r+"\n");
				// System.out.print(table_2);
				if (r >= 0) {
					String sw = table_2.getValueAt(r, 1).toString();
					// System.out.print(sw);
					Main.deletetable(table_2, "passenger", "idno", sw, r);
					table_2 = Main.selecttable(table_2, scrollPane_2, Main.passengerrowname, 7, "passenger");
					JOptionPane.showMessageDialog(null, "删除成功！");
				} else {
					JOptionPane.showMessageDialog(null, "请选择要删除的数据！");
				}
			}
		});

		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main.fpassenger = new Fpassenger(-1,table_2);
							Main.fpassenger.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int r=table_2.getSelectedRow();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main.fpassenger = new Fpassenger(r,table_2);
							Main.fpassenger.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		
		
		
		/**
		 * panel_3的各个按键触发器
		 * 
		 */
		recordt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane, "recordp");
				table_3 = Main.selecttable(table_3, scrollPane_3, Main.recordrowname, 8, "record");
			}
		});

		button_11.addActionListener(new ActionListener() { // 查询按钮
			public void actionPerformed(ActionEvent arg0) {
				String rn1 = "idno";
				String sw1 = textField_10.getText();
				String rn2 = "rno";
				String sw2 = textField_11.getText();
				String rn3 = "tno";
				String sw3 = textField_12.getText();
				table_3 = Main.selecttable3(table_3, scrollPane_3, Main.recordrowname, 8, "record", rn1, sw1, rn2, sw2,
						rn3, sw3);
			}
		});

		button_14.addActionListener(new ActionListener() { // 删除
			public void actionPerformed(ActionEvent arg0) {
				int r = table_3.getSelectedRow();
				System.out.print(r);
				if (r >= 0) {
					String sw = table_3.getValueAt(r, 1).toString();
					// System.out.print(sw);
					Main.deletetable(table_3, "record", "idno", sw, r);
					table_3 = Main.selecttable(table_3, scrollPane_3, Main.recordrowname, 8, "record");
					JOptionPane.showMessageDialog(null, "删除成功！");
				} else {
					JOptionPane.showMessageDialog(null, "请选择要删除的数据！");
				}
			}
		});

		/**
		 * 
		 * panel_4的各个按键触发器
		 * 
		 */
		pricet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane, "pricep");
				table_4 = Main.selecttable(table_4, scrollPane_4, Main.pricerowname, 4, "price");
			}
		});

		button_15.addActionListener(new ActionListener() { // 查询按钮
			public void actionPerformed(ActionEvent arg0) {
				String sw = textField_9.getText().trim();
				if (sw.equals("")) {
					table_4 = Main.selecttable(table_4, scrollPane_4, Main.pricerowname, 4, "price");
				} else {
					table_4 = Main.selecttable1(table_4, scrollPane_4, Main.pricerowname, 4, "price", "tno", sw);
				}
			}
		});

		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int r = table_4.getSelectedRow();
				if (r >= 0) {
					String sw = table_4.getValueAt(r, 0).toString();
					// System.out.print(sw);
					Main.deletetable(table_4, "price", "tno", sw, r);
					table_4 = Main.selecttable(table_4, scrollPane_4, Main.pricerowname, 4, "price");
					JOptionPane.showMessageDialog(null, "删除成功！");
				} else {
					JOptionPane.showMessageDialog(null, "请选择要删除的数据！");
				}
			}
		});

		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main.fprice = new Fprice(-1,table_4);
							Main.fprice.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int r=table_4.getSelectedRow();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main.fprice = new Fprice(r,table_4);
							Main.fprice.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		
		

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

}
