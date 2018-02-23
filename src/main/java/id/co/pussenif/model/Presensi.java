/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.pussenif.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author WINDOWS 10
 */
@Entity
@Table(name = "presensi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presensi.findAll", query = "SELECT p FROM Presensi p")
    , @NamedQuery(name = "Presensi.findByPresensiId", query = "SELECT p FROM Presensi p WHERE p.presensiId = :presensiId")
    , @NamedQuery(name = "Presensi.findByNrp", query = "SELECT p FROM Presensi p WHERE p.nrp = :nrp")
    , @NamedQuery(name = "Presensi.findByNama", query = "SELECT p FROM Presensi p WHERE p.nama = :nama")
    , @NamedQuery(name = "Presensi.findByJam", query = "SELECT p FROM Presensi p WHERE p.jam = :jam")
    , @NamedQuery(name = "Presensi.findByIsActive", query = "SELECT p FROM Presensi p WHERE p.isActive = :isActive")})
public class Presensi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "presensi_id")
    private Integer presensiId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nrp")
    private int nrp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jam")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private int isActive;
    @JoinColumn(name = "anggota_id", referencedColumnName = "anggota_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Anggota anggotaId;

    public Presensi() {
    }

    public Presensi(Integer presensiId) {
        this.presensiId = presensiId;
    }

    public Presensi(Integer presensiId, int nrp, String nama, Date jam, int isActive) {
        this.presensiId = presensiId;
        this.nrp = nrp;
        this.nama = nama;
        this.jam = jam;
        this.isActive = isActive;
    }

    public Integer getPresensiId() {
        return presensiId;
    }

    public void setPresensiId(Integer presensiId) {
        this.presensiId = presensiId;
    }

    public int getNrp() {
        return nrp;
    }

    public void setNrp(int nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getJam() {
        return jam;
    }

    public void setJam(Date jam) {
        this.jam = jam;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Anggota getAnggotaId() {
        return anggotaId;
    }

    public void setAnggotaId(Anggota anggotaId) {
        this.anggotaId = anggotaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presensiId != null ? presensiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presensi)) {
            return false;
        }
        Presensi other = (Presensi) object;
        if ((this.presensiId == null && other.presensiId != null) || (this.presensiId != null && !this.presensiId.equals(other.presensiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.pussenif.model.Presensi[ presensiId=" + presensiId + " ]";
    }
    
}
