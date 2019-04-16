package com.ibm.developer;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;

/**
 * Logging appender which writes all logging statements to a single thread.
 * <br/>
 * <br/>
 * <b>NOT THREAD SAFE!</b>
 * 
 * @author William.Korando@ibm.com
 *
 */
public class StaticLogbackAppender extends AppenderBase<LoggingEvent> {
	static List<LoggingEvent> events = new ArrayList<>();

	@Override
	public void append(LoggingEvent e) {
		events.add(e);
	}

	public static List<LoggingEvent> getEvents() {
		return events;
	}

	public static void clearEvents() {
		events.clear();
	}
}
