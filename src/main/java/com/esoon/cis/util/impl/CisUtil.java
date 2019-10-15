/*******************************************************************************
 * @project: CapitalUtils
 * @package: com.esoon.cis
 * @file: CisUtil.java
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
* @Title: CisUtil.java 
* @Package com.esoon.cis 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Burns[张沛]   
* @date 2019-8-22 上午11:47:09 
* @version V1.0   
*/
package com.esoon.cis.util.impl;

/** 
 * @ClassName: CisUtil 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Burns[张沛] 
 * @date 2019-8-22 上午11:47:09 
 *  
 */

import java.io.File;

import javax.xml.soap.SOAPBody;

import com.acconsys.cws.CisServer;
import com.acconsys.cws.SOAPClient;
import com.acconsys.cws.SOAPRequest;
import com.acconsys.cws.SOAPResponse;

public class CisUtil {

	private static String ip;
	private static int port;
	private static String username;
	private static String password;

	private static CisUtil cisUtil;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param ip
	 * @param port
	 * @param username
	 * @param password
	 */
	public CisUtil(String ip, int port, String username, String password) {
		this.ip = ip;
		this.port = port;
		this.username = username;
		this.password = password;
	}

	public static CisUtil getCisUtil(String ip, int port, String username, String password) {
		if (cisUtil == null) {
			cisUtil = new CisUtil(ip, port, username, password);

		}
		return cisUtil;
	}

