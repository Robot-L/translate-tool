package com.r.myspring.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.r.myspring.injector.methods.GetDictValueByCode;

import java.util.List;

/**
 * @author luozhan
 * @create 2020-04
 */
public class ResSqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        if(DictMapper.class.isAssignableFrom(mapperClass)) {
            // 继承了DictMapper则注入获取字典值方法
            methodList.add(new GetDictValueByCode());
        }
        return methodList;
    }
}
