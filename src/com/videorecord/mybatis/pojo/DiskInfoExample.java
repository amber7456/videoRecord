package com.videorecord.mybatis.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiskInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DiskInfoExample() {
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

        public Criteria andDisk_idIsNull() {
            addCriterion("disk_id is null");
            return (Criteria) this;
        }

        public Criteria andDisk_idIsNotNull() {
            addCriterion("disk_id is not null");
            return (Criteria) this;
        }

        public Criteria andDisk_idEqualTo(String value) {
            addCriterion("disk_id =", value, "disk_id");
            return (Criteria) this;
        }

        public Criteria andDisk_idNotEqualTo(String value) {
            addCriterion("disk_id <>", value, "disk_id");
            return (Criteria) this;
        }

        public Criteria andDisk_idGreaterThan(String value) {
            addCriterion("disk_id >", value, "disk_id");
            return (Criteria) this;
        }

        public Criteria andDisk_idGreaterThanOrEqualTo(String value) {
            addCriterion("disk_id >=", value, "disk_id");
            return (Criteria) this;
        }

        public Criteria andDisk_idLessThan(String value) {
            addCriterion("disk_id <", value, "disk_id");
            return (Criteria) this;
        }

        public Criteria andDisk_idLessThanOrEqualTo(String value) {
            addCriterion("disk_id <=", value, "disk_id");
            return (Criteria) this;
        }

        public Criteria andDisk_idLike(String value) {
            addCriterion("disk_id like", value, "disk_id");
            return (Criteria) this;
        }

        public Criteria andDisk_idNotLike(String value) {
            addCriterion("disk_id not like", value, "disk_id");
            return (Criteria) this;
        }

        public Criteria andDisk_idIn(List<String> values) {
            addCriterion("disk_id in", values, "disk_id");
            return (Criteria) this;
        }

        public Criteria andDisk_idNotIn(List<String> values) {
            addCriterion("disk_id not in", values, "disk_id");
            return (Criteria) this;
        }

        public Criteria andDisk_idBetween(String value1, String value2) {
            addCriterion("disk_id between", value1, value2, "disk_id");
            return (Criteria) this;
        }

        public Criteria andDisk_idNotBetween(String value1, String value2) {
            addCriterion("disk_id not between", value1, value2, "disk_id");
            return (Criteria) this;
        }

        public Criteria andDisk_nameIsNull() {
            addCriterion("disk_name is null");
            return (Criteria) this;
        }

        public Criteria andDisk_nameIsNotNull() {
            addCriterion("disk_name is not null");
            return (Criteria) this;
        }

        public Criteria andDisk_nameEqualTo(String value) {
            addCriterion("disk_name =", value, "disk_name");
            return (Criteria) this;
        }

        public Criteria andDisk_nameNotEqualTo(String value) {
            addCriterion("disk_name <>", value, "disk_name");
            return (Criteria) this;
        }

        public Criteria andDisk_nameGreaterThan(String value) {
            addCriterion("disk_name >", value, "disk_name");
            return (Criteria) this;
        }

        public Criteria andDisk_nameGreaterThanOrEqualTo(String value) {
            addCriterion("disk_name >=", value, "disk_name");
            return (Criteria) this;
        }

        public Criteria andDisk_nameLessThan(String value) {
            addCriterion("disk_name <", value, "disk_name");
            return (Criteria) this;
        }

        public Criteria andDisk_nameLessThanOrEqualTo(String value) {
            addCriterion("disk_name <=", value, "disk_name");
            return (Criteria) this;
        }

        public Criteria andDisk_nameLike(String value) {
            addCriterion("disk_name like", value, "disk_name");
            return (Criteria) this;
        }

        public Criteria andDisk_nameNotLike(String value) {
            addCriterion("disk_name not like", value, "disk_name");
            return (Criteria) this;
        }

        public Criteria andDisk_nameIn(List<String> values) {
            addCriterion("disk_name in", values, "disk_name");
            return (Criteria) this;
        }

        public Criteria andDisk_nameNotIn(List<String> values) {
            addCriterion("disk_name not in", values, "disk_name");
            return (Criteria) this;
        }

        public Criteria andDisk_nameBetween(String value1, String value2) {
            addCriterion("disk_name between", value1, value2, "disk_name");
            return (Criteria) this;
        }

        public Criteria andDisk_nameNotBetween(String value1, String value2) {
            addCriterion("disk_name not between", value1, value2, "disk_name");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityIsNull() {
            addCriterion("disk_capacity is null");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityIsNotNull() {
            addCriterion("disk_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityEqualTo(String value) {
            addCriterion("disk_capacity =", value, "disk_capacity");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityNotEqualTo(String value) {
            addCriterion("disk_capacity <>", value, "disk_capacity");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityGreaterThan(String value) {
            addCriterion("disk_capacity >", value, "disk_capacity");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityGreaterThanOrEqualTo(String value) {
            addCriterion("disk_capacity >=", value, "disk_capacity");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityLessThan(String value) {
            addCriterion("disk_capacity <", value, "disk_capacity");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityLessThanOrEqualTo(String value) {
            addCriterion("disk_capacity <=", value, "disk_capacity");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityLike(String value) {
            addCriterion("disk_capacity like", value, "disk_capacity");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityNotLike(String value) {
            addCriterion("disk_capacity not like", value, "disk_capacity");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityIn(List<String> values) {
            addCriterion("disk_capacity in", values, "disk_capacity");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityNotIn(List<String> values) {
            addCriterion("disk_capacity not in", values, "disk_capacity");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityBetween(String value1, String value2) {
            addCriterion("disk_capacity between", value1, value2, "disk_capacity");
            return (Criteria) this;
        }

        public Criteria andDisk_capacityNotBetween(String value1, String value2) {
            addCriterion("disk_capacity not between", value1, value2, "disk_capacity");
            return (Criteria) this;
        }

        public Criteria andDisk_stateIsNull() {
            addCriterion("disk_state is null");
            return (Criteria) this;
        }

        public Criteria andDisk_stateIsNotNull() {
            addCriterion("disk_state is not null");
            return (Criteria) this;
        }

        public Criteria andDisk_stateEqualTo(String value) {
            addCriterion("disk_state =", value, "disk_state");
            return (Criteria) this;
        }

        public Criteria andDisk_stateNotEqualTo(String value) {
            addCriterion("disk_state <>", value, "disk_state");
            return (Criteria) this;
        }

        public Criteria andDisk_stateGreaterThan(String value) {
            addCriterion("disk_state >", value, "disk_state");
            return (Criteria) this;
        }

        public Criteria andDisk_stateGreaterThanOrEqualTo(String value) {
            addCriterion("disk_state >=", value, "disk_state");
            return (Criteria) this;
        }

        public Criteria andDisk_stateLessThan(String value) {
            addCriterion("disk_state <", value, "disk_state");
            return (Criteria) this;
        }

        public Criteria andDisk_stateLessThanOrEqualTo(String value) {
            addCriterion("disk_state <=", value, "disk_state");
            return (Criteria) this;
        }

        public Criteria andDisk_stateLike(String value) {
            addCriterion("disk_state like", value, "disk_state");
            return (Criteria) this;
        }

        public Criteria andDisk_stateNotLike(String value) {
            addCriterion("disk_state not like", value, "disk_state");
            return (Criteria) this;
        }

        public Criteria andDisk_stateIn(List<String> values) {
            addCriterion("disk_state in", values, "disk_state");
            return (Criteria) this;
        }

        public Criteria andDisk_stateNotIn(List<String> values) {
            addCriterion("disk_state not in", values, "disk_state");
            return (Criteria) this;
        }

        public Criteria andDisk_stateBetween(String value1, String value2) {
            addCriterion("disk_state between", value1, value2, "disk_state");
            return (Criteria) this;
        }

        public Criteria andDisk_stateNotBetween(String value1, String value2) {
            addCriterion("disk_state not between", value1, value2, "disk_state");
            return (Criteria) this;
        }

        public Criteria andIs_fullIsNull() {
            addCriterion("is_full is null");
            return (Criteria) this;
        }

        public Criteria andIs_fullIsNotNull() {
            addCriterion("is_full is not null");
            return (Criteria) this;
        }

        public Criteria andIs_fullEqualTo(String value) {
            addCriterion("is_full =", value, "is_full");
            return (Criteria) this;
        }

        public Criteria andIs_fullNotEqualTo(String value) {
            addCriterion("is_full <>", value, "is_full");
            return (Criteria) this;
        }

        public Criteria andIs_fullGreaterThan(String value) {
            addCriterion("is_full >", value, "is_full");
            return (Criteria) this;
        }

        public Criteria andIs_fullGreaterThanOrEqualTo(String value) {
            addCriterion("is_full >=", value, "is_full");
            return (Criteria) this;
        }

        public Criteria andIs_fullLessThan(String value) {
            addCriterion("is_full <", value, "is_full");
            return (Criteria) this;
        }

        public Criteria andIs_fullLessThanOrEqualTo(String value) {
            addCriterion("is_full <=", value, "is_full");
            return (Criteria) this;
        }

        public Criteria andIs_fullLike(String value) {
            addCriterion("is_full like", value, "is_full");
            return (Criteria) this;
        }

        public Criteria andIs_fullNotLike(String value) {
            addCriterion("is_full not like", value, "is_full");
            return (Criteria) this;
        }

        public Criteria andIs_fullIn(List<String> values) {
            addCriterion("is_full in", values, "is_full");
            return (Criteria) this;
        }

        public Criteria andIs_fullNotIn(List<String> values) {
            addCriterion("is_full not in", values, "is_full");
            return (Criteria) this;
        }

        public Criteria andIs_fullBetween(String value1, String value2) {
            addCriterion("is_full between", value1, value2, "is_full");
            return (Criteria) this;
        }

        public Criteria andIs_fullNotBetween(String value1, String value2) {
            addCriterion("is_full not between", value1, value2, "is_full");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andVideo_typeIsNull() {
            addCriterion("video_type is null");
            return (Criteria) this;
        }

        public Criteria andVideo_typeIsNotNull() {
            addCriterion("video_type is not null");
            return (Criteria) this;
        }

        public Criteria andVideo_typeEqualTo(String value) {
            addCriterion("video_type =", value, "video_type");
            return (Criteria) this;
        }

        public Criteria andVideo_typeNotEqualTo(String value) {
            addCriterion("video_type <>", value, "video_type");
            return (Criteria) this;
        }

        public Criteria andVideo_typeGreaterThan(String value) {
            addCriterion("video_type >", value, "video_type");
            return (Criteria) this;
        }

        public Criteria andVideo_typeGreaterThanOrEqualTo(String value) {
            addCriterion("video_type >=", value, "video_type");
            return (Criteria) this;
        }

        public Criteria andVideo_typeLessThan(String value) {
            addCriterion("video_type <", value, "video_type");
            return (Criteria) this;
        }

        public Criteria andVideo_typeLessThanOrEqualTo(String value) {
            addCriterion("video_type <=", value, "video_type");
            return (Criteria) this;
        }

        public Criteria andVideo_typeLike(String value) {
            addCriterion("video_type like", value, "video_type");
            return (Criteria) this;
        }

        public Criteria andVideo_typeNotLike(String value) {
            addCriterion("video_type not like", value, "video_type");
            return (Criteria) this;
        }

        public Criteria andVideo_typeIn(List<String> values) {
            addCriterion("video_type in", values, "video_type");
            return (Criteria) this;
        }

        public Criteria andVideo_typeNotIn(List<String> values) {
            addCriterion("video_type not in", values, "video_type");
            return (Criteria) this;
        }

        public Criteria andVideo_typeBetween(String value1, String value2) {
            addCriterion("video_type between", value1, value2, "video_type");
            return (Criteria) this;
        }

        public Criteria andVideo_typeNotBetween(String value1, String value2) {
            addCriterion("video_type not between", value1, value2, "video_type");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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