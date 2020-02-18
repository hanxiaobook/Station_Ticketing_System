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
import javax.swing.JButton;

public class Fprice extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String tno;
	private int bp;
	private int fp;
	private int sp;
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// Fprice frame = new Fprice();
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
	public Fprice(int r, JTable table) {
		setDefaultCloseOperation(2);
		setBounds(100, 100, 376, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u8F66  \u6B21  \u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(55, 29, 120, 29);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u5546\u52A1\u5EA7\u4EF7\u683C\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(55, 87, 110, 29);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u4E00\u7B49\u5EA7\u4EF7\u683C\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(55, 145, 110, 29);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u4E8C\u7B49\u5EA7\u4EF7\u683C\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(55, 203, 110, 29);
		contentPane.add(label_3);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setBounds(185, 29, 94, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_1.setBounds(185, 86, 94, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_2.setBounds(185, 143, 94, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_3.setBounds(185, 200, 94, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton button = new JButton("\u786E\u5B9A");
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(55, 284, 97, 36);
		contentPane.add(button);

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(207, 284, 97, 36);
		contentPane.add(button_1);

		if (r >= 0) {
			textField.setText((String) table.getModel().getValueAt(r, 0));
			textField_1.setText((String) table.getModel().getValueAt(r, 1));
			textField_2.setText((String) table.getModel().getValueAt(r, 3));
			textField_3.setText((String) table.getModel().getValueAt(r, 3));
		}
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (r < 0) {
					tno = textField.getText();
					bp = Integer.parseInt(textField_1.getText());
					fp = Integer.parseInt(textField_2.getText());
					sp = Integer.parseInt(textField_3.getText());
					if ((!tno.equals("")) && (!textField_1.getText().equals("")) && (!textField_2.getText().equals(""))
							&& (!textField_3.getText().equals(""))) {
						Connection conn = Main.Connect();
						PreparedStatement stat;
						ResultSet ret;
						ResultSetMetaData rsmt;
						try {
							//
							stat = conn.prepareStatement("insert into price values( ? , ? , ? , ? )");
							stat.setString(1, tno);
							stat.setInt(2, bp);
							stat.setInt(3, fp);
							stat.setInt(4, sp);
							stat.execute();
							JOptionPane.showMessageDialog(null, "添加票价成功！");
							Main.fprice.dispose();
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
					bp = Integer.parseInt(textField_1.getText());
					fp = Integer.parseInt(textField_2.getText());
					sp = Integer.parseInt(textField_3.getText());
					if ((!tno.equals("")) && (!textField_1.getText().equals("")) && (!textField_2.getText().equals(""))
							&& (!textField_3.getText().equals(""))) {
						Connection conn = Main.Connect();
						PreparedStatement stat;
						ResultSet ret;
						ResultSetMetaData rsmt;
						try {
							//
							String key=(String) table.getModel().getValueAt(r, 0);
							stat = conn.prepareStatement("update price set tno = ? , pbcseat = ? , pfcseat = ? , pscseat = ?  where tno = ? ");
							stat.setString(1, tno);
							stat.setInt(2, bp);
							stat.setInt(3, fp);
							stat.setInt(4, sp);
							stat.setString(5, key);
							stat.execute();
							JOptionPane.showMessageDialog(null, "修改票价成功！");
							Main.fprice.dispose();
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
				Main.fprice.dispose();
			}
		});
	}

}
