package com.glodon.easyshow.service.impl;

import com.glodon.easyshow.dto.ChartDatasourceDTO;
import com.glodon.easyshow.entity.ChartDatasourceEntity;
import com.glodon.easyshow.repository.ChartDatasourceRepository;
import com.glodon.easyshow.service.ChartDatasourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName ChartDatasourceServiceImpl
 * @Description 数据源service
 * @Author fanwd
 * @Date 2019/10/17 20:20
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class ChartDatasourceServiceImpl implements ChartDatasourceService {

    @Autowired
    private ChartDatasourceRepository chartDatasourceRepository;

    @Override
    public Optional<ChartDatasourceDTO> getDatasourceById(Long id) {
        Optional<ChartDatasourceEntity> entity = chartDatasourceRepository.findById(id);
        return entity.map(ChartDatasourceDTO::new);
    }

    @Override
    public void addTheme(ChartDatasourceDTO chartDatasourceDTO) {

    }

    @Override
    public void updateTheme(Long id, ChartDatasourceDTO chartDatasourceDTO) {

    }

    @Override
    public void deleteThemeById(Long id) {

    }

    @Override
    public List<ChartDatasourceDTO> listAll() {
        return null;
    }
}
