package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Asset;
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
}
