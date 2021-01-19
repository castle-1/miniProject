package edu.bit.ex.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.ex.Command.Command;
import edu.bit.ex.Command.ContentCommand;
import edu.bit.ex.Command.ListCommand;
import edu.bit.ex.Command.deleteCommand;
import edu.bit.ex.Command.modifyCommnad;
import edu.bit.ex.Command.relpyViewCommand;
import edu.bit.ex.Command.replyCommand;
import edu.bit.ex.Command.writeCommand;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");

		Command command = null;
		String viewPage = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String con = uri.substring(conPath.length());

		if (con.equals("/list.do")) {
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		} else if (con.equals("/content_view.do")) {
			command = new ContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		} else if (con.equals("/modify.do")) {
			command = new modifyCommnad();
			command.execute(request, response);
			viewPage = "list.do";
		} else if (con.equals("/reply_view.do")) {
			command = new relpyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		} else if (con.equals("/reply.do")) {
			command = new replyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if (con.equals("/delete.do")) {
			command = new deleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if (con.equals("/writeView.do")) {
			viewPage = "writeView.jsp";
		} else if (con.equals("/write.do")) {
			command = new writeCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}
