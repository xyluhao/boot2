package cn.dlj1.cms.controller;

import cn.dlj1.cms.entity.Entity;
import cn.dlj1.cms.request.query.ExportQuery;
import cn.dlj1.cms.response.Result;
import cn.dlj1.cms.service.ExportService;
import cn.dlj1.cms.web.auth.annotation.Menu;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 数据导出接口
 */
public interface ExportController<T extends Entity> extends Controller<T> {

    /**
     * 导出信息
     * 返回导出数据时需要的
     * 字段信息 [{k(字段值):v(字段名),...}]
     *
     * @return
     */
    @GetMapping("/export/infos")
    @ResponseBody
    @Menu(value = "导出字段", key = "exportInfos")
    default Result exportInfos() {
        ExportService service = (ExportService) getService();
        return service.getExportInfos();
    }

    /**
     * 导出操作
     *
     * @param response
     * @param query
     * @return
     */

    @GetMapping(value = "/export")
    @Menu(value = "导出", key = "export")
    default void export(HttpServletResponse response, @Validated ExportQuery<T> query) {
        ExportService service = (ExportService) getService();

        service.export(response, query);
    }

}
