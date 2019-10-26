package com.glodon.easyshow.repository;

import com.glodon.easyshow.entity.ComputerInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ComputerInfoRepository
 * @Description TODO
 * @Author fanwd
 * @Date 2019/10/25 22:54
 **/
@Service
public class ComputerInfoRepository {

    private static final List<ComputerInfo> computerList = new ArrayList<>();

    static {
        computerList.add(new ComputerInfo("1", "T450", "联想", "笔记本", 5000.0, 9000.0, 73));
        computerList.add(new ComputerInfo("2", "TZ45", "联想", "台式机", 7000.0, 12000.0, 124));
        computerList.add(new ComputerInfo("3", "H145", "惠普", "笔记本", 3500.0, 7300.0, 50));
        computerList.add(new ComputerInfo("4", "HZ15", "惠普", "台式机", 4700.0, 8100.0, 89));
        computerList.add(new ComputerInfo("5", "S52s", "华硕", "笔记本", 4000.0, 7100.0, 177));
        computerList.add(new ComputerInfo("6", "S67X", "华硕", "台式机", 8900.0, 15000.0, 57));
        computerList.add(new ComputerInfo("7", "PR10", "苹果", "笔记本", 8900.0, 17000.0, 83));
        computerList.add(new ComputerInfo("8", "PZ2", "苹果", "台式机", 10000.0, 20000.0, 49));
        computerList.add(new ComputerInfo("9", "D560", "戴尔", "笔记本", 1500.0, 3000.0, 61));
        computerList.add(new ComputerInfo("10", "DT23", "戴尔", "台式机", 2000.0, 40000.0, 94));
    }

    public List<ComputerInfo> listAll() {
        return computerList;
    }
}
