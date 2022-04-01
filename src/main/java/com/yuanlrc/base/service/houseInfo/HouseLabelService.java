package com.yuanlrc.base.service.houseInfo;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.dao.houseInfo.HouseLabelDao;
import com.yuanlrc.base.entity.houseInfo.HouseLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseLabelService {
    @Autowired
    private HouseLabelDao houseLabelDao;
    /**
     * 添加/编辑
     */
    public HouseLabel save(HouseLabel houseLabel){
        return houseLabelDao.save(houseLabel);
    }
    /**
     * 删除
     */
    public void delete(Long id){
        houseLabelDao.deleteById(id);
    }
    /**
     * 通过id查询
     */
    public HouseLabel find(Long id){
        return houseLabelDao.find(id);
    }
    /**
     * 通过标签名查询
     */
    public HouseLabel findByName(String name){
        return houseLabelDao.findByName(name.trim());
    }
    /**
     * 查询所有
     */
    public List<HouseLabel> findAll(){
        return houseLabelDao.findAll();
    }
    /**
     * 后台分页查询
     */
    public PageBean<HouseLabel> findList(HouseLabel houseLabel, PageBean<HouseLabel> pageBean){
        ExampleMatcher withMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<HouseLabel> example = Example.of(houseLabel, withMatcher);
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize());
        Page<HouseLabel> findAll = houseLabelDao.findAll(example, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }
}
