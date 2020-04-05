package servlets;

import accounts.AccountService;
import accounts.UserProfile;

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

        UserProfile profile = accountService.getUserByLogin(login);

        // If profile is null - user does not exist
        if ( profile != null && profile.getLogin().equals(login) ) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            System.out.println("user "+ login + " is already exists");
            return;
        }
        // Create new user
        accountService.addNewUser(new UserProfile(login));
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        System.out.println("user " + login + " was added");
    }

}
