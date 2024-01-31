package org.rak.fee.interfaces;

public interface BusinessService<D> {
	D getByUuid(String uuid);
	D create(D dto);
	D update(D dto, String id);
	void delete(String uuid);

}
