package com.nirvana.boot.user.api;

import com.nirvana.boot.common.base.ServiceResponse;
import com.nirvana.boot.user.IUserPointSOAService;
import com.nirvana.boot.user.request.UserPointReq;
import com.nirvana.boot.user.response.UserPointResp;
import org.springframework.stereotype.Service;

/**
 * 用户积分SOA服务.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/24 16:34
 */
@Service("userPointSOAService")
public class UserPointSOAServiceImpl implements IUserPointSOAService {

    @Override
    public ServiceResponse<UserPointResp> querySingleUserPoint(UserPointReq req) {

        return null;
    }
}
