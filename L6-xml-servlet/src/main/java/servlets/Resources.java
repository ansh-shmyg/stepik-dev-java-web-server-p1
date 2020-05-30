package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import resources.TestResource;
import sax.ReadXMLFileSAX;


public class Resources extends HttpServlet {
    static final Logger logger = LogManager.getLogger(Resources.class.getName());
    public static final String PAGE_URL = "/resources";
    public String NAME = "";
    public int AGE = 0;
    private final TestResource testResource;
    public Resources(TestResource testResource) {this.testResource = testResource;}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        String xmlFile = request.getParameter("path");
        TestResource resource = (TestResource) ReadXMLFileSAX.readXML(xmlFile);
        NAME = resource.getName();
        AGE = resource.getAge();
        testResource.setAge(AGE);
        testResource.setName(NAME);
        response.getWriter().println("name = " + NAME + "; ");
        response.getWriter().println("age = " + AGE);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        String xmlFile = request.getParameter("path");
        TestResource resource = (TestResource) ReadXMLFileSAX.readXML(xmlFile);
        NAME = resource.getName();
        AGE = resource.getAge();
        testResource.setAge(AGE);
        testResource.setName(NAME);
        response.getWriter().println("name = " + NAME + "; ");
        response.getWriter().println("age = " + AGE);
    }
}
