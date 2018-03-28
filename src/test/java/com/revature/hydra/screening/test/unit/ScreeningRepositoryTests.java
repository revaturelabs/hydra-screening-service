package com.revature.hydra.screening.test.unit;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.revature.beans.SimpleScreening;
import com.revature.hydra.screening.data.ScreeningRepository;
import com.revature.hydra.test.util.TestContext;
import com.revature.hydra.test.util.WebAppContext;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestContext.class, WebAppContext.class })
@DataJpaTest
@WebAppConfiguration
public class ScreeningRepositoryTests {
	
	@Autowired
	ScreeningRepository sr;
	
	private Integer ssId;
	
	@Before
	public final void init() {
		SimpleScreening ss = new SimpleScreening(1, 2, 3, 50.0,
				"aboutMeCommentary", "generalCommentary", "softSkillCommentary", new Date(),
				new Date(), true, "Status");
		ssId = sr.save(ss).getScreeningId();
	}
	
	@After
	public final void end() {
		sr.deleteAll();
	}
	
	@Test
	public final void testChangeAboutMeCommentaryByScreeningId() {
		sr.changeAboutMeCommentaryByScreeningId("splargh", ssId);
		Assert.assertEquals(sr.findOne(ssId).getAboutMeCommentary(), "splargh");
	}
	
	@Test
	public final void testChangeGeneralCommentaryByScreeningId() {
		sr.changeGeneralCommentaryByScreeningId("splargh", ssId);
		Assert.assertEquals(sr.findOne(ssId).getGeneralCommentary(), "splargh");
	}
	
	@Test
	public final void testUpdateScreeningInformationByScreeningId() {
		sr.updateScreeningInformationByScreeningId("new", false, "new", new Date(), 60.0, ssId);
		SimpleScreening ss = sr.findOne(ssId);
		Assert.assertNotEquals(ss.getStatus(), "Status");
		Assert.assertNotEquals(ss.getSoftSkillsVerdict(), new Boolean(true));
		Assert.assertNotEquals(ss.getSoftSkillCommentary(), "softSkillCommentary");
		Assert.assertNotNull(ss.getEndDateTime());
		Assert.assertNotEquals(ss.getCompositeScore(), new Double(50.0));
	}
	
}
