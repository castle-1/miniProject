package soccer.playerList.PLCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccer.playerList.PLDao.PLDao;
import soccer.playerList.PLDto.PLDto;

public class modifyViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String pName = request.getParameter("pName");
		PLDao pldao = new PLDao();
		PLDto pldto = pldao.modifyView(pName);
		request.setAttribute("modifyView", pldto);
		
	}

}
