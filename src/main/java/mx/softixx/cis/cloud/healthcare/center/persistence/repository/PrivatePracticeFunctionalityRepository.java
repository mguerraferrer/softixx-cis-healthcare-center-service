package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePractice;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeFunctionality;

/**
 * Repository : PrivatePracticeFunctionality
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface PrivatePracticeFunctionalityRepository extends JpaRepository<PrivatePracticeFunctionality, Long> {

	/**
	 * Returns the PrivatePracticeFunctionality that exactly matches the given id
	 * 
	 * @param id Long
	 * @return PrivatePracticeFunctionality or null
	 */
	PrivatePracticeFunctionality findByIdAndActiveTrue(Long id);

	/**
	 * Returns the PrivatePracticeFunctionality associated with a
	 * {@link PrivatePractice} if exactly matches the given functionality id
	 * 
	 * @param privatePractice {@link PrivatePractice}
	 * @param functionalityId Long
	 * @return PrivatePracticeFunctionality or null
	 */
	PrivatePracticeFunctionality findByPrivatePracticeAndPrivatePractice_ActiveTrueAndFunctionalityIdAndActiveTrue(
			PrivatePractice privatePractice, Long functionalityId);

	/**
	 * Returns the PrivatePracticeFunctionality associated with a
	 * {@link PrivatePractice} if exactly matches the given hash
	 * 
	 * @param privatePractice {@link PrivatePractice}
	 * @param hash            String
	 * @return PrivatePracticeFunctionality or null
	 */
	PrivatePracticeFunctionality findByPrivatePracticeAndHashAndPrivatePractice_ActiveTrueAndActiveTrue(
			PrivatePractice privatePractice, String hash);

}