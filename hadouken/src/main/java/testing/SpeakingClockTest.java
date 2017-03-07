package testing;
import org.junit.Before;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class SpeakingClockTest {

	SpeakingClock sut;

	@Before
	public void setup() {
		sut = new SpeakingClock();
	}

	@Test
	public void tellTheTime_AM() {
		sut.tellTheTime();
		
	}

}
