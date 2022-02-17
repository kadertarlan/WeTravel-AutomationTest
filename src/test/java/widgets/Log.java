package widgets;

import java.util.logging.Logger;

public class Log {

	private static Logger Log = Logger.getLogger(Log.class.getName());//
	
	public static void info(String message) {
        Log.info(message);
    }

	public static void warn(String message) {
        Log.warning(message);
    }

}
