package org.rak.fee.unit.fee;

import org.apache.logging.log4j.util.Strings;
import org.rak.fee.annotation.Validator;
import org.rak.fee.interfaces.RequestValidator;

import java.util.Optional;

@Validator
public class FeeRequestValidatorImpl implements RequestValidator<FeeDto> {

	private final FeeRepository repository;

	public FeeRequestValidatorImpl(FeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean validateRequest(FeeDto dto) {
		return Optional.ofNullable(dto)
				.filter(dto1 -> Strings.isNotBlank(dto1.getType()))
				.filter(dto1 -> Strings.isNotBlank(dto1.getSubCategory()))
				.filter(dto1 -> FeeType.isValid(dto1.getType()))
				.filter(dto1 -> FeeCategory.isValid(dto1.getCategory()))
				.filter(dto1 -> FeeFrequency.isValid(dto1.getFrequency()))
				.filter(dto1 -> validateSubTypeBasedOnType(dto1.getType(), dto1.getSubCategory()))
				.filter(dto1 ->  !repository.existsByTypeAndCategoryAndSubCategoryAndFrequency(dto1.getType(), dto1.getCategory(), dto1.getSubCategory(), dto1.getFrequency()))
				.isPresent();
	}

	private boolean validateSubTypeBasedOnType(String type, String subType) {
		return true;
	}
}
