package com.yuanlrc.base.dao.houseInfo;

import com.yuanlrc.base.entity.houseInfo.HouseInspectionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseInspectionRecordDao extends JpaRepository<HouseInspectionRecord,Long> {
    /**
     * 通过id查询
     */
    @Query("select r from HouseInspectionRecord r where r.id = :id")
    HouseInspectionRecord find(@Param("id") Long id);


    /**
     * 根据时间到倒叙
     * @param id
     * @return
     */
    List<HouseInspectionRecord> findByHouseInfo_IdOrderByCreateTimeDesc(Long id);


    /**
     * 根据用户和房屋id查询总数
     * @param userId
     * @param HouseInfoId
     * @return
     */
    Integer countByUser_IdAndHouseInfo_Id(Long userId,Long HouseInfoId);



    /**
     * 通过房间id查询近30天的带看次数
     */
    @Query(nativeQuery = true,value = "SELECT COUNT(*) FROM ylrc_house_inspection_record h WHERE h.house_info_id = :id\n" +
            "AND DATE_SUB(CURDATE(),INTERVAL 30 DAY) <= h.create_time")
    Object findWithinThirtyDays(@Param("id") Long id);

    /**
     * 通过房间id查询近7天的带看次数
     */
    @Query(nativeQuery = true,value = "SELECT COUNT(*) FROM ylrc_house_inspection_record h WHERE h.house_info_id = :id\n" +
            "AND DATE_SUB(CURDATE(),INTERVAL 7 DAY) <= h.create_time")
    Object findWithinSevenDays(@Param("id") Long id);
}
