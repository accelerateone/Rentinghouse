package com.yuanlrc.base.service.admin;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.dao.admin.RentHouseFeaturesDao;
import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.entity.rentHouse.RentHouseFeatures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 租房房源特色业务处理层
 * @author wangzihan
 * @date : 2021/1/9 17:21
 */
@Service
public class RentHouseFeaturesService {

    @Autowired
    private RentHouseFeaturesDao houseFeaturesDao;

    /**
     * 根据name模糊分页查询
     * @param pageBean
     * @param rentHouseFeatures
     * @return
     */
    public PageBean<RentHouseFeatures> findList(PageBean<RentHouseFeatures> pageBean, RentHouseFeatures rentHouseFeatures){
        ExampleMatcher withMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<RentHouseFeatures> example = Example.of(rentHouseFeatures,withMatcher);
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage()-1,pageBean.getPageSize());
        Page<RentHouseFeatures> findAll = houseFeaturesDao.findAll(example,pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }

    /**
     * 查询所有
     * @return
     */
    public List<RentHouseFeatures> findAll(){
        return houseFeaturesDao.findAll();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public RentHouseFeatures find(Long id){
        return houseFeaturesDao.find(id);
    }

    /**
     * 按照用户名查找用户
     * @param name
     * @return
     */
    public RentHouseFeatures findByName(String name){
        return houseFeaturesDao.findByName(name);
    }

    /**
     * 判断特色名是否存在，添加和编辑均可判断
     * @param name
     * @param id
     * @return
     */
    public boolean isExistName(String name,Long id){
        RentHouseFeatures rentHouseFeatures = houseFeaturesDao.findByName(name);
        if(rentHouseFeatures != null){
            //表示特色名存在，接下来判断是否是编辑特色的本身
            if(rentHouseFeatures.getId().longValue() != id.longValue()){
                return true;
            }
        }
        return false;
    }

    /**
     * 保存/编辑
     * @param housingCharacteristics
     * @return
     */
    public RentHouseFeatures save(RentHouseFeatures housingCharacteristics){
        return houseFeaturesDao.save(housingCharacteristics);
    }

    /**
     * 根据id删除
     * @param id
     */
    public void delete(Long id){
        houseFeaturesDao.deleteById(id);
    }




}
