package edu.bit.ex.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.ex.Dao.Dao;


public class replyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bId = request.getParameter("bId");
		String nName = request.getParameter("nName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");

		Dao dao = new Dao();
		dao.reply(bId, nName, bTitle, bContent, bGroup, bStep, bIndent);
		
	}

}
