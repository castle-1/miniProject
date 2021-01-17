package soccer.playerList.PLCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soccer.playerList.PLDao.PLDao;
import soccer.playerList.PLDto.PLDto;

public class PLListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
				
		PLDao pldao = new PLDao();
		ArrayList<PLDto> pldto = pldao.list();
		request.setAttribute("list", pldto);
	}

}
