/*************************************************************************
 *                  XIAONIU66 CONFIDENTIAL AND PROPRIETARY                                                      
 *
 *                COPYRIGHT (C) XIAONIU66 CORPORATION 2016                                                      
 *    ALL RIGHTS RESERVED BY XIAONIU66 CORPORATION. THIS PROGRAM    
 * MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY   
 * XIAONIU66 CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
 * OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN       
 * PERMISSION OF XIAONIU66 CORPORATION. USE OF COPYRIGHT NOTICE   
 * DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.                       
 *                  XIAONIU66 CONFIDENTIAL AND PROPRIETARY        
 *************************************************************************/

package com.nirvana.boot.common.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 基本Bean.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/24 16:07
 */
public class BaseBean implements Serializable {

    private static final long serialVersionUID = -7704162706138177783L;

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
