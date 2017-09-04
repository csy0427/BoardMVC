package Servlet;

import Service.MemberBoardServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BoardListServlet extends HttpServlet {

    MemberBoardServiceImpl memberBoardSerive=new MemberBoardServiceImpl();
    Map<String,Map<String,String>> returnBoardList=null;

    public void init(ServletConfig servletConfig) throws ServletException{
        System.out.println("BoardReadListServlet constructor");
        super.init(servletConfig);
        returnBoardList=new HashMap<>();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BoardListServlet service method");
        returnBoardList = memberBoardSerive.list();
        request.setAttribute("returnBoardList",returnBoardList);
        request.getRequestDispatcher("/WEB-INF/view/boardList.jsp").forward(request, response);
    }
}
