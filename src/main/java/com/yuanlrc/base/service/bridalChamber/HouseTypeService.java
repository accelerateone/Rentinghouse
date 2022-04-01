package com.yuanlrc.base.service.bridalChamber;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.dao.bridalChamber.HouseTypeDao;
import com.yuanlrc.base.entity.bridalChamber.HouseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseTypeService {

    @Autowired
    private HouseTypeDao houseTypeDao;

    public PageBean<HouseType> findAllByNewHouseInfoName(PageBean<HouseType> pageBean,HouseType houseType){
        ExampleMatcher withMatcher = ExampleMatcher.matching()
                .withMatcher("newHouseInfo.name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<HouseType> example = Example.of(houseType,withMatcher);
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage() - 1, pageBean.getPageSize());
        Page<HouseType> findAll = houseTypeDao.findAll(example, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }

    /**
     * 查询所有
     * @return
     */
    public List<HouseType> findAll(){
        return houseTypeDao.findAll();
    }

    /**
     * 根据新房id查询所有户型
     * @param newHouseInfoId
     * @return
     */
    public List<HouseType> findByNewHouseInfo_Id(Long newHouseInfoId){
        return houseTypeDao.findByNewHouseInfo_Id(newHouseInfoId);
    }

    public List<HouseType> findTop3ByNewHouseInfo_Id(Long newHouseInfoId){
        return houseTypeDao.findTop3ByNewHouseInfo_Id(newHouseInfoId);
    }


    /**
     * 根据id查询
     * @param id
     * @return
     */
    public HouseType find(Long id){
        return houseTypeDao.find(id);
    }

    /**
     * 保存/编辑
     * @param houseType
     * @return
     */
    public HouseType save(HouseType houseType){
        return houseTypeDao.save(houseType);
    }

    /**
     * 根据id删除
     * @param id
     */
    public void del(Long id){
        houseTypeDao.deleteById(id);
    }

}
