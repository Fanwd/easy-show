package com.glodon.easyshow.service.impl;

import com.glodon.easyshow.dto.DesignDatasourceDTO;
import com.glodon.easyshow.entity.DesignDatasourceEntity;
import com.glodon.easyshow.repository.DesignDatasourceRepository;
import com.glodon.easyshow.service.DesignDatasourceService;
import org.springframework.beans.factory.annotation.Autowired;
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
@Transactional(rollbackFor = Exception.class)
public class DesignDatasourceServiceImpl implements DesignDatasourceService {

    @Autowired
    private DesignDatasourceRepository designDatasourceRepository;

    @Override
    public Optional<DesignDatasourceDTO> getDatasourceById(String id) {
        Optional<DesignDatasourceEntity> entity = designDatasourceRepository.findById(id);
        return entity.map(DesignDatasourceDTO::new);
    }

    @Override
    public void addDatasource(DesignDatasourceDTO designDatasourceDTO) {
        Assert.notNull(designDatasourceDTO, "Datasource is null");

        DesignDatasourceEntity entity = designDatasourceDTO.toEntity();
        designDatasourceRepository.save(entity);
    }

    @Override
    public void updateDatasource(String id, DesignDatasourceDTO designDatasourceDTO) {
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
        oldEntity.setDataStructure(designDatasourceDTO.getDataStructure());
        designDatasourceRepository.save(oldEntity);
    }

    @Override
    public void deleteDatasourceById(String id) {
        designDatasourceRepository.deleteById(id);
    }

    @Override
    public List<DesignDatasourceDTO> listAll() {
        List<DesignDatasourceEntity> entityList = designDatasourceRepository.findAll();
        return entityList.stream()
                .map(DesignDatasourceDTO::new)
                .collect(Collectors.toList());
    }
}
