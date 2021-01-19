package edu.bit.ex.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.ex.Dao.Dao;
import edu.bit.ex.Dto.Dto;

public class relpyViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		Dao dao = new Dao();
		Dto dto = dao.replyView(bId);
		
		request.setAttribute("replyView", dto);
	}

}
