package com.tnas.alticci.repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Repository
public class InMemoryAlticciRepository implements AlticciRepository {

	private static List<BigInteger> cacheSequence;

	static {
		cacheSequence = new ArrayList<>();
		cacheSequence.add(BigInteger.ZERO);
		cacheSequence.add(BigInteger.ONE);
		cacheSequence.add(BigInteger.ONE);
	}
	
	@Override
	public Optional<BigInteger> getElementByIndex(Integer index) {
		return index < cacheSequence.size() ?
				Optional.of(cacheSequence.get(index)) : Optional.empty();
	}
	
	@Override
	public void pushElement(BigInteger element) {
		cacheSequence.add(element);
	}

	@Override
	public Integer getSequenceSize() {
		return cacheSequence.size();
	}
	
}
