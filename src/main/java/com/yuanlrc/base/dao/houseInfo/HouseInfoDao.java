package com.yuanlrc.base.dao.houseInfo;

import com.yuanlrc.base.entity.bridalChamber.NewHouseInfo;
import com.yuanlrc.base.entity.houseInfo.HouseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseInfoDao extends JpaRepository<HouseInfo,Long>, JpaSpecificationExecutor<HouseInfo> {
    /**
     * 通过id查询
     */
    @Query("select i from HouseInfo i where i.id = :id")
    HouseInfo find(@Param("id") Long id);

    /**
     * 通过小区id查询
     */
    @Query("select i from HouseInfo i where i.housingEstate.id = :id")
    List<HouseInfo> findByHousingEstateId(@Param("id") Long id);


    /**
     * 根据小区查找
     * @param district
     * @param id
     * @return
     */
    List<HouseInfo> findTop8ByDistrictLikeAndIdNot(String district,Long id);


    List<HouseInfo> findTop3By();
}
