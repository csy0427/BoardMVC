package Servlet;

import Service.MemberBoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class BoardReadServlet extends HttpServlet {

    MemberBoardServiceImpl memberBoardSerive=new MemberBoardServiceImpl();
    Map<String,String> returnBoardList=null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BoardReadServlet doGet method");
        String index= request.getParameter("index");
        returnBoardList=memberBoardSerive.get(index);
        request.setAttribute("returnBoardList",returnBoardList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/view/readPost.jsp");
        dispatcher.forward(request,response);

    }
}
