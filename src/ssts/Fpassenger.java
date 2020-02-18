package ssts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Fpassenger extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String name;
	private String idno;
	private String phone;
	private String tno;
	private String type;
	private String seat;
	private String sno;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// Fpassenger frame = new Fpassenger();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public Fpassenger(int r, JTable table) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u59D3    \u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(60, 29, 98, 32);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u8BC1 \u4EF6 \u53F7\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(60, 71, 98, 32);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(60, 113, 98, 32);
		contentPane.add(label_2);

		JLabel lblNewLabel = new JLabel("\u8F66 \u6B21 \u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(60, 155, 98, 32);
		contentPane.add(lblNewLabel);

		JLabel label_3 = new JLabel("\u8F66\u7968\u7C7B\u578B\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(60, 197, 98, 32);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u5EA7\u4F4D\u7C7B\u578B\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		label_4.setBounds(60, 239, 98, 32);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("\u5EA7 \u4F4D \u53F7\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 18));
		label_5.setBounds(60, 281, 98, 32);
		contentPane.add(label_5);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setBounds(168, 33, 150, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_1.setBounds(168, 75, 150, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_2.setBounds(168, 117, 150, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_3.setBounds(168, 159, 150, 29);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "\u4E2A\u4EBA\u7968", "\u56E2\u4F53\u7968" }));
		comboBox.setBounds(168, 201, 150, 29);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "\u5546\u52A1\u5EA7", "\u4E00\u7B49\u5EA7", "\u4E8C\u7B49\u5EA7" }));
		comboBox_1.setBounds(168, 243, 150, 29);
		contentPane.add(comboBox_1);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_4.setBounds(168, 285, 150, 29);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JButton button = new JButton("\u786E\u5B9A");
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(60, 357, 97, 32);
		contentPane.add(button);

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(221, 357, 97, 32);
		contentPane.add(button_1);

		if (r >= 0) {
			textField.setText((String) table.getModel().getValueAt(r, 0));
			textField_1.setText((String) table.getModel().getValueAt(r, 1));
			textField_2.setText((String) table.getModel().getValueAt(r, 2));
			textField_3.setText((String) table.getModel().getValueAt(r, 3));
			if (comboBox.getSelectedItem().toString().equals("个人票")) {
				comboBox.setSelectedIndex(0);
			} else {
				comboBox.setSelectedIndex(1);
			}
			if (comboBox_1.getSelectedItem().toString().equals("商务座")) {
				comboBox_1.setSelectedIndex(0);
			} else if (comboBox_1.getSelectedItem().toString().equals("一等座")) {
				comboBox_1.setSelectedIndex(1);
			} else {
				comboBox_1.setSelectedIndex(2);
			}
			textField_4.setText((String) table.getModel().getValueAt(r, 6));
		}

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (r < 0) {
					name = textField.getText();
					idno = textField_1.getText();
					phone = textField_2.getText();
					tno = textField_3.getText();
					type = (String) comboBox.getSelectedItem();
					seat = (String) comboBox_1.getSelectedItem();
					sno = textField_4.getText();
					if ((!idno.equals("")) && (!tno.equals("")) && (!seat.equals(""))) {
						Connection conn = Main.Connect();
						PreparedStatement stat;
						ResultSet ret;
						ResultSetMetaData rsmt;
						try {
							//
							stat = conn.prepareStatement("insert into passenger values( ? , ? , ? , ? , ? , ? , ? )");
							stat.setString(1, name);
							stat.setString(2, idno);
							stat.setString(3, phone);
							stat.setString(4, tno);
							if (type.equals("个人票"))
								stat.setInt(5, 0);
							else
								stat.setInt(5, 1);
							stat.setString(6, seat);
							stat.setString(7, sno);
							stat.execute();
							JOptionPane.showMessageDialog(null, "添加乘客成功！");
							Main.fpassenger.dispose();
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "请添加完整数据！");
					}
				}
				else {
					name = textField.getText();
					idno = textField_1.getText();
					phone = textField_2.getText();
					tno = textField_3.getText();
					type = (String) comboBox.getSelectedItem();
					seat = (String) comboBox_1.getSelectedItem();
					sno = textField_4.getText();
					if ((!idno.equals("")) && (!tno.equals("")) && (!seat.equals(""))) {
						Connection conn = Main.Connect();
						PreparedStatement stat;
						ResultSet ret;
						ResultSetMetaData rsmt;
						try {
							//
							String key=(String) table.getModel().getValueAt(r, 1);
							stat = conn.prepareStatement("update passenger set name = ? , idno = ? , phone = ? , tno = ? , type = ? , seat = ? , sno = ?  where idno = ? ");
							stat.setString(1, name);
							stat.setString(2, idno);
							stat.setString(3, phone);
							stat.setString(4, tno);
							if (type.equals("个人票"))
								stat.setInt(5, 0);
							else
								stat.setInt(5, 1);
							stat.setString(6, seat);
							stat.setString(7, sno);
							stat.setString(8, key);
							stat.execute();
							JOptionPane.showMessageDialog(null, "修改乘客信息成功！");
							Main.fpassenger.dispose();
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "请添加完整数据！");
					}
				}
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.fpassenger.dispose();
			}
		});

	}
}
