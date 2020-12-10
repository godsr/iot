package com.ziumks.iot.config;

import org.springframework.http.HttpStatus;

public class CommonCode {
	
	public static final String CHAR_SET = "UTF-8";
	
	public static final String SESSION_ID = "sessionId";
	
	public static class SCHEMA {
		public static final String IOC = "ioc";
		public static final String OMS = "oms";
		public static final String FMS = "fms";
	}
	
	public static class GRUP_CD {
		public static final String DEVICE_TYPE = "IOT001";
		public static final String DeviceProtocolType = "IOT002";
		public static final String TagType = "IOT003";
		public static final String StreamDataType = "IOT004";

		public static final String CompanyType  = "IOT006";

		public static final String ProtocolType = "IOT051";
		public static final String DataFormatType = "IOT052";
		public static final String TransferType = "IOT053";
		public static final String IdLocationType = "IOT054";
		public static final String IdParseType = "IOT055";
		public static final String DataCountType = "IOT056";
		public static final String DataCommandType = "IOT057";
		public static final String DataGetterType = "IOT058";
		public static final String DataSplitType = "IOT059";
		public static final String DataParseType = "IOT060";
		public static final String CornType = "IOT061";
	}
	
	// stream type
	public static class TAG_TYPE {
		public static final String COLLECT = "IOT003001";
		public static final String CONTROLL = "IOT003002";
		public static final String LOCATION = "IOT003003";
	}
	
	public enum RSC {
		EMPTY("", ""),
		ACCEPTED("1000", "ACCEPTED"),
		OK("2000", "OK"), 
		CREATED("2001", "CREATED"), 
		DELETED("2002","DELETED"), 
		UPDATED("2004","UPDATED"), 
		BAD_REQUEST("4000","BAD_REQUEST"),
		NOT_FOUND("4004","NOT_FOUND"),
		OPERATION_NOT_ALLOWED("4005","OPERATION_NOT_ALLOWED"),
		REQUEST_TIMEOUT("4008","REQUEST_TIMEOUT"),
		SUBSCRIPTION_CREATOR_HAS_NO_PRIVILEGE("4101","SUBSCRIPTION_CREATOR_HAS_NO_PRIVILEGE"),
		CONTENTS_UNACCEPTABLE("4102","CONTENTS_UNACCEPTABLE"),
		ACCESS_DENIED("4103","ACCESS_DENIED"),
		GROUP_REQUEST_IDENTIFIER_EXISTS("4104","GROUP_REQUEST_IDENTIFIER_EXISTS"),
		CONFLICT("4015","CONFLICT"),
		INTERNAL_SERVER_ERROR("5000","INTERNAL_SERVER_ERROR"),
		NOT_IMPLEMENTED("5001","NOT_IMPLEMENTED"),
		TARGET_NOT_REACHABLE("5103","TARGET_NOT_REACHABLE"),
		NO_PRIVILEGE("5105","NO_PRIVILEGE"),
		ALREADY_EXISTS("5106","ALREADY_EXISTS"),
		TARGET_NOT_SUBSCRIBABLE("5203","TARGET_NOT_SUBSCRIBABLE"),
		SUBSCRIPTION_VERIFICATION_INITIATION_FAILED("5204","SUBSCRIPTION_VERIFICATION_INITIATION_FAILED"),
		SUBSCRIPTION_HOST_HAS_NO_PRIVILEGE("5205","SUBSCRIPTION_HOST_HAS_NO_PRIVILEGE"),
		NON_BLOCKING_REQUEST_NOT_SUPPORTED("5206","NON_BLOCKING_REQUEST_NOT_SUPPORTED"),
		NOT_ACCEPTABLE("5207","NOT_ACCEPTABLE"),
		EXTENAL_OBJECT_NOT_REACHABLE("6003","EXTENAL_OBJECT_NOT_REACHABLE"),
		EXTENAL_OBJECT_NOT_FOUND("6005","EXTENAL_OBJECT_NOT_FOUND"),
		MAX_NUMBERF_OF_MEMBER_EXCEEDED("6010","MAX_NUMBERF_OF_MEMBER_EXCEEDED"),
		MEMBER_TYPE_INCONSISTENT("6011","MEMBER_TYPE_INCONSISTENT"),
		MGMT_SESSION_CANNOT_BE_ESTABLISHED("6020","MGMT_SESSION_CANNOT_BE_ESTABLISHED"),
		MGMT_SESSION_ESTABLISHMENT_TIMEOUT("6021","MGMT_SESSION_ESTABLISHMENT_TIMEOUT"),
		INVALID_CMDTYPE("6022","INVALID_CMDTYPE"),
		INVALID_ARGUMENTS("6023","INVALID_ARGUMENTS"),
		INSUFFICIENT_ARGUMENTS("6024","INSUFFICIENT_ARGUMENTS"),
		MGMT_CONVERSION_ERROR("6025","MGMT_CONVERSION_ERROR"),
		MGMT_CANCELATION_FAILURE("6026","MGMT_CANCELATION_FAILURE"),
		ALREADY_COMPLETE("6028","ALREADY_COMPLETE"),
		COMMAND_NOT_CANCELLABLE("6029","COMMAND_NOT_CANCELLABLE");
		
