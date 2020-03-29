package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MirrorRequestsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userVariables = request.getParameterMap().values().toString();
        Enumeration<String> params = request.getParameterNames();
        StringBuilder sb = new StringBuilder(100);
        while(params.hasMoreElements()){
            String paramName = params.nextElement();
            System.out.println(request.getParameter(paramName));
            sb.append(request.getParameter(paramName));
        }
        response.getWriter().println(sb.toString());
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
