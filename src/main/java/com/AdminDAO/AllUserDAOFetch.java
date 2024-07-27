package com.AdminDAO;

import java.sql.*;
import java.util.LinkedList;

import com.admin.AllStudentInfoCarrier;

import Eportal.servlet.DataBaseDetails;

public class AllUserDAOFetch extends DataBaseDetails {
	
	//All Students Info Detail's Fetcher
	public boolean GetAllStudents(AllStudentInfoCarrier obj)
	{
		boolean flag = false;
		
		LinkedList <String> name = new LinkedList <String> ();
		LinkedList <Integer> Sno = new LinkedList <Integer> ();
		LinkedList <String> Contact = new LinkedList <String> ();
		LinkedList <String> Email = new LinkedList <String> ();
		LinkedList <String> date = new LinkedList <String> ();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select distinct * from studentdetails";
			
			Statement st = con.createStatement();
			
			ResultSet rd = st.executeQuery(query);
			
			while(rd.next())
			{
				int sno = rd.getInt(5);
				String nm = rd.getString(1);
				String mail = rd.getString(4);
				String contact = rd.getString(3);
				String d = rd.getNString(6);
				
				name.offer(nm);
				Sno.offer(sno);
				Contact.offer(contact);
				Email.offer(mail);
				date.offer(d);
			}
			
			obj.setSno(Sno);
			obj.setName(name);
			obj.setEmail(Email);
			obj.setContact(Contact);
			obj.setDate(date);
			
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
	
	//All Teacher Details Fetcher
	public boolean getAllTeachers(AllStudentInfoCarrier obj)
	{
		boolean flag = false;
		LinkedList <String> name = new LinkedList <String> ();
		LinkedList <Integer> Sno = new LinkedList <Integer> ();
		LinkedList <String> Contact = new LinkedList <String> ();
		LinkedList <String> Email = new LinkedList <String> ();
		LinkedList <String> date = new LinkedList <String> ();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select * from teacher";
			
			Statement st = con.createStatement();
			
			ResultSet rd = st.executeQuery(query);
			
			while(rd.next())
			{
				int Tno = rd.getInt(1);
				String Tnm = rd.getString(2);
				String Tmail = rd.getString(4);
				String Tcontact = rd.getString(3);
				String d = rd.getNString(6);
				
				name.offer(Tnm);
				Sno.offer(Tno);
				Contact.offer(Tcontact);
				Email.offer(Tmail);
				date.offer(d);
			}
			
			obj.setSno(Sno);
			obj.setName(name);
			obj.setEmail(Email);
			obj.setContact(Contact);
			obj.setDate(date);
			
			flag = true;
			
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			
		}
		
		return(flag);
	}
	
	//Available orr Uploaded Course's Detail's Fetcher
	public boolean getAllCourseDetails(AllStudentInfoCarrier obj)
	{
		boolean flag = false;
		LinkedList <String> name = new LinkedList <String> ();
		LinkedList <Integer> Sno = new LinkedList <Integer> ();
		@SuppressWarnings("unused")
		LinkedList <String> Contact = new LinkedList <String> ();
		LinkedList <String> Email = new LinkedList <String> ();
		LinkedList <String> date = new LinkedList <String> ();
		
		LinkedList <String> img = new LinkedList <String> ();
		LinkedList <String> desc = new LinkedList <String> ();
		
		
		LinkedList <String> filepath = new LinkedList <String> ();
		LinkedList <String> status = new LinkedList <String> ();
		LinkedList <Integer> CourseId = new LinkedList <Integer> ();
		LinkedList <String> jsp = new LinkedList <String> ();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select * from courses,teacher where courses.UploaderTno = teacher.Tno";
			
			Statement st = con.createStatement();
			
			ResultSet rd = st.executeQuery(query);
			
			while(rd.next())
			{
				int CourseNo = rd.getInt(1);
				String Cnm = rd.getString(2);
				String fp = rd.getString(3);
				int Tno = rd.getInt(4);
				String Cstatus = rd.getString(5);
				String Tmail = rd.getString(13);
				String d = rd.getString(6);
				String j = rd.getString(7);
				String i = rd.getString(9);
				String dsc = rd.getString(8);
				
				CourseId.offer(CourseNo);
				filepath.offer(fp);
				name.offer(Cnm);
				Sno.offer(Tno);
				status.offer(Cstatus);
				Email.offer(Tmail);
				date.offer(d);
				jsp.offer(j);
				img.offer(i);
				desc.offer(dsc);
			}
			
			obj.setSno(Sno);
			obj.setName(name);
			obj.setEmail(Email);
			obj.setCourseId(CourseId);
			obj.setFilepath(filepath);
			obj.setStatus(status);
			obj.setDate(date);
			obj.setJsp(jsp);
			obj.setImg(img);
			obj.setDesc(desc);
			
			flag = true;
			
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			
		}
		
