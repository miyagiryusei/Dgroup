package jp.co.axiz.web.service;

import java.util.List;

import jp.co.axiz.web.entity.Role;

/*
 * roleテーブル用サービスインターフェース
 */
public interface RoleService {
    public List<Role> findAll();
}
