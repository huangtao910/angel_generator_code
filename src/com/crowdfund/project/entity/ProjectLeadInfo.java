package com.crowdfund.project.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProjectLeadInfo implements Serializable {
    /**
     * ID
     */
    private Long leadId;

    /**
     * ��Ŀid
     */
    private Long proId;

    /**
     * Ͷ����
     */
    private Long investorId;

    /**
     * ������
     */
    private Long financierId;

    /**
     * ����ʱ��
     */
    private Date createTime;

    /**
     * ���״̬��0����� 1ͨ�� 2��ͨ����
     */
    private Short status;

    /**
     * ���ʱ��
     */
    private Date checkTime;

    /**
     * �����
     */
    private String checkUserName;

    /**
     * ��Ͷ���
     */
    private BigDecimal leadAmount;

    /**
     * Ԥ�Ƶ���ʱ��
     */
    private Date paymentTime;

    /**
     * ��Ͷ����˵��
     */
    private String leadIntroduce;

    private static final long serialVersionUID = 1L;

    public Long getLeadId() {
        return leadId;
    }

    public void setLeadId(Long leadId) {
        this.leadId = leadId;
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

    public BigDecimal getLeadAmount() {
        return leadAmount;
    }

    public void setLeadAmount(BigDecimal leadAmount) {
        this.leadAmount = leadAmount;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getLeadIntroduce() {
        return leadIntroduce;
    }

    public void setLeadIntroduce(String leadIntroduce) {
        this.leadIntroduce = leadIntroduce == null ? null : leadIntroduce.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", leadId=").append(leadId);
        sb.append(", proId=").append(proId);
        sb.append(", investorId=").append(investorId);
        sb.append(", financierId=").append(financierId);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", checkUserName=").append(checkUserName);
        sb.append(", leadAmount=").append(leadAmount);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", leadIntroduce=").append(leadIntroduce);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}