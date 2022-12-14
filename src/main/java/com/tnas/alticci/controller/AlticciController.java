package com.tnas.alticci.controller;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnas.alticci.service.AlticciService;

@RestController
@RequestMapping("/alticci")
public class AlticciController {
	
	@Autowired
	private AlticciService service;

	@GetMapping("/{n}")
	public ResponseEntity<BigInteger> getElement(@PathVariable @NotNull @PositiveOrZero Integer n) {
		return ResponseEntity.ok(this.service.computeElement(n));
	}
}
