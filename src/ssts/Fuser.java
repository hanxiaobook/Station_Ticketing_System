package ssts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;

public class Fuser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String userid;
	private String password;
	private String level;
	private String username;
	private String idno;
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// Fuser frame = new Fuser();
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
	public Fuser(int r, JTable table) {
		setDefaultCloseOperation(2);
		setBounds(100, 100, 324, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setBounds(128, 41, 137, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_1.setBounds(128, 81, 137, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_2.setBounds(128, 161, 137, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_3.setBounds(128, 201, 137, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(44, 43, 74, 21);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(44, 85, 74, 21);
		contentPane.add(lblNewLabel_1);

		JLabel label = new JLabel("\u7EA7  \u522B\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(44, 123, 74, 21);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u59D3  \u540D:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(44, 163, 74, 21);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u8BC1\u4EF6\u53F7:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(44, 203, 74, 21);
		contentPane.add(label_2);

		JButton button = new JButton("\u786E\u5B9A");

		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(24, 321, 111, 39);
		contentPane.add(button);

		JButton button_1 = new JButton("\u53D6\u6D88");

		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(163, 321, 111, 39);
		contentPane.add(button_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "admin", "passenger" }));
		comboBox.setBounds(128, 121, 137, 30);
		contentPane.add(comboBox);

		if (r >= 0) {
			textField.setText((String) table.getModel().getValueAt(r, 0));
			textField_1.setText((String) table.getModel().getValueAt(r, 1));
			if (comboBox.getSelectedItem().toString().equals("admin")) {
				comboBox.setSelectedIndex(0);
			} else {
				comboBox.setSelectedIndex(1);
			}

			textField_2.setText((String) table.getModel().getValueAt(r, 3));
			textField_3.setText((String) table.getModel().getValueAt(r, 4));

		}

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (r < 0) {
					userid = textField.getText();
					password = textField_1.getText();
					level = (String) comboBox.getSelectedItem();
					username = textField_2.getText();
					idno = textField_3.getText();
					if ((!userid.equals("")) && (!password.equals("")) && (!idno.equals(""))) {
						Connection conn = Main.Connect();
						PreparedStatement stat;
						ResultSet ret;
						ResultSetMetaData rsmt;
						try {
							//
							stat = conn.prepareStatement("insert into [user] values( ? , ? , ? , ? , ? )");
							stat.setString(1, userid);
							stat.setString(2, password);
							stat.setString(3, level);
							stat.setString(4, username);
							stat.setString(5, idno);
							stat.execute();
							JOptionPane.showMessageDialog(null, "添加用户成功！");
							Main.fuser.dispose();
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "请添加完整数据！");
					}
				}else {
					userid = textField.getText();
					password = textField_1.getText();
					level = (String) comboBox.getSelectedItem();
					username = textField_2.getText();
					idno = textField_3.getText();
					if ((!userid.equals("")) && (!password.equals("")) && (!idno.equals(""))) {
						Connection conn = Main.Connect();
						PreparedStatement stat;
						ResultSet ret;
						ResultSetMetaData rsmt;
						try {
							//
							String key=(String) table.getModel().getValueAt(r, 0);
							stat = conn.prepareStatement("update [user] set userid = ? , password = ? ,[level] = ? , username = ? ,idno = ? where userid = ?");
							stat.setString(1, userid);
							stat.setString(2, password);
							stat.setString(3, level);
							stat.setString(4, username);
							stat.setString(5, idno);
							stat.setString(6, key);
							stat.execute();
							JOptionPane.showMessageDialog(null, "修改成功！");
							Main.fuser.dispose();
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
				Main.fuser.dispose();
			}
		});
	}
}
