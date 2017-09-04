package Servlet;

import Service.MemberLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class LoginCheckServlet extends HttpServlet {

    MemberLoginServiceImpl memberService=new MemberLoginServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginCheckServlet doPost");
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        request.setAttribute("id",id);
        request.setAttribute("password",password);
        Map<String, Map<String, String>> db= null;
        db= memberService.list();
        if(db==null) System.out.print("null........");
        request.setAttribute("dbArray",db);
        request.getRequestDispatcher("/WEB-INF/view/loginCheck.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
