package com.coco.yygh.cmn.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.coco.yygh.cmn.service.DictService;
import com.coco.yygh.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.coco.yygh.common.result.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "数据字典接口")
@RestController
@RequestMapping("/admin/cmn/dict")
@CrossOrigin
public class DictController {
    @Resource
    private DictService dictService;

    @ApiOperation(value = "根据数据id获取子数据列表")
    @GetMapping("/findChildData/{id}")
    public Result findChildData(@PathVariable Long id){
        List<Dict> list = dictService.findChildData(id);
        return Result.ok(list);
    }

    @GetMapping("/exportData")
    public void exportDict(HttpServletResponse response){
        dictService.exportDictData(response);
    }

    @PostMapping("/importData")
    public Result importDict(MultipartFile file){
        dictService.importDictData(file);
        return Result.ok();
    }
}
