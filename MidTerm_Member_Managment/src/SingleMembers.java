
public class SingleMembers extends MemberDetails {
	private String clubName;
	
	
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	
	
	
	//default constructor
	
	public SingleMembers(String name, String clubName, int months) {
		super(name, months);
		this.clubName = clubName;
		
	}
	@Override
	public void checkIn(Club club) {
		 try {
	            this.getClubName().compareTo(club.getName());
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("This member does not belong to this club");
	        }		
	}
	@Override
	protected void remove(Object memberDetails) {
		this.clubName = null;
		
	}

}