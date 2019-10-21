package com.glodon.easyshow.api;

import com.glodon.easyshow.entity.Project;
import com.glodon.easyshow.repository.ProjectRepository;
import com.glodon.easyshow.result.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DemoProjectApi
 * @Description 项目API
 * @Author fanwd
 * @Date 2019/10/18 23:34
 **/
@RestController
@Api("项目信息API")
public class DemoProjectApi {

    @Autowired
    private ProjectRepository projectRepository;

    @ApiOperation("查询所有项目信息")
    @GetMapping("/projects")
    @CrossOrigin
    public JsonResult<List<Project>> listAllProject() {
        List<Project> result = projectRepository.listAllProject();
        return JsonResult.success(result);
    }
}
