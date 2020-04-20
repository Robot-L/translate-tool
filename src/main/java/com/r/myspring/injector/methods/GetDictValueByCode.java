package com.r.myspring.injector.methods;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.support.ColumnCache;
import com.r.myspring.annotation.Dictionary;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author luozhan
 * @create 2020-04
 */
public class GetDictValueByCode extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        Dictionary dictionary = modelClass.getAnnotation(Dictionary.class);
        String[] codeField = dictionary.codeField();
        String valueField = dictionary.valueField();
        Map<String, ColumnCache> columnMap = LambdaUtils.getColumnMap(modelClass);

        String[] codeColumns = Stream.of(codeField).map(field ->
                Optional.ofNullable(columnMap.get(field.toUpperCase()))
                        .map(ColumnCache::getColumn)
                        .orElseThrow(() -> new RuntimeException("@Dictionary注解codeField配置有误，找不到指定的属性名")))
                .toArray(String[]::new);

        // 自定义sql tableInfo.getTableName() 获取表名
        String sql = "<script>" +
                "select %s from %s " +
                "where %s = #{array[0]}" +
                "<if test = 'array.length > 1'>" +
                "  and %s = #{array[1]}" +
                "</if>" +
                "</script>";
        String valueColumn = tableInfo.getFieldList().stream().filter(n -> n.getField().getName().equals(valueField)).map(TableFieldInfo::getColumn).findAny().orElseThrow(() -> new RuntimeException("@Dictionary注解valueField配置有误，找不到指定的属性名"));
        Object[] params = Stream.concat(Stream.of(valueColumn, tableInfo.getTableName()), Stream.of(codeColumns)).toArray();
        sql = String.format(sql, valueColumn, tableInfo.getTableName(), codeColumns[0],codeColumns.length>1?codeColumns[1]:null);

        // mapper 接口方法名
        String method = "getDictValueByCode";

        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);

        // addSelectMappedStatementForOther可指定返回值类型
        // addSelectMappedStatementForTable返回对应实体对象
        return addSelectMappedStatementForOther(mapperClass, method, sqlSource, String.class);

    }
}
