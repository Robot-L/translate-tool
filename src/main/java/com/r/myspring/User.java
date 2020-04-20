package com.r.myspring;

import com.r.myspring.annotation.Dictionary;
import com.r.myspring.annotation.Translate;
import lombok.Data;

/**
 * @author luozhan
 * @create 2020-04
 */
@Data
public class User {
    @Translate(dictClass = Account.class, translateField = "idName")
    private Long id;
    private String idName;
    private String name;
    private Integer age;
    private String email;
}
