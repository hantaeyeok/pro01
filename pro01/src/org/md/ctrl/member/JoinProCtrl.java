package org.md.ctrl.member;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.md.dao.MemberDAO;
import org.md.dto.Member;
import org.md.util.AES256;

@WebServlet("/JoinPro.do")
public class JoinProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinProCtrl() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String pw = request.getParameter("pw");
		String key = "%02x";
		String enPw = "";
		
		try {
			enPw = AES256.encryptAES256(pw, key);
			System.out.println("비밀번호 암호화 : " + enPw); //나중에 지워야함
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
				| InvalidParameterSpecException | UnsupportedEncodingException | BadPaddingException
				| IllegalBlockSizeException e) {
			e.printStackTrace();
		}
		
		
		
		Member mem = new Member(request.getParameter("id"),
				request.getParameter("pw"),
				request.getParameter("name"),
				request.getParameter("email"),
				request.getParameter("tel"),
				request.getParameter("address1") + "$" + request.getParameter("address2"),
				request.getParameter("postcode")
				);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(mem);
		
		if(cnt>0) {
			response.sendRedirect(request.getContextPath());
		} else {
			response.sendRedirect("/Join.do");
		}
	}

}
