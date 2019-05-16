package com.pallas.jcl.creator.job.card;


import com.pallas.jcl.creator.datamodel.abstraction.JclMainElement;
import com.pallas.jcl.creator.datamodel.interfaces.Author;
import com.pallas.jcl.creator.datamodel.interfaces.JobCardDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.KeywordParamDefinition;
import com.pallas.jcl.creator.job.card.params.KeywordParamName;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.general.CommentTool;

public class JobCard 
	extends JclMainElement<KeywordParamName,KeywordParamDefinition>
	implements JobCardDefinition{

	private String accountInfo;
	private Author author;
	private String jobDesc;
	
	public JobCard(String name) throws InvalidNameException {
		super(name);
	}	

	@Override
	public String getJobDesc() {
		return this.jobDesc;
	}

	@Override
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	@Override
	public String getAccountInfo() {
		return this.accountInfo;
	}
	
	@Override
	public void setAccountInfo(String accountInfo) {
		this.accountInfo = accountInfo;
	}
	
	@Override
	public Author getAuthor() {
		return this.author;
	}

	@Override
	public void setAuthor(Author author) {
		this.author = author;	
	}

	@Override
	public String toString() {

		StringBuilder content = new StringBuilder("//").append(this.name).append(String.format("%1$"+(12 - this.name.length())+"s","JOB"));
		content.append(" ").append((accountInfo==null?"":"'"+accountInfo+"'")).append((author==null?"":","+"'"+author.getLname()+"'"));
		
		if(this.elementList.size()>0) 
			content.append(",").append(this.getParam(content.length(),this.elementList));

		if(jobDesc!=null) 
			content.append(CommentTool.generateComment(jobDesc, true));	

		return content.toString();
	}



	


}
