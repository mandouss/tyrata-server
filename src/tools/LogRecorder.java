package tools;
import java.io.*;
import models.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/***
 * 
 * 
 * @author Zizhao Fang
 *
 */
public class LogRecorder {
	public static void recordLog(String logs, String fileName) throws FileNotFoundException {
		//If the file doesn't exists, create the file and then add the data.
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		
		File f = new File(fileName);
		PrintWriter out = null;
		if ( f.exists() && !f.isDirectory() ) {
		    out = new PrintWriter(new FileOutputStream(new File(fileName), true));
		}
		else {
		    out = new PrintWriter(fileName);
		}
		
		out.append(reportDate + "----"+logs + "\n");
		
		//out.append(Result.dbToXml(m)+"\n");
		out.close();
	}

}
