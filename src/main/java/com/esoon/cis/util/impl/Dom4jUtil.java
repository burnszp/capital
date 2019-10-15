
    /**  
     * @Title: Dom4jUtil.java
     * @Package com.esoon.cis.util.impl
     * @Description: TODO(用一句话描述该文件做什么)
     * @author 35725
     * @date 2019年9月12日 下午5:21:52 
     * @version V1.0  
     */
    
package com.esoon.cis.util.impl;

import java.io.File;
import java.io.FileWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
     * @ClassName: Dom4jUtil
     * @Description: TODO(这里用一句话描述这个类的作用)
     * @author 35725
     * @date 2019年9月12日
     *
     */

public class Dom4jUtil {

	/**
	 * 
	     * @Title: getDocumentByFile
	     * @Description: TODO(根据文件路径获得文件对象)
	     * @param @param xmlPath
	     * @param @return 参数
	     * @return Document 返回类型
	     * @throws
	 */
	public static Document getDocumentByFile(String xmlPath) {
		SAXReader sr = new SAXReader();
		Document document = null;
		try {
			document = sr.read(new File(xmlPath));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}
	
	public static String getStringByDocument(Document document) {
		return document.asXML();
	}
}
