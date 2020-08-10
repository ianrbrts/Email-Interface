import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ControlServlet extends HttpServlet {
	

    private static final long serialVersionUID = 1L;
    private PeopleDAO peopleDAO;
    public String tempUser = null;
 
    public void init() {
        peopleDAO = new PeopleDAO(); 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
            case "/signup":
            	signUp(request,response);
            	break;
            	
            case "/login":
            	login(request,response);
            	break;
            case "/logout":
            	logout(request,response);
            	break;        
            case"compose":
            	compose(request,response);
            	break;
            	
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void compose(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException {
		//todo make compose text box
		
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		tempUser = null;
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request,response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException {
    	String email = request.getParameter("email");
    	String password = request.getParameter("password1");
    	tempUser = email;
    	
    	//checking if given credentials exist in db
    	if(peopleDAO.login(email, password)) {
    		List<Message> messageList = peopleDAO.getMail(email);
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("inbox.jsp");
    		request.setAttribute("messageitems", messageList);
    		dispatcher.forward(request,response);
    	}
    	else {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
    		dispatcher.forward(request,response);
    	}
	}

    private  void signUp(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException {
    	String email = request.getParameter("email");
    	String password = request.getParameter("password1");
    	String username = request.getParameter("username");
    	
    	tempUser = email;
    	
    	User signup = new User(email, password, username);
    	
    	peopleDAO.signUp(signup);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    	dispatcher.forward(request,response);
	}
}
    
   