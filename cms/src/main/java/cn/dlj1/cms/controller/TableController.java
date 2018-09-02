package cn.dlj1.cms.controller;

import cn.dlj1.cms.db.key.Key;
import cn.dlj1.cms.entity.Entity;
import cn.dlj1.cms.request.query.Query;
import cn.dlj1.cms.response.Result;
import cn.dlj1.cms.service.TableService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 数据表格接口
 *
 * @param <K>
 * @param <T>
 */
public interface TableController extends Controller {


    @RequestMapping("/table")
    @ResponseBody
    default Result table(@Validated Query query) {
        return getTableService().table( query);
    }

    default TableService getTableService() {
        return (TableService) getService();
    }

}
