package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductColorDTO {

        private String name;
        private String code; // ← این باید وجود داشته باشد!

        public ProductColorDTO() {}

        public ProductColorDTO(String name, String code) {
            this.name = name;
            this.code = code;
        }
    }
