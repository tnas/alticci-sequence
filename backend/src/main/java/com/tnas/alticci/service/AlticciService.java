package com.tnas.alticci.service;

import java.math.BigInteger;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnas.alticci.repository.AlticciRepository;

@Service
public class AlticciService {

	private static final Integer PREVIOUS_THIRD_ELEMENT = 3;
	private static final Integer PREVIOUS_SECOND_ELEMENT = 2;
	
	@Autowired
	private AlticciRepository respository;
	
	public BigInteger computeElement(Integer index) {
		
		var optElement = this.respository.getElementByIndex(index);
		
		if (optElement.isPresent()) {
			return optElement.get();
		}
		else {
			
			IntFunction<BigInteger> alticciFunction = (int i) ->
				this.respository.getElementByIndex(i - PREVIOUS_THIRD_ELEMENT).get()
					.add(this.respository.getElementByIndex(i - PREVIOUS_SECOND_ELEMENT).get());
			
			IntStream.rangeClosed(this.respository.getSequenceSize(), index)
				.forEach(i -> this.respository.pushElement(alticciFunction.apply(i)));
			
			return this.respository.getElementByIndex(index)
					.orElseThrow(() -> new RuntimeException("Alticci Sequence computation failed."));
		}
	}
}
