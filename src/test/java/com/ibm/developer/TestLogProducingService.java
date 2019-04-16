package com.ibm.developer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ibm.developer.LogProducingService;

public class TestLogProducingService {
	private LogProducingService service = new LogProducingService();

	@BeforeEach
	public void clearLoggingStatements() {
		StaticLogbackAppender.clearEvents();
	}

	@Test
	public void testAssertingLoggingStatementsA() {
		service.writeSomeLoggingStatements("A");
		assertThat(StaticLogbackAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! A");
	}

	@Test
	public void testAssertingLoggingStatementsB() {
		service.writeSomeLoggingStatements("B");
		assertThat(StaticLogbackAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! B");
	}

}
