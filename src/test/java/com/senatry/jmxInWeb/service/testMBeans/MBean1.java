package com.senatry.jmxInWeb.service.testMBeans;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

@ManagedResource(description = "测试")
@Service
public class MBean1 {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(MBean1.class);

	private String attyRW = "prop1 value";

	private long attrRwLong;

	@ManagedAttribute
	public String getAttrRW() {
		log.debug(String.format("getAttrRW() = %s", attyRW));
		return attyRW;
	}

	@ManagedAttribute(description = "读写属性")
	public void setAttrRW(String arg) {
		log.debug(String.format("setAttrRW(%s)", arg));
		this.attyRW = arg;
	}

	@ManagedAttribute(description = "只读属性")
	public Long getAttrReadOnly() {
		long res = System.currentTimeMillis();
		log.debug(String.format("getAttrReadOnly() = %d", res));

		return res;
	}

	@ManagedAttribute(description = "只写属性")
	public void setAttrWriteOnly(String arg) {
		log.debug(String.format("setAttrWriteOnly(%s)", arg));
	}

	@ManagedOperation(description = "对参数进行说明的操作")
	@ManagedOperationParameters(
	{
			@ManagedOperationParameter(description = "T1说明", name = "t1名字"),
			@ManagedOperationParameter(description = "T2说明", name = "t2名字")
	})
	public Long twoParamOpi(long t1, String t2) {

		log.debug(String.format("twoParamOpi(%d, %s)", t1, t2));

		return System.currentTimeMillis();
	}

	@ManagedOperation(description = "无参数的操作")
	public String noParamOpt() {
		// MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

		log.debug("noParamOpt()");

		return "call noParamOpt";
	}

	@ManagedOperation(description = "无返回的操作")
	public void voidReturnOpt() {
		log.debug("voidReturnOpt()");
	}

	@ManagedAttribute(description = "读写属性long")
	public long getAttrRwLong() {
		return attrRwLong;
	}

	@ManagedAttribute
	public void setAttrRwLong(long attrRwLong) {
		this.attrRwLong = attrRwLong;
	}
}