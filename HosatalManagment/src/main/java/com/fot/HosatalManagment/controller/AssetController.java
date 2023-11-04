package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.entity.Asset;
import com.fot.HosatalManagment.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @GetMapping("/getByRoomId/{roomId}")
    public ResponseEntity<List<Asset>> getAssetsByRoomId(@PathVariable int roomId) {
        List<Asset> assets = assetService.getAssetsByRoomId(roomId);
        return ResponseEntity.ok(assets);
    }
}

