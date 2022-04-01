package com.yuanlrc.base.service.houseInfo;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.dao.houseInfo.HouseDivisionInfoDao;
import com.yuanlrc.base.entity.admin.Role;
import com.yuanlrc.base.entity.bridalChamber.NewHouseInfo;
import com.yuanlrc.base.entity.houseInfo.HouseDivisionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class HouseDivisionInfoService {

    @Autowired
    private HouseDivisionInfoDao houseDivisionInfoDao;

    /**
     * 添加/编辑
     */
    public HouseDivisionInfo save(HouseDivisionInfo houseDivisionInfo){
        return houseDivisionInfoDao.save(houseDivisionInfo);
    }
    /**
     * 删除
     */
    public void delete(Long id){
        houseDivisionInfoDao.deleteById(id);
    }
    /**
     * 通过id查询
     */
    public HouseDivisionInfo find(Long id){
        return houseDivisionInfoDao.find(id);
    }
    /**
     * 通过房屋id查询
     */
    public List<HouseDivisionInfo> findByHouseInfoId(Long id){
        return houseDivisionInfoDao.findByHouseInfoId(id);
    }
    /**
     * 查询所有
     */
    public List<HouseDivisionInfo> findAll(){
        return houseDivisionInfoDao.findAll();
    }
    /**
     * 分页查询
     */
    public PageBean<HouseDivisionInfo> findList(HouseDivisionInfo houseDivisionInfo, PageBean<HouseDivisionInfo> pageBean ){
        ExampleMatcher withMatcher = ExampleMatcher.matching().withMatcher("houseInfo.houseNumber", ExampleMatcher.GenericPropertyMatchers.contains());

        withMatcher = withMatcher.withIgnorePaths("divisionArea","houseInfo.area","houseInfo.floor","houseInfo.buildingAge"
                ,"houseInfo.buildingNumber","houseInfo.watchNumber","houseInfo.specificPrice","houseInfo.unitPrice","housingEstate.price"
                ,"housingEstate.completedYear","housingEstate.propertyCost","housingEstate.sumBuildings","housingEstate.sumHouse");
        Example<HouseDivisionInfo> example = Example.of(houseDivisionInfo, withMatcher);
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize());
        Page<HouseDivisionInfo> findAll = houseDivisionInfoDao.findAll(example, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }
}
