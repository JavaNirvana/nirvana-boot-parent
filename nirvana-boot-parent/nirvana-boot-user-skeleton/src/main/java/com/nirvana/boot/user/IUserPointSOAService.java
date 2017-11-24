package com.nirvana.boot.user;

import com.nirvana.boot.common.base.ServiceResponse;
import com.nirvana.boot.user.request.UserPointReq;
import com.nirvana.boot.user.response.UserPointResp;

/**
 * 用户积分SOA服务.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/24 16:03
 */
public interface IUserPointSOAService {

    /**
     * 查询单条用户积分
     * @param req
     * @return
     */
    public ServiceResponse<UserPointResp> querySingleUserPoint(UserPointReq req);
}
