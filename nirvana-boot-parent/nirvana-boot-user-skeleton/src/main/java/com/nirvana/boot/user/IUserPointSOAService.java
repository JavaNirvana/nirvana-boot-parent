package com.nirvana.boot.user;

import com.nirvana.boot.common.base.ServiceResponse;
import com.nirvana.boot.user.request.PlusUserPointReq;
import com.nirvana.boot.user.request.QueryUserPointReq;
import com.nirvana.boot.user.response.PlusUserPointResp;
import com.nirvana.boot.user.response.UserPointResp;

import java.util.List;

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
    public ServiceResponse<List<UserPointResp>> queryUserPoint(QueryUserPointReq req);

    /**
     * 增加用户积分
     * @param req
     * @return
     */
    public ServiceResponse<PlusUserPointResp> plusUserPoint(PlusUserPointReq req);
}
