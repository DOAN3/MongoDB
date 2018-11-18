package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Khachhang;
public interface KhachhangRepository extends MongoRepository<Khachhang, String> {

  public Khachhang findOneByTen(String ten);


}
