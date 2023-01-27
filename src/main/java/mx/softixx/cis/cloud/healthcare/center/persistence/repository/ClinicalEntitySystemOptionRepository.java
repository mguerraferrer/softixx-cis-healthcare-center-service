package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntitySystemOption;

/**
 * Repository : ClinicalEntitySystemOption
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface ClinicalEntitySystemOptionRepository extends JpaRepository<ClinicalEntitySystemOption, Long> {

	/**
	 * Returns the ClinicalEntitySystemOption that exactly matches the given id
	 * 
	 * @param id Long
	 * @return ClinicalEntitySystemOption or null
	 */
	ClinicalEntitySystemOption findByIdAndActiveTrue(Long id);

	/**
	 * Returns the ClinicalEntitySystemOption associated with a
	 * {@link ClinicalEntity} and AutoConfigSystemOption id if
	 * {@link ClinicalEntity#isActive()} is true,
	 * {@link ClinicalEntitySystemOption#isActive()} is true
	 * 
	 * 
	 * @param clinicalEntity           {@link ClinicalEntity}
	 * @param autoConfigSystemOptionId Long
	 * @return ClinicalEntitySystemOption or null
	 */
	ClinicalEntitySystemOption findByClinicalEntityAndClinicalEntity_ActiveTrueAndAutoConfigSystemOptionIdAndActiveTrue(
			ClinicalEntity clinicalEntity, Long autoConfigSystemOptionId);

	/**
	 * Returns the ClinicalEntitySystemOption associated with a
	 * {@link ClinicalEntity} and that exactly matches the given hash if
	 * {@link ClinicalEntity#isActive()} is true,
	 * {@link ClinicalEntitySystemOption#isActive()} is true
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @param hash           String
	 * @return ClinicalEntitySystemOption or null
	 */
	ClinicalEntitySystemOption findByClinicalEntityAndClinicalEntity_ActiveTrueAndHashAndActiveTrue(
			ClinicalEntity clinicalEntity, String hash);

	/**
	 * Returns the list of ClinicalEntitySystemOption associated with a
	 * {@link ClinicalEntity} if {@link ClinicalEntity#isActive()} is true,
	 * {@link ClinicalEntitySystemOption#isActive()} is true
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @return {@code List<ClinicalEntitySystemOption>} or empty list
	 */
	List<ClinicalEntitySystemOption> findByClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity);

}