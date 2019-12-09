package com.glodon.easyshow.api;


import com.glodon.easyshow.dto.DesignChartDataDTO;
import com.glodon.easyshow.exception.BusinessException;
import com.glodon.easyshow.service.ChartDataService;
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

@RunWith(SpringRunner.class)
@WebMvcTest(ChartDataApi.class)
public class ChartDataApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChartDataService chartDataService;

    @Test
    public void series() throws Exception {
        DesignChartDataDTO result = new DesignChartDataDTO();
        Mockito.when(chartDataService.getResultById("1")).thenReturn(result);

        mockMvc
                .perform(MockMvcRequestBuilders.get("/chart_dates/{id}", "2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("code", Matchers.equalTo(0)));
    }

    @Test(expected = Exception.class)
    public void seriesException() throws Exception {
        Mockito.when(chartDataService.getResultById("1")).thenThrow(new BusinessException());

        mockMvc
                .perform(MockMvcRequestBuilders.get("/chart_dates/{id}", "1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("code", Matchers.equalTo(0)));
    }
}