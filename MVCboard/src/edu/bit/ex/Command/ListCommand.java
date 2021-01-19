package edu.bit.ex.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.ex.Dao.Dao;
import edu.bit.ex.Dto.Dto;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		Dao dao = new Dao();
		ArrayList<Dto> dto = dao.list();
		request.setAttribute("list", dto);
	}

}
