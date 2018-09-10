package cn.dlj1.cms.controller;

import cn.dlj1.cms.entity.Entity;
import cn.dlj1.cms.response.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 查询一条数据接口（展示接口）
 *
 *
 */
public interface ViewController<T extends Entity> extends Controller<T> {

    @RequestMapping("/view")
    @ResponseBody
    default Result view(@Validated @NotNull long id) {
        return getActionService().view(id);
    }

}