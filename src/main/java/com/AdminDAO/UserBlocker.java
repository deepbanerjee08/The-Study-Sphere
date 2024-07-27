package com.AdminDAO;

import java.sql.*;

import Eportal.servlet.DataBaseDetails;

public class UserBlocker extends DataBaseDetails {
	
	public boolean StuUserBlock(int Sid)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "update studentdetails set action = 'block' where Sno = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Sid);
			
			int c = st.executeUpdate();
			
			System.out.println(c+" / 1 User blocked");
			flag = true;
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return(flag);
	}
	
	public boolean TUserBlock(int Tid)
	{
		boolean flag = false;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "update teacher set Action = 'block' where Tno = ?";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, Tid);
			
			int c = st.executeUpdate();
			
			System.out.println(c+" / 1 User blocked");
			flag = true;
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