	public static String getProjectList() {
		String xmlString = null;
		try {
			CisServer server = new CisServer(ip, port);
			SOAPRequest request = new SOAPRequest();
			request.setUsername(username);
			request.setPassword(password);
			request.setPayload("<projects/>");
			request.build(true);
			SOAPClient client = new SOAPClient();
			SOAPResponse response = client.callService(request, server.getProjectsListService());

			response.getSoapResponse();
			response.getSoapResponse().getTextContent();
			// 从Document 转成xml字符串
			xmlString = DomUtils.toStringFromDoc1(response.getSoapResponse());

//		 SOAPBody body = response.getResponse().getSOAPBody();
			// 保存内容到指定文件
			response.saveBody(new File("testresult/2014/projects.xml"));
//		 xmlString = body.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return xmlString;

	}

	/**
	 * 获得指定项目的设计信息集合
	 * 
	 * @param projectName
	 * @return
	 */
	public static String getDesignList(String projectName) {
		String xmlString = null;
		try {
			CisServer server = new CisServer(ip, port);
			SOAPRequest request = new SOAPRequest();
			request.setUsername(username);
			request.setPassword(password);
			request.setPayload("<project name='" + projectName + "'/>");
			request.build(true);
			SOAPClient client = new SOAPClient();
			SOAPResponse response = client.callService(request, server.getDesignsListService());

			response.getSoapResponse();
			response.getSoapResponse().getTextContent();
			// 从Document 转成xml字符串
			xmlString = DomUtils.toStringFromDoc1(response.getSoapResponse());

//		 SOAPBody body = response.getResponse().getSOAPBody();
			// 保存内容到指定文件
			response.saveBody(new File("testresult/2014/designs.xml"));
//		 xmlString = body.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return xmlString;

	}

	public static String getDesignXmlByUid(String designUID) {
		String xmlString = null;
		try {
			CisServer server = new CisServer(ip, port);
			SOAPRequest request = new SOAPRequest();
			request.setUsername(username);
			request.setPassword(password);
			request.setPayload("<wiringdesign id='" + designUID + "'/>");
			request.build(true);
			SOAPClient client = new SOAPClient();
			SOAPResponse response = client.callService(request, server.getDesignExporterService());

			response.getSoapResponse();
			response.getSoapResponse().getTextContent();
			// 从Document 转成xml字符串
			xmlString = DomUtils.toStringFromDoc1(response.getSoapResponse());

//		 SOAPBody body = response.getResponse().getSOAPBody();
			// 保存内容到指定文件
			response.addDocumentType();
			response.saveBody(new File("design.xml"));
//		 xmlString = body.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return xmlString;

	}

	
	/**
	 * 根据指定的三个信息返回设计的源文件。
	 * @param name
	 * @param revision
	 * @param shortdescription
	 * @param projectName
	 * @return
	 */
	public static String getDesignXmlByTTriplet(String name, String revision, String shortdescription,
			String projectName) {
		String xmlString = null;
		try {
			CisServer server = new CisServer(ip, port);
			SOAPRequest request = new SOAPRequest();
			request.setUsername(username);
			request.setPassword(password);
			request.setPayload("<wiringdesign name='" + name + "' revision='" + revision + "' shortdescription='"
					+ shortdescription + "' projectname='" + projectName + "'/>");
			System.out.println("<wiringdesign name='" + name + "' revision='" + name + "' shortdescription='"
					+ shortdescription + "' projectname='" + projectName + "'/>");
			request.build(true);
			SOAPClient client = new SOAPClient();
			SOAPResponse response = client.callService(request, server.getDesignExporterService());

			response.getSoapResponse();
			response.getSoapResponse().getTextContent();
			// 从Document 转成xml字符串
			xmlString = DomUtils.toStringFromDoc1(response.getSoapResponse());

//		 SOAPBody body = response.getResponse().getSOAPBody();
			// 保存内容到指定文件
			response.addDocumentType();
			response.saveBody(new File("design.xml"));
//		 xmlString = body.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return xmlString;

	}

//	public static List<String> getAllProjectName() throws Exception {
//		List<String> projectList = new ArrayList<String>();
//		CisServer server = new CisServer(IP, Integer.parseInt(PORT));
//		SOAPRequest request = new SOAPRequest();
//		request.setUsername(USERNAME);
//		request.setPassword(PASSWORD);
//		request.setPayload("<projects/>");
//		request.build(true);
//		SOAPClient client = new SOAPClient();
//		SOAPResponse response = client.callService(request,
//				server.getProjectsListService());
//
//		SOAPBody body = response.getResponse().getSOAPBody();
//		NodeList nodeList = body.getChildNodes();
//		if (nodeList != null) {
//			for (int i = 0; i < nodeList.getLength(); i++) {
//				Node node = nodeList.item(i);
//				if ("projects".equals(node.getNodeName())
//						&& node instanceof Element) {
//					// 开始循环遍历projects
//					NodeList projects = node.getChildNodes();
//					if (projects != null) {
//						for (int j = 0; j < projects.getLength(); j++) {
//							Node project = projects.item(j);
//							if ("project".equals(project.getNodeName())
//									&& project instanceof Element) {
//								Node projectNameNode = project.getAttributes()
//										.getNamedItem("name");
//								String projectName = projectNameNode
//										.getNodeValue();
//								System.out
//										.println("projectName:" + projectName);
//								projectList.add(projectName);
//							}
//						}
//					}
//				}
//			}
//		}
//		return projectList;
//	}
//
//	public List<DesignModelUI> getDesignByProjectName(String projectName)
//			throws Exception {
//		List<DesignModelUI> designModelUIList = new ArrayList<DesignModelUI>();
//		JOptionPane.showMessageDialog(null, "IP:" + IP + "PORT:" + PORT
//				+ "USERNAME:" + USERNAME + "PASSWORD:" + PASSWORD + "PROJECT"
//				+ projectName);
//		CisServer server = new CisServer(IP, Integer.parseInt(PORT));
//		SOAPRequest request = new SOAPRequest();
//		request.setUsername(USERNAME);
//		request.setPassword(PASSWORD);
//		request.setPayload("<project name='" + projectName + "'/>");
//		request.build(true);
//		SOAPClient client = new SOAPClient();
//		SOAPResponse response = client.callService(request,
//				server.getDesignsListService());
//		File designFile = new File(PropertieUtil.getPropertieUtil().getValue(
//				Constants.FILE_DIR)
//				+ "_Design"
//				+ "_"
//				+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
//				+ ".xml");
//		if (!designFile.exists()) {
//			designFile.createNewFile();
//		}
//		if (!designFile.exists()) {
//			JOptionPane.showMessageDialog(null, designFile.getName() + "不存在！");
//		}
//
//		response.saveBody(designFile);
//		SOAPBody body = response.getResponse().getSOAPBody();
//		if (body.hasChildNodes()) {
//
//			NodeList nodeList = body.getElementsByTagName("design");
//			if (nodeList != null) {
//				for (int i = 0; i < nodeList.getLength(); i++) {
//					Node node1 = nodeList.item(i);
//					if ("design".equals(node1.getNodeName())) {
//						Node type = node1.getAttributes().getNamedItem(
//								"designtype");
//						if(type!=null){
//							
//							String designType = type.getNodeValue();
//							if ("logicdesign".equals(designType)
//									|| "harnessdesign".equals(designType)) {
//								Node name = node1.getAttributes().getNamedItem(
//										"name");
//								Node revision = node1.getAttributes().getNamedItem(
//										"revision");
//								String designName = name.getNodeValue();
//								String designRevision = revision.getNodeValue();
//								DesignModelUI designModelUI = new DesignModelUI();
//								designModelUI.setDesignName(designName);
//								designModelUI.setDesignRevision(designRevision);
//								designModelUI.setProjectName(projectName);
//								designModelUIList.add(designModelUI);
//							}
//						}
//					}
//
//				}
//			}
//		}
//		return designModelUIList;
//	}
//
//	public void getComponentUsedInfoInDesign(String projectName,
//			String designName, String designRevision,
//			Map<String, ComponentUsedModel> map) throws Exception {
//
//		CisServer server = new CisServer(IP, Integer.parseInt(PORT));
//		SOAPRequest request = new SOAPRequest();
//		request.setUsername(USERNAME);
//		request.setPassword(PASSWORD);
//		// request.setPayload("<wiringdesign designtype='Logic' name='Design' projectname='Test2' revision='C' shortdesc=''/>");
//		request.setPayload("<wiringdesign name='" + designName
//				+ "' projectname='" + projectName + "' revision='"
//				+ designRevision + "' />");
//		request.build(true);
//		SOAPClient client = new SOAPClient();
//		SOAPResponse response = client.callService(request,
//				server.getDesignBridgeOutService());
//
//		SOAPBody body = response.getResponse().getSOAPBody();
//
//		if (body != null) {
//			NodeList nodeList = body.getChildNodes();
//			if (nodeList != null) {
//
//				for (int i = 0; i < nodeList.getLength(); i++) {
//					Node node = nodeList.item(i);
//					if ("wiringdesign".equals(node.getNodeName())
//							|| "harnessdesign".equals(node.getNodeName())) {
//						NodeList nodeList1 = node.getChildNodes();
//						if (nodeList1 != null) {
//							for (int j = 0; j < nodeList1.getLength(); j++) {
//								Node node1 = nodeList1.item(j);
//								if (node1 instanceof Element) {
//									Node attrNode = node1.getAttributes()
//											.getNamedItem("partnumber");
//									if (attrNode != null) {
//										String partNumber = attrNode
//												.getNodeValue();
//										if (map.get(partNumber) == null) {
//											ProjectModel pModel = new ProjectModel();
//											Map<String, Integer> designMap = new HashMap<String, Integer>();
//											designMap.put(designName
//													+ designRevision, 1);
//											pModel.setDesignMap(designMap);
//											pModel.setUsedInAllDesignCount(1);
//											Map<String, ProjectModel> projectMap = new HashMap<String, ProjectModel>();
//											projectMap.put(projectName, pModel);
//											ComponentUsedModel cModel = new ComponentUsedModel();
//											cModel.setProjectMap(projectMap);
//											cModel.setUsedInAllProjectCount(1);
//											map.put(partNumber, cModel);
//										} else {
//											ComponentUsedModel cModel = map
//													.get(partNumber);
//											Map<String, ProjectModel> projectMap = cModel
//													.getProjectMap();
//											ProjectModel pModel = projectMap
//													.get(projectName);
//											if (pModel == null) {
//												pModel = new ProjectModel();
//												Map<String, Integer> designMap = new HashMap<String, Integer>();
//												designMap.put(designName + "_"
//														+ designRevision, 1);
//												pModel.setDesignMap(designMap);
//												pModel.setUsedInAllDesignCount(1);
//												projectMap.put(projectName,
//														pModel);
//											} else {
//												Map<String, Integer> designMap = pModel
//														.getDesignMap();
//												if (designMap == null) {
//													designMap = new HashMap<String, Integer>();
//													designMap
//															.put(designName
//																	+ designRevision,
//																	1);
//												} else {
//													Integer designCount = designMap
//															.get(designName
//																	+ designRevision);
//													if (designCount == null) {
//														designMap
//																.put(designName
//																		+ designRevision,
//																		1);
//													} else {
//														designMap
//																.put(designName
//																		+ designRevision,
//																		designCount + 1);
//													}
//												}
//												pModel.setUsedInAllDesignCount(pModel
//														.getUsedInAllDesignCount() + 1);
//											}
//											cModel.setUsedInAllProjectCount(cModel
//													.getUsedInAllProjectCount() + 1);
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//
//			}
//
//		}
//
//	}
}

/*******************************************************************************
 * <B>Revision History</B><BR>
 * [type 'revision' and press Alt + / to insert revision block]<BR>
 * 
 * 
 * 
 * Copyright 2019 esoon-tech All rights reserved.
 ******************************************************************************/