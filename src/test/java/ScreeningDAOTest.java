import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.hydra.screening.data.ScreeningRepository;
import com.revature.hydra.screening.data.SoftSkillViolationRepository;
import com.revature.hydra.screening.data.ViolationTypeRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ScreeningDAOTest {

	public static final Logger log = Logger.getLogger(ScreeningDAOTest.class);
	
	@Autowired
	private ScreeningRepository screeningRepository;
	@Autowired
	private SoftSkillViolationRepository softSkillViolationRepository;
	@Autowired
	private ViolationTypeRepository violationRepository;

}
