package edu.bit.ex.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.ex.Dao.Dao;

public class deleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		Dao dao = new Dao();
		dao.delete(bId);
		
	}

}
