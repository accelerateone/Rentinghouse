package com.yuanlrc.base.dao.houseInfo;

import com.yuanlrc.base.entity.houseInfo.HouseDivisionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseDivisionInfoDao extends JpaRepository<HouseDivisionInfo,Long> , JpaSpecificationExecutor<HouseDivisionInfo> {
    /**
     * 通过id查询
     */
    @Query("select d from HouseDivisionInfo d where d.id = :id")
    HouseDivisionInfo find(@Param("id") Long id);

    /**
     * 通过房屋id查询
     */
    @Query("select h from HouseDivisionInfo h where h.houseInfo.id = :id")
    List<HouseDivisionInfo> findByHouseInfoId(@Param("id") Long id);
}
