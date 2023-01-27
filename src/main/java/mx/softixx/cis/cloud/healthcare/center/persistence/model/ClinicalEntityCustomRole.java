package mx.softixx.cis.cloud.healthcare.center.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "clinical_entity_custom_role"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "clinical_entity_custom_role", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_custom_role_id_seq", allocationSize = 1)
public class ClinicalEntityCustomRole extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
    private ClinicalEntity clinicalEntity;
	
	@Column(name = "code", length = 100)
    private String code;

    @Column(name = "value", length = 100)
    private String value;

    @Column(name = "active")
    private boolean active;

    /* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

	/* toString */
    public String toString() { 
        var sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(code);
        sb.append("|");
        sb.append(value);
        sb.append("|");
        sb.append(active);
        return sb.toString();
    }

}