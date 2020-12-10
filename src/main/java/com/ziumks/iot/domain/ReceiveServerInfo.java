package com.ziumks.iot.domain;

import com.ziumks.iot.config.CommonCode;
import org.hibernate.annotations.Formula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "RECEIVE_SERVER_INFO", schema = "iot_web")
public class ReceiveServerInfo {
    private static final long serialVersionUID = 1446169513018067249L;

    @Id
    @Column(name = "RECEIVE_SERVER_ID", length = 32, nullable = false)
    private String receiveServerId;
    @Column(name = "RECEIVE_SERVER_NM", length = 100)
    private String receiveServerNm;
    @Column(name = "PROTOCOL_TYPE", length = 24)
    private String protocolType;
    @Column(name = "TRANSFER_TYPE", length = 24)
    private String transferType;
    @Column(name = "IP", length = 15)
    private String ip;
    @Column(name = "PORT", length = 5)
    private String port;
    @Column(name = "ID_LOCATION", length = 24)
    private String idLocation;
    @Column(name = "GET_TYPE", length = 24)
    private String getType;
    @Column(name = "GET_VALUE")
    private String getValue;
    @Column(name = "PARSE_TYPE")
    private String parseType;
    @Column(name = "PARSE_VALUE")
    private String parseValue;
    @Column(name = "COMMAND_TYPE")
    private String commandType;
    @Column(name = "COMMAND_VALUE")
    private String commandValue;

    //join
    @Formula("(SELECT cci.cd_nm FROM iot_web.comm_cd_info AS cci WHERE cci.grup_cd='"+ CommonCode.GRUP_CD.ProtocolType+"' AND cci.cd = PROTOCOL_TYPE)")
    private String protocolTypeNm;
    @Formula("(SELECT cci.cd_nm FROM iot_web.comm_cd_info AS cci WHERE cci.grup_cd='"+CommonCode.GRUP_CD.TransferType+"' AND cci.cd = TRANSFER_TYPE)")
    private String transferTypeNm;
    @Formula("(SELECT cci.cd_nm FROM iot_web.comm_cd_info AS cci WHERE cci.grup_cd='"+CommonCode.GRUP_CD.DataParseType+"' AND cci.cd = PARSE_TYPE)")
    private String parseTypeNm;
    @Formula("(SELECT cci.cd_nm FROM iot_web.comm_cd_info AS cci WHERE cci.grup_cd='"+CommonCode.GRUP_CD.IdParseType+"' AND cci.cd = GET_TYPE)")
    private String getTypeNm;
    @Formula("(SELECT cci.cd_nm FROM iot_web.comm_cd_info AS cci WHERE cci.grup_cd='"+CommonCode.GRUP_CD.IdLocationType+"' AND cci.cd = ID_LOCATION)")
    private String idLocationNm;
    @Formula("(SELECT cci.cd_nm FROM iot_web.comm_cd_info AS cci WHERE cci.grup_cd='"+CommonCode.GRUP_CD.DataCommandType+"' AND cci.cd = COMMAND_TYPE)")
    private String commandTypeNm;
    

    public String getReceiveServerId() {
        return receiveServerId;
    }

    public void setReceiveServerId(String receiveServerId) {
        this.receiveServerId = receiveServerId;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
    }

    public String getGetType() {
        return getType;
    }

    public void setGetType(String getType) {
        this.getType = getType;
    }

    public String getGetValue() {
        return getValue;
    }

    public void setGetValue(String getValue) {
        this.getValue = getValue;
    }

    public String getParseType() {
        return parseType;
    }

    public void setParseType(String parseType) {
        this.parseType = parseType;
    }

    public String getParseValue() {
        return parseValue;
    }

    public void setParseValue(String parseValue) {
        this.parseValue = parseValue;
    }

    public String getProtocolTypeNm() {
        return protocolTypeNm;
    }

    public void setProtocolTypeNm(String protocolTypeNm) {
        this.protocolTypeNm = protocolTypeNm;
    }

    public String getTransferTypeNm() {
        return transferTypeNm;
    }

    public void setTransferTypeNm(String transferTypeNm) {
        this.transferTypeNm = transferTypeNm;
    }

    public String getParseTypeNm() {
        return parseTypeNm;
    }

    public void setParseTypeNm(String parseTypeNm) {
        this.parseTypeNm = parseTypeNm;
    }

    public String getGetTypeNm() {
        return getTypeNm;
    }

    public void setGetTypeNm(String getTypeNm) {
        this.getTypeNm = getTypeNm;
    }

    public String getIdLocationNm() {
        return idLocationNm;
    }

    public void setIdLocationNm(String idLocationNm) {
        this.idLocationNm = idLocationNm;
    }

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    public String getCommandValue() {
        return commandValue;
    }

    public void setCommandValue(String commandValue) {
        this.commandValue = commandValue;
    }

    public String getCommandTypeNm() {
        return commandTypeNm;
    }

    public void setCommandTypeNm(String commandTypeNm) {
        this.commandTypeNm = commandTypeNm;
    }

    public String getReceiveServerNm() {
        return receiveServerNm;
    }

    public void setReceiveServerNm(String receiveServerNm) {
        this.receiveServerNm = receiveServerNm;
    }

    
}
