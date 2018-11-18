package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Khachhang;

import com.example.repository.KhachhangRepository;
@EntityScan

@RestController
@RequestMapping("/khachhang")
public class KhachhangController {

    @Autowired
   KhachhangRepository khachhangRepository;
    
    @RequestMapping(value="/{ten}",method = RequestMethod.GET)
    public Khachhang showUser(@PathVariable String ten){
        return khachhangRepository.findOneByTen(ten);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Khachhang khachhang) {
       khachhangRepository.save(khachhang);
    }

    @RequestMapping(value = "/{id}") 
    public Khachhang read(@PathVariable String id) {
        return khachhangRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Khachhang khachhang) {
        khachhangRepository.save(khachhang);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
    public void delete(@PathVariable String id) {
        khachhangRepository.delete(id); 
    }

}