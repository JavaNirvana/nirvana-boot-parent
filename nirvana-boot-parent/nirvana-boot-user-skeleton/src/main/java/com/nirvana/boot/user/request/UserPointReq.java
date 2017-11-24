package com.nirvana.boot.user.request;

import com.nirvana.boot.common.base.BaseBean;

/**
 * UserPoint请求参数.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/24 16:15
 */
public class UserPointReq extends BaseBean {

    private static final long serialVersionUID = -8813162820657695283L;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
