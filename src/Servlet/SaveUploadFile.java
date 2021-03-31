package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;

import java.sql.*;
import java.util.*;
import java.io.*;

import org.apache.commons.fileupload.*;

/**
 * Servlet implementation class SaveUploadFile
 */
@WebServlet("/SaveUploadFile")
public class SaveUploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void destroy(){
    	super.destroy();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String isbn=request.getParameter("isbn");
		String path=request.getContextPath();
		String realpath=request.getRealPath("images");
		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println("path="+path);
		System.out.println("request.getRealPath('images')="+realpath);
		System.out.println("basePath="+basePath);
		System.out.println("isbn= "+isbn);
		DiskFileUpload fu = new DiskFileUpload();
		fu.setSizeMax(1024*1024);
		fu.setRepositoryPath(realpath);
		try{
			List fileItems = fu.parseRequest(request);
			Iterator iter = fileItems.iterator();
			while(iter.hasNext()){
				FileItem item=(FileItem)iter.next();
				if(!item.isFormField()){
					File savedFile = new File(realpath,isbn+".jpg");
					item.write(savedFile);
				}
			}
		}
		catch(Exception e){
			response.sendRedirect("uploadfile_show.jsp?isbn="+isbn);
		}
		
	}

}
