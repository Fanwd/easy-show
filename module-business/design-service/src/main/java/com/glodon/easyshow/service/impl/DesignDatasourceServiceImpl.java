package com.glodon.easyshow.service.impl;

import com.glodon.easyshow.dto.DesignDatasourceDTO;
import com.glodon.easyshow.entity.DesignDatasourceEntity;
import com.glodon.easyshow.repository.DesignDatasourceRepository;
import com.glodon.easyshow.service.DesignDatasourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Optional<DesignDatasourceDTO> getDatasourceById(Long id) {
        Optional<DesignDatasourceEntity> entity = designDatasourceRepository.findById(id);
        return entity.map(DesignDatasourceDTO::new);
    }

    @Override
    public void addDatasource(DesignDatasourceDTO designDatasourceDTO) {

    }

    @Override
    public void updateDatasource(Long id, DesignDatasourceDTO designDatasourceDTO) {

    }

    @Override
    public void deleteDatasourceById(Long id) {

    }

    @Override
    public List<DesignDatasourceDTO> listAll() {
        return null;
    }
}
