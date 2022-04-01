package com.yuanlrc.base.dao.housingEstate;


import com.yuanlrc.base.entity.housingEstate.HousingEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 小区数据库处理层
 * @author wangzihan
 * @date : 2021/1/7 13:33
 */
@Repository
public interface HousingEstateDao extends JpaRepository<HousingEstate,Long>, JpaSpecificationExecutor<HousingEstate> {

    /**
     * 根据小区id查询
     * @param id
     * @return
     */
    @Query("select he from HousingEstate he where id = :id")
    HousingEstate find(@Param("id")Long id);

    /**
     * 按照小区名查找小区信息
     * @param name
     * @return
     */
    HousingEstate findByName(String name);

    /**
     * 通过小区模糊搜索小区
     * @param district
     * @return
     */
    List<HousingEstate> findByDistrictLike(String district);
}
