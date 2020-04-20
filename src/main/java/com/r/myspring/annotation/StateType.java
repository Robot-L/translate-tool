package com.r.myspring.annotation;

/**
 * 状态类型枚举，对应RES_STATE_DEF表的TABLE_COL
 *
 * @author wuyong7
 */
public enum StateType {
    /**
     * 资源状态
     */
    RES_STATE,

    /**
     * 管理状态
     */
    MGMT_STATE,
    /**
     * 号码池状态
     */
    POOL_STATE,
    /**
     *
     */
    SEG_STATE,
    /**
     * 临时号码状态
     */
    TEMP_STATE,
    /**
     * 光猫状态
     */
    EMODEL_STATE,
    /**
     * 税务状态
     */
    TAX_STATE,
    /**
     * 写卡状态
     */
    WRITE_STATE,
    /**
     *
     */
    APP_STATE

}
