package soccer.playerList.PLCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccer.playerList.PLDao.PLDao;

public class PLUpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pName = request.getParameter("pName");
		String pNationality = request.getParameter("pNationality");
		String pBirth =  request.getParameter("pBirth");
		double pHeight = Double.parseDouble(request.getParameter("pHeight"));
		double pWeight = Double.parseDouble(request.getParameter("pWeight"));
		String pTeam = request.getParameter("pTeam");
		int pBackNumber = Integer.parseInt(request.getParameter("pBackNumber"));
		String pPosition = request.getParameter("pPosition");
		String pLeague = request.getParameter("pLeague");

		PLDao pldao = new PLDao();
		pldao.update(pName, pNationality, pBirth, pHeight, pWeight, pTeam, pBackNumber, pPosition, pLeague);
	}

}
