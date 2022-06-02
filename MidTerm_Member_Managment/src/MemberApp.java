import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class MemberApp {

	private static ArrayList<MemberDetails> members = new ArrayList<>();

	public static void main(String[] args) {

		Club[] clubs = { new Club("Detroit Zoo", "8450 W 10 Mile Rd, Royal Oak, MI 48067"),
				new Club("Toledo Zoo", "2 Hippo Way, Toledo, OH 43609"),
				new Club("San Diego Zoo", "2920 Zoo Dr, San Diego, CA 92101"),
				new Club("Bronx Zoo", "2300 Southern Blvd, Bronx, NY 10460") };

		members.add(new SingleMembers("Larry Lizard", clubs[0].getName(), 11));
		members.add(new SingleMembers("Sally Snake", clubs[2].getName(), 8));
		members.add(new MultiMembers("Karen Kangaroo", 0, 6));
		members.add(new MultiMembers("Emily Elephant", 5, 5));

		Scanner scan = new Scanner(System.in);
		boolean willContinue = false;
		int memDelete = 0;

		System.out.println("Welcome to the Zoo-Keeper App!\n");

		do {
			System.out.println("Please Select An Option:\n1. Create A New Member\n2. List Current Members");
			int userChoice = scan.nextInt();
			scan.nextLine();

			if (userChoice == 1) {
				System.out.println("Enter the new member's full name:");
				String newMemName = scan.nextLine();

				System.out.println(
						"Choose a membership type - Select [1] to join a single location or [2] to access multiple locations:\n1. Single \n2. Multi");
				String newMemType = scan.nextLine();

				if (newMemType.equals("1")) {
					String newMemHomeClub = getUserInput(
							"Which zoo does the member wish to join?\n1. Detroit Zoo\n2. Toledo Zoo\n3. San Diego Zoo\n4. Bronx Zoo",
							scan);
					members.add(
							new SingleMembers(newMemName, clubs[Integer.parseInt(newMemHomeClub) - 1].getName(), 1));
					System.out.println(members.toString());

				} else if (newMemType.equals("2")) {
					members.add(new MultiMembers(newMemName, 0, 1));

				} else {
					System.out.println("Please select an appropriate option.");
				}

			} else if (userChoice == 2) {
				System.out.println("Please select a member by ID number");

				HashMap<Integer, String> memberMap = convertArrayListToHashMap(members);

				// printing the HashMap
				for (Entry<Integer, String> entry : memberMap.entrySet()) {
					System.out.println(entry.getKey() + ". " + entry.getValue());
				}
				int memId = scan.nextInt();

				for (MemberDetails member : members) {

					if (member.getId() == memId) {
						System.out.println(member.toString());

						System.out.println(
								"Please select an option: \n1. Check Member In\n2. Current Balance\n3. Cancel Membership");

						int choice = scan.nextInt();

						switch (choice) {
						case 1:
							if (member instanceof SingleMembers) {
								String homeClubChoice = getUserInput(
										"What zoo is the member checking into?"
												+ "\n1. Detroit Zoo\n2. Toledo Zoo\n3. San Diego Zoo\n4. Bronx Zoo",
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
<<<<<<< HEAD
							Iterator<MemberDetails> it = members.iterator();
							while (it.hasNext()) {
								MemberDetails s = it.next();
								
								if (s.equals(member))
								    it.remove();

								System.out.println(members);
								break;

							}
						}
					}
				}
				
=======
							memDelete = member.getId() - 1;
							System.out.println("Removing " + member.getName());

							members.remove(memDelete);// remove requested member
							memDelete = 0; // clear requested member delete
							break;

						default:
							System.out.println("Invalid input");
						}
					}
				}

>>>>>>> f30f123b889e858355f998aa08dd2480a6522a99
			} else {
				willContinue = false;
			}

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