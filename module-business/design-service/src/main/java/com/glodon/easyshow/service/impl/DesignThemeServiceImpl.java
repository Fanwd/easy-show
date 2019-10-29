package com.glodon.easyshow.service.impl;

import com.glodon.easyshow.dto.DesignThemeDTO;
import com.glodon.easyshow.entity.DesignThemeEntity;
import com.glodon.easyshow.repository.DesignThemeRepository;
import com.glodon.easyshow.service.DesignThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName DesignThemeServiceImpl
 * @Description 主题配置
 * @Author fanwd
 * @Date 2019/10/15 20:16
 **/
@Service
@CacheConfig(cacheNames = "theme")
@Transactional(rollbackFor = Exception.class)
public class DesignThemeServiceImpl implements DesignThemeService {

    @Autowired
    private DesignThemeRepository designThemeRepository;

    @Override
    @Cacheable(key = "targetClass.getSimpleName() + ':' + #id")
    public Optional<DesignThemeDTO> getThemeById(String id) {
        Optional<DesignThemeEntity> entityOptional = designThemeRepository.findById(id);
        return entityOptional.map(DesignThemeDTO::new);
    }

    @Override
    public void addTheme(DesignThemeDTO designThemeDTO) {
        if (null == designThemeDTO) {
            return;
        }
        DesignThemeEntity newEntity = designThemeDTO.toEntity();
        newEntity.setId(null);
        designThemeRepository.save(newEntity);
    }

    @Override
    public void updateTheme(String id, DesignThemeDTO designThemeDTO) {
        Assert.notNull(designThemeDTO, "theme is null");
        Assert.notNull(id, "theme id is null");

        Optional<DesignThemeEntity> oldThemeOptional = designThemeRepository.findById(id);
        Assert.isTrue(oldThemeOptional.isPresent(), "theme not exist");

        DesignThemeEntity oldTheme = oldThemeOptional.get();
        oldTheme.setName(designThemeDTO.getName());
        oldTheme.setStyle(designThemeDTO.getStyle());
        designThemeRepository.save(oldTheme);
    }

    @Override
    public void deleteThemeById(String id) {
        designThemeRepository.deleteById(id);
    }

    @Override
    @Cacheable
    public List<DesignThemeDTO> listAll() {
        List<DesignThemeEntity> entityList = designThemeRepository.findAll();
        return entityList.stream()
                .map(DesignThemeDTO::new)
                .collect(Collectors.toList());
    }
}
