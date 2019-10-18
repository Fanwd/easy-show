package com.glodon.easyshow.service.impl;

import com.glodon.easyshow.dto.ChartDesignDTO;
import com.glodon.easyshow.entity.ChartDesignEntity;
import com.glodon.easyshow.repository.ChartDesignRepository;
import com.glodon.easyshow.service.ChartDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName ChartDesignServiceImpl
 * @Description 图表设计service
 * @Author fanwd
 * @Date 2019/10/17 20:19
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class ChartDesignServiceImpl implements ChartDesignService {

    @Autowired
    private ChartDesignRepository chartDesignRepository;

    @Override
    public Optional<ChartDesignDTO> getDesignById(Long id) {
        Optional<ChartDesignEntity> entityOptional = chartDesignRepository.findById(id);
        return entityOptional.map(ChartDesignDTO::new);
    }

    @Override
    public void addDesign(ChartDesignDTO chartDesignDTO) {
        Assert.notNull(chartDesignDTO, "Design is null");

        ChartDesignEntity entity = chartDesignDTO.toEntity();
        chartDesignRepository.save(entity);
    }

    @Override
    public void updateDesign(Long id, ChartDesignDTO chartDesignDTO) {
        Assert.notNull(id, "Id is null");
        Assert.notNull(chartDesignDTO, "Design is null");

        Optional<ChartDesignEntity> oldEntityOptional = chartDesignRepository.findById(id);
        Assert.isTrue(oldEntityOptional.isPresent(), "Design not exist");

        ChartDesignEntity oldEntity = oldEntityOptional.get();
        oldEntity.setName(chartDesignDTO.getName());
        oldEntity.setChartType(chartDesignDTO.getChartType());
        oldEntity.setStyleType(chartDesignDTO.getStyleType());
        oldEntity.setDesign(chartDesignDTO.getDesign());
        oldEntity.setDatasourceId(chartDesignDTO.getDatasourceId());
        oldEntity.setThemeId(chartDesignDTO.getThemeId());
        chartDesignRepository.save(oldEntity);
    }

    @Override
    public void deleteDesignById(Long id) {
        chartDesignRepository.deleteById(id);
    }

    @Override
    public List<ChartDesignDTO> listAll() {
        List<ChartDesignEntity> entityList = chartDesignRepository.findAll();
        return entityList.stream()
                .map(ChartDesignDTO::new)
                .collect(Collectors.toList());
    }
}
