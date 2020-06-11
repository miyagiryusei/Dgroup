package jp.co.axiz.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.web.dao.RoleDao;
import jp.co.axiz.web.entity.Role;
import jp.co.axiz.web.service.RoleService;

/*
 * roleテーブル用サービス実装クラス
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 全件取得
     */
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
