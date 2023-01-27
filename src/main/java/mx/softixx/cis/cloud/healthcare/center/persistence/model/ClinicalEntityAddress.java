package mx.softixx.cis.cloud.healthcare.center.persistence.model;

import org.hibernate.annotations.ColumnTransformer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;
import mx.softixx.cis.common.jpa.util.ColumnTransformerUtil;

/**
 * Persistent class for entity stored in table "clinical_entity_address"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "clinical_entity_address", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_id_seq", allocationSize = 1)
public class ClinicalEntityAddress extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
    private ClinicalEntity clinicalEntity;
	
    @Column(name = "colony_mx_id")
    private Long colonyMxId;
    
	@Column(name = "street")
    @ColumnTransformer(	read = "pgp_sym_decrypt(street::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String street;

    @Column(name = "btw_street")
    @ColumnTransformer(	read = "pgp_sym_decrypt(btw_street::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String btwStreet;

    @Column(name = "outside_number")
    @ColumnTransformer(	read = "pgp_sym_decrypt(outside_number::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String outsideNumber;

    @Column(name = "inside_number")
    @ColumnTransformer(	read = "pgp_sym_decrypt(inside_number::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String insideNumber;

    @Column(name = "reference")
    @ColumnTransformer(	read = "pgp_sym_decrypt(reference::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String reference;

    @Column(name = "lat")
    @ColumnTransformer(	read = "pgp_sym_decrypt(lat::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String lat;

    @Column(name = "lon")
    @ColumnTransformer(	read = "pgp_sym_decrypt(lon::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String lon;

    @Column(name = "active")
    private boolean active;

    /* Getters and Setters */
	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public Long getColonyMxId() {
		return colonyMxId;
	}

	public void setColonyMxId(Long colonyMxId) {
		this.colonyMxId = colonyMxId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBtwStreet() {
		return btwStreet;
	}

	public void setBtwStreet(String btwStreet) {
		this.btwStreet = btwStreet;
	}

	public String getOutsideNumber() {
		return outsideNumber;
	}

	public void setOutsideNumber(String outsideNumber) {
		this.outsideNumber = outsideNumber;
	}

	public String getInsideNumber() {
		return insideNumber;
	}

	public void setInsideNumber(String insideNumber) {
		this.insideNumber = insideNumber;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	/* toString */
	public String toString() { 
        var sb = new StringBuilder(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:");
        sb.append(street);
        sb.append("|");
        sb.append(btwStreet);
        sb.append("|");
        sb.append(outsideNumber);
        sb.append("|");
        sb.append(insideNumber);
        sb.append("|");
        sb.append(reference);
        sb.append("|");
        sb.append(lat);
        sb.append("|");
        sb.append(lon);
        sb.append("|");
        sb.append(active);
        return sb.toString();
    }

}