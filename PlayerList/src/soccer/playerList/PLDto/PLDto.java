package soccer.playerList.PLDto;

import java.sql.Date;

public class PLDto {

	private String pName;
	private String pNationality;
	private Date pBirth;
	private double pHeight;
	private double pWeight;
	private String pTeam;
	private int pBackNumber;
	private String pPosition;
	private String pLeague;

	public PLDto() {
		super();
	}

	
	

	public PLDto(String pName, String pNationality, Date pBirth, double pHeight, double pWeight, String pTeam,
			int pBackNumber, String pPosition, String pLeague) {
		super();
		this.pName = pName;
		this.pNationality = pNationality;
		this.pBirth = pBirth;
		this.pHeight = pHeight;
		this.pWeight = pWeight;
		this.pTeam = pTeam;
		this.pBackNumber = pBackNumber;
		this.pPosition = pPosition;
		this.pLeague = pLeague;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpNationality() {
		return pNationality;
	}

	public void setpNationality(String pNationality) {
		this.pNationality = pNationality;
	}

	public Date getpBirth() {
		return pBirth;
	}

	public void setpBirth(Date pBirth) {
		this.pBirth = pBirth;
	}

	public double getpHeight() {
		return pHeight;
	}

	public void setDpHeight(double pHeight) {
		this.pHeight = pHeight;
	}

	public double getpWeight() {
		return pWeight;
	}

	public void setpWeight(double pWeight) {
		this.pWeight = pWeight;
	}

	public String getpTeam() {
		return pTeam;
	}

	public void setpTeam(String pTeam) {
		this.pTeam = pTeam;
	}

	public int getpBackNumber() {
		return pBackNumber;
	}

	public void setpBackNumber(int pBackNumber) {
		this.pBackNumber = pBackNumber;
	}

	public String getpPosition() {
		return pPosition;
	}

	public void setPosition(String pPosition) {
		this.pPosition = pPosition;
	}

	public String getpLeague() {
		return pLeague;
	}

	public void setpLeague(String pLeague) {
		this.pLeague = pLeague;
	}

}
