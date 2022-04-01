package com.yuanlrc.base.entity.houseInfo;

import com.yuanlrc.base.entity.admin.BaseEntity;
import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.entity.housingEstate.HousingEstate;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * 代开记录
 */
@Entity
@Table(name="ylrc_house_inspection_record")
@EntityListeners(AuditingEntityListener.class)
@ToString
@Data
public class HouseInspectionRecord extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;//带看经纪人

    @ManyToOne
    @JoinColumn(name = "housing_estate_id")
    private HousingEstate housingEstate;//小区

    @ManyToOne
    @JoinColumn(name = "house_info_id")
    private HouseInfo houseInfo;//房屋信息

    @Transient
    private Integer coun;//带看次数
}
