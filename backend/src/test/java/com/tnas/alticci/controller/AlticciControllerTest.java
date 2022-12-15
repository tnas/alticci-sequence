package com.tnas.alticci.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class AlticciControllerTest {

	private static final String API = "http://localhost:8080/alticci/";

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void whenGetElement_10_ThenResult_9() {
		var response = this.restTemplate.getForEntity(API.concat("/10"), BigInteger.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(new BigInteger("9"), response.getBody());
	}
	
	@Test
	void whenGetNegativeElement_ThenResultError() {
		var url = API.concat("/-5");
		assertThrows(RuntimeException.class, 
				() -> this.restTemplate.getForEntity(url, BigInteger.class));
	}
	
	@Test
	void whenGetElementGreaterThan_1000_ThenResultError() {
		var url = API.concat("/1001");
		assertThrows(RuntimeException.class, 
				() -> this.restTemplate.getForEntity(url, BigInteger.class));
	}
}
