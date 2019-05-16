package com.pallas.jcl.creator.job.steps.dd;

import com.pallas.jcl.creator.datamodel.abstraction.JclMainElement;
import com.pallas.jcl.creator.datamodel.interfaces.DDParamDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.DDStatementDefinition;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.steps.dd.params.DDParamName;


public class DDStatement 
	extends JclMainElement<DDParamName,DDParamDefinition>
	implements DDStatementDefinition{
	
	public DDStatement(String name) throws InvalidNameException{
		super(name);	
	}
	
	@Override
	public String toString() {
		StringBuilder content = new StringBuilder();
		content.append("\n//").append(this.name).append(String.format("%1$"+(12 - this.name.length())+"s","DD "));
		if(this.elementList.size()>0) 
			content.append(this.getParam(content.length(), this.elementList));
		return content.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DDStatement other = (DDStatement) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
	
}
