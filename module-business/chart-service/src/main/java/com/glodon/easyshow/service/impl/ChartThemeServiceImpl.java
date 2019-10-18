package com.glodon.easyshow.service.impl;

import com.glodon.easyshow.dto.ChartThemeDTO;
import com.glodon.easyshow.entity.ChartThemeEntity;
import com.glodon.easyshow.repository.ChartThemeRepository;
import com.glodon.easyshow.service.ChartThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName ChartThemeServiceImpl
 * @Description 主题配置
 * @Author fanwd
 * @Date 2019/10/15 20:16
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class ChartThemeServiceImpl implements ChartThemeService {

    @Autowired
    private ChartThemeRepository chartThemeRepository;

    @Override
    public Optional<ChartThemeDTO> getThemeById(Long id) {
        Optional<ChartThemeEntity> entityOptional = chartThemeRepository.findById(id);
        return entityOptional.map(ChartThemeDTO::new);
    }

    @Override
    public void addTheme(ChartThemeDTO chartThemeDTO) {
        if (null == chartThemeDTO) {
            return;
        }
        ChartThemeEntity newEntity = chartThemeDTO.toEntity();
        chartThemeRepository.save(newEntity);
    }

    @Override
    public void updateTheme(Long id, ChartThemeDTO chartThemeDTO) {
        Assert.notNull(chartThemeDTO, "theme is null");
        Assert.notNull(id, "theme id is null");

        Optional<ChartThemeEntity> oldThemeOptional = chartThemeRepository.findById(id);
        Assert.isTrue(oldThemeOptional.isPresent(), "theme not exist");

        ChartThemeEntity oldTheme = oldThemeOptional.get();
        oldTheme.setName(chartThemeDTO.getName());
        oldTheme.setStyle(chartThemeDTO.getStyle());
        chartThemeRepository.save(oldTheme);
    }

    @Override
    public void deleteThemeById(Long id) {
        chartThemeRepository.deleteById(id);
    }

    @Override
    public List<ChartThemeDTO> listAll() {
        List<ChartThemeEntity> entityList = chartThemeRepository.findAll();
        return entityList.stream()
                .map(ChartThemeDTO::new)
                .collect(Collectors.toList());
    }
}
