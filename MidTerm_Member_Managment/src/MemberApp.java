import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class MemberApp {

	private static ArrayList<MemberDetails> members = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// switch statement:
		// add, delete, display member info
		Club[] clubs = { new Club("DownTownFit", "123 Downtown Street"),
				new Club("FitnessThisWholeBurgerInMyMouth", "Foodcourt"), new Club("UpTownFit", "321 Uptown Street"),
				new Club("CornerTownFit", "000 Cornertown Street") };

		members.add(new SingleMembers("John Doe", clubs[0].getName(), 11));
		members.add(new SingleMembers("Mary Moe", clubs[2].getName(), 8));
		members.add(new MultiMembers("Jack Foe", 0, 6));
		members.add(new MultiMembers("Emily Toe", 5, 5));

		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		boolean willContinue = false;
		int memDelete = 0;

		System.out.println("Welcome to the Member Management App!! \n ");

		do {
			System.out.println("Please Select an option?\n1. Adding Members\n2. Member Checkin");
			int userChoice = scan.nextInt();
			scan.nextLine();

			if (userChoice == 1) {
				String newMemName = getUserInput("What is the new member's name?", scan);
				String newMemType = getUserInput("Are they choosing a single or multi membership?", scan);

				if (newMemType.equals("single")) {
					String newMemHomeClub = getUserInput("What is the name of their Home club?"
							+ "\n1. DownTownFit\n2. FitnessThisWholeBurgerInMyMouth\n3. UpTownFit\n4. CornerTownFit",
							scan);
					members.add(
							new SingleMembers(newMemName, clubs[Integer.parseInt(newMemHomeClub) - 1].getName(), 1));

				} else if (newMemType.equals("multi")) {
					members.add(new MultiMembers(newMemName, 0, 1));
				} else {
					System.out.println("Please Select an appropriate option.");
				}
			} else if (userChoice == 2) {
				HashMap<Integer, String> memberMap = convertArrayListToHashMap(members);

				// printing the HashMap
				for (Entry<Integer, String> entry : memberMap.entrySet()) {

					System.out.println(entry.getKey() + ". " + entry.getValue());
				}
				System.out.println("Please select a member by ID number");
				int memId = scan2.nextInt();

				for (MemberDetails member : members) {

					if (member.getId() == memId) {
						System.out.println(member.toString());

						System.out.println(
								"Please select an option: \n1. Check Member In\n2. Current Balance\n3. Cancel Membership");

						int choice = scan2.nextInt();

						switch (choice) {
						case 1:

							if (member instanceof SingleMembers) {
								String homeClubChoice = getUserInput("What is the name of their Home club?"
										+ "\n1. DownTownFit\n2. FitnessThisWholeBurgerInMyMouth\n3. UpTownFit\n4. CornerTownFit",
										scan);
								member.checkIn(clubs[Integer.parseInt(homeClubChoice) - 1]);
								System.out.println("Welcome " + member.getName() + " to "
										+ clubs[Integer.parseInt(homeClubChoice) - 1].getName());
							} else {
								member.checkIn(null);
								System.out.println("Be sure to tell " + member.getName()
										+ " about their 5 new membership points!");
							}
							break;
						case 2:

							if (member instanceof SingleMembers) {
								int balance = (member.getMonths() * 10);
								System.out.println(member.getName() + "'s current balance is: $" + balance);
							} else {
								int balance = (member.getMonths() * 15);
								System.out.println(member.getName() + "'s current balance is: $" + balance);
							}
							break;
						case 3:
							memDelete = member.getId() - 1;
							System.out.println("Removing " + member.getName());
							
//							Iterator<MemberDetails> itr = members.iterator();
//
//							while (itr.hasNext()) {
//							    MemberDetails number = itr.next();
//
//							       if (number == member ) {
//							       itr.remove();
//							    }
//							       System.out.println(members);
//							}
//							
							
//							for (int i = 0; i < members.size(); i++) {
//								
//								if ((member.getId()) == (i+1)) {
//									System.out.println("Removing " + member.getName());
//									members.remove(member);
//								
//								}
//							}
							//System.out.println(members.toString());
							break;
						}
					}
				}
			} else {
				willContinue = false;
			}
			
			members.remove(memDelete);//remove requested member
			memDelete = 0; //clear requested member delete
			
			
			System.out.println("Continue? (y/n)");
			String userWantsToContinue = scan.nextLine();
			if (userWantsToContinue.toLowerCase().startsWith("y")) {
				willContinue = true;
			} else {
				willContinue = false;
			}
		} while (willContinue);
		System.out.println("Goodbye!");

	}

	private static String getUserInput(String prompt, Scanner scan) {
		System.out.println(prompt);
		return scan.nextLine();
	}

	private static LinkedHashMap<Integer, String> convertArrayListToHashMap(ArrayList<MemberDetails> members) {

		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

		for (MemberDetails member : members) {

			linkedHashMap.put(members.indexOf(member) + 1, member.getName());
		}

		return linkedHashMap;
	}

}