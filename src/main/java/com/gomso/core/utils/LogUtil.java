package com.gomso.core.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LogUtil {

	
	public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        t.printStackTrace(pw);
        pw.flush();
        sw.flush();
        String message = sw.toString();
        try {
        	pw.close();
			sw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return message;
    }
}
