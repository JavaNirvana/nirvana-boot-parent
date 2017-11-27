package com.nirvana.boot.user.request;

import com.nirvana.boot.common.anno.ValidateProperty;
import com.nirvana.boot.common.base.BaseBean;

/**
 * UserPoint请求参数.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/24 16:15
 */
public class QueryUserPointReq extends BaseBean {

    private static final long serialVersionUID = -8813162820657695283L;

    @ValidateProperty(nullable = false, max_len = 20)
    private String recordNo;

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }
}
