package org.rak.fee.interfaces;

public interface RequestValidator<D> {
	boolean validateRequest(D dto);
}
