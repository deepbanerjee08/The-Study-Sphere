package databaseConnect;

import java.sql.*;

import Eportal.servlet.DataBaseDetails;

public class LoginVerification extends DataBaseDetails{

	public boolean LoginVerify(String email, String pass)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,dbname,dbpass);
			//As it is dynamic
			String query = "select * from studentdetails where email=? and password=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, pass);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next()) {
				
				String blocked = rd.getString(7);
				System.out.println(blocked);
				if(blocked == null)
				{
					return(true);
				}
			}
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return(false);
	}
	
	//Teachers----------------------------------------
	public boolean TLoginVerify(String Temail,String Tpass)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select * from teacher where Temail=? and Tpassword=?";
			
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, Temail);
			st.setString(2, Tpass);
			
			ResultSet rd = st.executeQuery();
			
			if(rd.next())
			{
				String action = rd.getString(7);
				
				if(action == null)
				{
					flag = true;
				}
				
			}
			
			st.close();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return(flag);
	}

}
