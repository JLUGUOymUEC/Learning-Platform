package Bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped; 
									 
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;


public class useBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int passivegrade;//客观题考试成绩
	private int activegrade;//主观题考试成绩
	private String id;
	private String password;
	private String subject;//身份
    private String testSub;//考试科目
	private List<String> subjects=new ArrayList<String>();
	private int s1;
	private int s2;
	private int s3;
	private int j1;
	private int j2;
	private int j3;
	private int t1;
	private int t2;
	private int t3;//题目id
	private String s1t;
	private String s2t;
	private String s3t;
	private String j1t;
	private String j2t;
	private String j3t;
	private String t1t;
	private String t2t;
	private String t3t;//题目本身
	private String s1ta;
	private String s2ta;
	private String s3ta;
	private String j1ta;
	private String j2ta;
	private String j3ta;
	private String t1ta;
	private String t2ta;
	private String t3ta;//题目答案
	public void selectQuestion(ComponentSystemEvent e)throws AbortProcessingException
	{
		User_bean us=new User_bean(subject);
	       String sql="select * from user_schema.paper1 where id='1'";
	       us.db.query(sql);
	       ResultSet rs=us.db.getRs();//获取题号，再从每个不同表中提取题目         

     try {
		s1=rs.getInt(0);
		s2=rs.getInt(1);
		s3=rs.getInt(2);
		t1=rs.getInt(3);
		t2=rs.getInt(4);
		t3=rs.getInt(5);
		j1=rs.getInt(6);
		j2=rs.getInt(7);
		j3=rs.getInt(8);
	
     sql="select * from user_schema.questions where testsub='"+testSub+"'and id='"+s1+"'";//第一列testsub考试门类第二列试题id该表没有主键,第三列试题，也可以自行添加
     us.db.query(sql);
     s1t=us.db.getRs().getString(2);
     sql="select * from user_schema.questions where testsub='"+testSub+"'and id='"+s2+"'";//第一列testsub考试门类第二列试题id该表没有主键,第三列试题，也可以自行添加
     us.db.query(sql);
     s2t=us.db.getRs().getString(2);
     sql="select * from user_schema.questions where testsub='"+testSub+"'and id='"+s3+"'";//第一列testsub考试门类第二列试题id该表没有主键,第三列试题，也可以自行添加
     us.db.query(sql);
     s3t=us.db.getRs().getString(2);
     sql="select * from user_schema.questiont where testsub='"+testSub+"'and id='"+t1+"'";//第一列testsub考试门类第二列试题id该表没有主键,第三列试题，也可以自行添加
     us.db.query(sql);
     t1t=us.db.getRs().getString(2);
     sql="select * from user_schema.questiont where testsub='"+testSub+"'and id='"+t2+"'";//第一列testsub考试门类第二列试题id该表没有主键,第三列试题，也可以自行添加
     us.db.query(sql);
     t2t=us.db.getRs().getString(2);
     sql="select * from user_schema.questiont where testsub='"+testSub+"'and id='"+t3+"'";//第一列testsub考试门类第二列试题id该表没有主键,第三列试题，也可以自行添加
     us.db.query(sql);
     t3t=us.db.getRs().getString(2);
     sql="select * from user_schema.questionj where testsub='"+testSub+"'and id='"+j1+"'";//第一列testsub考试门类第二列试题id该表没有主键,第三列试题，也可以自行添加
     us.db.query(sql);
     j1t=us.db.getRs().getString(2);
     sql="select * from user_schema.questionj where testsub='"+testSub+"'and id='"+j2+"'";//第一列testsub考试门类第二列试题id该表没有主键,第三列试题，也可以自行添加
     us.db.query(sql);
     j2t=us.db.getRs().getString(2);
     sql="select * from user_schema.questionj where testsub='"+testSub+"'and id='"+j3+"'";//第一列testsub考试门类第二列试题id该表没有主键,第三列试题，也可以自行添加
     us.db.query(sql);
     j3t=us.db.getRs().getString(2);
     } catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
	public void sets1(int s1)
	{
		this.s1=s1;
	}
	public void sets2(int s2)
	{
		this.s2=s2;
	}
	public void sets3(int s3)
	{
		this.s3=s3;
	}
	public void sett1(int t1)
	{
		this.t1=t1;
	}
	public void sett2(int t2)
	{
		this.t2=t2;
	}
	public void sett3(int t3)
	{
		this.t3=t3;
	}
	public void setj1(int j1)
	{
		this.j1=j1;
	}
	public void setj2(int j2)
	{
		this.j2=j2;
	}
	public void setj3(int j3)
	{
		this.j3=j3;
	}
	public int gets1()
	{
		return s1;
	}
	public int gets2()
	{
		return s2;
	}
	public int gets3()
	{
		return s3;
	}
	public int getj1()
	{
		return j1;
	}
	public int getj2()
	{
		return j2;
	}
	public int getj3()
	{
		return j3;
	}
	public int gett1()
	{
		return t1;
	}
	public int gett2()
	{
		return t2;
	}
	public int gett3()
	{
		return t3;
	}public String gets1t()
	{
		return s1t;
	}
	public String gets2t()
	{
		return s2t;
	}
	public String gets3t()
	{
		return s3t;
	}
	public String getj1t()
	{
		return j1t;
	}
	public String getj2t()
	{
		return j2t;
	}
	public String getj3t()
	{
		return j3t;
	}
	public String gett1t()
	{
		return t1t;
	}
	public String gett2t()
	{
		return t2t;
	}
	public String gett3t()
	{
		return t3t;
	}
	public void sets1t(String s1t)
	{
		this.s1t=s1t;
	}
	public void sets2t(String s2t)
	{
		this.s2t=s2t;
	}
	public void sets3t(String s3t)
	{
		this.s3t=s3t;
	}
	public void sett1t(String t1t)
	{
		this.t1t=t1t;
	}
	public void sett2t(String t2t)
	{
		this.t2t=t2t;
	}
	public void sett3t(String t3t)
	{
		this.t3t=t3t;
	}
	public void setj1t(String j1t)
	{
		this.j1t=j1t;
	}
	public void setj2t(String j2t)
	{
		this.j2t=j2t;
	}
	public void setj3t(String j3t)
	{
		this.j3t=j3t;
	}
	public String gets1ta()
	{
		return s1ta;
	}
	public String gets2ta()
	{
		return s2ta;
	}
	public String gets3ta()
	{
		return s3ta;
	}
	public String getj1ta()
	{
		return j1ta;
	}
	public String getj2ta()
	{
		return j2ta;
	}
	public String getj3ta()
	{
		return j3ta;
	}
	public String gett1ta()
	{
		return t1ta;
	}
	public String gett2ta()
	{
		return t2ta;
	}
	public String gett3ta()
	{
		return t3ta;
	}
	public void sets1ta(String s1ta)
	{
		this.s1ta=s1ta;
	}
	public void sets2ta(String s2ta)
	{
		this.s2ta=s2ta;
	}
	public void sets3ta(String s3ta)
	{
		this.s3ta=s3ta;
	}
	public void sett1ta(String t1ta)
	{
		this.t1ta=t1ta;
	}
	public void sett2ta(String t2ta)
	{
		this.t2ta=t2ta;
	}
	public void sett3ta(String t3ta)
	{
		this.t3ta=t3ta;
	}
	public void setj1ta(String j1ta)
	{
		this.j1ta=j1ta;
	}
	public void setj2ta(String j2ta)
	{
		this.j2ta=j2ta;
	}
	public void setj3ta(String j3ta)
	{
		this.j3ta=j3ta;
	}
	public String registPaper()
	{User_bean us=new User_bean(subject);
	String sql="select * from  user_schema.questions where id='"+s1+"'";//选择题第一列是考试分类 ，第二列是题目id，第三列是题目本身，第四列是答案
	us.db.query(sql);
	if(!us.db.next()){return "failure";}
	sql="select * from  user_schema.questions where id='"+s2+"'";
	us.db.query(sql);
	if(!us.db.next()){return "failure";}
	sql="select * from  user_schema.questions where id='"+s3+"'";
	us.db.query(sql);
	if(!us.db.next()){return "failure";}
	sql="select * from  user_schema.questionj where id='"+j1+"'";
	us.db.query(sql);
	if(!us.db.next()){return "failure";}
	sql="select * from  user_schema.questionj where id='"+j2+"'";
	us.db.query(sql);
	if(!us.db.next()){return "failure";}
	sql="select * from  user_schema.questionj where id='"+j3+"'";
	us.db.query(sql);
	if(!us.db.next()){return "failure";}
	sql="select * from  user_schema.questiont where id='"+t1+"'";
	us.db.query(sql);
	if(!us.db.next()){return "failure";}
	sql="select * from  user_schema.questiont where id='"+t2+"'";
	us.db.query(sql);
	if(!us.db.next()){return "failure";}
	sql="select * from  user_schema.questiont where id='"+t3+"'";
	us.db.query(sql);
	if(!us.db.next()){return "failure";}
	int i;
	for(i=1;;i++)
	{sql="select * from  user_schema.paper where id='"+i+"'";
	us.db.query(sql);
	if(us.db.next()){break;}
	}
	sql="insert into user_shcema.paper1 s1='"+s1+"' where id='"+i+"'";
	us.db.update(sql);
	sql="insert into user_shcema.paper1 s2='"+s2+"' where id='"+i+"'";
	us.db.update(sql);
	sql="insert into user_shcema.paper1 s3='"+s3+"' where id='"+i+"'";
	us.db.update(sql);
	sql="insert into user_shcema.paper1 t1='"+t1+"' where id='"+i+"'";
	us.db.update(sql);
	sql="insert into user_shcema.paper1 t2='"+t2+"' where id='"+i+"'";
	us.db.update(sql);
	sql="insert into user_shcema.paper1 t3='"+t3+"' where id='"+i+"'";
	us.db.update(sql);
	sql="insert into user_shcema.paper1 j1='"+j1+"' where id='"+i+"'";
	us.db.update(sql);
	sql="insert into user_shcema.paper1 j2='"+j2+"' where id='"+i+"'";
	us.db.update(sql);
	sql="insert into user_shcema.paper1 j3='"+j3+"' where id='"+i+"'";
	us.db.update(sql);
		return "success";
	}
	public String submitpaper() throws SQLException//提交试卷答案
	{
		passivegrade=0;
		activegrade=0;//提交试卷时清空成绩
		User_bean us=new User_bean(subject);
		String sql="select * from  user_schema.questions where id='"+s1+"'";
		us.db.query(sql);
		if(s1ta.equals(us.db.getRs().getString(3))){passivegrade=passivegrade+3;}
		sql="select * from  user_schema.questions where id='"+s2+"'";
		if(s2ta.equals(us.db.getRs().getString(3))){passivegrade=passivegrade+3;}
		sql="select * from  user_schema.questions where id='"+s3+"'";
		if(s3ta.equals(us.db.getRs().getString(3))){passivegrade=passivegrade+4;}
		sql="insert into user_schema.paper values('"+id+"','"+testSub+"','"+s1t+"','"+s2t+"','"+s3t+"','"+t1t+"','"+t2t+"','"+t3t+"','"+j1t+"','"+j2t+"','"+j3t+"','"+s1ta+"','"+s2ta+"','"+s3ta+"','"+t1ta+"','"+t2ta+"','"+t3ta+"','"+j1ta+"','"+j2ta+"','"+j3ta+"','"+passivegrade+"','"+activegrade+"')";
		//paper表中 第一列 考生id ，第二列考试科目,后9列考试题目,再后9列考试答案,再后一列客观题分数，最后一列主观题分数
		return "success";
	}
	public String chooseTest()
	{
		User_bean us=new User_bean(subject);
		String sql="select * from  user_schema."+subject+"where id='"+id+"'and "+testSub+"='1'";//学生表有五个学科列，每个列默认为0，注册后变为1
		us.db.query(sql);
		if(us.db.next())
		{return "success";}
		System.out.println("选择失败，没有进行注册考试");
		return "fail";
	}
	public String registTest()
	{
		String sql="update user_schema."+subject+" set "+testSub+"='1' where id='"+id+"'" ;
		return "success";
	}
	public String updatePassword()
	{
		User_bean us=new User_bean(subject);
		String sql="update user_schema."+subject+"set password='"+password+"' where id='"+id+"'";
		us.db.update(sql);
		return "success";
	}
	public String isValid()
	{   
          
		User_bean us=new User_bean(subject);
		boolean bo= us.valid(id, password);
		
		if(bo==true){
			System.out.println("登录成功");
			if(subject.equals("admin"))return "admin";
			if(subject.equals("teacher"))return "teacher";
			if(subject.equals("student"))return "student";
		}
		System.out.println("登录失败");return "fail";
	}
	
	public String getid()
	{
		return id;
	}
	public void setid(String id)
	{
		this.id=id;
	}
	public String getpassword()
	{
		return password;
	}
	public void setpassword(String password)
	{
		this.password=password;
	}
	public String gettestSub()
	{
		
		return testSub;
	}
	public void settestSub(String testSub)
	{
		this.testSub=testSub;
	}
	public String getsubject()
	{
		
		return subject;
	}
	public void setsubject(String subject)
	{
		this.subject=subject;
	}
	public List<String> getsubjects()
	{
		return subjects;
	}
	public void setsubjects(List<String> subjects)
	{
		this.subjects=subjects;
	}
	
}
