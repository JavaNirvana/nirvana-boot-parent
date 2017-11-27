
package com.nirvana.boot.user.dao;

import com.nirvana.boot.common.base.BaseMapper;
import com.nirvana.boot.user.domain.UserPoint;
import com.nirvana.boot.user.domain.query.QueryUserPoint;

import java.util.List;

/**
 * 用户积分Mapper.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/27 13:40
 */
public interface UserPointMapper extends BaseMapper {

    /**
     * 查询用户积分记录
     * @param query
     * @return
     */
    public List<UserPoint> queryUserPoints(QueryUserPoint query);

    /**
     * 保存用户积分
     * @param userPoint
     */
    public void saveUserPoint(UserPoint userPoint);
}
