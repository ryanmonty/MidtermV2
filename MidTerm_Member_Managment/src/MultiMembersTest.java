import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class MultiMembersTest {

	@Test
	void testMemPointsStartsAtZero() {
		MultiMembers mm = new MultiMembers("Phil", 0, 1);
		mm.getMemPoints();
		assertEquals(0, mm.getMemPoints());
	}
	
	@Test
	void testGetMemPointsWithOneCheckIn() {
		MultiMembers mm = new MultiMembers("Jake", 0, 1);
		mm.checkIn(null);
		assertEquals(5, mm.getMemPoints());
	}
	//FIX
	@Test
	void testGetMemPointsWithTwoCheckIns() {
		MultiMembers mm = new MultiMembers("Paul", 0, 2);
		mm.checkIn(null);
		mm.checkIn(null);
		assertEquals(10, mm.getMemPoints());
	}
	
	@Test
	void testRemoveMember() {
		MultiMembers mm = new MultiMembers("Stacy", 135, 6);
		mm.remove(mm);
		assertEquals(0, mm.getMemPoints());
	}

}