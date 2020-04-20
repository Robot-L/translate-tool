package com.r.myspring.injector;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.io.Serializable;

/**
 * @author luozhan
 * @create 2020-04
 */
public interface DictMapper<T> extends BaseMapper<T> {
    /**
     * 根据字典code获取字典value
     * @param code 字典code
     * @return 字典value
     */
    String getDictValueByCode(Serializable... code);
}
