package com.glodon.easyshow.service.impl;

import com.glodon.easyshow.dto.DesignChartDTO;
import com.glodon.easyshow.entity.DesignChartEntity;
import com.glodon.easyshow.repository.DesignChartRepository;
import com.glodon.easyshow.service.DesignChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.data.domain.Example;
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
@CacheConfig(cacheNames = "DesignChartServiceImpl")
@Transactional(rollbackFor = Exception.class)
public class DesignChartServiceImpl implements DesignChartService {

    @Autowired
    private DesignChartRepository designChartRepository;

    @Override
    @Cacheable(key = "#id")
    public Optional<DesignChartDTO> getChartById(String id) {
        Optional<DesignChartEntity> entityOptional = designChartRepository.findById(id);
        return entityOptional.map(DesignChartDTO::new);
    }

    @Override
    @CacheEvict(key = "'list*'")
    public void addChart(DesignChartDTO designChartDTO) {
        Assert.notNull(designChartDTO, "Chart is null");

        DesignChartEntity entity = designChartDTO.toEntity();
        designChartRepository.save(entity);
    }

    @Override
    @CachePut(key = "#id")
    @CacheEvict(key = "'list*'")
    public void updateChart(String id, DesignChartDTO designChartDTO) {
        Assert.notNull(id, "Id is null");
        Assert.notNull(designChartDTO, "Chart is null");

        Optional<DesignChartEntity> oldEntityOptional = designChartRepository.findById(id);
        Assert.isTrue(oldEntityOptional.isPresent(), "Chart not exist");

        DesignChartEntity oldEntity = oldEntityOptional.get();
        oldEntity.setName(designChartDTO.getName());
        oldEntity.setChartType(designChartDTO.getChartType());
        oldEntity.setChartStyle(designChartDTO.getChartStyle());
        oldEntity.setStyle(designChartDTO.getStyle());
        oldEntity.setDesign(designChartDTO.getDesign());
        oldEntity.setDatasourceId(designChartDTO.getDatasourceId());
        oldEntity.setThemeId(designChartDTO.getThemeId());
        designChartRepository.save(oldEntity);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(key = "#id"),
            @CacheEvict(key = "'list*'")
    })
    public void deleteChartById(String id) {
        designChartRepository.deleteById(id);
    }

    @Override
    @Cacheable(key = "'list-' + #datasourceId + '-' + #chartType")
    public List<DesignChartDTO> listChart(String datasourceId, String chartType) {
        DesignChartEntity entity = new DesignChartEntity();
        entity.setDatasourceId(datasourceId);
        entity.setChartType(chartType);
        Example<DesignChartEntity> example = Example.of(entity);
        List<DesignChartEntity> entityList = designChartRepository.findAll(example);
        return entityList.stream()
                .map(DesignChartDTO::new)
                .collect(Collectors.toList());
    }
}
