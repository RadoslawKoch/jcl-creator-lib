package com.pallas.jcl.creator.datamodel.interfaces;

import java.util.List;

import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.JclElementNotFoundException;

public interface JclContainer<I,T extends JclElement<I>>  {

	void add(T element) throws DuplicateJclElementException;
	void delete(T element) throws JclElementNotFoundException;
	void deleteById(I id) throws JclElementNotFoundException;
	T getById(I id) throws JclElementNotFoundException;
	List<T> getElements();
	void setElements(List<T> elements);
	
}