		return(flag);
	}
	
	//Student Register-Course detail's Fetcher
	public boolean GetStuCourseRegistter(AllStudentInfoCarrier obj)
	{
		boolean flag = false;
		
		LinkedList <String> name = new LinkedList <String> ();
		LinkedList <Integer> Sno = new LinkedList <Integer> ();
		LinkedList <String> Email = new LinkedList <String> ();
		LinkedList <String> date = new LinkedList <String> ();
		LinkedList <Integer> CourseId = new LinkedList <Integer> ();
		LinkedList <Integer> extraId = new LinkedList <Integer> (); 
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select * from sturegistercourse,courses,studentdetails where sturegistercourse.Cno = courses.Cno and sturegistercourse.Sno = studentdetails.Sno";
			
			Statement st = con.createStatement();
			
			ResultSet rd = st.executeQuery(query);
			
			while(rd.next())
			{
				int CourseID = rd.getInt(1);
				String nm = rd.getString(2);
				int sno = rd.getInt(3);
				String d = rd.getNString(4);
				String mail = rd.getString(14);
				int UploaderId = rd.getInt(8);
				
				
				extraId.offer(UploaderId);
				CourseId.offer(CourseID);
				name.offer(nm);
				Sno.offer(sno);
				Email.offer(mail);
				date.offer(d);
			}
			
			obj.setCourseId(CourseId);
			obj.setExtraId(extraId);
			obj.setSno(Sno);
			obj.setName(name);
			obj.setEmail(Email);
			obj.setDate(date);
			
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
	
	//Student Course VIDEO-SEEN DumB detail's Fetcher
	public boolean GetStuSeenVideos(AllStudentInfoCarrier obj)
	{
		boolean flag = false;
		
		LinkedList <String> name = new LinkedList <String> ();
		LinkedList <Integer> Sno = new LinkedList <Integer> ();
		LinkedList <String> Email = new LinkedList <String> ();
		LinkedList <String> date = new LinkedList <String> ();
		LinkedList <Integer> CourseId = new LinkedList <Integer> ();
		LinkedList <String> CourseName = new LinkedList <String> (); 
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select * from stuvideoregister,courses,studentdetails where  stuvideoregister.Cid = courses.Cno and stuvideoregister.Sid = studentdetails.Sno";
			
			Statement st = con.createStatement();
			
			ResultSet rd = st.executeQuery(query);
			
			while(rd.next())
			{
				String nm = rd.getString(1);
				int sno = rd.getInt(2);
				int CourseID = rd.getInt(3);
				String d = rd.getNString(4);
				String Cname = rd.getString(6);
				String mail = rd.getString(14);
				
				CourseName.offer(Cname);
				CourseId.offer(CourseID);
				name.offer(nm);
				Sno.offer(sno);
				Email.offer(mail);
				date.offer(d);
			}
			
			obj.setCourseId(CourseId);
			obj.setExtraStr(CourseName);
			obj.setSno(Sno);
			obj.setName(name);
			obj.setEmail(Email);
			obj.setDate(date);
			
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
	
	//Student Course VIDEO-SEEN DumB detail's Fetcher
	public boolean GetStuMarks(AllStudentInfoCarrier obj)
	{
		boolean flag = false;
		
		LinkedList <Integer> mark = new LinkedList <Integer> ();
		LinkedList <Integer> Sno = new LinkedList <Integer> ();
		LinkedList <String> Email = new LinkedList <String> ();
		LinkedList <String> date = new LinkedList <String> ();
		LinkedList <Integer> CourseId = new LinkedList <Integer> ();
		LinkedList <String> CourseName = new LinkedList <String> (); 
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbname, dbpass);
			
			String query = "select stucoursemarks.Cno, courses.cname, stucoursemarks.Sno, studentdetails.email, stucoursemarks.mark, stucoursemarks.dates  from stucoursemarks,courses,studentdetails where stucoursemarks.Cno = courses.Cno and stucoursemarks.Sno = studentdetails.Sno;";
			
			Statement st = con.createStatement();
			
			ResultSet rd = st.executeQuery(query);
			
			while(rd.next())
			{
				int cid = rd.getInt(1);
				String cname = rd.getString(2);
				int sid = rd.getInt(3);
				String semail = rd.getString(4);
				int m = rd.getInt(5);
				String d = rd.getString(6);
				
				CourseId.offer(cid);
				CourseName.offer(cname);
				Sno.offer(sid);
				Email.offer(semail);
				mark.offer(m);
				date.offer(d);
			}
			
			obj.setExtraId(mark);
			obj.setCourseId(CourseId);
			obj.setName(CourseName);
			obj.setSno(Sno);
			obj.setEmail(Email);
			obj.setDate(date);
			
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
