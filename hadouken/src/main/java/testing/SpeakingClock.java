package testing;

public class SpeakingClock {
	
	IClock clock;
	ISpeechSynthesizer synth;
	SpeakingClockEngine engine;
	
	public void tellTheTime(){
		String time = engine.asSpeech(clock.getTime());
		synth.speak(time);
	}
}
