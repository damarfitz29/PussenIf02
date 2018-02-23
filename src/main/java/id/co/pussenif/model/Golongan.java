/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.pussenif.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author WINDOWS 10
 */
@Entity
@Table(name = "golongan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Golongan.findAll", query = "SELECT g FROM Golongan g")
    , @NamedQuery(name = "Golongan.findByGolonganId", query = "SELECT g FROM Golongan g WHERE g.golonganId = :golonganId")
    , @NamedQuery(name = "Golongan.findByNama", query = "SELECT g FROM Golongan g WHERE g.nama = :nama")
    , @NamedQuery(name = "Golongan.findByLastUpdate", query = "SELECT g FROM Golongan g WHERE g.lastUpdate = :lastUpdate")
    , @NamedQuery(name = "Golongan.findByIsActive", query = "SELECT g FROM Golongan g WHERE g.isActive = :isActive")})
public class Golongan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "golongan_id")
    private Integer golonganId;
    @Basic(optional = false)
   // @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "is_active")
    private int isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "golonganId", fetch = FetchType.LAZY)
    private List<Anggota> anggotaList;

    public Golongan() {
    }

    public Golongan(Integer golonganId) {
        this.golonganId = golonganId;
    }

    public Golongan(Integer golonganId, String nama, Date lastUpdate, int isActive) {
        this.golonganId = golonganId;
        this.nama = nama;
        this.lastUpdate = lastUpdate;
        this.isActive = isActive;
    }

    public Integer getGolonganId() {
        return golonganId;
    }

    public void setGolonganId(Integer golonganId) {
        this.golonganId = golonganId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<Anggota> getAnggotaList() {
        return anggotaList;
    }

    public void setAnggotaList(List<Anggota> anggotaList) {
        this.anggotaList = anggotaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (golonganId != null ? golonganId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Golongan)) {
            return false;
        }
        Golongan other = (Golongan) object;
        if ((this.golonganId == null && other.golonganId != null) || (this.golonganId != null && !this.golonganId.equals(other.golonganId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.pussenif.model.Golongan[ golonganId=" + golonganId + " ]";
    }
    
}
