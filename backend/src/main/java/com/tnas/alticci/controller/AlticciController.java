package com.tnas.alticci.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnas.alticci.api.AlticciApi;
import com.tnas.alticci.service.AlticciService;

@RestController
@Validated
@RequestMapping("/alticci")
public class AlticciController implements AlticciApi {
	
	@Autowired
	private AlticciService service;

	@GetMapping("/{n}")
	@Override
	public ResponseEntity<BigInteger> getElement(@PathVariable Integer n) {
		return ResponseEntity.ok(this.service.computeElement(n));
	}
}
