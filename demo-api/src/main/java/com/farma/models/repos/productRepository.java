package com.farma.models.repos;

import java.util.List;

import com.farma.models.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<Product, Long> {
	List<Product> findByStatusPeminjaman (int statusPembelian);
	List<Product> findByTitleBook(String nama_barang);
    Product findOne(Long id);
    List<Product> findBynama_barang(String nama_barang);
    List<Product> findByStatusPembelian(int statusPembelian);
}