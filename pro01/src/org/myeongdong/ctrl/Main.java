package org.myeongdong.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.myeongdong.dto.*;;

@WebServlet("/pro01")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Main() {
        super();
      
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServletContext application = request.getServletContext();
		String realPath = request.getSession().getServletContext().getRealPath("/");
		String author = "hty";
		request.setAttribute("author", author);
		request.setAttribute("aespa.jpg", "./images/aespa.jpg");
		
		application.setAttribute("realPath", realPath);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request, response);
	}
	

}
