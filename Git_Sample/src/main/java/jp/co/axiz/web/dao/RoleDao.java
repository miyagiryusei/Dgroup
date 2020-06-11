package jp.co.axiz.web.dao;

import java.util.List;

import jp.co.axiz.web.entity.Role;

/*
 * roleテーブル用DAO (インターフェース)
 */
public interface RoleDao {

    public List<Role> findAll();
}
