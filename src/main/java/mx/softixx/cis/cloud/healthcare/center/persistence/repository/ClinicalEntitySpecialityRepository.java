package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntitySpeciality;

/**
 * Repository : ClinicalEntitySpeciality
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface ClinicalEntitySpecialityRepository extends JpaRepository<ClinicalEntitySpeciality, Long> {

	/**
	 * Returns the ClinicalEntitySpeciality associated with a {@link ClinicalEntity}
	 * and speciality id
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @param speciality     Long
	 * @return ClinicalEntitySpeciality or null
	 */
	ClinicalEntitySpeciality findByClinicalEntityAndClinicalEntity_ActiveTrueAndSpecialityIdAndActiveTrue(
			ClinicalEntity clinicalEntity, Long specialityId);

	/**
	 * Returns the list of ClinicalEntitySpeciality associated with a
	 * {@link ClinicalEntity}
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @return {@code ClinicalEntitySpeciality} or empty list
	 */
	List<ClinicalEntitySpeciality> findByClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity);

}