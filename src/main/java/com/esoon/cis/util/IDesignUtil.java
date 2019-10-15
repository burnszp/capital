package com.esoon.cis.util;

public interface IDesignUtil {

	/**
	     * @Title: createProject
	     * @Description: 创建一个空的项目，项目中没有项目，没有模版定义，没有样式定义等。
	     * @param @param projectName
	     * @param @return 参数
	     * @return String 返回类型
	     * @throws
	 */
	String createProject(String projectName);
	
	/**
	 * 
	     * @Title: createLogicDesign
	     * @Description: 创建一个logic设计，该设计不带图纸。
	     * @param @param designName
	     * @param @param revision
	     * @param @return 参数
	     * @return String 返回类型
	     * @throws
	 */
	String createLogicDesignWithoutDiagram(String designName,String revision);
	
	
}
