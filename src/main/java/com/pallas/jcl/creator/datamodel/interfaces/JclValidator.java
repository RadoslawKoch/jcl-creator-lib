package com.pallas.jcl.creator.datamodel.interfaces;

public interface JclValidator<T> {

	boolean isValid(T name, String value);	
}
