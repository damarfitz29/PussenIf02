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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    , @NamedQuery(name = "Presensi.findByJam", query = "SELECT p FROM Presensi p WHERE p.jam = :jam")})
public class Presensi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRESENSI_ID")
    private Integer presensiId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "JAM")
    @Temporal(TemporalType.TIME)
    private Date jam;
    @JoinColumn(name = "ANGGOTA_ID", referencedColumnName = "ANGGOTA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Anggota anggotaId;

    public Presensi() {
    }

    public Presensi(Integer presensiId) {
        this.presensiId = presensiId;
    }

    public Presensi(Integer presensiId, Date jam) {
        this.presensiId = presensiId;
        this.jam = jam;
    }

    public Integer getPresensiId() {
        return presensiId;
    }

    public void setPresensiId(Integer presensiId) {
        this.presensiId = presensiId;
    }

    public Date getJam() {
        return jam;
    }

    public void setJam(Date jam) {
        this.jam = jam;
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
        return "id.co.pussenif.Presensi[ presensiId=" + presensiId + " ]";
    }
    
}
