
public class MultiMembers extends MemberDetails {
	private int memPoints;
	
	public int getMemPoints() {
		return memPoints;
	}

	public void setMemPoints(int memPoints) {
		this.memPoints = memPoints;
	}

	public MultiMembers(String name, int memPoints, int months ) {
		super(name, months);
		this.memPoints = memPoints;
	}
	
	@Override
	public void checkIn(Club club) {
		this.memPoints = this.memPoints + 5;
		System.out.println("\nCurrent Membership Points Balance: " + this.memPoints);
		
	}
	@Override
	protected void remove(Object memberDetails) {
		this.memPoints = 0;
	}
	@Override
	public void display() {
		System.out.println("Name:" + this.getName()
						+  "\nID: " + this.getId()
						+  "\nMemberShip Points: " + this.getMemPoints()
						+  "\nCurrent Months with the park: " + this.getMonths()
						+  "\nMembership Type: Multi Park Access");
			
	}

}