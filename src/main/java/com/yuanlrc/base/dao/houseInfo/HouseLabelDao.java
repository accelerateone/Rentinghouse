package com.yuanlrc.base.dao.houseInfo;

import com.yuanlrc.base.entity.houseInfo.HouseLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseLabelDao extends JpaRepository<HouseLabel, Long> {
    /**
     * 通过id查询
     */
    @Query("select l from HouseLabel l where l.id = :id")
    HouseLabel find(@Param("id") Long id);

    /**
     * 通过标签名查询
     */
    HouseLabel findByName(String name);
}
