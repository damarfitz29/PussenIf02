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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "anggota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anggota.findAll", query = "SELECT a FROM Anggota a")
    , @NamedQuery(name = "Anggota.findByAnggotaId", query = "SELECT a FROM Anggota a WHERE a.anggotaId = :anggotaId")
    , @NamedQuery(name = "Anggota.findByNrp", query = "SELECT a FROM Anggota a WHERE a.nrp = :nrp")
    , @NamedQuery(name = "Anggota.findByNama", query = "SELECT a FROM Anggota a WHERE a.nama = :nama")
    , @NamedQuery(name = "Anggota.findByAlamat", query = "SELECT a FROM Anggota a WHERE a.alamat = :alamat")
    , @NamedQuery(name = "Anggota.findByTglLahir", query = "SELECT a FROM Anggota a WHERE a.tglLahir = :tglLahir")
    , @NamedQuery(name = "Anggota.findByAgama", query = "SELECT a FROM Anggota a WHERE a.agama = :agama")
    , @NamedQuery(name = "Anggota.findByJenisKelamin", query = "SELECT a FROM Anggota a WHERE a.jenisKelamin = :jenisKelamin")
    , @NamedQuery(name = "Anggota.findByStatus", query = "SELECT a FROM Anggota a WHERE a.status = :status")
    , @NamedQuery(name = "Anggota.findByTglAktif", query = "SELECT a FROM Anggota a WHERE a.tglAktif = :tglAktif")
    , @NamedQuery(name = "Anggota.findByUpdateLast", query = "SELECT a FROM Anggota a WHERE a.updateLast = :updateLast")})
public class Anggota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANGGOTA_ID")
    private Integer anggotaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NRP")
    private String nrp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAMA")
    private String nama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "ALAMAT")
    private String alamat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TGL_LAHIR")
    @Temporal(TemporalType.DATE)
    private Date tglLahir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "AGAMA")
    private String agama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "JENIS_KELAMIN")
    private String jenisKelamin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "STATUS")
    private String status;
    @Lob
    @Column(name = "FOTO")
    private byte[] foto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TGL_AKTIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglAktif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPDATE_LAST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateLast;
    @JoinColumn(name = "GOLONGAN_ID", referencedColumnName = "GOLONGAN_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Golongan golonganId;
    @JoinColumn(name = "DIVISI_ID", referencedColumnName = "DIVISI_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Divisi divisiId;
    @OneToMany(mappedBy = "anggotaId", fetch = FetchType.LAZY)
    private List<Presensi> presensiList;

    public Anggota() {
    }

    public Anggota(Integer anggotaId) {
        this.anggotaId = anggotaId;
    }

    public Anggota(Integer anggotaId, String nrp, String nama, String alamat, Date tglLahir, String agama, String jenisKelamin, String status, Date tglAktif, Date updateLast) {
        this.anggotaId = anggotaId;
        this.nrp = nrp;
        this.nama = nama;
        this.alamat = alamat;
        this.tglLahir = tglLahir;
        this.agama = agama;
        this.jenisKelamin = jenisKelamin;
        this.status = status;
        this.tglAktif = tglAktif;
        this.updateLast = updateLast;
    }

    public Integer getAnggotaId() {
        return anggotaId;
    }

    public void setAnggotaId(Integer anggotaId) {
        this.anggotaId = anggotaId;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Date getTglAktif() {
        return tglAktif;
    }

    public void setTglAktif(Date tglAktif) {
        this.tglAktif = tglAktif;
    }

    public Date getUpdateLast() {
        return updateLast;
    }

    public void setUpdateLast(Date updateLast) {
        this.updateLast = updateLast;
    }

    public Golongan getGolonganId() {
        return golonganId;
    }

    public void setGolonganId(Golongan golonganId) {
        this.golonganId = golonganId;
    }

    public Divisi getDivisiId() {
        return divisiId;
    }

    public void setDivisiId(Divisi divisiId) {
        this.divisiId = divisiId;
    }

    @XmlTransient
    public List<Presensi> getPresensiList() {
        return presensiList;
    }

    public void setPresensiList(List<Presensi> presensiList) {
        this.presensiList = presensiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anggotaId != null ? anggotaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anggota)) {
            return false;
        }
        Anggota other = (Anggota) object;
        if ((this.anggotaId == null && other.anggotaId != null) || (this.anggotaId != null && !this.anggotaId.equals(other.anggotaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.co.pussenif.Anggota[ anggotaId=" + anggotaId + " ]";
    }
    
}
