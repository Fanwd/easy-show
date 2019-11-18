package com.glodon.easyshow.api;

import com.glodon.easyshow.entity.Project;
import com.glodon.easyshow.repository.ProjectRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoProjectApi.class)
public class DemoProjectApiTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProjectRepository projectRepository;

    @Test
    public void listAllProject() throws Exception {
        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project());
        Mockito.when(projectRepository.listAllProject()).thenReturn(projectList);
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/projects"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("success")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code", Matchers.equalTo(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.length()").value(1));
    }
}