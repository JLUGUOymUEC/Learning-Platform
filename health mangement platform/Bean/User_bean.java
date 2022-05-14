package Bean;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.Database;
public class User_bean {
	public String subject;
	public User_bean(String subject){
		this.subject=subject;
	}
	public static Database db = new Database();
	//注册验证
			public boolean isExist(String id){
				String sql = null;
				boolean isValid = false;
				if(db.createConn()){
					if(subject.equals("student"))
					{sql = "select * from user_schema.student where student_id='"+id+"'";}
					else if(subject.equals("admin"))
					{
						sql = "select * from user_schema.admin where admin_id='"+id+"'";
					}
					else if(subject.equals("teacher"))
					{
						sql = "select * from user_schema.teacher where teacher_id='"+id+"'";
					}
					db.query(sql);
					if(db.next()){
						isValid = true;
					}
					db.closeRs();
					db.closeStm();
					db.closeConn();
				}
				return isValid;
			}
			//注册用户
			public boolean add(String id,String password){
				boolean isValid = false;
				
				if(db.createConn()){
					if(subject.equals("student")){
					String sql = "insert into user_schema.student (student_id,student_password)values('"+id+"','"+ password + "');";
					isValid = db.update(sql);
					}
					else if(subject.equals("teacher")){
						String sql = "insert into user_schema.teacher (teacher_id,teacher_password)values('"+id+"','"+ password + "');";
						isValid = db.update(sql);
						}
					else if(subject.equals("admin")){
						String sql = "insert into user_schema.admin (admin_id,admin_password)values('"+id+"','"+ password + "');";
						isValid = db.update(sql);
						}
					db.closeStm();
					db.closeConn();
				}
				return isValid;
			}
			
			public boolean valid(String id,String password){
				boolean isValid = false;	
				if(db.createConn()){
					
					String sql="select * from userschema."+subject+" where "+subject+"_id='"+id+"' and "+subject+"_password='"+password+"';";
		          db.query(sql);
					
					if(db.next()){
						isValid = true;
					}
						}
				return isValid;
			}
			//查询当前数据库中的用户数目
			public  int selectAll(){
			      if(db.createConn()){
			    	  String sql="select * from p_user where 1=1";
			    	  db.query(sql);
			    	  ResultSet rs=db.getRs();
			    	  int number=0;
			    	  if(rs!=null){
			    		  try {
						rs.last();
							number=rs.getRow();
							System.out.println(number);
							    db.closeRs();
								db.closeStm();
								db.closeConn();
							return number;
						} catch (SQLException e) {
							// TODO Auto-generated catch block\	
							e.printStackTrace();
							  return 0;
						}
			    		 
			    	  } 
			      }
				return 0;
			 
			
			
			}
			

			//注册验证

				public boolean add(String id,String username,String password,String email){
					boolean isValid = false;
					if(db.createConn()){
						String sql = "insert into p_user(id,username,password,email) values('"+id+"','"+username+"','"+password+"','"+email+"')";
						isValid = db.update(sql);
						db.closeStm();
						db.closeConn();
					}
					return isValid;
				}


			
}
