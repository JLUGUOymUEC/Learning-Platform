package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	public String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/user_schema";
	private String username="root";
	private String password="980207";
	public Connection conn;
	public Statement stm;
	public  ResultSet rs;
	public PreparedStatement pre;
	public boolean createConn() {
		boolean b=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_schema","root","980207");
		    b=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		   return b;
	}



	  public boolean update(String sql) {
		  boolean b = false;
			try {
				stm = conn.createStatement();
				stm.execute(sql);
				b = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return b;
	  }

	  
	//查询
		public void query(String sql){
			try {
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//判断有无数据
			public boolean next(){
				boolean b = false;
				try {
					if(rs.next()){
						b = true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return b;
			}
			//获取表字段值
			public String getValue(String field) {
				String value = null;
				try {
					if (rs != null) {
						value = rs.getString(field);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return value;
			}
			//关闭连接
			public void closeConn() {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//关闭statement
			public void closeStm() {
				try {
					if (stm != null) {
						stm.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//关闭ResultSet
			public void closeRs() {
				try {
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			public String getDriver() {
				return driver;
			}
			public void setDriver(String driver) {
				this.driver = driver;
			}
			public String getUrl() {
				return url;
			}
			public void setUrl(String url) {
				this.url = url;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public Connection getConn() {
				return conn;
			}



			public void setConn(Connection conn) {
				this.conn = conn;
			}



			public Statement getStm() {
				return stm;
			}



			public void setStm(Statement stm) {
				this.stm = stm;
			}



			public ResultSet getRs() {
				return rs;
			}



			public void setRs(ResultSet rs) {
				this.rs = rs;
			}



			public PreparedStatement getPre() {
				return pre;
			}
			public void setPre(PreparedStatement pre) {
				this.pre = pre;
			}

		public static void main(String args[]) throws SQLException {
			Database db=new Database();
			System.out.println(db.createConn()); 
			db.query("select * from login.user;");
		    while(db.rs.next())
		    {
		    	db.rs.getString(1);
		    	db.rs.getString(2);
		    	System.out.println(db.rs.getString(1)); 
		    	System.out.println(db.rs.getString(2)); 
		    }
		}
	

}
