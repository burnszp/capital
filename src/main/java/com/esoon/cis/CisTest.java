/*******************************************************************************
 * @project: CapitalUtils
 * @package: com.esoon.cis
 * @file: CisTest.java
 * @author: zhangpei
 * @created: 2019-8-22
 * @purpose:
 * 
 * @version: 1.0
 * 
 * Revision History at the end of file.
 * 
 * Copyright 2019 esoon-tech All rights reserved.
 ******************************************************************************/

/**   
* @Title: CisTest.java 
* @Package com.esoon.cis 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Burns[张沛]   
* @date 2019-8-22 下午1:44:58 
* @version V1.0   
*/
package com.esoon.cis;

import com.esoon.cis.util.impl.CisUtil;

/** 
 * @ClassName: CisTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Burns[张沛] 
 * @date 2019-8-22 下午1:44:58 
 *  
 */
public class CisTest {
	public static void main(String[] args) {
//		CisUtil cu = CisUtil.getCisUtil("127.0.0.1", 49901, "system", "manager");
		CisUtil cu = CisUtil.getCisUtil("localhost", 49901, "system", "manager");
		String xmlString = null;
		{
			//1、获得captial中所有项目信息
//			{
				xmlString = cu.getProjectList();//文件内容保存在当前
//			}
		}
		
		
		{
			//2、获得captial中指定项目(例如“TA600”)下所有设计信息
//			{
//				xmlString = cu.getDesignList("TA600");
//			}
		}
		
		
		{
			//3、根据指定1个（uid）或4个信息（name,revision.shortdescription,projectName）获取某个设计信息
			{
				xmlString = cu.getDesignXmlByUid("UID409d71-145efe3e535-3661251947176775d765044d1fcbae0c");
				xmlString = cu.getDesignXmlByTTriplet("HarnessDesign3", "A", "Short Description1", "TA600");
			}
		}
		
		
//		String xmlString = cu.getDesignList("12所");
//		<?xml version="1.0" encoding="UTF-8" standalone="no"?><designs xmlns="http://www.mentor.com/harness/Schema/bridgesdesigns" author="system" creationDate="2019-09-10" creationTime="11:21:20" schemaVersion="1_0">
//		  <design designtype="topologydesign" id="UID4ec5e4-16d190e82b5-ef94443c96f38a5ae992ab7ba0885d36" name="IntegratorDesign1" revision="A"/>
//		</designs>
		
		
//		String xmlString = cu.getDesignXml("UID24a8ab-16d1951664e-ef94443c96f38a5ae992ab7ba0885d36");
//		String xmlString = cu.getDesignXmlByUid("UID4ec5e4-16d190e82b5-ef94443c96f38a5ae992ab7ba0885d36");
//		String xmlString = cu.getDesignXmlByTTriplet("TopologyDesign1", "A", "111", "12所");
//		String xmlString = cu.getDesignXmlByTTriplet("Design1", "A", "222", "12所");
		System.out.println("展示获取的xml内容：");
		System.out.println(xmlString);
	}

}


/*******************************************************************************
 * <B>Revision History</B><BR>
 * [type 'revision' and press Alt + / to insert revision block]<BR>
 * 
 * 
 * 
 * Copyright 2019 esoon-tech All rights reserved.
 ******************************************************************************/