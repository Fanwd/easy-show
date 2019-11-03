package com.glodon.easyshow.service.impl;

import com.glodon.easyshow.dto.DesignDatasourceDTO;
import com.glodon.easyshow.entity.DesignDatasourceEntity;
import com.glodon.easyshow.repository.DesignDatasourceRepository;
import com.glodon.easyshow.service.DesignDatasourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName DesignDatasourceServiceImpl
 * @Description 数据源service
 * @Author fanwd
 * @Date 2019/10/17 20:20
 **/
@Service
@CacheConfig(cacheNames = "DesignDatasourceServiceImpl")
@Transactional(rollbackFor = Exception.class)
public class DesignDatasourceServiceImpl implements DesignDatasourceService {

    @Autowired
    private DesignDatasourceRepository designDatasourceRepository;

    @Override
    @Cacheable(key = "#id")
    public Optional<DesignDatasourceDTO> getDatasourceById(String id) {
        Optional<DesignDatasourceEntity> entity = designDatasourceRepository.findById(id);
        return entity.map(DesignDatasourceDTO::new);
    }

    @Override
    @CacheEvict(key = "'list'")
    public void addDatasource(DesignDatasourceDTO designDatasourceDTO) {
        Assert.notNull(designDatasourceDTO, "Datasource is null");

        DesignDatasourceEntity entity = designDatasourceDTO.toEntity();
        designDatasourceRepository.save(entity);
    }

    @Override
    @CachePut(key = "#id")
    @CacheEvict(key = "'list'")
    public DesignDatasourceDTO updateDatasource(String id, DesignDatasourceDTO designDatasourceDTO) {
        Assert.notNull(id, "Id is null");
        Assert.notNull(designDatasourceDTO, "Chart is null");

        Optional<DesignDatasourceEntity> oldEntityOptional = designDatasourceRepository.findById(id);
        Assert.isTrue(oldEntityOptional.isPresent(), "Chart not exist");

        DesignDatasourceEntity oldEntity = oldEntityOptional.get();
        oldEntity.setName(designDatasourceDTO.getName());
        oldEntity.setType(designDatasourceDTO.getType());
        oldEntity.setRequestInfo(designDatasourceDTO.getRequestInfo());
        oldEntity.setData(designDatasourceDTO.getData());
        oldEntity.setDataPath(designDatasourceDTO.getDataPath());
        oldEntity.setDataStructures(designDatasourceDTO.getDataStructures());
        designDatasourceRepository.save(oldEntity);
        return new DesignDatasourceDTO(oldEntity);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(key = "#id"),
            @CacheEvict(key = "'list'")
    })
    public void deleteDatasourceById(String id) {
        designDatasourceRepository.deleteById(id);
    }

    @Override
    @Cacheable(key = "'list'")
    public List<DesignDatasourceDTO> listAll() {
        List<DesignDatasourceEntity> entityList = designDatasourceRepository.findAll();
        return entityList.stream()
                .map(DesignDatasourceDTO::new)
                .collect(Collectors.toList());
    }
}
