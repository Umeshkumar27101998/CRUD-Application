package com.example.demo.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Invoice; 

public interface InvoiceRepo extends JpaRepository<Invoice,Integer> 
{
	
}
