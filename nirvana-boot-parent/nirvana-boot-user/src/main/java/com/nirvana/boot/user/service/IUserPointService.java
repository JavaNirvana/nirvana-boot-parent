package com.nirvana.boot.user.service;

import com.nirvana.boot.user.domain.UserPoint;
import com.nirvana.boot.user.domain.query.QueryUserPoint;

import java.util.List;

/**
 * 用户积分服务.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/27 11:45
 */
public interface IUserPointService {

    /**
     * 查询用户积分
     * @param queryUserPoint
     * @return
     */
    public List<UserPoint> queryUserPoints(QueryUserPoint queryUserPoint);

    /**
     * 保存用户积分
     * @param userPoint
     */
    public void saveUserPoint(UserPoint userPoint);
}
