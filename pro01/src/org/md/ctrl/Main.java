package org.md.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.md.dao.NoticeDAO;
import org.md.dao.QnaDAO;
import org.md.dto.Notice;
import org.md.dto.Qna;

@WebServlet("/pro01")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Main() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String author = "hty";
		
		ServletContext application = request.getServletContext();
		String realPath = request.getSession().getServletContext().getRealPath("/");
		application.setAttribute("realPath", realPath);
		application.setAttribute("title", "명동 소개");
				
		NoticeDAO ndao = new NoticeDAO();
		List<Notice> latestNotiList = ndao.getLatestNoticeList();
		
		
		QnaDAO qdao = new QnaDAO();
		List<Qna> latestQnaList = qdao.getLatestQnaList();
	
		
		request.setAttribute("latestNotiList", latestNotiList);
		request.setAttribute("latestQnaList", latestQnaList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
	
		
		view.forward(request, response);
	}
}
