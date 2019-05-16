package com.pallas.jcl.creator.job.steps;

import java.util.ArrayList;
import java.util.List;

import com.pallas.jcl.creator.datamodel.abstraction.Executable;
import com.pallas.jcl.creator.datamodel.abstraction.JclMainElement;
import com.pallas.jcl.creator.datamodel.interfaces.DDStatementDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.StepDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.StepParamDefinition;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.exceptions.JclElementNotFoundException;
import com.pallas.jcl.creator.job.general.CommentTool;
import com.pallas.jcl.creator.job.general.GlobalSettings;
import com.pallas.jcl.creator.job.steps.params.StepParamName;

public class Step 
	extends JclMainElement<StepParamName,StepParamDefinition> 
	implements StepDefinition{

	private final Executable execPosition;
	private List<DDStatementDefinition> ddStatements = new ArrayList<>();
	private String comment;
	
	public Step(String name,Executable execPosition) throws InvalidNameException{
		super(name);
		this.execPosition = execPosition;
	}
	
	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public DDStatementDefinition getDDByName(String name) throws JclElementNotFoundException {
		for(DDStatementDefinition x : this.ddStatements) {
			if(x.getName().equals(name))
				return x;
		}
		throw new JclElementNotFoundException(name);
	}
	
	@Override
	public void deleteDD(String name) throws JclElementNotFoundException{
		this.ddStatements.remove(this.getDDByName(name));
	}

	@Override
	public List<DDStatementDefinition> getDDStatements() {
		return ddStatements;
	}

	public void setDdStatements(List<DDStatementDefinition> ddStatements) {
		this.ddStatements = ddStatements;
	}

	@Override
	public void addDD(DDStatementDefinition ddStatement) throws DuplicateJclElementException {
		if(this.ddStatements.contains(ddStatement))
			throw new DuplicateJclElementException(ddStatement.toString());
		this.ddStatements.add(ddStatement);
	}

	@Override
	public Executable getExecPosition() {
		return execPosition;
	}


	@Override
	public String toString() {
		StringBuilder content = new StringBuilder();
		if(comment!=null) {
			content.append(CommentTool.generateComment(this.comment, false));
		}
		content.append("\n//").append(this.name).append(String.format("%1$"+(13 - this.name.length())+"s","EXEC")).append(" ").append(this.execPosition);
		int signCounter = content.length();
		if(this.elementList.size()>0) {
			content.append(",").append(this.getParam(signCounter, this.elementList));	
		}
		if(this.ddStatements.size()>0) {
			for(DDStatementDefinition x : this.ddStatements) {
				if(signCounter+x.toString().length()+2 >  GlobalSettings.LINE_LENGTH) {
					signCounter=11;
				}
				signCounter+=x.toString().length()+2;
				content.append(x);				
			}			
		}
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
		Step other = (Step) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public void setElements(List<StepParamDefinition> elements) {
		this.elementList = elements;	
	}


	
}
