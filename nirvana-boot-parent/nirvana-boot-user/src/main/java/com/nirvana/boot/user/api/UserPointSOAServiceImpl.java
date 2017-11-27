package com.nirvana.boot.user.api;

import com.nirvana.boot.common.base.ServiceResponse;
import com.nirvana.boot.common.util.ExceptionUtil;
import com.nirvana.boot.common.util.ValidateUtil;
import com.nirvana.boot.user.IUserPointSOAService;
import com.nirvana.boot.user.domain.UserPoint;
import com.nirvana.boot.user.domain.query.QueryUserPoint;
import com.nirvana.boot.user.request.PlusUserPointReq;
import com.nirvana.boot.user.request.QueryUserPointReq;
import com.nirvana.boot.user.response.PlusUserPointResp;
import com.nirvana.boot.user.response.UserPointResp;
import com.nirvana.boot.user.service.IUserPointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    private static final Logger LOG = LoggerFactory.getLogger(UserPointSOAServiceImpl.class);

    @Autowired
    private IUserPointService userPointService;

    @Override
    public ServiceResponse<List<UserPointResp>> queryUserPoint(QueryUserPointReq req) {
        ServiceResponse<List<UserPointResp>> serviceResponse = null;
        List<UserPointResp> userPointRespList = null;
        try {
            ValidateUtil.check(req);

            QueryUserPoint query = new QueryUserPoint();
            query.setRecordNo(req.getRecordNo());
            LOG.info(">>> userPointService.queryUserPoints >>> query:{}", query);
            List<UserPoint> userPoints = userPointService.queryUserPoints(query);
            LOG.info(">>> userPointService.queryUserPoints >>> size:{}", userPoints.size());

            userPointRespList = new ArrayList<UserPointResp>();
            UserPointResp userPointResp = null;
            for (UserPoint userPoint : userPoints) {
                userPointResp = new UserPointResp();
                BeanUtils.copyProperties(userPoint, userPointResp);
                userPointRespList.add(userPointResp);
            }
            serviceResponse = new ServiceResponse<List<UserPointResp>>(userPointRespList);
        } catch (Exception e) {
            serviceResponse = ExceptionUtil.handleException2Response(e);
        }

        return serviceResponse;
    }

    @Override
    public ServiceResponse<PlusUserPointResp> plusUserPoint(PlusUserPointReq req) {
        ServiceResponse<List<UserPointResp>> serviceResponse = null;
        try {
            ValidateUtil.check(req);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
