package servlets;

import accounts.AccountService;
import dbService.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignupServlet extends HttpServlet {
    private final AccountService accountService;

    public SignupServlet(AccountService accountService) {this.accountService = accountService;}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ( login == null || password == null){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.out.println("login and password is empty");
            return;
        }

        // TO DO
        // Add correct check is user registered or not
        try {
            accountService.getUserByLoginDB(login);
        }
        catch (DBException e){
            if (e.getMessage().contains("No data is available")){
                System.out.println("User " + login + " is not registered");
                accountService.addNewUserDB(login, password);
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_OK);
                System.out.println("user: " + login + ", pass: " + password + "was added to DB");
                return;
            }
            else {
                e.printStackTrace();
            }
        }
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        System.out.println("user "+ login + " is already exists");
    }

}
