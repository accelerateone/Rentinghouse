package com.yuanlrc.base.dao.bridalChamber;

import com.yuanlrc.base.entity.bridalChamber.HousingCharacteristics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HousingCharacteristicsDao extends JpaRepository<HousingCharacteristics,Long> {

    /**
     * 通过id查询
     * @param id
     * @return HousingCharacteristics
     */
    @Query("select hc from HousingCharacteristics hc where hc.id = :id")
    HousingCharacteristics find(@Param("id")Long id);

}
