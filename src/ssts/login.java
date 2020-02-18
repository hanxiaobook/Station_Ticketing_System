package ssts;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel.setBounds(78, 47, 99, 34);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("\u5BC6  \u7801\uFF1A");
		label.setFont(new Font("黑体", Font.PLAIN, 20));
		label.setBounds(78, 111, 99, 34);
		contentPane.add(label);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));
		passwordField.setBounds(187, 114, 178, 34);
		contentPane.add(passwordField);

		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField.setBounds(187, 50, 178, 34);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String userid = textField.getText();
				String password = passwordField.getText();
				if (userid.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入完整信息！");
				} else {
					// System.out.print(userid+"\n");
					// System.out.print(password+"\n");

					String checkid = null;
					String checkpw = null;
					String level = null;
					if (userid != null) {
						Connection conn = null;
						Statement stat;
						ResultSet ret;
						String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
						String url = "jdbc:sqlserver://localhost:1433;DatabaseName=SSTS";
						String user = "sa";
						String passwd = "123456";
						try {
							Class.forName(driver);
							conn = DriverManager.getConnection(url, user, passwd);
						} catch (Exception e) {
							e.printStackTrace();
						}

						try {
							stat = conn.createStatement();
							ret = stat.executeQuery("select * from [user] where userid='" + userid + "'");
							if (ret != null) {
								ret.next();
								checkid = ret.getString(1).trim();
								checkpw = ret.getString(2).trim();

								// System.out.print(checkid+"\n");
								// System.out.print(checkpw+"\n");

								if (userid.equals(checkid) && password.equals(checkpw)) {
									level = ret.getString(3).trim();
									// System.out.print(level);
									if (level.equals("admin")) {
										// 跳转到admin界面
										EventQueue.invokeLater(new Runnable() {
											public void run() {
												try {
													Main.fadmin = new Fadmin();
													Main.fadmin.setVisible(true);
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
										});
										Main.login.dispose();
									} else {
										// 跳转到passenger界面
										EventQueue.invokeLater(new Runnable() {
											public void run() {
												try {
													Main.passenger = new passenger(userid, password);
													Main.passenger.setVisible(true);
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
										});
										Main.login.dispose();
									}
								} else {
									// 检查用户名和密码！！
									// System.out.print("error");
									JOptionPane.showMessageDialog(null, "账户或密码错误，请重新输入！");
								}
							} else {

							}

						} catch (SQLException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(159, 191, 139, 44);
		contentPane.add(button);

		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(308, 191, 139, 44);
		contentPane.add(button_1);

		JButton button_2 = new JButton("\u6CE8\u518C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main.fregister = new Fregister();
							Main.fregister.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		button_2.setBounds(10, 191, 139, 44);
		contentPane.add(button_2);
	}
}
