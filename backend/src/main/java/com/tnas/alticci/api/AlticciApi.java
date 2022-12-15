package com.tnas.alticci.api;

import java.math.BigInteger;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Api("Alticci API")
@Tag(name = "Alticci API", description = "API for computing Alticci Sequence")
public interface AlticciApi {

	@Operation(summary = "Retrieve the nth element of the Alticci Sequence", tags = "Alticci API")
	@ApiImplicitParam(name = "n", paramType = "path", value = "Position of the element in the Alticci Sequence", required = true,
			dataTypeClass = Integer.class, example = "10")
	ResponseEntity<BigInteger> getElement(@NotNull @PositiveOrZero @Max(1000) Integer n);
}
