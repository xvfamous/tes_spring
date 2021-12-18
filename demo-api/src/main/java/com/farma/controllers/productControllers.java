package com.farma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farma.models.entities.Product;
import com.farma.models.repos.productRepository;

@RestController
@RequestMapping("/Product")
public class productControllers {

@Autowired
productRepository productRepository;


@GetMapping("/")
public List<Product> getAll(){
return productRepository.findAll();
}

@PostMapping("/")
public Product tambahproduct(@Validated @RequestBody Product Product) {
return productRepository.save(Product);
}

@PutMapping("/{id}")
public ResponseEntity<Product> updateProduct(@PathVariable(value="id")Long id,
@Validated @RequestBody Product detailProduct){
Product Product = productRepository.findOne(id);
if(Product == null)
return ResponseEntity.notFound().build();
Product.setnama_barang(detailProduct.getnama_barang());
Product.setdeskripsi_barang(detailProduct.getdeskripsi_barang());
Product.setharga_barang(detailProduct.getharga_barang());
Product.setNamaPembeli(detailProduct.getNamaPemebeli());
Product.setStatusPembelian(detailProduct.getStatusPembelian());
Product.setnoHandphone (detailProduct.getnoHandphone());
Product updatedProduct = productRepository.save(Product);
return ResponseEntity.ok(updatedProduct);
}

@DeleteMapping("/{id}")
public String deleteProduct(@PathVariable (value="id") Long id){
Product Product = productRepository.findOne(id);
String result = "";
if(Product == null) {
result = "id "+id+" tidak ditemukan";
return result;
}
result = "id "+id+" berhasil di hapus";
productRepository.deleteById(id);
return result; 
}

@GetMapping("/{id}")
public ResponseEntity<Product> getProductById(@PathVariable(value="id") Long id){
Product Product = productRepository.findOne(id);
if(Product == null)
return ResponseEntity.notFound().build();
return ResponseEntity.ok().body(Product);
}

@GetMapping("/sortProduct")
public List<Product> sortProduct(@RequestParam(value="title")String nama_barang){
return productRepository.findBynama_barang(nama_barang);
}

@GetMapping("/sortstatus/{statusPembelian}")
public List<Product> sortstatus(@PathVariable(value="statusPembelian") int statusPembelian){
return productRepository.findByStatusPembelian(statusPembelian);
}


}
