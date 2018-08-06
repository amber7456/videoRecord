package com.videorecord.mybatis.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideoInfoExample() {
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

        public Criteria andVideo_nameIsNull() {
            addCriterion("video_name is null");
            return (Criteria) this;
        }

        public Criteria andVideo_nameIsNotNull() {
            addCriterion("video_name is not null");
            return (Criteria) this;
        }

        public Criteria andVideo_nameEqualTo(String value) {
            addCriterion("video_name =", value, "video_name");
            return (Criteria) this;
        }

        public Criteria andVideo_nameNotEqualTo(String value) {
            addCriterion("video_name <>", value, "video_name");
            return (Criteria) this;
        }

        public Criteria andVideo_nameGreaterThan(String value) {
            addCriterion("video_name >", value, "video_name");
            return (Criteria) this;
        }

        public Criteria andVideo_nameGreaterThanOrEqualTo(String value) {
            addCriterion("video_name >=", value, "video_name");
            return (Criteria) this;
        }

        public Criteria andVideo_nameLessThan(String value) {
            addCriterion("video_name <", value, "video_name");
            return (Criteria) this;
        }

        public Criteria andVideo_nameLessThanOrEqualTo(String value) {
            addCriterion("video_name <=", value, "video_name");
            return (Criteria) this;
        }

        public Criteria andVideo_nameLike(String value) {
            addCriterion("video_name like", value, "video_name");
            return (Criteria) this;
        }

        public Criteria andVideo_nameNotLike(String value) {
            addCriterion("video_name not like", value, "video_name");
            return (Criteria) this;
        }

        public Criteria andVideo_nameIn(List<String> values) {
            addCriterion("video_name in", values, "video_name");
            return (Criteria) this;
        }

        public Criteria andVideo_nameNotIn(List<String> values) {
            addCriterion("video_name not in", values, "video_name");
            return (Criteria) this;
        }

        public Criteria andVideo_nameBetween(String value1, String value2) {
            addCriterion("video_name between", value1, value2, "video_name");
            return (Criteria) this;
        }

        public Criteria andVideo_nameNotBetween(String value1, String value2) {
            addCriterion("video_name not between", value1, value2, "video_name");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeIsNull() {
            addCriterion("video_episode is null");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeIsNotNull() {
            addCriterion("video_episode is not null");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeEqualTo(String value) {
            addCriterion("video_episode =", value, "video_episode");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeNotEqualTo(String value) {
            addCriterion("video_episode <>", value, "video_episode");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeGreaterThan(String value) {
            addCriterion("video_episode >", value, "video_episode");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeGreaterThanOrEqualTo(String value) {
            addCriterion("video_episode >=", value, "video_episode");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeLessThan(String value) {
            addCriterion("video_episode <", value, "video_episode");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeLessThanOrEqualTo(String value) {
            addCriterion("video_episode <=", value, "video_episode");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeLike(String value) {
            addCriterion("video_episode like", value, "video_episode");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeNotLike(String value) {
            addCriterion("video_episode not like", value, "video_episode");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeIn(List<String> values) {
            addCriterion("video_episode in", values, "video_episode");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeNotIn(List<String> values) {
            addCriterion("video_episode not in", values, "video_episode");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeBetween(String value1, String value2) {
            addCriterion("video_episode between", value1, value2, "video_episode");
            return (Criteria) this;
        }

        public Criteria andVideo_episodeNotBetween(String value1, String value2) {
            addCriterion("video_episode not between", value1, value2, "video_episode");
            return (Criteria) this;
        }

        public Criteria andVideo_broadcast_timeIsNull() {
            addCriterion("video_broadcast_time is null");
            return (Criteria) this;
        }

        public Criteria andVideo_broadcast_timeIsNotNull() {
            addCriterion("video_broadcast_time is not null");
            return (Criteria) this;
        }

        public Criteria andVideo_broadcast_timeEqualTo(Date value) {
            addCriterion("video_broadcast_time =", value, "video_broadcast_time");
            return (Criteria) this;
        }

        public Criteria andVideo_broadcast_timeNotEqualTo(Date value) {
            addCriterion("video_broadcast_time <>", value, "video_broadcast_time");
            return (Criteria) this;
        }

        public Criteria andVideo_broadcast_timeGreaterThan(Date value) {
            addCriterion("video_broadcast_time >", value, "video_broadcast_time");
            return (Criteria) this;
        }

        public Criteria andVideo_broadcast_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("video_broadcast_time >=", value, "video_broadcast_time");
            return (Criteria) this;
        }

        public Criteria andVideo_broadcast_timeLessThan(Date value) {
            addCriterion("video_broadcast_time <", value, "video_broadcast_time");
            return (Criteria) this;
        }

        public Criteria andVideo_broadcast_timeLessThanOrEqualTo(Date value) {
            addCriterion("video_broadcast_time <=", value, "video_broadcast_time");
            return (Criteria) this;
        }

        public Criteria andVideo_broadcast_timeIn(List<Date> values) {
            addCriterion("video_broadcast_time in", values, "video_broadcast_time");
            return (Criteria) this;
        }

        public Criteria andVideo_broadcast_timeNotIn(List<Date> values) {
            addCriterion("video_broadcast_time not in", values, "video_broadcast_time");
            return (Criteria) this;
        }

        public Criteria andVideo_broadcast_timeBetween(Date value1, Date value2) {
            addCriterion("video_broadcast_time between", value1, value2, "video_broadcast_time");
            return (Criteria) this;
        }

        public Criteria andVideo_broadcast_timeNotBetween(Date value1, Date value2) {
            addCriterion("video_broadcast_time not between", value1, value2, "video_broadcast_time");
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

        public Criteria andVideo_seasonIsNull() {
            addCriterion("video_season is null");
            return (Criteria) this;
        }

        public Criteria andVideo_seasonIsNotNull() {
            addCriterion("video_season is not null");
            return (Criteria) this;
        }

        public Criteria andVideo_seasonEqualTo(String value) {
            addCriterion("video_season =", value, "video_season");
            return (Criteria) this;
        }

        public Criteria andVideo_seasonNotEqualTo(String value) {
            addCriterion("video_season <>", value, "video_season");
            return (Criteria) this;
        }

        public Criteria andVideo_seasonGreaterThan(String value) {
            addCriterion("video_season >", value, "video_season");
            return (Criteria) this;
        }

        public Criteria andVideo_seasonGreaterThanOrEqualTo(String value) {
            addCriterion("video_season >=", value, "video_season");
            return (Criteria) this;
        }

        public Criteria andVideo_seasonLessThan(String value) {
            addCriterion("video_season <", value, "video_season");
            return (Criteria) this;
        }

        public Criteria andVideo_seasonLessThanOrEqualTo(String value) {
            addCriterion("video_season <=", value, "video_season");
            return (Criteria) this;
        }

        public Criteria andVideo_seasonLike(String value) {
            addCriterion("video_season like", value, "video_season");
            return (Criteria) this;
        }

        public Criteria andVideo_seasonNotLike(String value) {
            addCriterion("video_season not like", value, "video_season");
            return (Criteria) this;
        }

        public Criteria andVideo_seasonIn(List<String> values) {
            addCriterion("video_season in", values, "video_season");
            return (Criteria) this;
        }

        public Criteria andVideo_seasonNotIn(List<String> values) {
            addCriterion("video_season not in", values, "video_season");
            return (Criteria) this;
        }

        public Criteria andVideo_seasonBetween(String value1, String value2) {
            addCriterion("video_season between", value1, value2, "video_season");
            return (Criteria) this;
        }

        public Criteria andVideo_seasonNotBetween(String value1, String value2) {
            addCriterion("video_season not between", value1, value2, "video_season");
            return (Criteria) this;
        }

        public Criteria andVideo_countryIsNull() {
            addCriterion("video_country is null");
            return (Criteria) this;
        }

        public Criteria andVideo_countryIsNotNull() {
            addCriterion("video_country is not null");
            return (Criteria) this;
        }

        public Criteria andVideo_countryEqualTo(String value) {
            addCriterion("video_country =", value, "video_country");
            return (Criteria) this;
        }

        public Criteria andVideo_countryNotEqualTo(String value) {
            addCriterion("video_country <>", value, "video_country");
            return (Criteria) this;
        }

        public Criteria andVideo_countryGreaterThan(String value) {
            addCriterion("video_country >", value, "video_country");
            return (Criteria) this;
        }

        public Criteria andVideo_countryGreaterThanOrEqualTo(String value) {
            addCriterion("video_country >=", value, "video_country");
            return (Criteria) this;
        }

        public Criteria andVideo_countryLessThan(String value) {
            addCriterion("video_country <", value, "video_country");
            return (Criteria) this;
        }

        public Criteria andVideo_countryLessThanOrEqualTo(String value) {
            addCriterion("video_country <=", value, "video_country");
            return (Criteria) this;
        }

        public Criteria andVideo_countryLike(String value) {
            addCriterion("video_country like", value, "video_country");
            return (Criteria) this;
        }

        public Criteria andVideo_countryNotLike(String value) {
            addCriterion("video_country not like", value, "video_country");
            return (Criteria) this;
        }

        public Criteria andVideo_countryIn(List<String> values) {
            addCriterion("video_country in", values, "video_country");
            return (Criteria) this;
        }

        public Criteria andVideo_countryNotIn(List<String> values) {
            addCriterion("video_country not in", values, "video_country");
            return (Criteria) this;
        }

        public Criteria andVideo_countryBetween(String value1, String value2) {
            addCriterion("video_country between", value1, value2, "video_country");
            return (Criteria) this;
        }

        public Criteria andVideo_countryNotBetween(String value1, String value2) {
            addCriterion("video_country not between", value1, value2, "video_country");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceIsNull() {
            addCriterion("video_source is null");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceIsNotNull() {
            addCriterion("video_source is not null");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceEqualTo(String value) {
            addCriterion("video_source =", value, "video_source");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceNotEqualTo(String value) {
            addCriterion("video_source <>", value, "video_source");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceGreaterThan(String value) {
            addCriterion("video_source >", value, "video_source");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceGreaterThanOrEqualTo(String value) {
            addCriterion("video_source >=", value, "video_source");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceLessThan(String value) {
            addCriterion("video_source <", value, "video_source");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceLessThanOrEqualTo(String value) {
            addCriterion("video_source <=", value, "video_source");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceLike(String value) {
            addCriterion("video_source like", value, "video_source");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceNotLike(String value) {
            addCriterion("video_source not like", value, "video_source");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceIn(List<String> values) {
            addCriterion("video_source in", values, "video_source");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceNotIn(List<String> values) {
            addCriterion("video_source not in", values, "video_source");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceBetween(String value1, String value2) {
            addCriterion("video_source between", value1, value2, "video_source");
            return (Criteria) this;
        }

        public Criteria andVideo_sourceNotBetween(String value1, String value2) {
            addCriterion("video_source not between", value1, value2, "video_source");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkIsNull() {
            addCriterion("video_remark is null");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkIsNotNull() {
            addCriterion("video_remark is not null");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkEqualTo(String value) {
            addCriterion("video_remark =", value, "video_remark");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkNotEqualTo(String value) {
            addCriterion("video_remark <>", value, "video_remark");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkGreaterThan(String value) {
            addCriterion("video_remark >", value, "video_remark");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkGreaterThanOrEqualTo(String value) {
            addCriterion("video_remark >=", value, "video_remark");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkLessThan(String value) {
            addCriterion("video_remark <", value, "video_remark");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkLessThanOrEqualTo(String value) {
            addCriterion("video_remark <=", value, "video_remark");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkLike(String value) {
            addCriterion("video_remark like", value, "video_remark");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkNotLike(String value) {
            addCriterion("video_remark not like", value, "video_remark");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkIn(List<String> values) {
            addCriterion("video_remark in", values, "video_remark");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkNotIn(List<String> values) {
            addCriterion("video_remark not in", values, "video_remark");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkBetween(String value1, String value2) {
            addCriterion("video_remark between", value1, value2, "video_remark");
            return (Criteria) this;
        }

        public Criteria andVideo_remarkNotBetween(String value1, String value2) {
            addCriterion("video_remark not between", value1, value2, "video_remark");
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

        public Criteria andLast_update_timeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLast_update_timeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLast_update_timeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLast_update_timeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLast_update_timeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLast_update_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLast_update_timeLessThan(Date value) {
            addCriterion("last_update_time <", value, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLast_update_timeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLast_update_timeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLast_update_timeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLast_update_timeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andLast_update_timeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "last_update_time");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceIsNull() {
            addCriterion("have_bd_resource is null");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceIsNotNull() {
            addCriterion("have_bd_resource is not null");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceEqualTo(String value) {
            addCriterion("have_bd_resource =", value, "have_bd_resource");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceNotEqualTo(String value) {
            addCriterion("have_bd_resource <>", value, "have_bd_resource");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceGreaterThan(String value) {
            addCriterion("have_bd_resource >", value, "have_bd_resource");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceGreaterThanOrEqualTo(String value) {
            addCriterion("have_bd_resource >=", value, "have_bd_resource");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceLessThan(String value) {
            addCriterion("have_bd_resource <", value, "have_bd_resource");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceLessThanOrEqualTo(String value) {
            addCriterion("have_bd_resource <=", value, "have_bd_resource");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceLike(String value) {
            addCriterion("have_bd_resource like", value, "have_bd_resource");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceNotLike(String value) {
            addCriterion("have_bd_resource not like", value, "have_bd_resource");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceIn(List<String> values) {
            addCriterion("have_bd_resource in", values, "have_bd_resource");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceNotIn(List<String> values) {
            addCriterion("have_bd_resource not in", values, "have_bd_resource");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceBetween(String value1, String value2) {
            addCriterion("have_bd_resource between", value1, value2, "have_bd_resource");
            return (Criteria) this;
        }

        public Criteria andHave_bd_resourceNotBetween(String value1, String value2) {
            addCriterion("have_bd_resource not between", value1, value2, "have_bd_resource");
            return (Criteria) this;
        }

        public Criteria andHave_posterIsNull() {
            addCriterion("have_poster is null");
            return (Criteria) this;
        }

        public Criteria andHave_posterIsNotNull() {
            addCriterion("have_poster is not null");
            return (Criteria) this;
        }

        public Criteria andHave_posterEqualTo(String value) {
            addCriterion("have_poster =", value, "have_poster");
            return (Criteria) this;
        }

        public Criteria andHave_posterNotEqualTo(String value) {
            addCriterion("have_poster <>", value, "have_poster");
            return (Criteria) this;
        }

        public Criteria andHave_posterGreaterThan(String value) {
            addCriterion("have_poster >", value, "have_poster");
            return (Criteria) this;
        }

        public Criteria andHave_posterGreaterThanOrEqualTo(String value) {
            addCriterion("have_poster >=", value, "have_poster");
            return (Criteria) this;
        }

        public Criteria andHave_posterLessThan(String value) {
            addCriterion("have_poster <", value, "have_poster");
            return (Criteria) this;
        }

        public Criteria andHave_posterLessThanOrEqualTo(String value) {
            addCriterion("have_poster <=", value, "have_poster");
            return (Criteria) this;
        }

        public Criteria andHave_posterLike(String value) {
            addCriterion("have_poster like", value, "have_poster");
            return (Criteria) this;
        }

        public Criteria andHave_posterNotLike(String value) {
            addCriterion("have_poster not like", value, "have_poster");
            return (Criteria) this;
        }

        public Criteria andHave_posterIn(List<String> values) {
            addCriterion("have_poster in", values, "have_poster");
            return (Criteria) this;
        }

        public Criteria andHave_posterNotIn(List<String> values) {
            addCriterion("have_poster not in", values, "have_poster");
            return (Criteria) this;
        }

        public Criteria andHave_posterBetween(String value1, String value2) {
            addCriterion("have_poster between", value1, value2, "have_poster");
            return (Criteria) this;
        }

        public Criteria andHave_posterNotBetween(String value1, String value2) {
            addCriterion("have_poster not between", value1, value2, "have_poster");
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