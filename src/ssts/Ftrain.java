package ssts;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ftrain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel label_5;
	private JButton button_1;
	private String tno;
	private String sstation;
	private String terminus;
	private String stime;
	private String ttime;
	private int bs;
	private int fs;
	private int ss;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// Ftrain frame = new Ftrain();
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
	public Ftrain(int r, JTable table) {
		setDefaultCloseOperation(2);
		setBounds(100, 100, 388, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(128, 41, 74, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(128, 81, 74, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(248, 81, 74, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(128, 121, 74, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(248, 121, 74, 30);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u8F66\u6B21\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(44, 43, 74, 21);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u7AD9  \u70B9\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(44, 85, 74, 21);
		contentPane.add(lblNewLabel_1);

		JLabel label = new JLabel("\u65F6  \u95F4\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(44, 123, 74, 21);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u5546\u52A1\u5EA7:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(44, 163, 74, 21);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u4E00\u7B49\u5EA7:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(44, 203, 74, 21);
		contentPane.add(label_2);

		JButton button = new JButton("\u786E\u5B9A");
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(44, 324, 112, 39);
		contentPane.add(button);

		JLabel label_3 = new JLabel("\u81F3");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(212, 84, 28, 22);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u4E8C\u7B49\u5EA7\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		label_4.setBounds(44, 241, 74, 21);
		contentPane.add(label_4);

		textField_5 = new JTextField();
		textField_5.setBounds(128, 161, 74, 30);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(128, 201, 74, 30);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(128, 239, 74, 30);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		label_5 = new JLabel("\u81F3");
		label_5.setFont(new Font("宋体", Font.PLAIN, 18));
		label_5.setBounds(212, 128, 28, 22);
		contentPane.add(label_5);

		button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(210, 324, 112, 39);
		contentPane.add(button_1);

		if (r >= 0) {
			textField.setText((String) table.getModel().getValueAt(r, 0));
			textField_1.setText((String) table.getModel().getValueAt(r, 1));
			textField_2.setText((String) table.getModel().getValueAt(r, 2));
			textField_3.setText((String) table.getModel().getValueAt(r, 3));
			textField_4.setText((String) table.getModel().getValueAt(r, 4));
			textField_5.setText((String) table.getModel().getValueAt(r, 5));
			textField_6.setText((String) table.getModel().getValueAt(r, 6));
			textField_7.setText((String) table.getModel().getValueAt(r, 7));
		}

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (r < 0) {
					tno = textField.getText();
					sstation = textField_1.getText();
					terminus = textField_2.getText();
					stime = textField_3.getText();
					ttime = textField_4.getText();
					bs = Integer.parseInt(textField_5.getText());
					fs = Integer.parseInt(textField_6.getText());
					ss = Integer.parseInt(textField_7.getText());
					if ((!tno.equals("")) && (!textField_5.getText().equals("")) && (!textField_6.getText().equals(""))
							&& (!textField_7.getText().equals(""))) {
						Connection conn = Main.Connect();
						PreparedStatement stat;
						ResultSet ret;
						ResultSetMetaData rsmt;
						try {
							//
							stat = conn.prepareStatement("insert into train values( ? , ? , ? , ? , ? , ? , ? , ? )");
							stat.setString(1, tno);
							stat.setString(2, sstation);
							stat.setString(3, terminus);
							stat.setString(4, stime);
							stat.setString(5, ttime);
							stat.setInt(6, bs);
							stat.setInt(7, fs);
							stat.setInt(8, ss);
							stat.execute();
							JOptionPane.showMessageDialog(null, "添加车次成功！");
							Main.ftrain.dispose();
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "请添加完整数据！");
					}
				}
				else {
					tno = textField.getText();
					sstation = textField_1.getText();
					terminus = textField_2.getText();
					stime = textField_3.getText();
					ttime = textField_4.getText();
					bs = Integer.parseInt(textField_5.getText());
					fs = Integer.parseInt(textField_6.getText());
					ss = Integer.parseInt(textField_7.getText());
					if ((!tno.equals("")) && (!textField_5.getText().equals("")) && (!textField_6.getText().equals(""))
							&& (!textField_7.getText().equals(""))) {
						Connection conn = Main.Connect();
						PreparedStatement stat;
						ResultSet ret;
						ResultSetMetaData rsmt;
						try {
							//
							String key=(String) table.getModel().getValueAt(r, 0);
							stat = conn.prepareStatement("update train set tno = ? , sstation = ? , terminus = ? , stime = ? , ttime = ? , bcseat = ? , fcseat = ? , scseat = ? where tno = ?");
							stat.setString(1, tno);
							stat.setString(2, sstation);
							stat.setString(3, terminus);
							stat.setString(4, stime);
							stat.setString(5, ttime);
							stat.setInt(6, bs);
							stat.setInt(7, fs);
							stat.setInt(8, ss);
							stat.setString(9, key);
							stat.execute();
							JOptionPane.showMessageDialog(null, "修改车次成功！");
							Main.ftrain.dispose();
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
				Main.ftrain.dispose();
			}
		});
	}

}
