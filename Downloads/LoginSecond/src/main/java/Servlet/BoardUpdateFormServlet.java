package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardUpdateFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index=request.getParameter("index");
        System.out.println(index+"))))))))))))))");
        request.setAttribute("boardNumber",index);
        request.getRequestDispatcher("/WEB-INF/view/updateForm.jsp").forward(request, response);
    }
}
