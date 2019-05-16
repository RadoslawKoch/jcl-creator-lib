package com.pallas.jcl.creator.datamodel.abstraction;

import java.util.ArrayList;
import java.util.List;

import com.pallas.jcl.creator.datamodel.interfaces.JclContainer;
import com.pallas.jcl.creator.datamodel.interfaces.JclElement;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.JclElementNotFoundException;
import com.pallas.jcl.creator.job.general.GlobalValidator;

public abstract class JclMainElement<I,T extends JclElement<I>>
	extends ParamGenerator<T> 
	implements JclElement<String>,JclContainer<I,T>{

	protected String name;
	protected List<T> elementList;
	
	public JclMainElement(String name) throws InvalidNameException {
		if(!GlobalValidator.isNameValid(name))
			throw new InvalidNameException(name);
		this.elementList = new ArrayList<>();
		this.name = name;
	}
	
	@Override
	public void add(T element) throws DuplicateJclElementException {
		if(this.elementList.contains(element))
			throw new DuplicateJclElementException(element.getName().toString());
		this.elementList.add(element);
	}
	
	@Override
	public void delete(T element) throws JclElementNotFoundException {
		if(!this.elementList.contains(element))
			throw new JclElementNotFoundException(element.toString());
		this.elementList.remove(element);
	}
	
	@Override
	public void deleteById(I id) throws JclElementNotFoundException {
		this.elementList.remove((this.getById(id)));
	}
	
	@Override
	public T getById(I id) throws JclElementNotFoundException {
		for(T el : elementList) {
			if(el.getName().equals(id)) {
				return el;
			}
		}
		throw new JclElementNotFoundException(id.toString());
	}
	
	@Override
	public String getName() {
		return this.name;		
	}

	@Override
	public List<T> getElements() {
		return elementList;
	}

	@Override
	public void setElements(List<T> elements) {
		this.elementList = elements;
		
	}
	
	
	
	
}
