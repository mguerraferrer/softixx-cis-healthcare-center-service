package mx.softixx.cis.cloud.healthcare.center.persistence.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "clinical_entity_speciality"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "clinical_entity_speciality", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_speciality_id_seq", allocationSize = 1)
public class ClinicalEntitySpeciality extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
	private ClinicalEntity clinicalEntity;

	@Column(name = "speciality_id")
	private Long specialityId;

	@Column(name = "hash", nullable = false, length = 50)
	private String hash;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntitySpeciality", targetEntity = ClinicalEntityService.class)
	private List<ClinicalEntityService> clinicalEntityServices;

	/* Getters and Setters */
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public Long getSpecialityId() {
		return specialityId;
	}

	public void setSpecialityId(Long specialityId) {
		this.specialityId = specialityId;
	}

	public List<ClinicalEntityService> getClinicalEntityServices() {
		if (clinicalEntityServices == null) {
			clinicalEntityServices = new ArrayList<>();
		}
		return clinicalEntityServices;
	}

	public void setClinicalEntityServices(List<ClinicalEntityService> clinicalEntityServices) {
		this.clinicalEntityServices = clinicalEntityServices;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(hash);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}