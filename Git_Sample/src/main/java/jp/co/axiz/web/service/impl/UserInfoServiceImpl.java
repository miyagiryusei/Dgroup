package jp.co.axiz.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.UserInfoService;

/*
 * user_infoテーブル用サービス実装クラス
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * 認証処理
     */
    @Override
    public UserInfo authentication(String loginId, String pass) {
        return userInfoDao.findByLoginIdAndPassword(loginId, pass);
    }

    /**
     * 条件を指定した検索
     */
    @Override
    public List<UserInfo> find(UserInfo userInfo) {
        return userInfoDao.find(userInfo);
    }

    /**
     * user_idによる検索
     */
    @Override
    public UserInfo findByLoginId(String loginId) {
        return userInfoDao.findByLoginId(loginId);
    }

    @Override
    public boolean existsUserByLoginId(String loginId) {
        return findByLoginId(loginId) != null;
    }

    /**
     * 登録
     */
    @Override
    public void insert(UserInfo userInfo) {
        userInfoDao.insert(userInfo);
    }
}
