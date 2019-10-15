package com.esoon.cis.util.impl;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.Element;

import com.esoon.cis.util.IDesignUtil;

public class DesignUtil implements IDesignUtil {
	private String capitalVersion = "2014";

	/**
	 * 创建一个新的实例 DesignUtil
	 *
	 */

	public DesignUtil(String capitalVersion) {
		this.capitalVersion = capitalVersion;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param projectName
	 * 
	 * @return
	 * 
	 * @see com.esoon.cis.util.IDesignUtil#createProject(java.lang.String)
	 */

	public String createProject(String projectName) {
		File projectTempletFile = new File("templet/" + capitalVersion + "/" + capitalVersion + "_" + "project.xml");
		System.out.println("projectTempletFile：>>>>>>>>>>>" + projectTempletFile.getAbsolutePath());
		Document document = Dom4jUtil.getDocumentByFile(projectTempletFile.getAbsolutePath());
		Element projectElement = document.getRootElement();
		projectElement.addAttribute("name", projectName);
		
		return document.asXML();
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param designName
	 * 
	 * @param revision
	 * 
	 * @return
	 * 
	 * @see com.esoon.cis.util.IDesignUtil#createLogicDesign(java.lang.String,
	 * java.lang.String)
	 */

	public String createLogicDesignWithoutDiagram(String designName, String revision) {
		

		File logicTempletFile = new File("templet/" + capitalVersion + "/" + capitalVersion + "_" + "logic.xml");
		System.out.println("logicTempletFile：>>>>>>>>>>>" + logicTempletFile.getAbsolutePath());
		Document document = Dom4jUtil.getDocumentByFile(logicTempletFile.getAbsolutePath());
		Element projectElement = document.getRootElement();
		Element logicElement = projectElement.element("designmgr").element("logicaldesign");
		logicElement.addAttribute("name", designName);
		logicElement.addAttribute("version", revision);
		return document.asXML();
	}

}
