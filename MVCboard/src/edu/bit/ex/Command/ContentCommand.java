package edu.bit.ex.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.ex.Dao.Dao;
import edu.bit.ex.Dto.Dto;

public class ContentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bId = request.getParameter("bId");
		Dao dao = new Dao();
		Dto dto = dao.contentView(bId);
		request.setAttribute("contentView", dto);
		
	}

}
