package ssts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ItemEvent;

public class passenger extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable record;
	private JTable trefund;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Vector data = new Vector();
	Vector name = new Vector();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public passenger(String userid,String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 617);
		setTitle("普通用户界面");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("\u67E5\u8BE2");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(432, 56, 86, 33);
		contentPane.add(button);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "\u8F66  \u6B21", "\u7AD9  \u70B9", "\u65F6\u523B\u8868" }));
		comboBox.setBounds(137, 56, 97, 33);
		contentPane.add(comboBox);

		JLabel label = new JLabel("\u6211\u8981\u67E5\u8BE2\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(25, 56, 125, 33);
		contentPane.add(label);

		textField = new JTextField();
		textField.setBounds(260, 56, 134, 33);
		contentPane.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 138, 971, 421);
		contentPane.add(scrollPane);

		JButton button_1 = new JButton("\u8D2D\u7968");

		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(597, 10, 97, 44);
		contentPane.add(button_1);

		JButton button_2 = new JButton("\u9000\u7968");
		
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		button_2.setBounds(597, 64, 97, 44);
		contentPane.add(button_2);

		JRadioButton radioButton = new JRadioButton("\u4E2A\u4EBA");
		buttonGroup.add(radioButton);
		radioButton.setFont(new Font("宋体", Font.PLAIN, 18));
		radioButton.setBounds(788, 18, 63, 23);
		contentPane.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("\u56E2\u4F53");
		buttonGroup.add(radioButton_1);
		radioButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		radioButton_1.setBounds(869, 18, 63, 23);
		contentPane.add(radioButton_1);

		JLabel label_1 = new JLabel("\u4F5C\u4E3A\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(724, 16, 58, 26);
		contentPane.add(label_1);

		JButton button_3 = new JButton("\u8D2D\u7968\u8BB0\u5F55");
		
		button_3.setFont(new Font("宋体", Font.PLAIN, 20));
		button_3.setBounds(724, 64, 127, 44);
		contentPane.add(button_3);

		JButton button_4 = new JButton("\u9000\u51FA");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main.login = new login();
							Main.login.setVisible(true);
							Main.passenger.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		button_4.setFont(new Font("宋体", Font.PLAIN, 20));
		button_4.setBounds(876, 64, 103, 44);
		contentPane.add(button_4);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sc;
				sc = (String) comboBox.getSelectedItem();
				if (sc.equals("车  次")) { // 车次查询
					// System.out.print(1);
					data.clear();
					name.clear();
					Connection conn = Main.Connect();
					PreparedStatement stat;
					ResultSet ret;
					ResultSetMetaData rsmt;
					try {
						String sw = textField.getText();
						// System.out.print(sw);
						if (sw.equals("")) {
							stat = conn.prepareStatement("select * from train");
						} else {
							stat = conn.prepareStatement("select * from train where tno= ? ");
							stat.setString(1, sw);
						}
						ret = stat.executeQuery();
						// rsmt=ret.getMetaData();
						DefaultTableModel model = new DefaultTableModel(); // 新建一个默认数据模型
						table = new JTable(model);

						// Vector data=new Vector();
						// Vector name=new Vector();
						name.add("车次号");
						name.add("始发站");
						name.add("终点站");
						name.add("发车时间");
						name.add("到站时间");
						name.add("商务座席位");
						name.add("一等座席位");
						name.add("二等座席位");
						// for(int i=1;i<=8;i++) {
						// name.add(rsmt.getColumnName(i));
						// }
						while (ret.next()) {
							Vector row = new Vector();
							for (int i = 1; i <= 8; i++) {
								row.add(ret.getString(i).trim());
							}
							data.add(row);
						}
						model.setDataVector(data, name);
						scrollPane.setViewportView(table);
						// System.out.print(data);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				} else if (sc.equals("站  点")) { // 站点查询
					// System.out.print(2);
					data.clear();
					name.clear();
					Connection conn = Main.Connect();
					PreparedStatement stat;
					ResultSet ret;
					ResultSetMetaData rsmt;
					try {
						String sw = textField.getText();
						// System.out.print(sw);
						if (sw.equals("")) {
							stat = conn.prepareStatement("select * from train");
						} else {
							stat = conn.prepareStatement(
									"select * from train where sstation= ? OR terminus= ? ORDER BY sstation");
							stat.setString(1, sw);
							stat.setString(2, sw);
						}
						ret = stat.executeQuery();
						// rsmt=ret.getMetaData();
						DefaultTableModel model = new DefaultTableModel(); // 新建一个默认数据模型
						table = new JTable(model);

						// Vector data=new Vector();
						// Vector name=new Vector();
						name.add("车次号");
						name.add("始发站");
						name.add("终点站");
						name.add("发车时间");
						name.add("到站时间");
						name.add("商务座席位");
						name.add("一等座席位");
						name.add("二等座席位");
						// for(int i=1;i<=8;i++) {
						// name.add(rsmt.getColumnName(i));
						// }
						while (ret.next()) {
							Vector row = new Vector();
							for (int i = 1; i <= 8; i++) {
								row.add(ret.getString(i).trim());
							}
							data.add(row);
						}
						model.setDataVector(data, name);
						scrollPane.setViewportView(table);
						// System.out.print(data);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				} else if (sc.equals("时刻表")) { // 时间查询
					// System.out.print(3);
					data.clear();
					name.clear();
					Connection conn = Main.Connect();
					PreparedStatement stat;
					ResultSet ret;
					ResultSetMetaData rsmt;
					try {
						String sw = textField.getText();
						// System.out.print(sw);
						if (sw.equals("")) {
							stat = conn.prepareStatement("select * from train");
						} else {
							stat = conn.prepareStatement(
									"select * from train where Convert(varchar,stime,120) LIKE ? OR Convert(varchar,ttime,120) LIKE ?");
							stat.setString(1, "%" + sw + "%");
							stat.setString(2, "%" + sw + "%");
						}
						ret = stat.executeQuery();
						// rsmt=ret.getMetaData();
						DefaultTableModel model = new DefaultTableModel(); // 新建一个默认数据模型
						table = new JTable(model);

						// Vector data=new Vector();
						// Vector name=new Vector();
						name.add("车次号");
						name.add("始发站");
						name.add("终点站");
						name.add("发车时间");
						name.add("到站时间");
						name.add("商务座席位");
						name.add("一等座席位");
						name.add("二等座席位");
						// for(int i=1;i<=8;i++) {
						// name.add(rsmt.getColumnName(i));
						// }
						while (ret.next()) {
							Vector row = new Vector();
							for (int i = 1; i <= 8; i++) {
								row.add(ret.getString(i).trim());
							}
							data.add(row);
						}
						model.setDataVector(data, name);
						scrollPane.setViewportView(table);
						// System.out.print(data);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((!radioButton.isSelected()) && (!radioButton_1.isSelected())) {
					JOptionPane.showMessageDialog(null, "请选择购票类型！");
				} else {
					if (table != null) {
						int i = table.getSelectedRow();
						String tno;
						if (i >= 0) {
							tno = (String) table.getModel().getValueAt(i, 0);
						}else {
							tno=null;
						}
						// System.out.print(tno);
						if (radioButton.isSelected()) { // 个人票
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										Main.buy = new Buy(tno, 0, i,userid);
										Main.buy.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						} else if (radioButton_1.isSelected()) { // 团体票
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										Buy buy = new Buy(tno, 1, i,userid);
										buy.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						}
						// int i = table.getSelectedRow();
						// String s = (String) table.getModel().getValueAt(i, 0);
						// System.out.print(i);
					} else {
//						JOptionPane.showMessageDialog(null, "请先使用查询功能选中一趟列车！");
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Buy buy = new Buy(null, 0, -1,userid);
									buy.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				}
			}
		});
		button_3.addActionListener(new ActionListener() {			//购票记录
			public void actionPerformed(ActionEvent arg0) {
				data.clear();
				name.clear();
				Connection conn = Main.Connect();
				PreparedStatement stat;
				ResultSet ret;
				ResultSetMetaData rsmt;
				try {
					// System.out.print(sw);
					stat = conn.prepareStatement("select * from [user] where userid=?");
					stat.setString(1, userid);
					ret = stat.executeQuery();
					ret.next();
					String idno=ret.getString(5).trim();
//					System.out.print(idno);
					
					stat = conn.prepareStatement("select * from record where record.idno=?");
					stat.setString(1, idno);
					ret = stat.executeQuery();
//					ret.next();
//					System.out.print(ret.getString(1).trim());
					// rsmt=ret.getMetaData();
					DefaultTableModel model = new DefaultTableModel(); // 新建一个默认数据模型
					record = new JTable(model);

					// Vector data=new Vector();
					// Vector name=new Vector();
					name.add("姓名");
					name.add("证件号");
					name.add("订单号");
					name.add("下单时间");
					name.add("车次号");
					name.add("车票类型");
					name.add("座位类型");
					name.add("座位号");
					// for(int i=1;i<=8;i++) {
					// name.add(rsmt.getColumnName(i));
					// }
					while (ret.next()) {
						Vector row = new Vector();
						for (int i = 1; i <= 8; i++) {
							row.add(ret.getString(i).trim());
						}
//						System.out.print(row);
						data.add(row);
					}
					model.setDataVector(data, name);
					scrollPane.setViewportView(record);
//					System.out.print(data);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				data.clear();
				name.clear();
				Connection conn = Main.Connect();
				PreparedStatement stat;
				ResultSet ret;
				ResultSetMetaData rsmt;
				try {
					// System.out.print(sw);
					stat = conn.prepareStatement("select * from [user] where userid=?");
					stat.setString(1, userid);
					ret = stat.executeQuery();
					ret.next();
					String idno=ret.getString(5).trim();
//					System.out.print(idno);
					
					stat = conn.prepareStatement("select * from passenger where idno= ? ");
					stat.setString(1, idno);
					ret = stat.executeQuery();
//					int count = ret.getInt(1);
					
					if(ret.next()){
	//					ret.next();
	//					System.out.print(ret.getString(1).trim());
						// rsmt=ret.getMetaData();
						DefaultTableModel model = new DefaultTableModel(); // 新建一个默认数据模型
						trefund = new JTable(model);
	
						// Vector data=new Vector();
						// Vector name=new Vector();
						name.add("姓名");
						name.add("证件号");
						name.add("车次号");
						name.add("车票类型");
						name.add("座位类型");
						name.add("座位号");
						
						do{
							Vector row = new Vector();
							for (int i = 1; i <= 6; i++) {
								row.add(ret.getString(i).trim());
							}
//							System.out.print(row);
							data.add(row);
						}while (ret.next());
						model.setDataVector(data, name);
//						System.out.print(data);
						
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
//									Refund frame = new Refund();
//									frame.setVisible(true);
									
									Main.refund=new Refund(trefund);
									Main.refund.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						
//						scrollPane.setViewportView(refund);
//						System.out.print(data);
					}
					else{
						JOptionPane.showMessageDialog(null, "您尚未购买车票！");
					}
				
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}
}
