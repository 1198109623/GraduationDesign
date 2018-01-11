package com.hand.movie.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("order_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("order_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(Double value) {
            addCriterion("order_price =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(Double value) {
            addCriterion("order_price <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(Double value) {
            addCriterion("order_price >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("order_price >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(Double value) {
            addCriterion("order_price <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(Double value) {
            addCriterion("order_price <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<Double> values) {
            addCriterion("order_price in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<Double> values) {
            addCriterion("order_price not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(Double value1, Double value2) {
            addCriterion("order_price between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(Double value1, Double value2) {
            addCriterion("order_price not between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderContentIsNull() {
            addCriterion("order_content is null");
            return (Criteria) this;
        }

        public Criteria andOrderContentIsNotNull() {
            addCriterion("order_content is not null");
            return (Criteria) this;
        }

        public Criteria andOrderContentEqualTo(String value) {
            addCriterion("order_content =", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentNotEqualTo(String value) {
            addCriterion("order_content <>", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentGreaterThan(String value) {
            addCriterion("order_content >", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentGreaterThanOrEqualTo(String value) {
            addCriterion("order_content >=", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentLessThan(String value) {
            addCriterion("order_content <", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentLessThanOrEqualTo(String value) {
            addCriterion("order_content <=", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentLike(String value) {
            addCriterion("order_content like", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentNotLike(String value) {
            addCriterion("order_content not like", value, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentIn(List<String> values) {
            addCriterion("order_content in", values, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentNotIn(List<String> values) {
            addCriterion("order_content not in", values, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentBetween(String value1, String value2) {
            addCriterion("order_content between", value1, value2, "orderContent");
            return (Criteria) this;
        }

        public Criteria andOrderContentNotBetween(String value1, String value2) {
            addCriterion("order_content not between", value1, value2, "orderContent");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNull() {
            addCriterion("CREATION_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNotNull() {
            addCriterion("CREATION_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreationDateEqualTo(Date value) {
            addCriterion("CREATION_DATE =", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotEqualTo(Date value) {
            addCriterion("CREATION_DATE <>", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThan(Date value) {
            addCriterion("CREATION_DATE >", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATION_DATE >=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThan(Date value) {
            addCriterion("CREATION_DATE <", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATION_DATE <=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateIn(List<Date> values) {
            addCriterion("CREATION_DATE in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotIn(List<Date> values) {
            addCriterion("CREATION_DATE not in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateBetween(Date value1, Date value2) {
            addCriterion("CREATION_DATE between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATION_DATE not between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCinemaNameIsNull() {
            addCriterion("cinema_name is null");
            return (Criteria) this;
        }

        public Criteria andCinemaNameIsNotNull() {
            addCriterion("cinema_name is not null");
            return (Criteria) this;
        }

        public Criteria andCinemaNameEqualTo(String value) {
            addCriterion("cinema_name =", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameNotEqualTo(String value) {
            addCriterion("cinema_name <>", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameGreaterThan(String value) {
            addCriterion("cinema_name >", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameGreaterThanOrEqualTo(String value) {
            addCriterion("cinema_name >=", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameLessThan(String value) {
            addCriterion("cinema_name <", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameLessThanOrEqualTo(String value) {
            addCriterion("cinema_name <=", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameLike(String value) {
            addCriterion("cinema_name like", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameNotLike(String value) {
            addCriterion("cinema_name not like", value, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameIn(List<String> values) {
            addCriterion("cinema_name in", values, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameNotIn(List<String> values) {
            addCriterion("cinema_name not in", values, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameBetween(String value1, String value2) {
            addCriterion("cinema_name between", value1, value2, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andCinemaNameNotBetween(String value1, String value2) {
            addCriterion("cinema_name not between", value1, value2, "cinemaName");
            return (Criteria) this;
        }

        public Criteria andShowtimeIsNull() {
            addCriterion("showtime is null");
            return (Criteria) this;
        }

        public Criteria andShowtimeIsNotNull() {
            addCriterion("showtime is not null");
            return (Criteria) this;
        }

        public Criteria andShowtimeEqualTo(Date value) {
            addCriterion("showtime =", value, "showtime");
            return (Criteria) this;
        }

        public Criteria andShowtimeNotEqualTo(Date value) {
            addCriterion("showtime <>", value, "showtime");
            return (Criteria) this;
        }

        public Criteria andShowtimeGreaterThan(Date value) {
            addCriterion("showtime >", value, "showtime");
            return (Criteria) this;
        }

        public Criteria andShowtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("showtime >=", value, "showtime");
            return (Criteria) this;
        }

        public Criteria andShowtimeLessThan(Date value) {
            addCriterion("showtime <", value, "showtime");
            return (Criteria) this;
        }

        public Criteria andShowtimeLessThanOrEqualTo(Date value) {
            addCriterion("showtime <=", value, "showtime");
            return (Criteria) this;
        }

        public Criteria andShowtimeIn(List<Date> values) {
            addCriterion("showtime in", values, "showtime");
            return (Criteria) this;
        }

        public Criteria andShowtimeNotIn(List<Date> values) {
            addCriterion("showtime not in", values, "showtime");
            return (Criteria) this;
        }

        public Criteria andShowtimeBetween(Date value1, Date value2) {
            addCriterion("showtime between", value1, value2, "showtime");
            return (Criteria) this;
        }

        public Criteria andShowtimeNotBetween(Date value1, Date value2) {
            addCriterion("showtime not between", value1, value2, "showtime");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameIsNull() {
            addCriterion("projection_hall_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameIsNotNull() {
            addCriterion("projection_hall_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameEqualTo(String value) {
            addCriterion("projection_hall_name =", value, "projectionHallName");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameNotEqualTo(String value) {
            addCriterion("projection_hall_name <>", value, "projectionHallName");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameGreaterThan(String value) {
            addCriterion("projection_hall_name >", value, "projectionHallName");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameGreaterThanOrEqualTo(String value) {
            addCriterion("projection_hall_name >=", value, "projectionHallName");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameLessThan(String value) {
            addCriterion("projection_hall_name <", value, "projectionHallName");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameLessThanOrEqualTo(String value) {
            addCriterion("projection_hall_name <=", value, "projectionHallName");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameLike(String value) {
            addCriterion("projection_hall_name like", value, "projectionHallName");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameNotLike(String value) {
            addCriterion("projection_hall_name not like", value, "projectionHallName");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameIn(List<String> values) {
            addCriterion("projection_hall_name in", values, "projectionHallName");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameNotIn(List<String> values) {
            addCriterion("projection_hall_name not in", values, "projectionHallName");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameBetween(String value1, String value2) {
            addCriterion("projection_hall_name between", value1, value2, "projectionHallName");
            return (Criteria) this;
        }

        public Criteria andProjectionHallNameNotBetween(String value1, String value2) {
            addCriterion("projection_hall_name not between", value1, value2, "projectionHallName");
            return (Criteria) this;
        }

        public Criteria andSeatNumIsNull() {
            addCriterion("seat_num is null");
            return (Criteria) this;
        }

        public Criteria andSeatNumIsNotNull() {
            addCriterion("seat_num is not null");
            return (Criteria) this;
        }

        public Criteria andSeatNumEqualTo(String value) {
            addCriterion("seat_num =", value, "seatNum");
            return (Criteria) this;
        }

        public Criteria andSeatNumNotEqualTo(String value) {
            addCriterion("seat_num <>", value, "seatNum");
            return (Criteria) this;
        }

        public Criteria andSeatNumGreaterThan(String value) {
            addCriterion("seat_num >", value, "seatNum");
            return (Criteria) this;
        }

        public Criteria andSeatNumGreaterThanOrEqualTo(String value) {
            addCriterion("seat_num >=", value, "seatNum");
            return (Criteria) this;
        }

        public Criteria andSeatNumLessThan(String value) {
            addCriterion("seat_num <", value, "seatNum");
            return (Criteria) this;
        }

        public Criteria andSeatNumLessThanOrEqualTo(String value) {
            addCriterion("seat_num <=", value, "seatNum");
            return (Criteria) this;
        }

        public Criteria andSeatNumLike(String value) {
            addCriterion("seat_num like", value, "seatNum");
            return (Criteria) this;
        }

        public Criteria andSeatNumNotLike(String value) {
            addCriterion("seat_num not like", value, "seatNum");
            return (Criteria) this;
        }

        public Criteria andSeatNumIn(List<String> values) {
            addCriterion("seat_num in", values, "seatNum");
            return (Criteria) this;
        }

        public Criteria andSeatNumNotIn(List<String> values) {
            addCriterion("seat_num not in", values, "seatNum");
            return (Criteria) this;
        }

        public Criteria andSeatNumBetween(String value1, String value2) {
            addCriterion("seat_num between", value1, value2, "seatNum");
            return (Criteria) this;
        }

        public Criteria andSeatNumNotBetween(String value1, String value2) {
            addCriterion("seat_num not between", value1, value2, "seatNum");
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