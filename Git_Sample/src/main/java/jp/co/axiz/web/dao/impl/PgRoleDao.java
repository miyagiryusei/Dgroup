package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.RoleDao;
import jp.co.axiz.web.entity.Role;

/*
 * roleテーブル用DAO
 */
@Repository
public class PgRoleDao implements RoleDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL = "SELECT role_id, role_name FROM role ORDER BY role_id";

    /**
     * 全件取得
     */
    @Override
    public List<Role> findAll() {
        List<Role> resultList = jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<Role>(Role.class));

        return resultList;
    }

}
