package com.ctof.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 资源列表的一页结果
    **/
    public class PagableResult  {
    
        private Integer number = null;
        private Boolean last = null;
        private Integer size = null;
        private Integer numberOfElements = null;
        private Integer totalPages = null;
        private Integer totalElements = null;

    
        /**
            * 当前页数
        **/
        @JsonProperty("number")
        @Valid
        public Integer getNumber() {
            return number;
        }
        public void setNumber(Integer number) {
            this.number = number;
        }
    
        /**
            * 是否第一页
        **/
        @JsonProperty("last")
        @Valid
        public Boolean getLast() {
            return last;
        }
        public void setLast(Boolean last) {
            this.last = last;
        }
    
        /**
            * 每页资源项数
        **/
        @JsonProperty("size")
        @Valid
        public Integer getSize() {
            return size;
        }
        public void setSize(Integer size) {
            this.size = size;
        }
    
        /**
            * 当前页资源项数
        **/
        @JsonProperty("numberOfElements")
        @Valid
        public Integer getNumberOfElements() {
            return numberOfElements;
        }
        public void setNumberOfElements(Integer numberOfElements) {
            this.numberOfElements = numberOfElements;
        }
    
        /**
            * 总共页数
        **/
        @JsonProperty("totalPages")
        @Valid
        public Integer getTotalPages() {
            return totalPages;
        }
        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }
    
        /**
            * 总共资源项数
        **/
        @JsonProperty("totalElements")
        @Valid
        public Integer getTotalElements() {
            return totalElements;
        }
        public void setTotalElements(Integer totalElements) {
            this.totalElements = totalElements;
        }
    

        @Override
        public String toString()  {
            StringBuilder sb = new StringBuilder();
            sb.append("class PagableResult {\n");
            
            sb.append("  number: ").append(number).append("\n");
            sb.append("  last: ").append(last).append("\n");
            sb.append("  size: ").append(size).append("\n");
            sb.append("  numberOfElements: ").append(numberOfElements).append("\n");
            sb.append("  totalPages: ").append(totalPages).append("\n");
            sb.append("  totalElements: ").append(totalElements).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
