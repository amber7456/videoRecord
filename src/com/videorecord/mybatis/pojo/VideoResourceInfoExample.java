package com.videorecord.mybatis.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoResourceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideoResourceInfoExample() {
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

        public Criteria andVideo_idIsNull() {
            addCriterion("video_id is null");
            return (Criteria) this;
        }

        public Criteria andVideo_idIsNotNull() {
            addCriterion("video_id is not null");
            return (Criteria) this;
        }

        public Criteria andVideo_idEqualTo(String value) {
            addCriterion("video_id =", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idNotEqualTo(String value) {
            addCriterion("video_id <>", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idGreaterThan(String value) {
            addCriterion("video_id >", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idGreaterThanOrEqualTo(String value) {
            addCriterion("video_id >=", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idLessThan(String value) {
            addCriterion("video_id <", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idLessThanOrEqualTo(String value) {
            addCriterion("video_id <=", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idLike(String value) {
            addCriterion("video_id like", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idNotLike(String value) {
            addCriterion("video_id not like", value, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idIn(List<String> values) {
            addCriterion("video_id in", values, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idNotIn(List<String> values) {
            addCriterion("video_id not in", values, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idBetween(String value1, String value2) {
            addCriterion("video_id between", value1, value2, "video_id");
            return (Criteria) this;
        }

        public Criteria andVideo_idNotBetween(String value1, String value2) {
            addCriterion("video_id not between", value1, value2, "video_id");
            return (Criteria) this;
        }

        public Criteria andResource_typeIsNull() {
            addCriterion("resource_type is null");
            return (Criteria) this;
        }

        public Criteria andResource_typeIsNotNull() {
            addCriterion("resource_type is not null");
            return (Criteria) this;
        }

        public Criteria andResource_typeEqualTo(String value) {
            addCriterion("resource_type =", value, "resource_type");
            return (Criteria) this;
        }

        public Criteria andResource_typeNotEqualTo(String value) {
            addCriterion("resource_type <>", value, "resource_type");
            return (Criteria) this;
        }

        public Criteria andResource_typeGreaterThan(String value) {
            addCriterion("resource_type >", value, "resource_type");
            return (Criteria) this;
        }

        public Criteria andResource_typeGreaterThanOrEqualTo(String value) {
            addCriterion("resource_type >=", value, "resource_type");
            return (Criteria) this;
        }

        public Criteria andResource_typeLessThan(String value) {
            addCriterion("resource_type <", value, "resource_type");
            return (Criteria) this;
        }

        public Criteria andResource_typeLessThanOrEqualTo(String value) {
            addCriterion("resource_type <=", value, "resource_type");
            return (Criteria) this;
        }

        public Criteria andResource_typeLike(String value) {
            addCriterion("resource_type like", value, "resource_type");
            return (Criteria) this;
        }

        public Criteria andResource_typeNotLike(String value) {
            addCriterion("resource_type not like", value, "resource_type");
            return (Criteria) this;
        }

        public Criteria andResource_typeIn(List<String> values) {
            addCriterion("resource_type in", values, "resource_type");
            return (Criteria) this;
        }

        public Criteria andResource_typeNotIn(List<String> values) {
            addCriterion("resource_type not in", values, "resource_type");
            return (Criteria) this;
        }

        public Criteria andResource_typeBetween(String value1, String value2) {
            addCriterion("resource_type between", value1, value2, "resource_type");
            return (Criteria) this;
        }

        public Criteria andResource_typeNotBetween(String value1, String value2) {
            addCriterion("resource_type not between", value1, value2, "resource_type");
            return (Criteria) this;
        }

        public Criteria andResource_formatIsNull() {
            addCriterion("resource_format is null");
            return (Criteria) this;
        }

        public Criteria andResource_formatIsNotNull() {
            addCriterion("resource_format is not null");
            return (Criteria) this;
        }

        public Criteria andResource_formatEqualTo(String value) {
            addCriterion("resource_format =", value, "resource_format");
            return (Criteria) this;
        }

        public Criteria andResource_formatNotEqualTo(String value) {
            addCriterion("resource_format <>", value, "resource_format");
            return (Criteria) this;
        }

        public Criteria andResource_formatGreaterThan(String value) {
            addCriterion("resource_format >", value, "resource_format");
            return (Criteria) this;
        }

        public Criteria andResource_formatGreaterThanOrEqualTo(String value) {
            addCriterion("resource_format >=", value, "resource_format");
            return (Criteria) this;
        }

        public Criteria andResource_formatLessThan(String value) {
            addCriterion("resource_format <", value, "resource_format");
            return (Criteria) this;
        }

        public Criteria andResource_formatLessThanOrEqualTo(String value) {
            addCriterion("resource_format <=", value, "resource_format");
            return (Criteria) this;
        }

        public Criteria andResource_formatLike(String value) {
            addCriterion("resource_format like", value, "resource_format");
            return (Criteria) this;
        }

        public Criteria andResource_formatNotLike(String value) {
            addCriterion("resource_format not like", value, "resource_format");
            return (Criteria) this;
        }

        public Criteria andResource_formatIn(List<String> values) {
            addCriterion("resource_format in", values, "resource_format");
            return (Criteria) this;
        }

        public Criteria andResource_formatNotIn(List<String> values) {
            addCriterion("resource_format not in", values, "resource_format");
            return (Criteria) this;
        }

        public Criteria andResource_formatBetween(String value1, String value2) {
            addCriterion("resource_format between", value1, value2, "resource_format");
            return (Criteria) this;
        }

        public Criteria andResource_formatNotBetween(String value1, String value2) {
            addCriterion("resource_format not between", value1, value2, "resource_format");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionIsNull() {
            addCriterion("resource_resolution is null");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionIsNotNull() {
            addCriterion("resource_resolution is not null");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionEqualTo(String value) {
            addCriterion("resource_resolution =", value, "resource_resolution");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionNotEqualTo(String value) {
            addCriterion("resource_resolution <>", value, "resource_resolution");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionGreaterThan(String value) {
            addCriterion("resource_resolution >", value, "resource_resolution");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionGreaterThanOrEqualTo(String value) {
            addCriterion("resource_resolution >=", value, "resource_resolution");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionLessThan(String value) {
            addCriterion("resource_resolution <", value, "resource_resolution");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionLessThanOrEqualTo(String value) {
            addCriterion("resource_resolution <=", value, "resource_resolution");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionLike(String value) {
            addCriterion("resource_resolution like", value, "resource_resolution");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionNotLike(String value) {
            addCriterion("resource_resolution not like", value, "resource_resolution");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionIn(List<String> values) {
            addCriterion("resource_resolution in", values, "resource_resolution");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionNotIn(List<String> values) {
            addCriterion("resource_resolution not in", values, "resource_resolution");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionBetween(String value1, String value2) {
            addCriterion("resource_resolution between", value1, value2, "resource_resolution");
            return (Criteria) this;
        }

        public Criteria andResource_resolutionNotBetween(String value1, String value2) {
            addCriterion("resource_resolution not between", value1, value2, "resource_resolution");
            return (Criteria) this;
        }

        public Criteria andResource_subIsNull() {
            addCriterion("resource_sub is null");
            return (Criteria) this;
        }

        public Criteria andResource_subIsNotNull() {
            addCriterion("resource_sub is not null");
            return (Criteria) this;
        }

        public Criteria andResource_subEqualTo(String value) {
            addCriterion("resource_sub =", value, "resource_sub");
            return (Criteria) this;
        }

        public Criteria andResource_subNotEqualTo(String value) {
            addCriterion("resource_sub <>", value, "resource_sub");
            return (Criteria) this;
        }

        public Criteria andResource_subGreaterThan(String value) {
            addCriterion("resource_sub >", value, "resource_sub");
            return (Criteria) this;
        }

        public Criteria andResource_subGreaterThanOrEqualTo(String value) {
            addCriterion("resource_sub >=", value, "resource_sub");
            return (Criteria) this;
        }

        public Criteria andResource_subLessThan(String value) {
            addCriterion("resource_sub <", value, "resource_sub");
            return (Criteria) this;
        }

        public Criteria andResource_subLessThanOrEqualTo(String value) {
            addCriterion("resource_sub <=", value, "resource_sub");
            return (Criteria) this;
        }

        public Criteria andResource_subLike(String value) {
            addCriterion("resource_sub like", value, "resource_sub");
            return (Criteria) this;
        }

        public Criteria andResource_subNotLike(String value) {
            addCriterion("resource_sub not like", value, "resource_sub");
            return (Criteria) this;
        }

        public Criteria andResource_subIn(List<String> values) {
            addCriterion("resource_sub in", values, "resource_sub");
            return (Criteria) this;
        }

        public Criteria andResource_subNotIn(List<String> values) {
            addCriterion("resource_sub not in", values, "resource_sub");
            return (Criteria) this;
        }

        public Criteria andResource_subBetween(String value1, String value2) {
            addCriterion("resource_sub between", value1, value2, "resource_sub");
            return (Criteria) this;
        }

        public Criteria andResource_subNotBetween(String value1, String value2) {
            addCriterion("resource_sub not between", value1, value2, "resource_sub");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeIsNull() {
            addCriterion("resource_sub_type is null");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeIsNotNull() {
            addCriterion("resource_sub_type is not null");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeEqualTo(String value) {
            addCriterion("resource_sub_type =", value, "resource_sub_type");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeNotEqualTo(String value) {
            addCriterion("resource_sub_type <>", value, "resource_sub_type");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeGreaterThan(String value) {
            addCriterion("resource_sub_type >", value, "resource_sub_type");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeGreaterThanOrEqualTo(String value) {
            addCriterion("resource_sub_type >=", value, "resource_sub_type");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeLessThan(String value) {
            addCriterion("resource_sub_type <", value, "resource_sub_type");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeLessThanOrEqualTo(String value) {
            addCriterion("resource_sub_type <=", value, "resource_sub_type");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeLike(String value) {
            addCriterion("resource_sub_type like", value, "resource_sub_type");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeNotLike(String value) {
            addCriterion("resource_sub_type not like", value, "resource_sub_type");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeIn(List<String> values) {
            addCriterion("resource_sub_type in", values, "resource_sub_type");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeNotIn(List<String> values) {
            addCriterion("resource_sub_type not in", values, "resource_sub_type");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeBetween(String value1, String value2) {
            addCriterion("resource_sub_type between", value1, value2, "resource_sub_type");
            return (Criteria) this;
        }

        public Criteria andResource_sub_typeNotBetween(String value1, String value2) {
            addCriterion("resource_sub_type not between", value1, value2, "resource_sub_type");
            return (Criteria) this;
        }

        public Criteria andResource_record_timeIsNull() {
            addCriterion("resource_record_time is null");
            return (Criteria) this;
        }

        public Criteria andResource_record_timeIsNotNull() {
            addCriterion("resource_record_time is not null");
            return (Criteria) this;
        }

        public Criteria andResource_record_timeEqualTo(Date value) {
            addCriterion("resource_record_time =", value, "resource_record_time");
            return (Criteria) this;
        }

        public Criteria andResource_record_timeNotEqualTo(Date value) {
            addCriterion("resource_record_time <>", value, "resource_record_time");
            return (Criteria) this;
        }

        public Criteria andResource_record_timeGreaterThan(Date value) {
            addCriterion("resource_record_time >", value, "resource_record_time");
            return (Criteria) this;
        }

        public Criteria andResource_record_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("resource_record_time >=", value, "resource_record_time");
            return (Criteria) this;
        }

        public Criteria andResource_record_timeLessThan(Date value) {
            addCriterion("resource_record_time <", value, "resource_record_time");
            return (Criteria) this;
        }

        public Criteria andResource_record_timeLessThanOrEqualTo(Date value) {
            addCriterion("resource_record_time <=", value, "resource_record_time");
            return (Criteria) this;
        }

        public Criteria andResource_record_timeIn(List<Date> values) {
            addCriterion("resource_record_time in", values, "resource_record_time");
            return (Criteria) this;
        }

        public Criteria andResource_record_timeNotIn(List<Date> values) {
            addCriterion("resource_record_time not in", values, "resource_record_time");
            return (Criteria) this;
        }

        public Criteria andResource_record_timeBetween(Date value1, Date value2) {
            addCriterion("resource_record_time between", value1, value2, "resource_record_time");
            return (Criteria) this;
        }

        public Criteria andResource_record_timeNotBetween(Date value1, Date value2) {
            addCriterion("resource_record_time not between", value1, value2, "resource_record_time");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressIsNull() {
            addCriterion("resource_record_address is null");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressIsNotNull() {
            addCriterion("resource_record_address is not null");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressEqualTo(String value) {
            addCriterion("resource_record_address =", value, "resource_record_address");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressNotEqualTo(String value) {
            addCriterion("resource_record_address <>", value, "resource_record_address");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressGreaterThan(String value) {
            addCriterion("resource_record_address >", value, "resource_record_address");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressGreaterThanOrEqualTo(String value) {
            addCriterion("resource_record_address >=", value, "resource_record_address");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressLessThan(String value) {
            addCriterion("resource_record_address <", value, "resource_record_address");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressLessThanOrEqualTo(String value) {
            addCriterion("resource_record_address <=", value, "resource_record_address");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressLike(String value) {
            addCriterion("resource_record_address like", value, "resource_record_address");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressNotLike(String value) {
            addCriterion("resource_record_address not like", value, "resource_record_address");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressIn(List<String> values) {
            addCriterion("resource_record_address in", values, "resource_record_address");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressNotIn(List<String> values) {
            addCriterion("resource_record_address not in", values, "resource_record_address");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressBetween(String value1, String value2) {
            addCriterion("resource_record_address between", value1, value2, "resource_record_address");
            return (Criteria) this;
        }

        public Criteria andResource_record_addressNotBetween(String value1, String value2) {
            addCriterion("resource_record_address not between", value1, value2, "resource_record_address");
            return (Criteria) this;
        }

        public Criteria andResource_remarkIsNull() {
            addCriterion("resource_remark is null");
            return (Criteria) this;
        }

        public Criteria andResource_remarkIsNotNull() {
            addCriterion("resource_remark is not null");
            return (Criteria) this;
        }

        public Criteria andResource_remarkEqualTo(String value) {
            addCriterion("resource_remark =", value, "resource_remark");
            return (Criteria) this;
        }

        public Criteria andResource_remarkNotEqualTo(String value) {
            addCriterion("resource_remark <>", value, "resource_remark");
            return (Criteria) this;
        }

        public Criteria andResource_remarkGreaterThan(String value) {
            addCriterion("resource_remark >", value, "resource_remark");
            return (Criteria) this;
        }

        public Criteria andResource_remarkGreaterThanOrEqualTo(String value) {
            addCriterion("resource_remark >=", value, "resource_remark");
            return (Criteria) this;
        }

        public Criteria andResource_remarkLessThan(String value) {
            addCriterion("resource_remark <", value, "resource_remark");
            return (Criteria) this;
        }

        public Criteria andResource_remarkLessThanOrEqualTo(String value) {
            addCriterion("resource_remark <=", value, "resource_remark");
            return (Criteria) this;
        }

        public Criteria andResource_remarkLike(String value) {
            addCriterion("resource_remark like", value, "resource_remark");
            return (Criteria) this;
        }

        public Criteria andResource_remarkNotLike(String value) {
            addCriterion("resource_remark not like", value, "resource_remark");
            return (Criteria) this;
        }

        public Criteria andResource_remarkIn(List<String> values) {
            addCriterion("resource_remark in", values, "resource_remark");
            return (Criteria) this;
        }

        public Criteria andResource_remarkNotIn(List<String> values) {
            addCriterion("resource_remark not in", values, "resource_remark");
            return (Criteria) this;
        }

        public Criteria andResource_remarkBetween(String value1, String value2) {
            addCriterion("resource_remark between", value1, value2, "resource_remark");
            return (Criteria) this;
        }

        public Criteria andResource_remarkNotBetween(String value1, String value2) {
            addCriterion("resource_remark not between", value1, value2, "resource_remark");
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