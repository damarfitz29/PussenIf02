/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.pussenif.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    , @NamedQuery(name = "Golongan.findByNama", query = "SELECT g FROM Golongan g WHERE g.nama = :nama")})
public class Golongan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GOLONGAN_ID")
    private Integer golonganId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAMA")
    private String nama;
    @OneToMany(mappedBy = "golonganId", fetch = FetchType.LAZY)
    private List<Anggota> anggotaList;

    public Golongan() {
    }

    public Golongan(Integer golonganId) {
        this.golonganId = golonganId;
    }

    public Golongan(Integer golonganId, String nama) {
        this.golonganId = golonganId;
        this.nama = nama;
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
        return "id.co.pussenif.Golongan[ golonganId=" + golonganId + " ]";
    }
    
}
