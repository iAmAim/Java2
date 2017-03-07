package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MockitoingTest {

	Mockitoing sut;

	@Before
	public void setup() {

		sut = new Mockitoing();
	}

	@Test
	public void testTime_AM() {
		String morning11am = "11:00am";
		String morning11amWords = "eleven oclock am";
		assertTrue(sut.getTimeAsWords(morning11am).equals(morning11amWords));
	}
	

	@Test
	public void testTime_AM_error() {
		String morning21am = " 12:00am";
		String morning21amWords = "error";
		assertTrue(sut.getTimeAsWords(morning21am).equals(morning21amWords));
	}


}
