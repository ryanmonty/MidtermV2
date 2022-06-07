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

<<<<<<< HEAD
		// switch statement:
		// add, delete, display member info
=======
>>>>>>> 2c52b07019e49ab70e181f7730c499d2471ddac0
		Club[] clubs = { new Club("Detroit Zoo", "8450 W 10 Mile Rd, Royal Oak, MI 48067"),
				new Club("Belle Isle", "3 Inselruhe Ave, Detroit, MI 48207"),
				new Club("Georgia Aquarium", "225 Baker St NW, Atlanta, GA 30313"),
				new Club("Stage Nature Center", "6685 Coolidge Hwy, Troy, MI 48098") };

		members.add(new SingleMembers("Larry Lizard", clubs[0].getName(), 11));
		members.add(new SingleMembers("Sally Snake", clubs[2].getName(), 8));
		members.add(new MultiMembers("Karen Kangaroo", 0, 6));
		members.add(new MultiMembers("Emily Elephant", 5, 5));

		Scanner scan = new Scanner(System.in);
<<<<<<< HEAD
		Scanner scan2 = new Scanner(System.in);
		boolean willContinue;


		System.out.println("Welcome to the Zoo-Keeper App!\n ");

		do {
=======
		boolean willContinue = true;
		Integer IntMemDelete = 10;

		System.out.println("Welcome to the Zoo-Keeper App!\n");

		while (willContinue) {
>>>>>>> 2c52b07019e49ab70e181f7730c499d2471ddac0
			System.out.println("Please Select An Option:\n1. Create A New Member\n2. List Current Members");
			int userChoice = scan.nextInt();
			scan.nextLine();

			if (userChoice == 1) {
<<<<<<< HEAD
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
					
=======
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

				} else if (newMemType.equals("2")) {
					members.add(new MultiMembers(newMemName, 0, 1));

				} else {
					System.out.println("Please select an appropriate option.");
>>>>>>> 2c52b07019e49ab70e181f7730c499d2471ddac0
				}
				System.out.println("person is now joined to zoo");

			} else if (userChoice == 2) {
				System.out.println("Please select a member by ID number");
<<<<<<< HEAD
				
=======

>>>>>>> 2c52b07019e49ab70e181f7730c499d2471ddac0
				HashMap<Integer, String> memberMap = convertArrayListToHashMap(members);
				// printing the HashMap
				for (Entry<Integer, String> entry : memberMap.entrySet()) {
					System.out.println(entry.getKey() + ". " + entry.getValue());
				}
<<<<<<< HEAD
				int memId = scan2.nextInt();// Member ID from user
=======
				int memId = scan.nextInt();
>>>>>>> 2c52b07019e49ab70e181f7730c499d2471ddac0

				for (int selectedMember = 0; selectedMember < members.size();selectedMember++) {

					if (members.get(selectedMember).getId() == memId) {
						System.out.println(members.get(selectedMember).toString());

						System.out.println(
								"Please select an option: \n1. Check Member In\n2. Current Balance\n3. Cancel Membership\n4. Display Member Information");

						int choice = scan.nextInt();

						switch (choice) {
<<<<<<< HEAD
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
=======
						case 1:
							String homeClubChoice = getUserInput("What zoo is the member checking into?"
									+ "\n1. Detroit Zoo\n2. Toledo Zoo\n3. San Diego Zoo\n4. Bronx Zoo", scan);
							if (member instanceof SingleMembers) {
								try {

									int clubChoice = scan.nextInt();
									member.checkIn(clubs[clubChoice - 1]);
								} catch (ArrayIndexOutOfBoundsException e) {
									System.out.println("Please select from one of the existing clubs.");
								}

							} else {
								member.checkIn(null);
								System.out.println("Be sure to tell " + member.getName()
>>>>>>> 2c52b07019e49ab70e181f7730c499d2471ddac0
										+ " about their 5 new membership points!");
								members.get(selectedMember).checkIn(null);
							}
							break;
<<<<<<< HEAD
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
			
=======

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


							IntMemDelete = member.getId() - 1;
							System.out.println("Removing " + member.getName());
							members.remove(Integer.parseInt(IntMemDelete.toString()));// remove requested member
							break;

						default:
							System.out.println("Invalid input");
						}
					}
				}


			} else {
				willContinue = false;
			}

>>>>>>> 2c52b07019e49ab70e181f7730c499d2471ddac0
			System.out.println("Continue? (y/n)");
			String userWantsToContinue = scan.next();

			if (userWantsToContinue.equalsIgnoreCase("y")) {
				willContinue = true;

			} else {
				willContinue = false;
				System.out.println("Goodbye!");
			}
<<<<<<< HEAD
		} while (willContinue);
		//System.out.println("Goodbye!");
=======

		}
>>>>>>> 2c52b07019e49ab70e181f7730c499d2471ddac0

	}

	private static String getUserInput(String prompt, Scanner scan) {
		System.out.println(prompt);
		return scan.nextLine();
	}

	private static LinkedHashMap<Integer, String> convertArrayListToHashMap(ArrayList<MemberDetails> members) {
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

		for (MemberDetails member : members) {
<<<<<<< HEAD

			linkedHashMap.put(member.getId(), member.getName());
=======
			linkedHashMap.put(members.indexOf(member) + 1, member.getName());
>>>>>>> 2c52b07019e49ab70e181f7730c499d2471ddac0
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