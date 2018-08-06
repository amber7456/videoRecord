package com.videorecord.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
//import org.springframework.util.Assert;

import com.videorecord.exception.ForegoneException;

import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

public class JAXBUtils {

	public static String BeanToXml(Object bean, String packageName) throws ForegoneException {
		String xml = "";
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(packageName);
			Marshaller marshaller = jaxbContext.createMarshaller();
			StringWriter writer = new StringWriter();
			marshaller.marshal(bean, writer);
			xml = writer.toString();
		} catch (JAXBException e) {
			throw new ForegoneException("转换Bean为Xml出错", -10002);
		}
		return xml;
	}

	/**
	 * object convert to xml string
	 */
	public static String obj2xml(Object obj) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		return xmlSerializer.write(JSONSerializer.toJSON(obj));
	}

	public static Object XmlToBean(String xml, String packageName) throws ForegoneException {
		Object obj = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(packageName);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			obj = unmarshaller.unmarshal(new StringReader(xml));
		} catch (JAXBException e) {
			// 记录解析错误的XML
			e.printStackTrace();
			throw new ForegoneException(e.getMessage(), -10002);
		} catch (Exception e) {
			// 记录解析错误的XML
			e.printStackTrace();
			throw new ForegoneException(e.getMessage(), -10002);
		}
		return obj;
	}

	// public static String toXml(Object bean) {
	// String xml = "";
	// String className = "";
	// try {
	// if (bean instanceof String) {
	// xml = (String) bean;
	// className = "java.lang.String";
	// } else {
	// Class clazz = getClazz(bean);
	// className = clazz.getName();
	// JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
	// Marshaller marshaller = jaxbContext.createMarshaller();
	// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	// StringWriter writer = new StringWriter();
	// marshaller.marshal(bean, writer);
	// xml = writer.toString();
	// }
	// logInfo("JAXBUtils.toXml", className + " xml:\n" + xml);
	// } catch (Exception e) {
	// // throw new SVCException("转换" + className + "为Xml出错," +
	// // e.getMessage(), ErrCode.MAKY_ERR_JAXB_BEAN_TO_XML);
	// }
	// return xml;
	// }

	@SuppressWarnings("unchecked")
	public static <T> T toBean(String xml, Class<T> clazz) {
		T obj = null;
		@SuppressWarnings("unused")
		String className = "";
		try {
			if (null == xml || xml.trim().length() < 1) {
				return obj;
			}
			logInfo("JAXBUtils.toBean", clazz.getName() + " xml:\n" + xml);
			if (clazz.getName().equals("java.lang.String")) {
				obj = (T) xml;
			} else {
				className = clazz.getName();
				JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				obj = (T) unmarshaller.unmarshal(new StringReader(xml));
			}
		} catch (Exception e) {
			System.out.println(e);
			// throw new SVCException("转换Xml为" + className + "出错," +
			// e.getMessage(), ErrCode.MAKY_ERR_JAXB_XML_TO_BEAN);
		}
		return obj;
	}

	// private static Class<?> getClazz(Object instance) {
	// Assert.notNull(instance, "Instance must not be null");
	// Class clazz = instance.getClass();
	// if ((clazz != null) && clazz.getName().contains("$$")) {
	// Class<?> superClass = clazz.getSuperclass();
	// if ((superClass != null) && !Object.class.equals(superClass)) {
	// return superClass;
	// }
	// }
	// return clazz;
	// }

	private static void logInfo(String method, String in) {
		// // SpringBeanUtil.getLogSVC().info(JAXBUtils.class, in);
		// SpringBeanUtil.getLogSVC().info(JAXBUtils.class, in);
		// if (BasicDataManageImpl.basicDateMap.get("INTERVAL_TIME") == null ||
		// BasicDataManageImpl.basicDateMap.get("INTERVAL_TIME").trim().equals(""))
		// {
		// SpringBeanUtil.getErrorDataManage().saveErrorData("ERROR_BASIC_DATA",
		// "BASIC_DATA_NONE", "BasicDataManageImpl.SYSTEM_NAME",
		// "com.travelsky.msky.utils.JAXBUtils.logInfo");
		// SpringBeanUtil.getBasicDataManage();
		// }
		// SpringBeanUtil.getLogSVC().logdb(JAXBUtils.class, in, "", method, "",
		// Constants.LOG_INFO);
	}
}
