import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClubTest {

	@Test
	void testGetName() {
		Club club = new Club("Club", "123 Address");
		assertEquals("Club", club.getName());
	}
	
	@Test
	void testGetAddress() {
		Club club = new Club("Club", "123 Address");
		assertEquals("123 Address", club.getAddress());
	}
	
	@Test
	void testClubInfo() {
		Club club = new Club("Club", "123 Address");
		assertEquals("Club", club.getName());
		assertEquals("123 Address", club.getAddress());
	}

}