<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "com.admin.*, com.AdminDAO.*, java.util.LinkedList, java.io.File" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sharp - Admin</title>

    
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
	
    <style>
      .nav-ele-hover:hover, .activate{
        font-size: 1.5rem;
        transition: all 0.3s;
      }
    </style>
  </head>
  <body>
  
  	<%
  	//Preventing back button after logout
  	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  	response.setHeader("Pragma", "no-cache");
  	response.setHeader("Expires", "0");
  	
    if(session.getAttribute("AEmail") == null)
    {
    	response.sendRedirect("AdminLogin.html");
    }
    %>
    
    <header class="navbar navbar-light sticky-top bg-light flex-md-nowrap p-3 shadow">

        <button class="navbar-toggler  d-md-none me-5 collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <img src = "designlogo.jpeg" alt = "clgLogo" width = "7%"/>
        
        <div class="navbar-nav">
          <div class="nav-item text-nowrap">
            <form action = "AdminLogout" method="post">
            	<button type="submit" class="btn btn-outline-dark">Signout</button>
            </form>
          </div>
        </div>
      </header>
      
      <div class="container-fluid">
        <div class="row">
          <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse bg-dark" style="position: fixed; height: 95vh">
            <div class="position-sticky pt-3">
              <ul class="nav flex-column">
                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link" aria-current="page" href="ADMINHome.jsp">
                    Home
                  </a>
                </li>
                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link" href="ADMINStudents.jsp">
                    Student's
                  </a>
                </li>
                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link" href="AdminTeachers.jsp">
                    
                    Teacher's
                  </a>
                </li>

                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link" href="AdminCourses.jsp">    
                    Courses
                  </a>
                </li>

                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link" href="AdminStuCourseRegister.jsp">
                    
                    Course Register
                  </a>
                </li>
                
                <li class="nav-item nav-ele-hover activate">
                  <a class="text-white nav-link" href="AdminCourseView.jsp">
                    Course Store
                  </a>
                </li>
                
                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link" href="AdminStudentCourseVideoSee.jsp">
                    Student's Vseen
                  </a>
                </li>
                
                <li class="nav-item nav-ele-hover">
                  <a class="text-white nav-link" href="AdminTestMarks.jsp">
                    Student's Marks
                  </a>
                </li>
                
                
              </ul>
            </div>
          </nav>
      
          <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
              <h1 class="h2">Available Courses</h1>
            </div>
                <%
                LinkedList <String> name = new LinkedList <String> ();
            	LinkedList <Integer> Sno = new LinkedList <Integer> ();
            	LinkedList <String> Contact = new LinkedList <String> ();
            	LinkedList <String> Email = new LinkedList <String> ();
            	LinkedList <String> date = new LinkedList <String> ();
            	
            	LinkedList <String> filepath = new LinkedList <String> ();
            	LinkedList <String> status = new LinkedList <String> ();
            	LinkedList <Integer> CourseId = new LinkedList <Integer> ();
            	
            	LinkedList <String> img = new LinkedList <String> ();
            	LinkedList <String> desc = new LinkedList <String> ();
            	LinkedList <String> jsp = new LinkedList <String> ();
            	
            	Integer Sid [] = null;
            	String  Sname [] = null;
            	String SEmail [] = null;
            	String Scontact [] = null;
            	String JDate[] = null;
            	String FilePath[] = null;
            	String Status[] = null;
            	Integer CourseID [] = null;
            	String imgurl [] = null;
            	String dsc[] = null;
            	String jspfile[] = null;
            	
            	int i = 0;
                %>
                
                <%
                AllStudentInfoCarrier Cfetch = new AllStudentInfoCarrier();
                
                AllUserDAOFetch get = new AllUserDAOFetch();
                boolean flag = get.getAllCourseDetails(Cfetch);
                
                if(flag)
                {
                	Sno = Cfetch.getSno();
                	name = Cfetch.getName();
                	Email = Cfetch.getEmail();
    				filepath = Cfetch.getFilepath();
    				status = Cfetch.getStatus();
    				CourseId = Cfetch.getCourseId();
                	date = Cfetch.getDate();
                	img = Cfetch.getImg();
                	desc = Cfetch.getDesc();
                	jsp = Cfetch.getJsp();
                	
                	//Converting all LinkedList into Array
                	Sid = Sno.toArray(new Integer[0]);
                	
                	//Sname
                	Sname = name.toArray(new String[0]);
                	SEmail = Email.toArray(new String[0]);
                	
                	//Fp
					FilePath = filepath.toArray(new String[0]);
                	JDate = date.toArray(new String[0]);
                	CourseID = CourseId.toArray(new Integer[0]);
                	Status = status.toArray(new String[0]);
                	imgurl = img.toArray(new String[0]);
                	dsc = desc.toArray(new String[0]);
                	jspfile = jsp.toArray(new String[0]);
                	
                	//Length of Array
                	int p = Sid.length;
                	
                	for(i = 0; i<p; i++)
                	{
                	System.out.println(CourseID[i]);
                %>
                <div class="card mb-3" style="">
				  <div class="row g-0">
				    <div class="col-md-4" style="display: flex; justify-content: center; align-items: center;">
				      <img src=<%= imgurl[i]%> class="card-img-top" alt="logo">
				    </div>
				    <div class="col-md-8">
				      <div class="card-body">
				        <p class="card-text h5">Course ID: <%= CourseID[i]%></p>
				    	<p class="card-text h5">Course Name: <%= Sname[i]%></p>
				    	<p class="card-text">JSP-File: <%= jspfile[i]%></p>
				    	<p class="card-text">Uploader ID: <%= Sid[i]%></p>
				    	<p class="card-text">Uploader Email: <%= SEmail[i]%></p>
				    	<p class="card-text">Upload Date: <%= JDate[i]%></p>
				    	<p class="card-text h5">Status: <%= Status[i]%></p>
				    
				    	<button class="btn btn-primary float-left" type="button" data-bs-toggle="offcanvas" data-bs-target= <%= "#offcanvasRight"+CourseID[i]%> aria-controls="offcanvasRight">View File's</button>
						<div class="offcanvas offcanvas-end" tabindex="-1" id= <%= "offcanvasRight"+CourseID[i]%> aria-labelledby="offcanvasRightLabel">
						<div class="offcanvas-header">
					  		<h5 id="offcanvasRightLabel">File's: </h5>
					  		<button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
						</div>
					  	<div class="offcanvas-body">
				<%
					String Fpath = FilePath[i];
					
					File fobj = new File(Fpath);
					
					if(fobj.exists())
					{
					File fileItems [] = fobj.listFiles();
					
					for(File item : fileItems)
					{
						String Fname = item.getName();
						System.out.println("This id Fname: "+Fname);
						int dot = Fname.lastIndexOf(".");
						String ext = Fname.substring(dot+1);
						System.out.println(ext);
						
						if(ext.equals("mp4"))
						{
							String AbsolutePath = Fpath;
							//String AbsolutePath = item.getAbsolutePath();
							//System.out.print("This  PPPCCC : "+AbsolutePath);
							int z = AbsolutePath.indexOf("Courses");
							String relativePath = "./"+AbsolutePath.substring(z)+"/"+Fname;
							System.out.println(relativePath);
				%>
							<video src=<%= relativePath%> type="video/mp4" class="img-fluid mt-1" controls autoplay width="300">Not Supported Format</video>
							<p><%= Fname%></p>
				<%
						}
						
						else if(ext.equals("jpg") || ext.equals("jpeg") || ext.equals("png"))
						{
							String AbsolutePath = Fpath;
							//String AbsolutePath = item.getAbsolutePath();
							int z = AbsolutePath.indexOf("Courses");
							String relativePath = AbsolutePath.substring(z)+"/"+Fname;
							System.out.println(relativePath);
				%>    
					  		<img src= <%= relativePath%> class="img-fluid" alt="Your Upload" width="300">
                  			<p><%= Fname%></p>
               <%
						}
					}
				%>
						<!-- OFFCanvas & Card Close Inside Number of Courses For Loop-->
						
				<%
					}
				%>
					</div>
					</div> 
					
					<!-- Button trigger modal -->
						<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target=<%= "#exampleModal"+CourseID[i]%>>
						  Edit
						</button>
						
						<!-- Modal -->
						<div class="modal fade" id=<%= "exampleModal"+CourseID[i]%> tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLabel">Update Details</h5>
						        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						      </div>
						      <form action = "TCourseDEtailsUpdatEAdmin" method="post">
							      <div class="modal-body">
							      	
							      	<div class="mb-3">
									  <label for="exampleFormControlInput1" class="form-label">Course ID</label>
									  <input type="text" class="form-control" id="exampleFormControlInput1" name="cid" value=<%= CourseID[i]%> readonly>
									</div>
									
									<div class="mb-3">
									  <label for="exampleFormControlInput1" class="form-label">Uploader ID</label>
									  <input type="text" class="form-control" id="exampleFormControlInput1" name="uid" value=<%= Sid[i]%>>
									</div>
									
									<div class="mb-3">
									  <label for="exampleFormControlInput1" class="form-label">JSP - File <span class="ps-2 text-danger"><i class="fas fa-exclamation-triangle"></i> (filename.jsp)</span></label>
									  <input type="text" class="form-control" id="exampleFormControlInput1" name="jspfile" value=<%= jspfile[i]%> />
									</div>
							      	
							        <div class="mb-3">
									  <label for="exampleFormControlInput1" class="form-label">image URL (Default Path:<span class="text-success"> ./Courses/<%=Sname[i]%><%="("+Sid[i]+")" %>/</span><span class = "text-danger">file-name-here</span>)</label>
									  <input type="text" class="form-control" id="exampleFormControlInput1" name="imgurl" value=<%= imgurl[i]%> />
									</div>
									
									<div class="mb-3">
									  <label for="exampleFormControlInput1" class="form-label">Course Name</label>
									  <input type="text" class="form-control" id="exampleFormControlInput1" name="cname" value=<%= Sname[i]%> />
									</div>
									
									<div class="mb-3">
									  <label for="exampleFormControlTextarea1" class="form-label">Description</label>
									  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="desc"><%= dsc[i]%></textarea>
									</div>
									
									<div class="mb-3">
									  <label for="exampleFormControlInput1" class="form-label">Course Status (Copy & Paste this --> Active)</label>
									  <input type="text" class="form-control" id="exampleFormControlInput1" name="status" value=<%= Status[i]%>>
									</div>
									
							      </div>
							      
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
							        <button type="submit" class="btn btn-primary">Save changes</button>
							      </div>
						      </form>
						    </div>
						  </div>
						</div>
					
					</div>
                </div>
                </div>
                </div>
				<%
                  }
                }
               %>  
                     				 
          </main>>
        </div>
      </div>

    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
  
  </body>
</html>
