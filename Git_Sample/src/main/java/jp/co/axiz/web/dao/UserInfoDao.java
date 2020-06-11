package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.UserInfo;

/*
 * user_infoテーブル用DAO (インターフェース)
 */
public interface UserInfoDao {

    public List<UserInfo> findAll();

    public List<UserInfo> find(UserInfo userInfo);

    public UserInfo findByLoginId(String loginId);

    public UserInfo findByLoginIdAndPassword(String loginId, String password);

    public void insert(UserInfo user);
}
