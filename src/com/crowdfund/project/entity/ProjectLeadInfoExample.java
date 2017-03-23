package com.crowdfund.project.entity;

import com.crowdfund.common.page.Page;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectLeadInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    protected Integer limitStart;

    protected Integer limitEnd;

    protected String fields;

    public ProjectLeadInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLeadIdIsNull() {
            addCriterion("LEAD_ID is null");
            return (Criteria) this;
        }

        public Criteria andLeadIdIsNotNull() {
            addCriterion("LEAD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLeadIdEqualTo(Long value) {
            addCriterion("LEAD_ID =", value, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdNotEqualTo(Long value) {
            addCriterion("LEAD_ID <>", value, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdGreaterThan(Long value) {
            addCriterion("LEAD_ID >", value, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LEAD_ID >=", value, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdLessThan(Long value) {
            addCriterion("LEAD_ID <", value, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdLessThanOrEqualTo(Long value) {
            addCriterion("LEAD_ID <=", value, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdIn(List<Long> values) {
            addCriterion("LEAD_ID in", values, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdNotIn(List<Long> values) {
            addCriterion("LEAD_ID not in", values, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdBetween(Long value1, Long value2) {
            addCriterion("LEAD_ID between", value1, value2, "leadId");
            return (Criteria) this;
        }

        public Criteria andLeadIdNotBetween(Long value1, Long value2) {
            addCriterion("LEAD_ID not between", value1, value2, "leadId");
            return (Criteria) this;
        }

        public Criteria andProIdIsNull() {
            addCriterion("PRO_ID is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("PRO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(Long value) {
            addCriterion("PRO_ID =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(Long value) {
            addCriterion("PRO_ID <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(Long value) {
            addCriterion("PRO_ID >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PRO_ID >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(Long value) {
            addCriterion("PRO_ID <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(Long value) {
            addCriterion("PRO_ID <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<Long> values) {
            addCriterion("PRO_ID in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<Long> values) {
            addCriterion("PRO_ID not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(Long value1, Long value2) {
            addCriterion("PRO_ID between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(Long value1, Long value2) {
            addCriterion("PRO_ID not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdIsNull() {
            addCriterion("INVESTOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andInvestorIdIsNotNull() {
            addCriterion("INVESTOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInvestorIdEqualTo(Long value) {
            addCriterion("INVESTOR_ID =", value, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdNotEqualTo(Long value) {
            addCriterion("INVESTOR_ID <>", value, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdGreaterThan(Long value) {
            addCriterion("INVESTOR_ID >", value, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("INVESTOR_ID >=", value, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdLessThan(Long value) {
            addCriterion("INVESTOR_ID <", value, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdLessThanOrEqualTo(Long value) {
            addCriterion("INVESTOR_ID <=", value, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdIn(List<Long> values) {
            addCriterion("INVESTOR_ID in", values, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdNotIn(List<Long> values) {
            addCriterion("INVESTOR_ID not in", values, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdBetween(Long value1, Long value2) {
            addCriterion("INVESTOR_ID between", value1, value2, "investorId");
            return (Criteria) this;
        }

        public Criteria andInvestorIdNotBetween(Long value1, Long value2) {
            addCriterion("INVESTOR_ID not between", value1, value2, "investorId");
            return (Criteria) this;
        }

        public Criteria andFinancierIdIsNull() {
            addCriterion("FINANCIER_ID is null");
            return (Criteria) this;
        }

        public Criteria andFinancierIdIsNotNull() {
            addCriterion("FINANCIER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFinancierIdEqualTo(Long value) {
            addCriterion("FINANCIER_ID =", value, "financierId");
            return (Criteria) this;
        }

        public Criteria andFinancierIdNotEqualTo(Long value) {
            addCriterion("FINANCIER_ID <>", value, "financierId");
            return (Criteria) this;
        }

        public Criteria andFinancierIdGreaterThan(Long value) {
            addCriterion("FINANCIER_ID >", value, "financierId");
            return (Criteria) this;
        }

        public Criteria andFinancierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FINANCIER_ID >=", value, "financierId");
            return (Criteria) this;
        }

        public Criteria andFinancierIdLessThan(Long value) {
            addCriterion("FINANCIER_ID <", value, "financierId");
            return (Criteria) this;
        }

        public Criteria andFinancierIdLessThanOrEqualTo(Long value) {
            addCriterion("FINANCIER_ID <=", value, "financierId");
            return (Criteria) this;
        }

        public Criteria andFinancierIdIn(List<Long> values) {
            addCriterion("FINANCIER_ID in", values, "financierId");
            return (Criteria) this;
        }

        public Criteria andFinancierIdNotIn(List<Long> values) {
            addCriterion("FINANCIER_ID not in", values, "financierId");
            return (Criteria) this;
        }

        public Criteria andFinancierIdBetween(Long value1, Long value2) {
            addCriterion("FINANCIER_ID between", value1, value2, "financierId");
            return (Criteria) this;
        }

        public Criteria andFinancierIdNotBetween(Long value1, Long value2) {
            addCriterion("FINANCIER_ID not between", value1, value2, "financierId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("CHECK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("CHECK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Date value) {
            addCriterion("CHECK_TIME =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Date value) {
            addCriterion("CHECK_TIME <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Date value) {
            addCriterion("CHECK_TIME >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_TIME >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Date value) {
            addCriterion("CHECK_TIME <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_TIME <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Date> values) {
            addCriterion("CHECK_TIME in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Date> values) {
            addCriterion("CHECK_TIME not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Date value1, Date value2) {
            addCriterion("CHECK_TIME between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_TIME not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameIsNull() {
            addCriterion("CHECK_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameIsNotNull() {
            addCriterion("CHECK_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameEqualTo(String value) {
            addCriterion("CHECK_USER_NAME =", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameNotEqualTo(String value) {
            addCriterion("CHECK_USER_NAME <>", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameGreaterThan(String value) {
            addCriterion("CHECK_USER_NAME >", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_USER_NAME >=", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameLessThan(String value) {
            addCriterion("CHECK_USER_NAME <", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameLessThanOrEqualTo(String value) {
            addCriterion("CHECK_USER_NAME <=", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameLike(String value) {
            addCriterion("CHECK_USER_NAME like", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameNotLike(String value) {
            addCriterion("CHECK_USER_NAME not like", value, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameIn(List<String> values) {
            addCriterion("CHECK_USER_NAME in", values, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameNotIn(List<String> values) {
            addCriterion("CHECK_USER_NAME not in", values, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameBetween(String value1, String value2) {
            addCriterion("CHECK_USER_NAME between", value1, value2, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andCheckUserNameNotBetween(String value1, String value2) {
            addCriterion("CHECK_USER_NAME not between", value1, value2, "checkUserName");
            return (Criteria) this;
        }

        public Criteria andLeadAmountIsNull() {
            addCriterion("LEAD_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andLeadAmountIsNotNull() {
            addCriterion("LEAD_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLeadAmountEqualTo(BigDecimal value) {
            addCriterion("LEAD_AMOUNT =", value, "leadAmount");
            return (Criteria) this;
        }

        public Criteria andLeadAmountNotEqualTo(BigDecimal value) {
            addCriterion("LEAD_AMOUNT <>", value, "leadAmount");
            return (Criteria) this;
        }

        public Criteria andLeadAmountGreaterThan(BigDecimal value) {
            addCriterion("LEAD_AMOUNT >", value, "leadAmount");
            return (Criteria) this;
        }

        public Criteria andLeadAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LEAD_AMOUNT >=", value, "leadAmount");
            return (Criteria) this;
        }

        public Criteria andLeadAmountLessThan(BigDecimal value) {
            addCriterion("LEAD_AMOUNT <", value, "leadAmount");
            return (Criteria) this;
        }

        public Criteria andLeadAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LEAD_AMOUNT <=", value, "leadAmount");
            return (Criteria) this;
        }

        public Criteria andLeadAmountIn(List<BigDecimal> values) {
            addCriterion("LEAD_AMOUNT in", values, "leadAmount");
            return (Criteria) this;
        }

        public Criteria andLeadAmountNotIn(List<BigDecimal> values) {
            addCriterion("LEAD_AMOUNT not in", values, "leadAmount");
            return (Criteria) this;
        }

        public Criteria andLeadAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LEAD_AMOUNT between", value1, value2, "leadAmount");
            return (Criteria) this;
        }

        public Criteria andLeadAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LEAD_AMOUNT not between", value1, value2, "leadAmount");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNull() {
            addCriterion("PAYMENT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNotNull() {
            addCriterion("PAYMENT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeEqualTo(Date value) {
            addCriterion("PAYMENT_TIME =", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotEqualTo(Date value) {
            addCriterion("PAYMENT_TIME <>", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThan(Date value) {
            addCriterion("PAYMENT_TIME >", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PAYMENT_TIME >=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThan(Date value) {
            addCriterion("PAYMENT_TIME <", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThanOrEqualTo(Date value) {
            addCriterion("PAYMENT_TIME <=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIn(List<Date> values) {
            addCriterion("PAYMENT_TIME in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotIn(List<Date> values) {
            addCriterion("PAYMENT_TIME not in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeBetween(Date value1, Date value2) {
            addCriterion("PAYMENT_TIME between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotBetween(Date value1, Date value2) {
            addCriterion("PAYMENT_TIME not between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceIsNull() {
            addCriterion("LEAD_INTRODUCE is null");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceIsNotNull() {
            addCriterion("LEAD_INTRODUCE is not null");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceEqualTo(String value) {
            addCriterion("LEAD_INTRODUCE =", value, "leadIntroduce");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceNotEqualTo(String value) {
            addCriterion("LEAD_INTRODUCE <>", value, "leadIntroduce");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceGreaterThan(String value) {
            addCriterion("LEAD_INTRODUCE >", value, "leadIntroduce");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("LEAD_INTRODUCE >=", value, "leadIntroduce");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceLessThan(String value) {
            addCriterion("LEAD_INTRODUCE <", value, "leadIntroduce");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceLessThanOrEqualTo(String value) {
            addCriterion("LEAD_INTRODUCE <=", value, "leadIntroduce");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceLike(String value) {
            addCriterion("LEAD_INTRODUCE like", value, "leadIntroduce");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceNotLike(String value) {
            addCriterion("LEAD_INTRODUCE not like", value, "leadIntroduce");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceIn(List<String> values) {
            addCriterion("LEAD_INTRODUCE in", values, "leadIntroduce");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceNotIn(List<String> values) {
            addCriterion("LEAD_INTRODUCE not in", values, "leadIntroduce");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceBetween(String value1, String value2) {
            addCriterion("LEAD_INTRODUCE between", value1, value2, "leadIntroduce");
            return (Criteria) this;
        }

        public Criteria andLeadIntroduceNotBetween(String value1, String value2) {
            addCriterion("LEAD_INTRODUCE not between", value1, value2, "leadIntroduce");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}