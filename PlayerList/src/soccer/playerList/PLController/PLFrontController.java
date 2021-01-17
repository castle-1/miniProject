package soccer.playerList.PLController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccer.playerList.PLCommand.Command;
import soccer.playerList.PLCommand.PLListCommand;
import soccer.playerList.PLCommand.PLUpdateCommand;
import soccer.playerList.PLCommand.deleteCommand;
import soccer.playerList.PLCommand.modifyCommand;
import soccer.playerList.PLCommand.modifyViewCommand;

/**
 * Servlet implementation class PLFrontController
 */
@WebServlet("*.pl")
public class PLFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PLFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request,response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request,response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		System.out.println("actionDo");
		
		request.setCharacterEncoding("utf-8");
		Command command = null;
		String viewPage = null; 
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String con = uri.substring(conPath.length());
		
		if(con.equals("/list.pl")) {
			System.out.println("list.pl controller start");
			command = new PLListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}else if(con.equals("/updateView.pl")) {
			System.out.println("updateView.pl controller start");
			viewPage = "updateView.jsp";
		}else if(con.equals("/update.pl")) {
			System.out.println("update.pl controller start");
			command = new PLUpdateCommand();
			command.execute(request, response);
			viewPage = "list.pl";
		}else if(con.equals("/modifyView.pl")) {
			System.out.println("modifyView.pl controller start");
			command = new modifyViewCommand();
			command.execute(request, response);
			viewPage = "modifyView.jsp";
		}else if(con.equals("/modify.pl")) {
			System.err.println("modify.pl controller start");
			command = new modifyCommand();
			command.execute(request, response);
			viewPage = "list.pl";
		}else if(con.equals("/delete.pl")) {
			System.out.println("delete controller start");
			command = new deleteCommand();
			command.execute(request, response);
			viewPage = "list.pl";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	}

}
















