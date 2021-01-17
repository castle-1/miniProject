package soccer.playerList.PLDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import soccer.playerList.PLDto.PLDto;

public class PLDao {
	private DataSource dataSource;

	public PLDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<PLDto> list() {

		ArrayList<PLDto> pldtos = new ArrayList<PLDto>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from player";

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				String pName = resultSet.getString("pName");
				String pNationality = resultSet.getString("pNationality");
				Date pBirth = resultSet.getDate("pBirth");
				int pHeight = resultSet.getInt("pHeight");
				int pWeight = resultSet.getInt("pWeight");
				String pTeam = resultSet.getString("pTeam");
				int pBackNumber = resultSet.getInt("pBackNumber");
				String pPosition = resultSet.getString("pPosition");
				String pLeague = resultSet.getString("pLeague");

				PLDto pldto = new PLDto(pName, pNationality, pBirth, pHeight, pWeight, pTeam, pBackNumber, pPosition,
						pLeague);
				pldtos.add(pldto);
			}
			System.out.println("success listPrint");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		}

		return pldtos;
	}

	public void update(String pName, String pNationality, String pBirth, double pHeight, double pWeight, String pTeam,
			int pBackNumber, String pPosition, String pLeague) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into player values (?,?,?,?,?,?,?,?,?)";

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, pName);
			preparedStatement.setString(2, pNationality);
			preparedStatement.setString(3, pBirth);
			preparedStatement.setDouble(4, pHeight);
			preparedStatement.setDouble(5, pWeight);
			preparedStatement.setString(6, pTeam);
			preparedStatement.setInt(7, pBackNumber);
			preparedStatement.setString(8, pPosition);
			preparedStatement.setString(9, pLeague);

			int rn = preparedStatement.executeUpdate();
			System.out.println("update success" + rn);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}

		}

	}

	public PLDto modifyView(String StrpName) {

		PLDto pldto = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select * from player where pName=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, StrpName);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String pName = resultSet.getString("pName");
				String pNationality = resultSet.getString("pNationality");

				Date pBirth = resultSet.getDate("pBirth");

				double pHeight = resultSet.getDouble("pHeight");
				double pWeight = resultSet.getDouble("pWeight");
				String pTeam = resultSet.getString("pTeam");
				int pBackNumber = resultSet.getInt("pBackNumber");
				String pPosition = resultSet.getString("pPosition");
				String pLeague = resultSet.getString("pLeague");

				pldto = new PLDto(pName, pNationality, pBirth, pHeight, pWeight, pTeam, pBackNumber, pPosition,
						pLeague);

			}
			System.out.println("modifyView success");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

		return pldto;
	}

	public void modify(String pName, String pNationality, String pBirth, double pHeight, double pWeight, String pTeam,
			int pBackNumber, String pPosition, String pLeague) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "update player set pNationality = ?,pBirth=?,pHeight=?,pWeight=?,pTeam=?,pBackNumber=?,pPosition=?,pLeague=? where pName =?";

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, pNationality);
			preparedStatement.setString(2, pBirth);
			preparedStatement.setDouble(3, pHeight);
			preparedStatement.setDouble(4, pWeight);
			preparedStatement.setString(5, pTeam);
			preparedStatement.setInt(6, pBackNumber);
			preparedStatement.setString(7, pPosition);
			preparedStatement.setString(8, pLeague);

			preparedStatement.setString(9, pName);

			int rn = preparedStatement.executeUpdate();
			if (rn >= 1) {
				System.out.println("modify success ");
				System.out.println("rn = " + rn);
			} else if (rn == 0) {
				System.out.println("modify fail");
				System.out.println("rn = " + rn);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

	public void delete(String pName) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "delete from player where pName =?";
		
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pName);
			
			int rn = preparedStatement.executeUpdate();
			
			if(rn >= 1) {
				System.out.println("delete success " + rn);
			}else {
				System.out.println("delete fail " + rn);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

}
