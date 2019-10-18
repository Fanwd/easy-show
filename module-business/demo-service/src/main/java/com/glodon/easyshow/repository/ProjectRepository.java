package com.glodon.easyshow.repository;

import com.glodon.easyshow.entity.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProjectRepository
 * @Description 项目数据
 * @Author fanwd
 * @Date 2019/10/18 23:14
 **/
@Service
public class ProjectRepository {

    private static final List<Project> projectList = new ArrayList<>();

    static {
        projectList.add(new Project(1L, "龙城小区", "辽宁省", "沈阳市", 160.0, 200.0, 500.0, "在建"));
        projectList.add(new Project(2L, "城市公园", "辽宁省", "沈阳市", 450.0, 570.0, 800.0, "在建"));
        projectList.add(new Project(3L, "滨海共路", "辽宁省", "大连市", 370.0, 490.0, 630.0, "完工"));
        projectList.add(new Project(4L, "健身公园", "河北省", "唐山市", 190.0, 250.0, 410.0, "在建"));
        projectList.add(new Project(5L, "长河大厦", "河北省", "邯郸市", 520.0, 410.0, 940.0, "完工"));
        projectList.add(new Project(6L, "城市月光", "河南省", "郑州市", 390.0, 590.0, 730.0, "在建"));
        projectList.add(new Project(7L, "长远天地", "陕西省", "西安市", 410.0, 690.0, 860.0, "完工"));
        projectList.add(new Project(8L, "城南嘉园", "山东省", "济南市", 290.0, 970.0, 420.0, "在建"));
        projectList.add(new Project(9L, "城市芳庭", "山东省", "青岛市", 810.0, 360.0, 910.0, "在建"));
    }

    public List<Project> listAllProject() {
        return projectList;
    }

}
