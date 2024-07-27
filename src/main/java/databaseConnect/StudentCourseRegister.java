package databaseConnect;

import java.sql.*;

import Eportal.servlet.DataBaseDetails;

public class StudentCourseRegister extends DataBaseDetails{
	
	int count = 0;
	
	public boolean AlreadyEnrolled(int Sno, int Cno)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query="select * from sturegistercourse where Sno=? and Cno=?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Sno);
			st.setInt(2, Cno);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
			{
				flag = true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return(flag);
	}
	
	
	public boolean StudentCourseRegister(int Sid, int Cid, String Cname)
	{
		boolean flag = false;
		
		DATEGENERATOR date = new DATEGENERATOR();
		
		String Rdate = date.getDate();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbname,dbpass);
			
			String query = "insert into sturegistercourse values(?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Cid);
			st.setString(2, Cname);
			st.setInt(3, Sid);
			st.setString(4, Rdate);
			
			count = st.executeUpdate();
			count++;
			
			System.out.println(count+"/ Rows Affected");
			
			flag = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return(flag);
	}
}