		private final String value;
		private final String message;
		
		RSC(String value, String message){
			this.value = value;
			this.message = message;
		}
		public String getValue() {return value;}
		public String getMessage() {
			return message;
		}
		public static RSC getRSC(String responseStatusCode) {
			for (RSC rsc : RSC.values()) {
				if (rsc.getValue().equals(responseStatusCode)) {
					return rsc;
				}
			}
			return null;
		}
		
		public static HttpStatus getRSC2HttpStatus(RSC rsc) {
			HttpStatus httpStatus = null;
			
			switch (rsc) {
			case ACCEPTED:
				httpStatus = HttpStatus.ACCEPTED;
				break;
			case OK:
			case DELETED:
			case UPDATED:
				httpStatus = HttpStatus.OK;
				break;
			case CREATED:
				httpStatus = HttpStatus.CREATED;
				break;
			case CONFLICT:
			case GROUP_REQUEST_IDENTIFIER_EXISTS:
				httpStatus = HttpStatus.CONFLICT;
				break;
			case BAD_REQUEST:
			case CONTENTS_UNACCEPTABLE:
			case MAX_NUMBERF_OF_MEMBER_EXCEEDED:
			case MEMBER_TYPE_INCONSISTENT:
			case INVALID_CMDTYPE:
			case INVALID_ARGUMENTS:
			case INSUFFICIENT_ARGUMENTS:
			case ALREADY_COMPLETE:
			case COMMAND_NOT_CANCELLABLE:
				httpStatus = HttpStatus.BAD_REQUEST;
				break;
			case NOT_FOUND:
			case TARGET_NOT_REACHABLE:
			case EXTENAL_OBJECT_NOT_REACHABLE:
			case EXTENAL_OBJECT_NOT_FOUND:
				httpStatus = HttpStatus.NOT_FOUND;
				break;
			case OPERATION_NOT_ALLOWED:
				httpStatus = HttpStatus.METHOD_NOT_ALLOWED;
				break;
			case REQUEST_TIMEOUT:
				httpStatus = HttpStatus.REQUEST_TIMEOUT;
				break;
			case SUBSCRIPTION_CREATOR_HAS_NO_PRIVILEGE:
			case ACCESS_DENIED:
			case NO_PRIVILEGE:
			case ALREADY_EXISTS:
			case TARGET_NOT_SUBSCRIBABLE:
			case SUBSCRIPTION_HOST_HAS_NO_PRIVILEGE:
				httpStatus = HttpStatus.FORBIDDEN;
				break;
			case INTERNAL_SERVER_ERROR:
			case SUBSCRIPTION_VERIFICATION_INITIATION_FAILED:
			case MGMT_SESSION_CANNOT_BE_ESTABLISHED:
			case MGMT_SESSION_ESTABLISHMENT_TIMEOUT:
			case MGMT_CONVERSION_ERROR:
			case MGMT_CANCELATION_FAILURE:
				httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
				break;
			case NOT_IMPLEMENTED:
			case NON_BLOCKING_REQUEST_NOT_SUPPORTED:
				httpStatus = HttpStatus.NOT_IMPLEMENTED;
				break;
			default:
				httpStatus = HttpStatus.OK;
				break;
			}
			
			return httpStatus;
		}
	}
	
	public enum SEPERATOR {
		COMMA(","),		
		DASH("-"),	
		UNDER_BAR("_"),
		SHARP("#"),
		DOT("."),
		SEMICOLON(";"),
		COLON(":"),
		EQUAL("="),
		DOUBLE_DASH("--"),
		SLASH("/"),
		SPACE(" "),
		PERSENTAGE("%"),
		PLUS("+"),
		PLUS_ESCAPE("\\+"),
		STAR("*");
		
		private final String value;
		SEPERATOR(String value){
			this.value = value;
		}
		
		public String getValue() {return value;}
	}
	
	public static class FLAG {
		public final static String YES = "Y";
		public final static String NO = "N";
	}
	
	public static class FAC_CLFY_NAME {
		public static final String IOT = "IOT";		
		public static final String GATEWAY = "GATEWAY";		
		public static final String BEACON = "BEACON";		
		public static final String SMART_TAG = "TAG";		
		public static final String DEFAULT = "기타";		
	}

	public static class IOC{
		public static final String SYS_CD = "IOT";
	}
}
