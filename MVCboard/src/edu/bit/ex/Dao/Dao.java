package edu.bit.ex.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.bit.ex.Dto.Dto;

public class Dao {

	private DataSource dataSource;

	public Dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Dto> list() {
		ArrayList<Dto> dtos = new ArrayList<Dto>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select * from "
					+ "mvc_board order by bGroup desc, bStep asc";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String nName = resultSet.getString("nName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				String bDate = resultSet.getString("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");

				Dto dto = new Dto(bId, nName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);

			}
			System.out.println("list success");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {

				e2.printStackTrace();
			}

		}
		return dtos;
	}

	public Dto contentView(String str) {
		Hit(str);
		Dto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select * from mvc_board where bId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(str));
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String nName = resultSet.getString("nName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				String bDate = resultSet.getString("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");

				dto = new Dto(bId, nName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);

			}
			System.out.println("contentView");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {

				e2.printStackTrace();
			}

		}
		return dto;
	}

	public void modify(int bId, String nName, String bTitle, String bContent) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "update mvc_board set nName = ?, bTitle = ?, bContent = ? where bId = ?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, nName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, bId);

			int rn = preparedStatement.executeUpdate();
			System.out.println("modify success" + rn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {

				e2.printStackTrace();
			}

		}

	}

	public Dto replyView(int bid) {

		Dto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String query = "select * from mvc_board where bId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bid);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String nName = resultSet.getString("nName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				String bDate = resultSet.getString("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");

				dto = new Dto(bId, nName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);

			}
			System.out.println("replyView success");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {

				e2.printStackTrace();
			}

		}
		return dto;
	}

	public void reply(String bId, String nName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {
		replyShape(bGroup, bStep);

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "insert into mvc_board (bId, nName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, nName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);

			preparedStatement.setInt(4, Integer.parseInt(bGroup));
			preparedStatement.setInt(5, Integer.parseInt(bStep) + 1);
			preparedStatement.setInt(6, Integer.parseInt(bIndent) + 1);

			int rn = preparedStatement.executeUpdate();
			System.out.println("reply success" + rn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {

				e2.printStackTrace();
			}

		}

	}

	private void replyShape(String bGroup, String bStep) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bGroup) + 1);
			preparedStatement.setInt(2, Integer.parseInt(bStep) + 1);

			int rn = preparedStatement.executeUpdate();
			System.out.println("replyShape success" + rn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	public void delete(int bId) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "delete from mvc_board where bId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bId);

			int rn = preparedStatement.executeUpdate();
			System.out.println("delete success" + rn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	public void write(String nName, String bTitle, String bContent ) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "insert into mvc_board(bId,nName,bTitle,bContent,bHit,bGroup,bStep,bIndent) values(mvc_board_seq.nextval,?,?,?,0,mvc_board_seq.currval,0,0)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);

			int rn = preparedStatement.executeUpdate();
			System.out.println("write success" + rn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public void Hit(String bId) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bId);
			int rn = preparedStatement.executeUpdate();
			
			System.out.println("hit success" +rn);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {

				e2.printStackTrace();
			}
		}

		
		
		
	}

}
