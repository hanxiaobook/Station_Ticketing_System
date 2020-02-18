package ssts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Buy extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Buy(String tno, int type, int c,String userid) {
		setDefaultCloseOperation(2);
		setBounds(100, 100, 436, 452);
		setTitle("购买车票");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8BF7\u586B\u5199\u60A8\u7684\u4FE1\u606F\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 153, 30);
		contentPane.add(lblNewLabel);

		JButton button = new JButton("\u786E\u8BA4");

		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(82, 357, 94, 30);
		contentPane.add(button);

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.buy.dispose();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(251, 357, 94, 30);
		contentPane.add(button_1);

		JLabel label = new JLabel("\u59D3    \u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(36, 54, 110, 28);
		contentPane.add(label);

		JLabel lblNewLabel_1 = new JLabel("\u8BC1 \u4EF6 \u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(36, 92, 110, 28);
		contentPane.add(lblNewLabel_1);

		JLabel label_1 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(36, 130, 110, 28);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u8F66 \u6B21 \u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(36, 168, 110, 28);
		contentPane.add(label_2);

		JLabel lblNewLabel_2 = new JLabel("\u5EA7\u4F4D\u7C7B\u578B\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(36, 244, 110, 28);
		contentPane.add(lblNewLabel_2);

		JLabel label_3 = new JLabel("\u8F66\u7968\u7C7B\u578B\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(36, 206, 110, 28);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u6570\u91CF\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		label_4.setBounds(36, 282, 110, 28);
		contentPane.add(label_4);

		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField.setBounds(141, 50, 191, 31);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_1.setBounds(141, 91, 191, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_2.setBounds(141, 130, 191, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_3.setEditable(false);
		textField_3.setBounds(141, 168, 191, 31);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setText("1");
		textField_6.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_6.setEditable(false);
		textField_6.setBounds(141, 283, 191, 31);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "\u5546\u52A1\u5EA7", "\u4E00\u7B49\u5EA7", "\u4E8C\u7B49\u5EA7" }));
		comboBox.setBounds(141, 245, 191, 31);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "\u4E2A\u4EBA\u7968", "\u56E2\u4F53\u7968" }));
		comboBox_1.setBounds(141, 206, 191, 31);
		contentPane.add(comboBox_1);
		// comboBox_1.setSelectedIndex(1);

		Connection conn = Main.Connect();
		PreparedStatement stat;
		ResultSet ret;
		ResultSetMetaData rsmt;
		try {
			stat = conn.prepareStatement("select * from [user] where userid= ? ");
			stat.setString(1, userid);
			ret = stat.executeQuery();
			ret.next();
			textField_1.setText(ret.getString(5));
			textField_1.setEditable(false);
//			System.out.print(ret.getString(5));
			stat.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		if (c == -1) {
			textField_3.setEditable(true);
			comboBox.setSelectedIndex(1);
			textField_6.setEditable(true);
			comboBox_1.setSelectedIndex(type);
			if (type == 0) {
				textField_6.setText("1");
			} else {
				textField_6.setText("");
			}
		} else {
			
			textField_3.setText(tno);
			comboBox_1.setSelectedIndex(type);
			// textField_6.setText("1");
			if (type == 0) {
				textField_6.setText("1");
			} else {
				textField_6.setText("");
				textField_6.setEditable(true);
			}
		}
		button.addActionListener(new ActionListener() { // 确定按钮
			public void actionPerformed(ActionEvent arg0) {
				String pname = textField.getText();
				String idno = textField_1.getText();
				String phone = textField_2.getText();
				String tno = textField_3.getText();
				String seat = (String) comboBox.getSelectedItem();
				String ssnum = textField_6.getText();
				int snum = 0;
				int sno = 0;
				if ((pname.equals("")) || (idno.equals("")) || (phone.equals("")) || (tno.equals(""))
						|| (ssnum.equals(""))) {

				} else {
					try {
						snum = Integer.parseInt(ssnum);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
					if (snum == 0) {

					} else {

						Vector data = new Vector();
						Vector name = new Vector();
						data.clear();
						name.clear();
						Connection conn = Main.Connect();
						PreparedStatement stat;
						ResultSet ret;
						ResultSetMetaData rsmt;
						try {
							stat = conn.prepareStatement("select * from train where tno= ? ");
							stat.setString(1, tno);
							ret = stat.executeQuery();
							// while (ret.next()) {
							// for (int i = 1; i <= 8; i++) {
							// System.out.print(ret.getString(i).trim() + " ");
							// }
							// System.out.println(" ");
							// }
							// Thread.sleep(10);
							if (seat.equals("商务座")) {
								ret.next();
								sno = 101 - ret.getInt(6);
							} else if (seat.equals("一等座")) {
								ret.next();
								sno = 101 - ret.getInt(7);
							} else if (seat.equals("二等座")) {
								ret.next();
								sno = 101 - ret.getInt(8);
							}
//							System.out.print(sno);
							stat = conn.prepareStatement("insert into passenger values(?,?,?,?,?,?,?)");
							stat.setString(1, pname);
							stat.setString(2, idno);
							stat.setString(3, phone);
							stat.setString(4, tno);
							stat.setString(5, String.valueOf(type));
							stat.setString(6, seat);
							stat.setString(7, String.valueOf(sno));
							stat.execute();
							JOptionPane.showMessageDialog(null, "购票成功！");
							Main.buy.dispose();
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}
			}
		});
	}
}
