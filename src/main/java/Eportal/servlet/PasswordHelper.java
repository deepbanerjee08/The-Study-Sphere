package Eportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseConnect.PasswordFetcherHELPER;

@WebServlet("/PasswordHelper")
public class PasswordHelper extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out = res.getWriter();
		
		String Email = req.getParameter("Email");
		String contact = req.getParameter("Phone");
		
		// POJO Setting
		PasswordHELPERCarrier pass = new PasswordHELPERCarrier();
		pass.setEmail(Email);
		pass.setContact(contact);
		
		PasswordFetcherHELPER obj = new PasswordFetcherHELPER();
		boolean flg = obj.getPassword(pass);
		System.out.println("Password: "+flg);
		if(flg)
		{
			String password = pass.getPassword();
			
			System.out.println(password);
			
			PasswordEMAILSENDER send = new PasswordEMAILSENDER();
			boolean flag = send.SendPassword(Email, password);
			System.out.println("Mail sent: "+flag);
			if(flag)
			{
				RequestDispatcher rd = req.getRequestDispatcher("PasswordHELP.html");
				rd.include(req, res);
				out.print("<span style='color: green'><center>Check Your Email for More Detail's</center></span>");
			}
		}
		
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("PasswordHELP.html");
			rd.include(req, res);
			out.print("<span style='color: red'><center>Detail's doen't Match</center></span>");
		}
		
	}
	
}
