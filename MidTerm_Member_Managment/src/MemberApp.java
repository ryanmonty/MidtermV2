import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Date;

public class MemberApp {

	private static ArrayList<MemberDetails> members = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// switch statement:
		// add, delete, display member info
		Club[] clubs = { new Club("Detroit Zoo", "8450 W 10 Mile Rd, Royal Oak, MI 48067"),
				new Club("Belle Isle", "3 Inselruhe Ave, Detroit, MI 48207"),
				new Club("Georgia Aquarium", "225 Baker St NW, Atlanta, GA 30313"),
				new Club("Stage Nature Center", "6685 Coolidge Hwy, Troy, MI 48098") };

		members.add(new SingleMembers("Larry Lizard", clubs[0].getName(), 11));
		members.add(new SingleMembers("Sally Snake", clubs[2].getName(), 8));
		members.add(new MultiMembers("Karen Kangaroo", 0, 6));
		members.add(new MultiMembers("Emily Elephant", 5, 5));

		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		boolean willContinue;


		System.out.println("Welcome to the Zoo-Keeper App!\n ");

		do {
			System.out.println("Please Select An Option:\n1. Create A New Member\n2. List Current Members");
			int userChoice = scan.nextInt();
			scan.nextLine();

			if (userChoice == 1) {
				String newMemName = getUserInput("Enter the new member's full name:", scan);
				String newMemType = getUserInput("Choose a membership type - Select [1] to join a single location or [2] to access multiple locations:", scan);

				if (newMemType.equals("1")) { 
					String newMemHomeClub = getUserInput("Which park does the member wish to join?\n1. Detroit Zoo 8450 W 10 Mile Rd, Royal Oak, MI 48067" 
				+ "\n2. Belle Isle 3 Inselruhe Ave, Detroit, MI 48207"
				+ "\n3. Georgia Aquarium 225 Baker St NW, Atlanta, GA 30313"
				+ "\n4. Stage Nature Center 6685 Coolidge Hwy, Troy, MI 48098",scan);
					members.add(new SingleMembers(newMemName, clubs[Integer.parseInt(newMemHomeClub) - 1].getName(), 1));
					discount(members.get(members.size()-1));//for the last member added if the hour is odd give discount

				} else if (newMemType.equals("2")) {
					members.add(new MultiMembers(newMemName, 0, 1));
					discount(members.get(members.size()-1));//for the last member added if the hour is odd give discount
				} else {
					System.out.println("Please Select an appropriate option.");
					
				}
			} else if (userChoice == 2) {
				System.out.println("Please select a member by ID number");
				
				HashMap<Integer, String> memberMap = convertArrayListToHashMap(members);
				// printing the HashMap
				for (Entry<Integer, String> entry : memberMap.entrySet()) {

					System.out.println(entry.getKey() + ". " + entry.getValue());
				}
				int memId = scan2.nextInt();// Member ID from user

				for (int selectedMember = 0; selectedMember < members.size();selectedMember++) {

					if (members.get(selectedMember).getId() == memId) {
						System.out.println(members.get(selectedMember).toString());

						System.out.println(
								"Please select an option: \n1. Check Member In\n2. Current Balance\n3. Cancel Membership\n4. Display Member Information");

						int choice = scan2.nextInt();

						switch (choice) {
						case 1://1. Check Member In

							if (members.get(selectedMember) instanceof SingleMembers) {
								System.out.println("What zoo is the member checking into?\n"
										+ "\n1. Detroit Zoo 8450 W 10 Mile Rd, Royal Oak, MI 48067"
													+ "\n2. Belle Isle 3 Inselruhe Ave, Detroit, MI 48207"
													+ "\n3. Georgia Aquarium 225 Baker St NW, Atlanta, GA 30313"
													+ "\n4. Stage Nature Center 6685 Coolidge Hwy, Troy, MI 48098");
							int homeClubChoice = scan2.nextInt();//Second scanner to allow for program to flow and ask Contiune
								
								members.get(selectedMember).checkIn(clubs[homeClubChoice - 1]);
								
							}  
							else if (members.get(selectedMember) instanceof MultiMembers){
								System.out.println("Be sure to tell " + members.get(selectedMember).getName()
										+ " about their 5 new membership points!");
								members.get(selectedMember).checkIn(null);
							}
							break;
						case 2://2. Current Bill of Fees for 

							if (members.get(selectedMember) instanceof SingleMembers) {
								int balance = (members.get(selectedMember).getMonths() * 10);
								System.out.println(members.get(selectedMember).getName() + "'s current balance is: $" + balance);
							}  
							else if (members.get(selectedMember) instanceof MultiMembers) {
								int balance = (members.get(selectedMember).getMonths() * 15);
								System.out.println(members.get(selectedMember).getName() + "'s current balance is: $" + balance);
							}
							break;
						case 3://3. Cancel Membership
							System.out.println("Removing " + members.get(selectedMember).getName());						
							members.remove(selectedMember);
							
							break;
						case 4://4. Display Member Information
							System.out.println(members.get(selectedMember).toString());	
							System.out.println("Months with the park:" + members.get(selectedMember).getMonths());	
							members.get(selectedMember).display();				
							
							break;
						
							}
						}
					}
				
			} else {
				System.out.println("Please select 1 or 2");
			}	
			
			System.out.println("Continue? (y/n)");
			String userWantsToContinue = scan.nextLine();
			if (userWantsToContinue.toLowerCase().startsWith("y")) {
				willContinue = true;
			} else {
				willContinue = false;
			}
		} while (willContinue);
		//System.out.println("Goodbye!");

	}

	private static String getUserInput(String prompt, Scanner scan) {
		System.out.println(prompt);
		return scan.nextLine();
	}

	private static LinkedHashMap<Integer, String> convertArrayListToHashMap(ArrayList<MemberDetails> members) {

		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

		for (MemberDetails member : members) {

			linkedHashMap.put(member.getId(), member.getName());
		}

		return linkedHashMap;
	}
	private static void discount(MemberDetails member) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if (hour%2 == 0) {
			System.out.println("Prime time to Join!!! New members who join when the hour" 
		+ "\nof the day is even receive their first month free!");
		} else {
			System.out.println("Prime time to Join!!! New members who join when the hour" 
					+ "\nof the day is odd receive pizza!");
		}
	
	}


}