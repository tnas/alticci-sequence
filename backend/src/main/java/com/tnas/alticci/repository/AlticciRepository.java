package com.tnas.alticci.repository;

import java.math.BigInteger;
import java.util.Optional;

public interface AlticciRepository {

	Optional<BigInteger> getElementByIndex(Integer index);
	
	void pushElement(BigInteger element);
	
	Integer getSequenceSize();
}