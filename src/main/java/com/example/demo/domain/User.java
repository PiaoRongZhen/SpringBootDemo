package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @Version
    private Long version;
}
