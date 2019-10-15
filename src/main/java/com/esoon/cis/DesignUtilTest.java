
    /**  
     * @Title: DesignUtilTest.java
     * @Package com.esoon.cis
     * @Description: TODO(用一句话描述该文件做什么)
     * @author 35725
     * @date 2019年9月12日 下午5:37:28 
     * @version V1.0  
     */
    
package com.esoon.cis;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.esoon.cis.constant.DesignConstant;
import com.esoon.cis.util.impl.DesignUtil;

/**
     * @ClassName: DesignUtilTest
     * @Description: TODO(这里用一句话描述这个类的作用)
     * @author 35725
     * @date 2019年9月12日
     *
     */

public class DesignUtilTest {

	public static void main(String[] args) {
		UUID.randomUUID().toString();
		createLogicDesignWithoutDiagram();
		
	}
	
	public static void createProject() {
		DesignUtil du = new DesignUtil(DesignConstant.CapitalVersion_2014);
		String xmlString = du.createProject("测试创建项目例子");
		System.out.println(xmlString);
		File projectSaveFile = new File("templet/2014/测试创建项目例子.xml");
		try {
			FileUtils.writeStringToFile(projectSaveFile, xmlString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void createLogicDesignWithoutDiagram() {
		DesignUtil du = new DesignUtil(DesignConstant.CapitalVersion_2014);
		String xmlString = du.createLogicDesignWithoutDiagram("测试创建logic且不带图纸的设计例子","A");
		System.out.println(xmlString);
		File logicSaveFile = new File("templet/2014/测试创建logic且不带图纸的设计例子.xml");
		try {
			FileUtils.writeStringToFile(logicSaveFile, xmlString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
