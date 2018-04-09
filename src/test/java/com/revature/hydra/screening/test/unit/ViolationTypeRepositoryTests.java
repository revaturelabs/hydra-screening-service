package com.revature.hydra.screening.test.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.revature.beans.ViolationType;
import com.revature.hydra.screening.data.ViolationTypeRepository;
import com.revature.hydra.test.util.TestContext;
import com.revature.hydra.test.util.WebAppContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestContext.class, WebAppContext.class })
@DataJpaTest
@WebAppConfiguration
public class ViolationTypeRepositoryTests {
	
	@Autowired
	private ViolationTypeRepository vtr;
	
	private Integer vtId;
	
	@Before
	public final void init() {
		ViolationType vt = new ViolationType("Test text", "Test description");
		vtId = vtr.save(vt).getViolationTypeId();
	}
	
	@After
	public final void end() {
		vtr.deleteAll();
	}
	
	@Test
	public final void testFindViolationTypeTextByViolationTypeId() {
		Assert.assertEquals(vtr.findViolationTypeTextByViolationTypeId(vtId), "Test text");
	}
	
}
