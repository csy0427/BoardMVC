package Servlet;

import Service.MemberBoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BoardUpdateServlet extends HttpServlet {
    private MemberBoardServiceImpl memberBoardSerive=new MemberBoardServiceImpl();
    private Map<String,String> board=null;

    public void init(ServletConfig servletConfig) throws ServletException{
        System.out.println("BoarUpdateServlet init");
        super.init(servletConfig);
        board=new HashMap<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BoardUpdateServlet doPost method");
        String index= request.getParameter("boardNumber");
        System.out.println(index+"090909093024");
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        if ("".equals(title)) {
            title = "no title";
        }

        if ("".equals(content)) {
            content = "no content";
        }

        board.put("title",title);
        board.put("content",content);
        memberBoardSerive.update(index,board);

        request.setAttribute("title",title);
        request.setAttribute("content",content);

        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/view/update.jsp");
        dispatcher.forward(request,response);

    }
}
