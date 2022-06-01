import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingleMembersTest {

	@Test
	void testGetClub() {
		SingleMembers sm = new SingleMembers("Bruce", "Gym", 5);
		assertEquals("Gym", sm.getClubName());
	}

	@Test
	void testGetName() {
		SingleMembers sm = new SingleMembers("Bruce", "Gym", 5);
		assertEquals("Bruce", sm.getName());
	}

	@Test
	void testCheckIn() {
		Club club = new Club("Clubby McClubClub", "123 Club Street");
		assertEquals("Clubby McClubClub", club.getName());
		assertEquals("123 Club Street", club.getAddress());
	}
	//FINISH??
	@Test
	void testIncorrectCheckInLocation() {
		SingleMembers sm = new SingleMembers("Regina", "Correct Club", 5);
		Club club = new Club("Plastics Club", "123 Mean Girls Street");
		sm.checkIn(club);
		
	//	int expected = 0;
	//	int actual = sm.getClubName().si
		
	}
		
	@Test
	void testMemberDetails() {
		SingleMembers sm = new SingleMembers("Regina George", "Plastics Club", 18);
		Club club = new Club("Plastics Club", "123 Mean Girls Street");
		sm.getName();
		sm.getId();
		sm.getMonths();
	//	assertsEquals(sm.);
		
		
	}

}