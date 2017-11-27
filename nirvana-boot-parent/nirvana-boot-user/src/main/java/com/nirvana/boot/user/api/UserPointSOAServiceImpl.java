package com.nirvana.boot.user.api;

import com.nirvana.boot.common.base.ServiceResponse;
import com.nirvana.boot.common.util.ValidateUtil;
import com.nirvana.boot.user.IUserPointSOAService;
import com.nirvana.boot.user.request.PlusUserPointReq;
import com.nirvana.boot.user.request.QueryUserPointReq;
import com.nirvana.boot.user.response.PlusUserPointResp;
import com.nirvana.boot.user.response.UserPointResp;
import com.nirvana.boot.user.service.IUserPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户积分SOA服务.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/24 16:34
 */
@Service("userPointSOAService")
public class UserPointSOAServiceImpl implements IUserPointSOAService {

    @Autowired
    private IUserPointService userPointService;

    @Override
    public ServiceResponse<List<UserPointResp>> queryUserPoint(QueryUserPointReq req) {
        return null;
    }

    @Override
    public ServiceResponse<PlusUserPointResp> plusUserPoint(PlusUserPointReq req) {
        return null;
    }
}
