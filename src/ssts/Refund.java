package ssts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Refund extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Vector data = new Vector();
	Vector name = new Vector();
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	//// Refund frame = new Refund();
	//// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public Refund(JTable trefund) {
		setDefaultCloseOperation(2);
		setBounds(100, 100, 850, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 55, 800, 118);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u8981\u9000\u6B3E\u7684\u8F66\u7968\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(15, 11, 197, 30);
		contentPane.add(label);

		JButton button = new JButton("\u9000\u6B3E");

		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(236, 211, 104, 40);
		contentPane.add(button);

		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.refund.dispose();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(447, 211, 104, 40);
		contentPane.add(button_1);

		scrollPane.setViewportView(trefund);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int r = trefund.getSelectedRow();
				System.out.print(r);
				if (r >= 0) {
					String idno = trefund.getValueAt(r, 1).toString();
//					System.out.print(r);
					data.clear();
					name.clear();
					Connection conn = Main.Connect();
					PreparedStatement stat;
					ResultSet ret;
					ResultSetMetaData rsmt;
					try {
						//
						stat = conn.prepareStatement("delete from passenger where idno= ? ");
						stat.setString(1, idno);
						stat.execute();

						JOptionPane.showMessageDialog(null, "退票成功");
						Main.refund.dispose();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "请选择一张车票！");
				}
			}
		});
	}

}
