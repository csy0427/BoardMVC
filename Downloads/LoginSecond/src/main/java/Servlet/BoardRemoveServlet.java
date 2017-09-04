package Servlet;

import Service.MemberBoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardRemoveServlet extends HttpServlet {

    private MemberBoardServiceImpl memberBoardSerive=new MemberBoardServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BoardRemoveServlet doPost method");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BoardRemoveServlet doGet method");
        String boardNumber=request.getParameter("index");
        memberBoardSerive.delete(boardNumber);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/view/remove.jsp");
        dispatcher.forward(request,response);

    }
}
