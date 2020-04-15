package servlets;

import accounts.AccountService;
import dbService.DBException;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SigninServlet extends HttpServlet {
    private final AccountService accountService;

    public SigninServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ( login == null || password == null){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        // TO DO
        // Add correct check is user registered or not
        // Add correct check is user password is correct or not
        try {
            accountService.getUserData(login);
            response.getWriter().println("Authorized: " + login);
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);

        }
        catch (DBException e){
            if (e.getMessage().contains("No data is available")){
                response.getWriter().println("Unauthorized");
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            else {
                e.printStackTrace();
            }
        }

    }
}
