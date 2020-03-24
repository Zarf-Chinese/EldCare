package com.eldcare.model;

import java.util.ArrayList;
import java.util.List;

public class FeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeedbackExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andElderIsNull() {
            addCriterion("ELDER is null");
            return (Criteria) this;
        }

        public Criteria andElderIsNotNull() {
            addCriterion("ELDER is not null");
            return (Criteria) this;
        }

        public Criteria andElderEqualTo(Integer value) {
            addCriterion("ELDER =", value, "elder");
            return (Criteria) this;
        }

        public Criteria andElderNotEqualTo(Integer value) {
            addCriterion("ELDER <>", value, "elder");
            return (Criteria) this;
        }

        public Criteria andElderGreaterThan(Integer value) {
            addCriterion("ELDER >", value, "elder");
            return (Criteria) this;
        }

        public Criteria andElderGreaterThanOrEqualTo(Integer value) {
            addCriterion("ELDER >=", value, "elder");
            return (Criteria) this;
        }

        public Criteria andElderLessThan(Integer value) {
            addCriterion("ELDER <", value, "elder");
            return (Criteria) this;
        }

        public Criteria andElderLessThanOrEqualTo(Integer value) {
            addCriterion("ELDER <=", value, "elder");
            return (Criteria) this;
        }

        public Criteria andElderIn(List<Integer> values) {
            addCriterion("ELDER in", values, "elder");
            return (Criteria) this;
        }

        public Criteria andElderNotIn(List<Integer> values) {
            addCriterion("ELDER not in", values, "elder");
            return (Criteria) this;
        }

        public Criteria andElderBetween(Integer value1, Integer value2) {
            addCriterion("ELDER between", value1, value2, "elder");
            return (Criteria) this;
        }

        public Criteria andElderNotBetween(Integer value1, Integer value2) {
            addCriterion("ELDER not between", value1, value2, "elder");
            return (Criteria) this;
        }

        public Criteria andNurseIsNull() {
            addCriterion("NURSE is null");
            return (Criteria) this;
        }

        public Criteria andNurseIsNotNull() {
            addCriterion("NURSE is not null");
            return (Criteria) this;
        }

        public Criteria andNurseEqualTo(Integer value) {
            addCriterion("NURSE =", value, "nurse");
            return (Criteria) this;
        }

        public Criteria andNurseNotEqualTo(Integer value) {
            addCriterion("NURSE <>", value, "nurse");
            return (Criteria) this;
        }

        public Criteria andNurseGreaterThan(Integer value) {
            addCriterion("NURSE >", value, "nurse");
            return (Criteria) this;
        }

        public Criteria andNurseGreaterThanOrEqualTo(Integer value) {
            addCriterion("NURSE >=", value, "nurse");
            return (Criteria) this;
        }

        public Criteria andNurseLessThan(Integer value) {
            addCriterion("NURSE <", value, "nurse");
            return (Criteria) this;
        }

        public Criteria andNurseLessThanOrEqualTo(Integer value) {
            addCriterion("NURSE <=", value, "nurse");
            return (Criteria) this;
        }

        public Criteria andNurseIn(List<Integer> values) {
            addCriterion("NURSE in", values, "nurse");
            return (Criteria) this;
        }

        public Criteria andNurseNotIn(List<Integer> values) {
            addCriterion("NURSE not in", values, "nurse");
            return (Criteria) this;
        }

        public Criteria andNurseBetween(Integer value1, Integer value2) {
            addCriterion("NURSE between", value1, value2, "nurse");
            return (Criteria) this;
        }

        public Criteria andNurseNotBetween(Integer value1, Integer value2) {
            addCriterion("NURSE not between", value1, value2, "nurse");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("SCORE is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("SCORE =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("SCORE <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("SCORE >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCORE >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("SCORE <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("SCORE <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("SCORE in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("SCORE not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("SCORE between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("SCORE not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("GMT_CREATE is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("GMT_CREATE is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Long value) {
            addCriterion("GMT_CREATE =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Long value) {
            addCriterion("GMT_CREATE <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Long value) {
            addCriterion("GMT_CREATE >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Long value) {
            addCriterion("GMT_CREATE >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Long value) {
            addCriterion("GMT_CREATE <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Long value) {
            addCriterion("GMT_CREATE <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Long> values) {
            addCriterion("GMT_CREATE in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Long> values) {
            addCriterion("GMT_CREATE not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Long value1, Long value2) {
            addCriterion("GMT_CREATE between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Long value1, Long value2) {
            addCriterion("GMT_CREATE not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andIsAnonIsNull() {
            addCriterion("IS_ANON is null");
            return (Criteria) this;
        }

        public Criteria andIsAnonIsNotNull() {
            addCriterion("IS_ANON is not null");
            return (Criteria) this;
        }

        public Criteria andIsAnonEqualTo(Boolean value) {
            addCriterion("IS_ANON =", value, "isAnon");
            return (Criteria) this;
        }

        public Criteria andIsAnonNotEqualTo(Boolean value) {
            addCriterion("IS_ANON <>", value, "isAnon");
            return (Criteria) this;
        }

        public Criteria andIsAnonGreaterThan(Boolean value) {
            addCriterion("IS_ANON >", value, "isAnon");
            return (Criteria) this;
        }

        public Criteria andIsAnonGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_ANON >=", value, "isAnon");
            return (Criteria) this;
        }

        public Criteria andIsAnonLessThan(Boolean value) {
            addCriterion("IS_ANON <", value, "isAnon");
            return (Criteria) this;
        }

        public Criteria andIsAnonLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_ANON <=", value, "isAnon");
            return (Criteria) this;
        }

        public Criteria andIsAnonIn(List<Boolean> values) {
            addCriterion("IS_ANON in", values, "isAnon");
            return (Criteria) this;
        }

        public Criteria andIsAnonNotIn(List<Boolean> values) {
            addCriterion("IS_ANON not in", values, "isAnon");
            return (Criteria) this;
        }

        public Criteria andIsAnonBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_ANON between", value1, value2, "isAnon");
            return (Criteria) this;
        }

        public Criteria andIsAnonNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_ANON not between", value1, value2, "isAnon");
            return (Criteria) this;
        }

        public Criteria andIsCheckedIsNull() {
            addCriterion("IS_CHECKED is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckedIsNotNull() {
            addCriterion("IS_CHECKED is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckedEqualTo(Boolean value) {
            addCriterion("IS_CHECKED =", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedNotEqualTo(Boolean value) {
            addCriterion("IS_CHECKED <>", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedGreaterThan(Boolean value) {
            addCriterion("IS_CHECKED >", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_CHECKED >=", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedLessThan(Boolean value) {
            addCriterion("IS_CHECKED <", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_CHECKED <=", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedIn(List<Boolean> values) {
            addCriterion("IS_CHECKED in", values, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedNotIn(List<Boolean> values) {
            addCriterion("IS_CHECKED not in", values, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_CHECKED between", value1, value2, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_CHECKED not between", value1, value2, "isChecked");
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

        public Criteria andCheckTimeEqualTo(Long value) {
            addCriterion("CHECK_TIME =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Long value) {
            addCriterion("CHECK_TIME <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Long value) {
            addCriterion("CHECK_TIME >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("CHECK_TIME >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Long value) {
            addCriterion("CHECK_TIME <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Long value) {
            addCriterion("CHECK_TIME <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Long> values) {
            addCriterion("CHECK_TIME in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Long> values) {
            addCriterion("CHECK_TIME not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Long value1, Long value2) {
            addCriterion("CHECK_TIME between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Long value1, Long value2) {
            addCriterion("CHECK_TIME not between", value1, value2, "checkTime");
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