/*************************************************************************
 *                  XIAONIU66 CONFIDENTIAL AND PROPRIETARY                                                      
 *
 *                COPYRIGHT (C) XIAONIU66 CORPORATION 2016                                                      
 *    ALL RIGHTS RESERVED BY XIAONIU66 CORPORATION. THIS PROGRAM    
 * MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY   
 * XIAONIU66 CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
 * OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN       
 * PERMISSION OF XIAONIU66 CORPORATION. USE OF COPYRIGHT NOTICE   
 * DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.                       
 *                  XIAONIU66 CONFIDENTIAL AND PROPRIETARY        
 *************************************************************************/

package com.nirvana.boot.user.service.impl;

import com.nirvana.boot.common.exception.BusinessException;
import com.nirvana.boot.user.dao.UserPointMapper;
import com.nirvana.boot.user.domain.UserPoint;
import com.nirvana.boot.user.domain.query.QueryUserPoint;
import com.nirvana.boot.user.enums.MsgEnum;
import com.nirvana.boot.user.service.IUserPointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户积分服务.
 *
 * @author lipw
 * @version 1.0
 * @date 2017/11/27 13:48
 */
@Service("userPointService")
public class UserPointServiceImpl implements IUserPointService {

    private static final Logger LOG = LoggerFactory.getLogger(UserPointServiceImpl.class);

    @Autowired
    private UserPointMapper userPointMapper;

    @Override
    public List<UserPoint> queryUserPoints(QueryUserPoint queryUserPoint) {
        List<UserPoint> resultList = null;
        try {
            resultList = userPointMapper.queryUserPoints(queryUserPoint);
        } catch (Exception e) {
            LOG.error(">>> queryUserPoints >>> has exception:", e);
            throw new BusinessException(MsgEnum.QUERY_DATA_ERROR);
        }
        if (CollectionUtils.isEmpty(resultList)) {
            resultList = new ArrayList<>();
        }
        return resultList;
    }

    @Override
    public void saveUserPoint(UserPoint userPoint) {
        try {
            userPointMapper.saveUserPoint(userPoint);
        } catch (Exception e) {
            LOG.error(">>> saveUserPoint >>> has exception:", e);
            throw new BusinessException(MsgEnum.INSERT_DATA_ERROR);
        }
    }
}
