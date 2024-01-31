package org.rak.fee.interfaces;

public interface Mapper<D, E> {

	D toDto(E entity);

	E toEntity(D dto);

}
