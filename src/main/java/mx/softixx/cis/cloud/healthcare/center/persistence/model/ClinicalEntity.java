package mx.softixx.cis.cloud.healthcare.center.persistence.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.ColumnTransformer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;
import mx.softixx.cis.common.jpa.util.ColumnTransformerUtil;

/**
 * Persistent class for entity stored in table "clinical_entity"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "clinical_entity", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_id_seq", allocationSize = 1)
public class ClinicalEntity extends BaseEntity {

    @Column(name = "name")
    @ColumnTransformer(	read = "pgp_sym_decrypt(name::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String name;

    @Column(name = "business_name")
    @ColumnTransformer(	read = "pgp_sym_decrypt(business_name::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String businessName;

    @Column(name = "logo")
    private String logo;

    @Column(name = "hash", length = 50)
    private String hash;

    @Column(name = "active")
    private boolean active;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "clinicalEntity", targetEntity = ClinicalEntityContactInfo.class)
    private List<ClinicalEntityContactInfo> clinicalEntityContactInfos;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "clinicalEntity", targetEntity = ClinicalEntitySpeciality.class)
    private List<ClinicalEntitySpeciality> clinicalEntitySpecialities;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "clinicalEntity", targetEntity = ClinicalEntitySystemOption.class)
    private List<ClinicalEntitySystemOption> clinicalEntitySystemOptions;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "clinicalEntity", targetEntity = ClinicalEntityFunctionality.class)
    private List<ClinicalEntityFunctionality> clinicalEntityFunctionalities;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "clinicalEntity", targetEntity = ClinicalEntityAddress.class)
    private List<ClinicalEntityAddress> clinicalEntityAddresses;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "clinicalEntity", targetEntity = ClinicalEntityAccessInfo.class)
    private List<ClinicalEntityAccessInfo> clinicalEntityAccessInfos;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "clinicalEntity", targetEntity = ClinicalEntityPreferences.class)
    private List<ClinicalEntityPreferences> clinicalEntityPreferenceses;

    @OneToMany(fetch = FetchType.EAGER,  mappedBy = "clinicalEntity", targetEntity = ClinicalEntityCustomRole.class)
    private List<ClinicalEntityCustomRole> clinicalEntityCustomRoles;
    
    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "clinicalEntity", targetEntity = DoctorClinicalEntity.class)
    private List<DoctorClinicalEntity> doctorClinicalEntities;
    
    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "clinicalEntity", targetEntity = AssistantClinicalEntity.class)
    private List<AssistantClinicalEntity> assistantClinicalEntities;
    
    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "clinicalEntity", targetEntity = NurseClinicalEntity.class)
    private List<NurseClinicalEntity> nurseClinicalEntities;

    public ClinicalEntity() {
    }
    
    public ClinicalEntity(String name, String businessName) {
    	this.name = name;
    	this.businessName = businessName;
    	this.logo = null;
    	this.hash = UUID.randomUUID().toString().replace("-", "");
    	this.active = false;
    }

    /* Getters and Setters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

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

	public List<ClinicalEntityContactInfo> getClinicalEntityContactInfos() {
		if (clinicalEntityContactInfos == null) {
			clinicalEntityContactInfos = new ArrayList<>();
		}
		return clinicalEntityContactInfos;
	}

	public void setClinicalEntityContactInfos(List<ClinicalEntityContactInfo> clinicalEntityContactInfos) {
		this.clinicalEntityContactInfos = clinicalEntityContactInfos;
	}

	public List<ClinicalEntitySpeciality> getClinicalEntitySpecialities() {
		if (clinicalEntitySpecialities == null) {
			clinicalEntitySpecialities = new ArrayList<>();
		}
		return clinicalEntitySpecialities;
	}

	public void setClinicalEntitySpecialities(List<ClinicalEntitySpeciality> clinicalEntitySpecialities) {
		this.clinicalEntitySpecialities = clinicalEntitySpecialities;
	}

	public List<ClinicalEntitySystemOption> getClinicalEntitySystemOptions() {
		if (clinicalEntitySystemOptions == null) {
			clinicalEntitySystemOptions = new ArrayList<>();
		}
		return clinicalEntitySystemOptions;
	}

	public void setClinicalEntitySystemOptions(List<ClinicalEntitySystemOption> clinicalEntitySystemOptions) {
		this.clinicalEntitySystemOptions = clinicalEntitySystemOptions;
	}

	public List<ClinicalEntityFunctionality> getClinicalEntityFunctionalities() {
		if (clinicalEntityFunctionalities == null) {
			clinicalEntityFunctionalities = new ArrayList<>();
		}
		return clinicalEntityFunctionalities;
	}

	public void setClinicalEntityFunctionalities(
			List<ClinicalEntityFunctionality> clinicalEntityFunctionalities) {
		this.clinicalEntityFunctionalities = clinicalEntityFunctionalities;
	}

	public List<ClinicalEntityAddress> getClinicalEntityAddresses() {
		if (clinicalEntityAddresses == null) {
			clinicalEntityAddresses = new ArrayList<>();
		}
		return clinicalEntityAddresses;
	}

	public void setClinicalEntityAddresses(List<ClinicalEntityAddress> clinicalEntityAddresses) {
		this.clinicalEntityAddresses = clinicalEntityAddresses;
	}

	public List<ClinicalEntityAccessInfo> getClinicalEntityAccessInfos() {
		if (clinicalEntityAccessInfos == null) {
			clinicalEntityAccessInfos = new ArrayList<>();
		}
		return clinicalEntityAccessInfos;
	}

	public void setClinicalEntityAccessInfos(List<ClinicalEntityAccessInfo> clinicalEntityAccessInfos) {
		this.clinicalEntityAccessInfos = clinicalEntityAccessInfos;
	}

	public List<ClinicalEntityPreferences> getClinicalEntityPreferenceses() {
		if (clinicalEntityPreferenceses == null) {
			clinicalEntityPreferenceses = new ArrayList<>();
		}
		return clinicalEntityPreferenceses;
	}

	public void setClinicalEntityPreferenceses(List<ClinicalEntityPreferences> clinicalEntityPreferenceses) {
		this.clinicalEntityPreferenceses = clinicalEntityPreferenceses;
	}

	public List<ClinicalEntityCustomRole> getClinicalEntityCustomRoles() {
		if (clinicalEntityCustomRoles == null) {
			clinicalEntityCustomRoles = new ArrayList<>();
		}
		return clinicalEntityCustomRoles;
	}

	public void setClinicalEntityCustomRoles(List<ClinicalEntityCustomRole> clinicalEntityCustomRoles) {
		this.clinicalEntityCustomRoles = clinicalEntityCustomRoles;
	}
    
    public List<DoctorClinicalEntity> getDoctorClinicalEntities() {
    	if (doctorClinicalEntities == null) {
    		doctorClinicalEntities = new ArrayList<>();
    	}
		return doctorClinicalEntities;
	}

	public void setDoctorClinicalEntities(List<DoctorClinicalEntity> doctorClinicalEntities) {
		this.doctorClinicalEntities = doctorClinicalEntities;
	}

	public List<AssistantClinicalEntity> getAssistantClinicalEntities() {
		if (assistantClinicalEntities == null) {
			assistantClinicalEntities = new ArrayList<>();
		}
		return assistantClinicalEntities;
	}

	public void setAssistantClinicalEntities(List<AssistantClinicalEntity> assistantClinicalEntities) {
		this.assistantClinicalEntities = assistantClinicalEntities;
	}

	public List<NurseClinicalEntity> getNurseClinicalEntities() {
		if (nurseClinicalEntities == null) {
			nurseClinicalEntities = new ArrayList<>();
		}
		return nurseClinicalEntities;
	}

	public void setNurseClinicalEntities(List<NurseClinicalEntity> nurseClinicalEntities) {
		this.nurseClinicalEntities = nurseClinicalEntities;
	}

	/* toString */
	public String toString() { 
        var sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:");
        sb.append(name);
        sb.append("|");
        sb.append(businessName);
        sb.append("|");
        sb.append(hash);
        sb.append("|");
        sb.append(active);
        return sb.toString();
    }

}