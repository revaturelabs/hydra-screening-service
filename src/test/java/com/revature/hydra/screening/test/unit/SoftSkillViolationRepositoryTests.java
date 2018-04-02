package com.revature.hydra.screening.test.unit;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.revature.beans.SimpleScreening;
import com.revature.beans.SoftSkillViolation;
import com.revature.hydra.screening.data.ScreeningRepository;
import com.revature.hydra.screening.data.SoftSkillViolationRepository;
import com.revature.hydra.test.util.TestContext;
import com.revature.hydra.test.util.WebAppContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestContext.class, WebAppContext.class })
@DataJpaTest
@WebAppConfiguration
public class SoftSkillViolationRepositoryTests {
	
	@Autowired
	private SoftSkillViolationRepository ssvr;
	
	@Autowired
	private ScreeningRepository sr;
	
	private Integer ssvId;
	
	private Integer ssId;
	
	@Before
	public final void init() {
		SimpleScreening ss = new SimpleScreening(1, 2, 3, 50.0,
				"aboutMeCommentary", "generalCommentary", "softSkillCommentary", new Date(),
				new Date(), true, "Status");
		ssId = sr.save(ss).getScreeningId();
		SoftSkillViolation ssv = new SoftSkillViolation(ss, 2, "splargh", new Date());
		ssvId = ssvr.save(ssv).getId();
	}
	
	@After
	public final void end() {
		ssvr.deleteAll();
		sr.deleteAll();
	}
	
	@Test
	public final void testFindSoftSkillViolationsByScreeningId() {
		SimpleScreening ss = sr.findOne(ssId);
		Assert.assertEquals(ssvr.findByScreeningId(ss).get(0).getId(), ssvr.findOne(ssvId).getId());
	}
	
}
