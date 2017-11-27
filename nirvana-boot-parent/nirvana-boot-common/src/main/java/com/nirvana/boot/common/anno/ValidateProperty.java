
package com.nirvana.boot.common.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 验证属性注解.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/24 17:56
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateProperty {
    /**
     * 是否为空
     * @return
     * @author lipanwen
     */
    public boolean nullable() default true;

    /**
     * 长度
     * @return
     * @author lipanwen
     */
    public int len() default -1;

    /**
     * 最小值
     * @return
     * @author lipanwen
     */
    public int min_value() default Integer.MIN_VALUE;

    /**
     * 最大值
     * @return
     * @author lipanwen
     */
    public int max_value() default Integer.MAX_VALUE;

    /**
     * 最大长度
     * @return
     * @author lipanwen
     */
    public int max_len() default -1;

    /**
     * 最小长度
     * @return
     * @author lipanwen
     */
    public int min_len() default -1;

    /**
     * 错误描述
     * @return
     * @author lipanwen
     */
    public String msg() default "";

    /**
     * 正在表达式规则
     * @return
     * @author lipanwen
     */
    public String rule() default "";

    /**
     * 时间格式yyyyMMddHHmmss
     * @return
     * @author lipanwen
     */
    public String time_rule() default "";

    /**
     * 属性可取值
     * @return
     * @author lipanwen
     */
    public String[] str_values() default {};

    /**
     * 属性可取值
     * @return
     * @author lipanwen
     */
    public int[] int_values() default {};
}
