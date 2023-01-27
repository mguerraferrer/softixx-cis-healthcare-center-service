package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityCustomRole;

/**
 * Repository : ClinicalEntityCustomRole
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface ClinicalEntityCustomRoleRepository extends JpaRepository<ClinicalEntityCustomRole, Long> {

	/**
	 * Returns the ClinicalEntityCustomRole that exactly matches the given id
	 * 
	 * @param id Long
	 * @return ClinicalEntityCustomRole or null
	 */
	ClinicalEntityCustomRole findByIdAndActiveTrue(Long id);

	/**
	 * Returns the ClinicalEntityCustomRole associated with a {@link ClinicalEntity}
	 * and exactly matches the given code if
	 * {@link ClinicalEntityCustomRole#getDeleted()} is false and
	 * {@link ClinicalEntity#getDeleted()} is false
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @param code           String
	 * @return ClinicalEntityCustomRole or null
	 */
	ClinicalEntityCustomRole findByClinicalEntityAndClinicalEntity_ActiveTrueAndCodeAndActiveTrue(
			ClinicalEntity clinicalEntity, String code);

	/**
	 * Returns the list of ClinicalEntityCustomRole associated with a
	 * {@link ClinicalEntity} if {@link ClinicalEntityCustomRole#getDeleted()} is
	 * false, {@link ClinicalEntity#getActive()} is true and
	 * {@link ClinicalEntity#getDeleted()} is false
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @return {@code List<ClinicalEntityCustomRole>} or empty list
	 */
	List<ClinicalEntityCustomRole> findByClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity);

}