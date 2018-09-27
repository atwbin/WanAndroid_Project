package com.yitoudai.wanandroid.core.dao;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/**
 * Author：Created by Wbin on 2018/8/7
 *
 * Description： 数据库
 */
public class DaoMaster extends AbstractDaoMaster {

    public static final int SCHEMA_VERSION = 1;

    public static  void createAllTables(Database db,boolean ifNotExists){

    }

    public DaoMaster(Database db, int schemaVersion) {
        super(db, schemaVersion);
    }

    @Override
    public AbstractDaoSession newSession() {
        return null;
    }

    @Override
    public AbstractDaoSession newSession(IdentityScopeType type) {
        return null;
    }


}
