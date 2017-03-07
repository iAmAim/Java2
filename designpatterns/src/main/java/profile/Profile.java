package profile;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Profile {
	
	 Units timeUnits() default Units.MILLISECS; 
	 public enum Units {
		   MILLISECS, SECONDS
		}
}
