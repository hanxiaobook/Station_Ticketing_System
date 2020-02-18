package ssts;

import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {
	public static login login;
	public static passenger passenger;
	public static Buy buy;
	public static Refund refund;
	public static Fadmin fadmin;
	public static Fuser fuser;
	public static Ftrain ftrain;
	public static Fpassenger fpassenger;
	public static Fprice fprice;
	public static Fregister fregister;
	public static Vector data = new Vector();
	public static Vector name = new Vector();
	public static JTable table =null;

	public static String[] userrowname = { "用户名", "密码", "等级", "姓名", "证件号" };
	public static String[] trainrowname = { "车次号", "始发站", "终点站", "发车时间", "到站时间", "商务座席位", "一等座席位", "二等座席位" };
	public static String[] passengerrowname = { "姓名", "证件号码", "联系方式", "车次号", "车票类型", "座位类型", "座位号" };
	public static String[] recordrowname = { "姓名", "证件号码", "订单编号", "下单时间", "车次号", "车票类型", "座位类型", "座位号" };
	public static String[] pricerowname = { "车次号", "商务座价格", "一等座价格", "二等座价格" };

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 login = new login();
					 login.setVisible(true);
//					 passenger = new passenger("user_0","000000");
//					 passenger.setVisible(true);
//					fadmin = new Fadmin();
//					fadmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Connection Connect() {
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
		return conn;
	}

	public static JTable selecttable(JTable table, JScrollPane scrollPane, String[] rowname, int rownum, String tn) {
		data.clear();
		name.clear();
		Connection conn = Main.Connect();
		PreparedStatement stat;
		ResultSet ret = null;
		ResultSetMetaData rsmt;
		try {
			stat = conn.prepareStatement("select * from " + tn);
			// stat.setString(1, tn);
			ret = stat.executeQuery();
			// rsmt=ret.getMetaData();
			if (ret.next()) {
				DefaultTableModel model = new DefaultTableModel(); // 新建一个默认数据模型
				table = new JTable(model);
				for (int i = 0; i < rownum; i++) {
					name.add(rowname[i]);
					// System.out.print(rowname[i]);
				}

				do{
					Vector row = new Vector();
					for (int i = 1; i <= rownum; i++) {
						row.add(ret.getString(i).trim());
					}
					data.add(row);
				}while (ret.next());
				model.setDataVector(data, name);
				scrollPane.setViewportView(table);
				// System.out.print(data);
			} else {
				JOptionPane.showMessageDialog(null, "没有符合条件的数据！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return table;
	}

	public static JTable selecttable1(JTable table, JScrollPane scrollPane, String[] rowname, int rownum, String tn,
			String rn, String sw) {
		data.clear();
		name.clear();
		Connection conn = Main.Connect();
		PreparedStatement stat;
		ResultSet ret = null;
		ResultSetMetaData rsmt;
		try {
			stat = conn.prepareStatement("select * from " + tn + " where " + rn + " = '" + sw + "'");
			// stat.setString(1, rn);
			// stat.setString(1, sw);
			ret = stat.executeQuery();
			// rsmt=ret.getMetaData();
			if (ret.next()) {
				DefaultTableModel model = new DefaultTableModel(); // 新建一个默认数据模型
				table = new JTable(model);
				for (int i = 0; i < rownum; i++) {
					name.add(rowname[i]);
					// System.out.print(rowname[i]);
				}

				do {
					Vector row = new Vector();
					for (int i = 1; i <= rownum; i++) {
						row.add(ret.getString(i).trim());
					}
					data.add(row);
				} while (ret.next());
				model.setDataVector(data, name);
				scrollPane.setViewportView(table);
				// System.out.print(data);
			} else {
				JOptionPane.showMessageDialog(null, "没有符合条件的数据！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return table;
	}

	public static JTable selecttable3(JTable table, JScrollPane scrollPane, String[] rowname, int rownum, String tn,
			String rn1, String sw1, String rn2, String sw2, String rn3, String sw3) {
//		int t = table.getSelectedRow();
//		System.out.print(t);
		data.clear();
		name.clear();
		Connection conn = Main.Connect();
		PreparedStatement stat;
		ResultSet ret = null;
		ResultSetMetaData rsmt;
		try {
			String sql = "select * from " + tn + " where 1 = 1";
			if (!sw1.equals("")) {
				sql += " and " + rn1 + " = '" + sw1 + "'";
			}
			if (!sw2.equals("")) {
				sql += " and " + rn2 + " = '" + sw2 + "'";
			}
			if (!sw3.equals("")) {
				sql += " and " + rn3 + " = '" + sw3 + "'";
			}

			stat = conn.prepareStatement(sql);
//			System.out.print(sql);
			// stat.setString(1, tn);
			ret = stat.executeQuery();
			// rsmt=ret.getMetaData();
			if (ret.next()) {
				DefaultTableModel model = new DefaultTableModel(); // 新建一个默认数据模型
				table = new JTable(model);
				for (int i = 0; i < rownum; i++) {
					name.add(rowname[i]);
					// System.out.print(rowname[i]);
				}

				do {
					Vector row = new Vector();
					for (int i = 1; i <= rownum; i++) {
						row.add(ret.getString(i).trim());
					}
					data.add(row);
				} while (ret.next());
				model.setDataVector(data, name);
				scrollPane.setViewportView(table);
				// System.out.print(data);
			} else {
				JOptionPane.showMessageDialog(null, "没有符合条件的数据！");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return table;
	}
	public static void deletetable(JTable table,String tn,String rn,String sw,int r) {
			
//			System.out.print(r);
			data.clear();
			name.clear();
			Connection conn = Main.Connect();
			PreparedStatement stat;
			ResultSet ret;
			ResultSetMetaData rsmt;
			try {
				//
				stat = conn.prepareStatement("delete from "+tn+" where "+rn+" = ? ");
				stat.setString(1, sw);
				stat.execute();
//				Main.refund.dispose();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
	}
}
