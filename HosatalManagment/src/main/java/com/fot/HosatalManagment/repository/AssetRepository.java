package com.fot.HosatalManagment.repository;

import com.fot.HosatalManagment.entity.Asset;
import com.fot.HosatalManagment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String> {
    @Procedure(name = "GetAssetDetailsByRoomId")
    List<Asset> GetAssetDetailsByRoomId(int targetId);

    @Procedure(name = "GetAssetDetails")
    Asset GetAssetDetails(String assetNumber);
}
