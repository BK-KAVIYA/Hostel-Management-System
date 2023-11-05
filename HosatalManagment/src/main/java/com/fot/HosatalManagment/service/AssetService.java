package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Asset;
import com.fot.HosatalManagment.entity.Attendance;
import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    @Transactional
    public List<Asset> getAssetsByRoomId(int roomId) {
        return assetRepository.GetAssetDetailsByRoomId(roomId);
    }

    public List<Asset> getAllAssets(){
        return assetRepository.findAll();
    }

    public Asset addAsset(Asset asset){
        return assetRepository.save(asset);
    }

    @Transactional
    public Asset getAssetDetails(String assetNumber) {
        return assetRepository.GetAssetDetails(assetNumber);
    }
}
