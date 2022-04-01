package com.yuanlrc.base.dao.bridalChamber;

import com.yuanlrc.base.entity.bridalChamber.HouseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HouseTypeDao extends JpaRepository<HouseType,Long> {

    /**
     * 通过id查询
     * @param id
     * @return HouseType
     */
    @Query("select ht from HouseType ht where ht.id = :id")
    HouseType find(@Param("id")Long id);

    /**
     * 通过楼盘id查询
     * @param houseInfoId
     * @return
     */
    List<HouseType> findByNewHouseInfo_Id(@Param("houseInfoId")Long houseInfoId);

    /**
     * 通过楼盘id查询
     * @param houseInfoId
     * @return
     */
    List<HouseType> findTop3ByNewHouseInfo_Id(@Param("houseInfoId")Long houseInfoId);

}
