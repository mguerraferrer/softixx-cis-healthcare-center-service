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
 * Persistent class for entity stored in table "nurse_clinical_entity"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "nurse_clinical_entity", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.nurse_clinical_entity_id_seq", allocationSize = 1)
public class NurseClinicalEntity extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
    private ClinicalEntity clinicalEntity;

	@Column(name = "nurse_id")
	private Long nurseId;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nurseClinicalEntity", targetEntity = NurseDoctorClinicalEntity.class)
	private List<NurseDoctorClinicalEntity> nurseDoctorClinicalEntities;

	public NurseClinicalEntity() {
	}

	public NurseClinicalEntity(Long nurseId, ClinicalEntity clinicalEntity) {
		this.nurseId = nurseId;
		this.clinicalEntity = clinicalEntity;
		this.active = true;
	}

	/* Getters and Setters */
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

	public Long getNurseId() {
		return nurseId;
	}

	public void setNurseId(Long nurseId) {
		this.nurseId = nurseId;
	}

	public List<NurseDoctorClinicalEntity> getNurseDoctorClinicalEntities() {
		if (nurseDoctorClinicalEntities == null) {
			nurseDoctorClinicalEntities = new ArrayList<>();
		}
		return nurseDoctorClinicalEntities;
	}

	public void setNurseDoctorClinicalEntities(List<NurseDoctorClinicalEntity> nurseDoctorClinicalEntities) {
		this.nurseDoctorClinicalEntities = nurseDoctorClinicalEntities;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(active);
		return sb.toString();
	}

}