package com.r.myspring;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.r.myspring.annotation.Dictionary;
import lombok.Data;

/**
 * @author luozhan
 * @create 2020-04
 */
@Data
@Dictionary(codeField={"id","username"},valueField = "accountName")
@TableName("T_ACCOUNT")
public class Account {
    private Long id;
    private String username;
    private String accountName;
}
