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
	static ThreadLocal<List<LoggingEvent>> threadLocal = new ThreadLocal<>();

	@Override
	public void append(LoggingEvent e) {
		List<LoggingEvent> events = threadLocal.get();
		if (events == null) {
			events = new ArrayList<>();
			threadLocal.set(events);
		}
		events.add(e);
	}

	public static List<LoggingEvent> getEvents() {
		return threadLocal.get();
	}

	public static void clearEvents() {
		threadLocal.remove();
	}
}
