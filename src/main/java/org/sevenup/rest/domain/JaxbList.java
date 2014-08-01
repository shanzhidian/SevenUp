package org.sevenup.rest.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

	@XmlRootElement(name="Father")
	public class JaxbList<T>{
	    protected List<T> list;

	    public JaxbList(){}

	    public JaxbList(List<T> list){
	    	this.list=list;
	    }

	    @XmlElement(name="Son")
	    public List<T> getList(){
	    	return list;
	    }
	}
