package com.r.myspring.annotation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.lang.annotation.*;

/**
 * 【字典翻译注解】标识在需要翻译的字段上
 *
 * @author luozhan
 * @date 2019-03
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Translate {
    /**
     * 翻译类型（静态字典翻译、缓存翻译、DAO翻译）
     */
    DicType type() default DicType.CACHE;

    /**
     * 缓存翻译传入缓存类的class
     */
    // Class<? extends BaseCache> cacheClass() default BaseCache.class;

    /**
     * DAO翻译传入DAO的class
     */
    Class<?> dictClass() default void.class;

    /**
     * 静态字典表中的key（即静态字典表的DICT_CODE）
     * 静态翻译时必传(type=DicType.STATIC)
     * 支持多个key，传数组
     */
    String[] dictCode() default "";

    /**
     * 状态表表中的key（即RES_STATE_DEF表的TABLE_COL）
     * 状态翻译时必传(type=DicType.STATE)
     */
    StateType stateType() default StateType.RES_STATE;

    /**
     * 指定字典key，不指定默认取Dictionary的配置
     */
    String dicKey() default "";

    /**
     * 指定字典value，不指定默认取Dictionary的配置
     */
    String dicValue() default "";

    /**
     * 指定翻译后的属性名
     */
    String translateField();
}
