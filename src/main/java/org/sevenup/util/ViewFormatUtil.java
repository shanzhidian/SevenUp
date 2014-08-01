package org.sevenup.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.View;

/**
 * 
 * @author steven
 *
 */
public class ViewFormatUtil {
	@Autowired
	@Qualifier("jsonview")
	private static View jsonView;

	@Autowired
	@Qualifier("xmlview")
	private static View xmlView;
	
	public static View getView(String format){
		View returnView = null;
		if(StringUtil.isEmpty(format)){
			
		}else{
			if(format.equalsIgnoreCase(SevenUpConstants.VIEW_JSON)){
				returnView = jsonView;
			}else if(format.equalsIgnoreCase(SevenUpConstants.VIEW_XML)){
				returnView = xmlView;
			}else{
				//
			}
		}
		return returnView;
	}
}
