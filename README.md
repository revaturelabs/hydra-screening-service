# hydra-screening-service
### Hydra MSA element for persisting and accessing tech screening data. 

This service contains the following methods for interacting with data:

* softSkillViolationsByScreeningID
  * Description
    * Returns a List of softSkillViolations by a given screeningID.
  * Endpoint
    * /screening/violation/{screeningID}
* getViolationTypes
  * Description
    * Returns a List of all possible Violations
  * Endpoint
    * /violation/all
* deleteSoftSkillViolation
  * Description
    * Deletes a soft skill violation from the database.
  * Endpoint
    * /violation/delete/{softSkillViolationID}
* updateAboutMeCommentary
  * Description
    * Update aboutMeCommentary by the given screeningID
  * Endpoint
    * /screening/introcomment
* createSoftSkillViolationAndReturnSoftSkillViolationID
  * Description
    * Save a new SoftSkillViolation and return the SoftSkillViolationId assigned to it.
  * Endpoint
    * /violation/flag
* createScreening
  * Description
    * Consumes a traineeId, date, trainerId, and skillTypeId to save a new Screening object to the database, and returns the ScreeningId
  * Endpoint
    * /screening/start
* storeGeneralComment
  * Description
    * Consumes a comment and saves it to the database to the given Screening by screeningId
  * Endpoint
    * /screening/generalComment
* endScreening
  * Description
    * Consumes a SimpleScreening request body and updates the screening with the end of screening data.
  * Endpoint
    * /screening/end

The Screening service communicates with the following services:
