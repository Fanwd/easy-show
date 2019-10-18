package com.glodon.easyshow.service.impl;

import com.glodon.easyshow.dto.DesignChartDTO;
import com.glodon.easyshow.entity.DesignChartEntity;
import com.glodon.easyshow.repository.DesignChartRepository;
import com.glodon.easyshow.service.DesignChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName DesignChartServiceImpl
 * @Description 图表设计service
 * @Author fanwd
 * @Date 2019/10/17 20:19
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class DesignChartServiceImpl implements DesignChartService {

    @Autowired
    private DesignChartRepository designChartRepository;

    @Override
    public Optional<DesignChartDTO> getChartById(String id) {
        Optional<DesignChartEntity> entityOptional = designChartRepository.findById(id);
        return entityOptional.map(DesignChartDTO::new);
    }

    @Override
    public void addChart(DesignChartDTO designChartDTO) {
        Assert.notNull(designChartDTO, "Chart is null");

        DesignChartEntity entity = designChartDTO.toEntity();
        designChartRepository.save(entity);
    }

    @Override
    public void updateChart(String id, DesignChartDTO designChartDTO) {
        Assert.notNull(id, "Id is null");
        Assert.notNull(designChartDTO, "Chart is null");

        Optional<DesignChartEntity> oldEntityOptional = designChartRepository.findById(id);
        Assert.isTrue(oldEntityOptional.isPresent(), "Chart not exist");

        DesignChartEntity oldEntity = oldEntityOptional.get();
        oldEntity.setName(designChartDTO.getName());
        oldEntity.setChartType(designChartDTO.getChartType());
        oldEntity.setStyleType(designChartDTO.getStyleType());
        oldEntity.setDesign(designChartDTO.getDesign());
        oldEntity.setDatasourceId(designChartDTO.getDatasourceId());
        oldEntity.setThemeId(designChartDTO.getThemeId());
        designChartRepository.save(oldEntity);
    }

    @Override
    public void deleteChartById(String id) {
        designChartRepository.deleteById(id);
    }

    @Override
    public List<DesignChartDTO> listAll() {
        List<DesignChartEntity> entityList = designChartRepository.findAll();
        return entityList.stream()
                .map(DesignChartDTO::new)
                .collect(Collectors.toList());
    }
}