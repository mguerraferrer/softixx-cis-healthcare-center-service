package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;

/**
 * Repository : ClinicalEntity
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface ClinicalEntityRepository extends JpaRepository<ClinicalEntity, Long> {

	/**
	 * Returns the ClinicalEntity that exactly matches the given id and
	 * {@link ClinicalEntity#getActive()} is true and
	 * {@link ClinicalEntity#getDeleted()} is false
	 * 
	 * @param id Long
	 * @return ClinicalEntity or null
	 */
	ClinicalEntity findByIdAndActiveTrue(Long id);

	/**
	 * Returns the ClinicalEntity that exactly matches the given hash and
	 * {@link ClinicalEntity#getActive()} is true and
	 * {@link ClinicalEntity#getDeleted()} is false
	 * 
	 * @param hash String
	 * @return ClinicalEntity or null
	 */
	ClinicalEntity findByHashAndActiveTrue(String hash);

	/**
	 * Returns the ClinicalEntity that exactly matches the given name and
	 * {@link ClinicalEntity#getActive()} is true and
	 * {@link ClinicalEntity#getDeleted()} is false
	 * 
	 * @param name String
	 * @return ClinicalEntity or null
	 */
	ClinicalEntity findByNameAndActiveTrue(String name);

	/**
	 * Returns the ClinicalEntity that exactly matches the given businessName and
	 * {@link ClinicalEntity#getActive()} is true and
	 * {@link ClinicalEntity#getDeleted()} is false
	 * 
	 * @param businessName String
	 * @return ClinicalEntity or null
	 */
	ClinicalEntity findByBusinessNameAndActiveTrue(String businessName);

	/**
	 * Returns the list of ClinicalEntity if {@link ClinicalEntity#getActive()} is
	 * true and {@link ClinicalEntity#getDeleted()} is false
	 * 
	 * @return {@code List<ClinicalEntity>} or empty list
	 */
	List<ClinicalEntity> findByActiveTrue();

	/**
	 * Returns a {@code Page<ClinicalEntity>} object sorted by the pageable param if
	 * {@link ClinicalEntity#getName()} contain the value of the name param and
	 * {@link ClinicalEntity#getDeleted()} is false
	 * 
	 * @param name     String
	 * @param pageable {@link Pageable}
	 * @return {@code Page<ClinicalEntity>} or empty page
	 */
	Page<ClinicalEntity> findByNameContainingIgnoreCaseAndActiveTrue(String name, Pageable pageable);

	/**
	 * Returns a {@code Page<ClinicalEntity>} object sorted by the pageable param if
	 * {@link ClinicalEntity#getBusinessName()} contain the value of the
	 * BusinessName param and {@link ClinicalEntity#getDeleted()} is false
	 * 
	 * @param businessName String
	 * @param pageable     {@link Pageable}
	 * @return {@code Page<ClinicalEntity>} or empty page
	 */
	Page<ClinicalEntity> findByBusinessNameContainingIgnoreCaseAndActiveTrue(String businessName, Pageable pageable);

}