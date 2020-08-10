import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/PeopleDAO")
public class PeopleDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	public PeopleDAO() {

    }
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connect = (Connection) DriverManager
        			      .getConnection("jdbc:mysql://localhost:3306/mail?&"
        			          + "user=john&password=pass1234");
                System.out.println("Connection made");
                statement = connect.createStatement();
                
             
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            
            System.out.println(connect);
        }
    }
    
   protected void signUp(User user) throws SQLException {
	   connect_func();
	   String sql = "INSERT into users (email, password, username) values (?, ?, ?)";
	   
	   preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
   	   preparedStatement.setString(1, user.getEmail());
   	   preparedStatement.setString(2, user.getPassword());
       preparedStatement.setString(3, user.getUsername());
       
       preparedStatement.executeUpdate();
   }

	public boolean login(String email, String password)throws SQLException {
		connect_func();
		
		String sql = "select email, password from users where email = ? and password = md5(?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, email);
   	    preparedStatement.setString(2, password);
   	    
   	    ResultSet resultSet = preparedStatement.executeQuery();
   	    
   	    if(resultSet.first()){
   	    	return true;
   	    }
   	    else {
   	    	return false;
   	    }
		
	}

	public List<Message> getMail(String email)throws SQLException {
		connect_func();
		
		List<Message> messageList = new ArrayList<Message>();
		
		String sql = "select * from messages where recipient = ?";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, email);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			String subject = resultSet.getString("subject");
			String sender = resultSet.getString("sender");
			String content = resultSet.getString("content");
			String time = resultSet.getString("time");
			int id = resultSet.getInt("messageid");
			
			Message message = new Message(subject, sender, content, time, id);
			messageList.add(message);
			
		}
		
		return messageList;
		
	}
   
}
