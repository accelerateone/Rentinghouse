package com.yuanlrc.base.service.bridalChamber;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.dao.bridalChamber.HousingCharacteristicsDao;
import com.yuanlrc.base.entity.bridalChamber.HousingCharacteristics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousingCharacteristicsService {

    @Autowired
    private HousingCharacteristicsDao housingCharacteristicsDao;

    public PageBean<HousingCharacteristics> findAllByHousingCharacteristicsName(PageBean<HousingCharacteristics> pageBean, HousingCharacteristics housingCharacteristics){
        ExampleMatcher withMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<HousingCharacteristics> example = Example.of(housingCharacteristics,withMatcher);
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage()-1,pageBean.getPageSize());
        Page<HousingCharacteristics> findAll = housingCharacteristicsDao.findAll(example,pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }


    /**
     * 查询所有
     * @return
     */
    public List<HousingCharacteristics> findAll(){
        return housingCharacteristicsDao.findAll();
    }


    /**
     * 根据id查询
     * @param id
     * @return
     */
    public HousingCharacteristics find(Long id){
        return housingCharacteristicsDao.find(id);
    }

    /**
     * 保存/编辑
     * @param housingCharacteristics
     * @return
     */
    public HousingCharacteristics save(HousingCharacteristics housingCharacteristics){
        return housingCharacteristicsDao.save(housingCharacteristics);
    }

    /**
     * 根据id删除
     * @param id
     */
    public void del(Long id){
        housingCharacteristicsDao.deleteById(id);
    }

}
