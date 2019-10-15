
    /**  
     * @Title: UUIDTest.java
     * @Package com.esoon.capital
     * @Description: TODO(用一句话描述该文件做什么)
     * @author 35725
     * @date 2019年9月20日 下午1:42:09 
     * @version V1.0  
     */
    
package com.esoon.capital;

import java.util.UUID;

import org.junit.Test;

import junit.framework.TestCase;

/**
     * @ClassName: UUIDTest
     * @Description: TODO(这里用一句话描述这个类的作用)
     * @author 35725
     * @date 2019年9月20日
     *
     */
public class UUIDTest extends TestCase {
	public static void main(String[] args) {
		
		System.out.println(UUID.randomUUID().toString());
	}

	@Test
	private void getUUID() {
	}
}
