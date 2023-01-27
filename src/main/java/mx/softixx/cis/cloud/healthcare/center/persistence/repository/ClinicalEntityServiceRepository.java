package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityService;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntitySpeciality;

/**
 * Repository : ClinicalEntityService
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface ClinicalEntityServiceRepository extends JpaRepository<ClinicalEntityService, Long> {

	/**
	 * Returns the ClinicalEntityAccessInfo associated with a
	 * {@link ClinicalEntitySpeciality} if
	 * {@link ClinicalEntitySpeciality#getDeleted()} is false and
	 * {@link ClinicalEntityService#getDeleted()} is false
	 * 
	 * @param clinicalEntitySpeciality {@link ClinicalEntitySpeciality}
	 * @return ClinicalEntityService or null
	 */
	ClinicalEntityService findByClinicalEntitySpecialityAndClinicalEntitySpeciality_ActiveTrueAndActiveTrue(
			ClinicalEntitySpeciality clinicalEntitySpeciality);

}