package com.crowdfund.project.entity;

import java.io.Serializable;
import java.util.Date;

public class ProjectMessage implements Serializable {
    /**
     * ID
     */
    private Long msgId;

    /**
     * 项目id
     */
    private Long proId;

    /**
     * 投资人
     */
    private Long investorId;

    /**
     * 融资人
     */
    private Long financierId;

    /**
     * 消息类型(1:项目咨询)
     */
    private Short msgType;

    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 发送时间
     */
    private Date createTime;

    /**
     * 审核状态（0待审核 1已审核 2已驳回）
     */
    private Short status;

    /**
     * 审核时间
     */
    private Date checkTime;

    /**
     * 审核人
     */
    private String checkUserName;

    private static final long serialVersionUID = 1L;

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public Long getFinancierId() {
        return financierId;
    }

    public void setFinancierId(Long financierId) {
        this.financierId = financierId;
    }

    public Short getMsgType() {
        return msgType;
    }

    public void setMsgType(Short msgType) {
        this.msgType = msgType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckUserName() {
        return checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName == null ? null : checkUserName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", msgId=").append(msgId);
        sb.append(", proId=").append(proId);
        sb.append(", investorId=").append(investorId);
        sb.append(", financierId=").append(financierId);
        sb.append(", msgType=").append(msgType);
        sb.append(", msgContent=").append(msgContent);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", checkUserName=").append(checkUserName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}