package ssts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;

public class Fregister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton button;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Fregister() {
		setDefaultCloseOperation(2);
		setBounds(100, 100, 324, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u7528 \u6237 \u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(34, 17, 101, 31);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u5BC6    \u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(34, 65, 101, 31);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(34, 113, 101, 31);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u59D3    \u540D\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(34, 161, 101, 31);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u8BC1 \u4EF6 \u53F7\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		label_4.setBounds(34, 209, 101, 31);
		contentPane.add(label_4);

		textField = new JTextField();
		textField.setBounds(137, 17, 133, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(137, 65, 133, 29);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(137, 113, 133, 29);
		contentPane.add(passwordField_1);

		textField_1 = new JTextField();
		textField_1.setBounds(137, 161, 133, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(137, 209, 133, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		button = new JButton("\u6CE8\u518C");

		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(36, 287, 97, 36);
		contentPane.add(button);

		button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.fregister.dispose();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(180, 287, 97, 36);
		contentPane.add(button_1);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userid = textField.getText();
				String password = passwordField.getText();
				String cpassword = passwordField.getText();
				String username = textField_1.getText();
				String idno = textField_2.getText();
				if ((!userid.equals("")) && (!idno.equals("")) && (!password.equals(""))) {
					if (password.equals(cpassword)) {
						Connection conn = Main.Connect();
						PreparedStatement stat;
						ResultSet ret;
						ResultSetMetaData rsmt;
						try {
							stat = conn.prepareStatement("insert into [user] values( ? , ? , 'passenger' , ? , ? )");
							stat.setString(1, userid);
							stat.setString(2, password);
							stat.setString(3, username);
							stat.setString(4, idno);
							stat.execute();
							JOptionPane.showMessageDialog(null, "注册成功！");
							Main.fregister.dispose();
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "两次输入密码不一致！");
					}
				} else {
					JOptionPane.showMessageDialog(null, "请输入完整信息！");
				}

			}
		});
	}
}
