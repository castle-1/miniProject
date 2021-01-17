package soccer.playerList.PLCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccer.playerList.PLDao.PLDao;

public class deleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pName = request.getParameter("pName");
		PLDao pldao = new PLDao();
		pldao.delete(pName);
		
	}

}
