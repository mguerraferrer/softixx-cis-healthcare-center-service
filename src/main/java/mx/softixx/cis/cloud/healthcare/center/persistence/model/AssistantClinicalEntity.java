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
 * Persistent class for entity stored in table "assistant_clinical_entity"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "assistant_clinical_entity", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.assistant_clinical_entity_id_seq", allocationSize = 1)
public class AssistantClinicalEntity extends BaseEntity {

	@Column(name = "assistant_id")
	private Long assistantId;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
    private ClinicalEntity clinicalEntity;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "assistantClinicalEntity", targetEntity = AssistantDoctorClinicalEntity.class)
	private List<AssistantDoctorClinicalEntity> assistantDoctorClinicalEntities;

	public AssistantClinicalEntity() {
	}

	public AssistantClinicalEntity(Long assistantId, ClinicalEntity clinicalEntity) {
		this.assistantId = assistantId;
		this.clinicalEntity = clinicalEntity;
		this.active = true;
	}

	/* Getters and Setters */
	public Long getAssistantId() {
		return assistantId;
	}

	public void setAssistantId(Long assistantId) {
		this.assistantId = assistantId;
	}

	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	public List<AssistantDoctorClinicalEntity> getAssistantDoctorClinicalEntities() {
		if (assistantDoctorClinicalEntities == null) {
			assistantDoctorClinicalEntities = new ArrayList<>();
		}
		return assistantDoctorClinicalEntities;
	}

	public void setAssistantDoctorClinicalEntities(
			List<AssistantDoctorClinicalEntity> assistantDoctorClinicalEntities) {
		this.assistantDoctorClinicalEntities = assistantDoctorClinicalEntities;
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