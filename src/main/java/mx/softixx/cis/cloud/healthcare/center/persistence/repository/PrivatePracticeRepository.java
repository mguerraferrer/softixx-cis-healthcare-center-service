package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePractice;

/**
 * Repository : PrivatePractice.
 */
public interface PrivatePracticeRepository extends JpaRepository<PrivatePractice, Long> {

	/**
	 * Returns the PrivatePractice that exactly matches the given id if
	 * {@link PrivatePractice#isActive()} is true
	 * 
	 * @param id Long
	 * @return PrivatePractice or null
	 */
	Optional<PrivatePractice> findByIdAndActiveTrue(Long id);

	/**
	 * Returns the PrivatePractice that exactly matches the given hash if
	 * {@link PrivatePractice#isActive()} is true
	 * 
	 * @param hash String
	 * @return PrivatePractice or null
	 */
	Optional<PrivatePractice> findByHashAndActiveTrue(String hash);
	
	/**
	 * Returns the PrivatePractice that exactly matches the given doctor id and hash
	 * if {@link PrivatePractice#isActive()} is true
	 * 
	 * @param doctorId Long
	 * @param hash     String
	 * @return PrivatePractice or null
	 */
	Optional<PrivatePractice> findByDoctorIdAndHashAndActiveTrue(Long doctorId, String hash);

	/**
	 * Returns the PrivatePractice associated with a doctor id if
	 * {@link PrivatePractice#isActive()} is true
	 * 
	 * @param doctorId Long
	 * @return {@code PrivatePractice} or null
	 */
	Optional<PrivatePractice> findByDoctorIdAndActiveTrue(Long doctorId);

	/**
	 * Returns the PrivatePractice associated with a doctor id
	 * 
	 * @param doctorId Long
	 * @return {@code PrivatePractice} or null
	 */
	Optional<PrivatePractice> findByDoctorId(Long doctorId);

	/**
	 * Returns the list of PrivatePractice if {@link PrivatePractice#isActive()} is
	 * true
	 * 
	 * @return {@code List<PrivatePractice>} or empty list
	 */
	List<PrivatePractice> findByActiveTrue();

}