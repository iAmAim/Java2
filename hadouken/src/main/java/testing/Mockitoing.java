package testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mockitoing {



	public String getTimeAsWords(String time) {

		String timePattern = "(.*):(.*)(am)";
		if (time.matches(timePattern)) {
			Pattern p = Pattern.compile(timePattern);
			Matcher m = p.matcher(time);
			while (m.find()) {
				
				for (HourAsWord hour : HourAsWord.values()) {
					if (m.group(1).equals(hour.toString())) {
						return hour.name() + " oclock am";
					}
				}

			}

		}
		return "error";
	}

}

enum HourAsWord {
	eleven("11"),twelve("12");;
	private String time;

	HourAsWord(String time) {
		this.time = time;
	}

	public String toString() {
		return this.time;
	}
}
