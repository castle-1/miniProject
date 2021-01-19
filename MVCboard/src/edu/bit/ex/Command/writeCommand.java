package edu.bit.ex.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.ex.Dao.Dao;
import edu.bit.ex.Dto.Dto;

public class writeCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String nName = request.getParameter("nName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		Dao dao = new Dao();
		dao.write(nName,bTitle,bContent);
	}

}
