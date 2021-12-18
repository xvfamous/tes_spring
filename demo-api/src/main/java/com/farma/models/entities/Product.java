package com.farma.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class Product implements Serializable{

@Id
@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
private Long id;

private String nama_barang;

private String deskripsi_barang;

private double harga_barang;

private int statusPembelian;

private String namaPembeli;

private char noHandphone;

@Column(nullable = false, updatable = false)
@Temporal (TemporalType.TIMESTAMP)
@CreatedDate
private Date createdAt;

@Column(nullable = false)
@Temporal(TemporalType.TIMESTAMP)
@LastModifiedDate
private Date updatedAt;

public Long getId() {
return id;
}

public String getnama_barang() {
return nama_barang;
}

public String getdeskripsi_barang() {
return deskripsi_barang;
}

public double getharga_barang() {
return harga_barang;
}

public int getStatusPembelian() {
return statusPembelian;
}

public String getNamaPemebeli() {
return namaPembeli;
}

public Date getCreatedAt() {
return createdAt;
}

public Date getUpdatedAt() {
return updatedAt;
}

public char getnoHandphone(){
return noHandphone;
}

public void setId(Long id) {
this.id = id;
}

public void setnama_barang(String nama_barang) {
this.nama_barang = nama_barang;
}

public void setdeskripsi_barang(String deskripsi_barang) {
this.deskripsi_barang = deskripsi_barang;
}

public void setharga_barang(Double harga_barang) {
this.harga_barang = harga_barang;
}

public void setStatusPembelian(int statusPembelian) {
this.statusPembelian = statusPembelian;
}

public void setNamaPembeli(String namaPembeli) {
this.namaPembeli = namaPembeli;
}

public void setCreatedAt(Date createdAt) {
this.createdAt = createdAt;
}

public void setUpdatedAt(Date updatedAt) {
this.updatedAt = updatedAt;
}

public void setnoHandphone(char noHandphone) {
    this.noHandphone = noHandphone;
    }
}