package com.yuanlrc.base.dao.admin;

import com.yuanlrc.base.entity.bridalChamber.EffectPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffectPictureDao extends JpaRepository<EffectPicture,Long> {
}
