package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductColorDTO {

        private String name;
        private String code; // ← این باید وجود داشته باشد!

        // getters و setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code; // ← همین متد باید تعریف شده باشد
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
