package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityFunctionality;

/**
 * Repository : ClinicalEntityFunctionality
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface ClinicalEntityFunctionalityRepository extends JpaRepository<ClinicalEntityFunctionality, Long> {

	/**
	 * Returns the ClinicalEntityFunctionality that exactly matches the given id
	 * 
	 * @param id Long
	 * @return ClinicalEntityFunctionality or null
	 */
	ClinicalEntityFunctionality findByIdAndActiveTrue(Long id);

	/**
	 * Returns the ClinicalEntityFunctionality associated with a
	 * {@link ClinicalEntity} and exactly matches the given functionality id
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @param url            String
	 * @return ClinicalEntityFunctionality or null
	 */
	ClinicalEntityFunctionality findByClinicalEntityAndClinicalEntity_ActiveTrueAndFunctionalityId(
			ClinicalEntity clinicalEntity, Long functionalityId);

	/**
	 * Returns the ClinicalEntityFunctionality associated with a
	 * {@link ClinicalEntity} and exactly matches the given functionality id
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @param functionality  Long
	 * @return ClinicalEntityFunctionality or null
	 */
	ClinicalEntityFunctionality findByClinicalEntityAndClinicalEntity_ActiveTrueAndFunctionalityIdAndActiveTrue(
			ClinicalEntity clinicalEntity, Long functionalityId);

	/**
	 * Returns the ClinicalEntityFunctionality associated with a
	 * {@link ClinicalEntity} and exactly matches the given hash
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @param hash           String
	 * @return ClinicalEntityFunctionality or null
	 */
	ClinicalEntityFunctionality findByClinicalEntityAndClinicalEntity_ActiveTrueAndHashAndActiveTrue(ClinicalEntity clinicalEntity,
			String hash);

	/**
	 * Returns the list of ClinicalEntityFunctionality associated with a
	 * {@link ClinicalEntity} if {@link ClinicalEntity#isActive()} is true and
	 * {@link Functionality#isActive()} is false sorted asc by
	 * {@link Functionality#getOrder()}
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @return {@code List<ClinicalEntityFunctionality>} or empty list
	 */
	List<ClinicalEntityFunctionality> findByClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(ClinicalEntity clinicalEntity);

}