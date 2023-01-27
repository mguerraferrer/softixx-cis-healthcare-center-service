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
 * Persistent class for entity stored in table "clinical_entity_contact_info"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "clinical_entity_contact_info", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_contact_info_id_seq", allocationSize = 1)
public class ClinicalEntityContactInfo extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
    private ClinicalEntity clinicalEntity;
	
    @Column(name = "phone1")
    @ColumnTransformer(	read = "pgp_sym_decrypt(phone1::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String phone1;

    @Column(name = "phone2")
    @ColumnTransformer(	read = "pgp_sym_decrypt(phone2::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String phone2;

    @Column(name = "phone3")
    @ColumnTransformer(	read = "pgp_sym_decrypt(phone3::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String phone3;

    @Column(name = "email1")
    @ColumnTransformer(	read = "pgp_sym_decrypt(email1::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String email1;

    @Column(name = "email2")
    @ColumnTransformer(	read = "pgp_sym_decrypt(email2::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String email2;

    @Column(name = "email3")
    @ColumnTransformer(	read = "pgp_sym_decrypt(email3::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String email3;

    @Column(name = "web")
    @ColumnTransformer(	read = "pgp_sym_decrypt(web::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String web;

    @Column(name = "blog")
    @ColumnTransformer(	read = "pgp_sym_decrypt(blog::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String blog;

    @Column(name = "facebook")
    @ColumnTransformer(	read = "pgp_sym_decrypt(facebook::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String facebook;

    @Column(name = "twitter")
    @ColumnTransformer(	read = "pgp_sym_decrypt(twitter::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String twitter;

    @Column(name = "instagram")
    @ColumnTransformer(	read = "pgp_sym_decrypt(instagram::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String instagram;

    @Column(name = "linkedin")
    @ColumnTransformer(	read = "pgp_sym_decrypt(linkedin::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String linkedin;

    @Column(name = "youtube")
    @ColumnTransformer(	read = "pgp_sym_decrypt(youtube::bytea, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')",
						write = "pgp_sym_encrypt(?, '"+ColumnTransformerUtil.PGP_SYM_CRYPT_KEY+"')")
    private String youtube;

    @Column(name = "active")
    private boolean active;

    /* Getters and Setters */
	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
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
        sb.append(phone1);
        sb.append("|");
        sb.append(phone2);
        sb.append("|");
        sb.append(phone3);
        sb.append("|");
        sb.append(email1);
        sb.append("|");
        sb.append(email2);
        sb.append("|");
        sb.append(email3);
        sb.append("|");
        sb.append(web);
        sb.append("|");
        sb.append(blog);
        sb.append("|");
        sb.append(facebook);
        sb.append("|");
        sb.append(twitter);
        sb.append("|");
        sb.append(instagram);
        sb.append("|");
        sb.append(linkedin);
        sb.append("|");
        sb.append(youtube);
        sb.append("|");
        sb.append(active);
        return sb.toString();
    }
	
}