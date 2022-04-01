package com.yuanlrc.base.service.houseInfo;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.dao.houseInfo.HousePicturesDao;
import com.yuanlrc.base.entity.houseInfo.HousePictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousePicturesService {
    @Autowired
    private HousePicturesDao housePicturesDao;

    /**
     * 添加/编辑
     */
    public HousePictures save(HousePictures housePictures){
        return housePicturesDao.save(housePictures);
    }
    /**
     * 删除
     */
    public void delete(Long id){
        housePicturesDao.deleteById(id);
    }
    /**
     * 通过id查询
     */
    public HousePictures find(Long id){
        return housePicturesDao.find(id);
    }
    /**
     * 通过房屋id查询
     */
    public List<HousePictures> findByHouseInfoId(Long id){
        return housePicturesDao.findByHouseInfoId(id);
    }
    /**
     * 查询所有
     */
    public List<HousePictures> findAll(){
        return housePicturesDao.findAll();
    }

    /**
     * 后台分页查询
     */
    public PageBean<HousePictures> findList(HousePictures housePictures, PageBean<HousePictures> pageBean){
        ExampleMatcher withMatcher = ExampleMatcher
                .matching()
                .withMatcher("housingEstate.name", ExampleMatcher.GenericPropertyMatchers.contains());
        withMatcher = withMatcher.withIgnorePaths("housingEstate.completedYear");
        Example<HousePictures> example = Example.of(housePictures, withMatcher);
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize());
        Page<HousePictures> findAll = housePicturesDao.findAll(example,pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }
}
