
package com.nirvana.boot.user.domain.query;

import com.nirvana.boot.common.base.BaseBean;

/**
 * 用户积分查询对象.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/27 13:41
 */
public class QueryUserPoint extends BaseBean {

    private static final long serialVersionUID = 6408134426802180439L;

    private String recordNo;

    private String userId;

    private Integer bisType;

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBisType() {
        return bisType;
    }

    public void setBisType(Integer bisType) {
        this.bisType = bisType;
    }
}
