package org.rak.fee.unit.fee;

import org.rak.fee.interfaces.Mapper;

import java.util.UUID;

@org.rak.fee.annotation.Mapper
public class FeeMapperImpl implements Mapper<FeeDto, Fee> {
	@Override
	public FeeDto toDto(Fee entity) {
		return FeeDto.builder()
	    		.uuid(entity.getUuid())
	    		.type(entity.getType())
				.subCategory(entity.getSubCategory())
				.description(entity.getDescription())
				.frequency(entity.getFrequency())
				.category(entity.getCategory())
				.amount(entity.getAmount())
	    		.build();

	}

	@Override
	public Fee toEntity(FeeDto dto) {
		return Fee.builder()
	    		.uuid(UUID.randomUUID().toString())
				.uuid(dto.getUuid())
				.type(dto.getType())
				.subCategory(dto.getSubCategory())
				.frequency(dto.getFrequency())
				.category(dto.getCategory())
				.description(dto.getDescription())
				.amount(dto.getAmount())
	    		.build();

	}
}
