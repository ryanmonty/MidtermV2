
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

	@Override
	public void checkIn(Club club) {
		int match = this.getClubName().compareTo(club.getName());

		if (match == 0) {
			System.out.println("Welcome, " + getName() + ", to the " + clubName);
		} else {
			System.out.println("Sorry, " + getName() + " doesn't belong to that zoo.");
		}
	}

	@Override
	protected void remove(Object memberDetails) {
		this.clubName = null;
	}

}