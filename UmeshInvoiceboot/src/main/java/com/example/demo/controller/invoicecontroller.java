package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.inter.InvoiceRepo;

import com.example.demo.model.Invoice;
import com.sun.el.stream.Optional;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class invoicecontroller 
{
	
	@Autowired
	InvoiceRepo repo;
	
	@RequestMapping("/")
	public String home() 
	{
		return "home.jsp";
	}
	//Umesh
	@DeleteMapping("/invoice/{aid}")
	public String deleteInvoice(int aid)
	{
		Invoice a = repo.getOne(aid);
		
		repo.delete(a);
		
		return "Deleted...";
	}
	//Umesh
	@PostMapping(path= "/invoice" , consumes= {"application/json"})
	public Invoice addinvoice(@RequestBody Invoice invoice)
	{
		repo.save(invoice);
		return invoice;
	}
	
	//Umesh
	@GetMapping(path= "/invoice")
	
	public List<Invoice> getinvoice()
	{
		return repo.findAll();
	}
	//Umesh
	@PutMapping(path= "/invoice" , consumes= {"application/json"})
	public Invoice saveOrUpdateinvoice(@RequestBody Invoice invoice)
	{
		repo.save(invoice);
		return invoice;
	}
	
	//umesh
	@RequestMapping("/invoice/{aid}")
	public java.util.Optional<Invoice> getinvoices(@PathVariable("aid") int aid)
	{
		return repo.findById(aid);
	}
		
	@RequestMapping("/getinvoice")
	public ModelAndView getinvoice(@RequestParam int aid)
	{
		ModelAndView mv= new ModelAndView("showinvoice.jsp");
		Invoice invoice = repo.findById(aid).orElse(new Invoice());
		mv.addObject(invoice);
		return mv;
	}

}
