package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePractice;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeCustomRole;

/**
 * Repository : PrivatePracticeCustomRole
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface PrivatePracticeCustomRoleRepository extends JpaRepository<PrivatePracticeCustomRole, Long> {

	/**
	 * Returns the PrivatePracticeCustomRole that exactly matches the given id
	 * 
	 * @param id Long
	 * @return PrivatePracticeCustomRole or null
	 */
	PrivatePracticeCustomRole findByIdAndActiveTrue(Long id);

	/**
	 * Returns the PrivatePracticeCustomRole associated with a
	 * {@link PrivatePractice} if exactly matches the given code and
	 * {@link PrivatePractice#isActive()} is true
	 * 
	 * @param privatePractice {@link PrivatePractice}
	 * @param code            String
	 * @return PrivatePracticeCustomRole or null
	 */
	PrivatePracticeCustomRole findByPrivatePracticeAndPrivatePractice_ActiveTrueAndCodeAndActiveTrue(
			PrivatePractice privatePractice, String code);

	/**
	 * Returns the PrivatePracticeCustomRole associated with a
	 * {@link PrivatePractice} if {@link PrivatePractice#getDeleted()}
	 * is false
	 * 
	 * @param privatePractice {@link PrivatePractice}
	 * @return {@code List<PrivatePracticeCustomRole>} or empty list
	 */
	List<PrivatePracticeCustomRole> findByPrivatePracticeAndPrivatePractice_ActiveTrueAndActiveTrue(
			PrivatePractice privatePractice);

}