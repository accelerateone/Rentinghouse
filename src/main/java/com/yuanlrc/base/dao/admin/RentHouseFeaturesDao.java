package com.yuanlrc.base.dao.admin;

import com.yuanlrc.base.entity.rentHouse.RentHouseFeatures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 租房房源特色数据库处理层
 * @author wangzihan
 * @date : 2021/1/9 17:19
 */
@Repository
public interface RentHouseFeaturesDao extends JpaRepository<RentHouseFeatures,Long> {

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Query("select rhf from RentHouseFeatures rhf where id = :id")
    RentHouseFeatures find(@Param("id")Long id);

    /**
     * 根据名字查找
     * @param name
     * @return
     */
    RentHouseFeatures findByName(@Param("name")String name);

}
