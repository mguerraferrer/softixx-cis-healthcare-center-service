package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePractice;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeSystemOption;

/**
 * Repository : PrivatePracticeSystemOption
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface PrivatePracticeSystemOptionRepository extends JpaRepository<PrivatePracticeSystemOption, Long> {

	/**
	 * Returns the PrivatePracticeSystemOption that exactly matches the given id
	 * 
	 * @param id Long
	 * @return PrivatePracticeSystemOption or null
	 */
	PrivatePracticeSystemOption findByIdAndActiveTrue(Long id);

	/**
	 * Returns the PrivatePracticeSystemOption associated with a
	 * {@link PrivatePractice} and autoConfigSystemOptionId if
	 * {@link PrivatePractice#isActive()} is true,
	 * {@link PrivatePracticeSystemOption#isActive()} is true
	 * 
	 * @param privatePractice          {@link PrivatePractice}
	 * @param autoConfigSystemOptionId Long
	 * @return PrivatePracticeSystemOption or null
	 */
	PrivatePracticeSystemOption findByPrivatePracticeAndAutoConfigSystemOptionIdAndPrivatePractice_ActiveTrueAndActiveTrue(
			PrivatePractice privatePractice, Long autoConfigSystemOptionId);

	/**
	 * Returns the PrivatePracticeSystemOption associated with a
	 * {@link PrivatePractice} and that exactly matches the given hash if
	 * {@link PrivatePractice#isActive()} is true,
	 * {@link PrivatePracticeSystemOption#isActive()} is true
	 * 
	 * @param privatePractice {@link PrivatePractice}
	 * @param hash            String
	 * @return PrivatePracticeSystemOption or null
	 */
	PrivatePracticeSystemOption findByPrivatePracticeAndHashAndPrivatePractice_ActiveTrueAndActiveTrue(
			PrivatePractice privatePractice, String hash);

	/**
	 * Returns the list of PrivatePracticeSystemOption associated with a
	 * {@link PrivatePractice} if {@link PrivatePractice#isActive()} is true,
	 * {@link PrivatePracticeSystemOption#isActive()} is true
	 * 
	 * @param privatePractice {@link PrivatePractice}
	 * @return PrivatePracticeSystemOption or null
	 */
	List<PrivatePracticeSystemOption> findByPrivatePracticeAndPrivatePractice_ActiveTrueAndActiveTrue(
			PrivatePractice privatePractice);

}