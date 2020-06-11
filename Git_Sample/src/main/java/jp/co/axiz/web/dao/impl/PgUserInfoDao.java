package jp.co.axiz.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.UserInfo;

/*
 * user_infoテーブル用DAO
 */
@Repository
public class PgUserInfoDao implements UserInfoDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL = "SELECT user_id, login_id, user_name, telephone, password, r.role_id, role_name FROM user_info u JOIN ROLE r ON u.role_id = r.role_id ORDER BY user_id";
    private static final String SELECT = "SELECT user_id, login_id, user_name, telephone, password, r.role_id, role_name FROM user_info u JOIN ROLE r ON u.role_id = r.role_id WHERE ";
    private static final String SELECT_BY_LOGIN_ID = "SELECT user_id, login_id, user_name, telephone, password, r.role_id, role_name FROM user_info u JOIN ROLE r ON u.role_id = r.role_id WHERE login_id = :loginId";
    private static final String SELECT_BY_LOGIN_ID_AND_PASS = "SELECT user_id, login_id, user_name, telephone, password, r.role_id, role_name FROM user_info u JOIN ROLE r ON u.role_id = r.role_id WHERE login_id = :loginId AND password = :password";
    private static final String ORDER_BY = " ORDER BY user_id";
    private static final String INSERT = "INSERT INTO user_info (login_id, user_name, telephone, password, role_id) VALUES (:loginId, :userName, :telephone, :password, :roleId)";

    /**
     * 全件取得
     */
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> resultList = jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

        return resultList;
    }

    /**
     * 条件を指定した検索
     */
    @Override
    public List<UserInfo> find(UserInfo userInfo) {

        if (userInfo == null || userInfo.isEmptyCondition()) {
            // 検索条件が無い場合は全検索
            return findAll();
        }

        // 検索条件の有無に応じて、sqlのWHERE句に指定する条件文、
        // Parameterをストックしていく。

        List<String> condition = new ArrayList<String>();
        MapSqlParameterSource param = new MapSqlParameterSource();

        String userName = userInfo.getUserName();
        String telephone = userInfo.getTelephone();

        if (userName != null && !userName.isEmpty()) {
            condition.add("user_name = :userName");
            param.addValue("userName", userName);

        }

        if (telephone != null && !telephone.isEmpty()) {
            condition.add("telephone = :telephone");
            param.addValue("telephone", telephone);

        }

        // WHERE句の文字列生成
        String whereString = String.join(" AND ", condition.toArray(new String[] {}));

        // SQL文生成
        String sql = SELECT + whereString + ORDER_BY;

        List<UserInfo> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

        return resultList;
    }

    /**
     * user_idによる検索
     */
    @Override
    public UserInfo findByLoginId(String loginId) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("loginId", loginId);

        List<UserInfo> resultList = jdbcTemplate.query(SELECT_BY_LOGIN_ID, param,
                new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }

    /**
     * user_id、passwordによる検索
     */
    @Override
    public UserInfo findByLoginIdAndPassword(String loginId, String password) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("loginId", loginId);
        param.addValue("password", password);

        List<UserInfo> resultList = jdbcTemplate.query(SELECT_BY_LOGIN_ID_AND_PASS, param,
                new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }

    /**
     * 登録
     */
    @Override
    public void insert(UserInfo user) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("loginId", user.getLoginId());
        param.addValue("userName", user.getUserName());
        param.addValue("telephone", user.getTelephone());
        param.addValue("password", user.getPassword());
        param.addValue("roleId", user.getRoleId());

        jdbcTemplate.update(INSERT, param);
    }
}
