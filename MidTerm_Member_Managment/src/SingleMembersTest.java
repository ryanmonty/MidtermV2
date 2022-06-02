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
	
	@Test
	void testSingleCheckIn() {
		Club club = new Club("Clubby McClubClub", "123 Club Street");
		SingleMembers sm = new SingleMembers("Bruce", "Clubby McClubClub", 2 );
		assertEquals(club, sm.getClubName());
	}

}