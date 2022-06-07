
public class SingleMembers extends MemberDetails {
	private String clubName;

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	// default constructor
	public SingleMembers(String name, String clubName, int months) {
		super(name, months);
		this.clubName = clubName;
	}
<<<<<<< HEAD
	
	//implementation of abstract method
	@Override
	public void checkIn(Club club) {
		 
		try {
	            if (this.getClubName().compareTo(club.getName()) == 0){
	            	System.out.println("Welcome" + " to the "
							+ club.getName() + "!");
	            }
	            else {
	            	System.out.println("This furry friend does not belong to this club :)");
	            }
	            
	        }
		catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Sorry, this member doesn't belong to that park.");
	        }		
=======

	@Override
	public void checkIn(Club club) {
		int match = this.getClubName().compareTo(club.getName());

		if (match == 0) {
			System.out.println("Welcome, " + getName() + ", to the " + clubName);
		} else {
			System.out.println("Sorry, " + getName() + " doesn't belong to that zoo.");
		}
>>>>>>> 2c52b07019e49ab70e181f7730c499d2471ddac0
	}

	@Override
	protected void remove(Object memberDetails) {
		this.clubName = null;
	}
	@Override
	public void display() {
		System.out.println("Name:" + this.getName()
						+  "\nID: " + this.getId()
						+  "\nHome Zoo: " + this.getClubName()
						+  "\nCurrent Months with the park: " + this.getMonths()
						+  "\nMembership Type: Single park Access");
			
	}

}