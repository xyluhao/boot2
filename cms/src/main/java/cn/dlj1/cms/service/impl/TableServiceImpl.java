package cn.dlj1.cms.service.impl;

import cn.dlj1.cms.dao.Dao;
import cn.dlj1.cms.db.key.Key;
import cn.dlj1.cms.entity.Entity;
import cn.dlj1.cms.request.query.Pager;
import cn.dlj1.cms.request.query.Query;
import cn.dlj1.cms.response.Result;
import cn.dlj1.cms.service.TableService;

import java.util.List;
import java.util.Map;

public abstract class TableServiceImpl<K extends Key, T extends Entity>
        extends ServiceImpl<K, T> implements TableService<K, T> {
    public static final String EXPORT_EXCEL_ATTRIBUTE_NAME = "EXPORT_ATTRIBUTE";

    @Override
    public abstract Dao getDao();

    @Override
    public Result table(Query query) {
        Result result = validate(query);
        if (result != Result.SUCCESS) {
            return result;
        }

        Pager pager = queryCount(query);

        List<Map<String, Object>> data = queryData(query);
        Object others = getOthers(query);

        result = callback(query, data, others);
        return result;
    }

    @Override
    public Result validate(Query query) {
        return null;
    }

    @Override
    public Pager queryCount(Query query) {
        return null;
    }

    @Override
    public List<Map<String, Object>> queryData(Query query) {
        return null;
    }

    @Override
    public Object getOthers(Query query) {
        return null;
    }

    @Override
    public Result callback(Query query, List<Map<String, Object>> data, Object others) {
        return null;
    }

    @Override
    public String[] getBtnsKey() {
        return new String[0];
    }

    @Override
    public void export(Query query) {
        getRequest().setAttribute(EXPORT_EXCEL_ATTRIBUTE_NAME, "导出的数据");
    }
}
