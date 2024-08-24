package com.akash.ennote;

import com.akash.ennote.services.AuditLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EnNoteApplicationTests {

	@Autowired
	private AuditLogService auditLogService;

	@Test
	public void contextLoads() {
		assertNotNull(auditLogService);
	}

}
