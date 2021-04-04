import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DnT {
	float currentTime;
	int hours;
	int mins;
	int secs;
	float milli;
	
	public void render() {
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println(currentTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT)));
		
	}
	public static void main(String args[]) {
		
		
	}
}
