package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.entity.Asset;
import com.fot.HosatalManagment.entity.Attendance;
import com.fot.HosatalManagment.entity.Student;
import com.fot.HosatalManagment.repository.AssetRepository;
import com.fot.HosatalManagment.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assets")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @Autowired
    private AssetRepository assetRepository;

    @GetMapping("/getByRoomId/{roomId}")
    public ResponseEntity<List<Asset>> getAssetsByRoomId(@PathVariable int roomId) {
        List<Asset> assets = assetService.getAssetsByRoomId(roomId);
        return ResponseEntity.ok(assets);
    }

    @GetMapping("/getAllAssets")
    public ResponseEntity<List<Asset>> getAllAssets() {
        List<Asset> assets = assetService.getAllAssets();
        return ResponseEntity.ok(assets);
    }

    @PostMapping("/add")
    public ResponseEntity<Asset> addAAsset(@RequestBody Asset asset) {
        Asset saveasset = assetService.addAsset(asset);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveasset);
    }

    @PutMapping("/update/{assetId}")
    public ResponseEntity<String> updateAsset(@PathVariable String assetId, @RequestBody Asset asset) throws UnsupportedEncodingException {
        String decodedAssetId = java.net.URLDecoder.decode(assetId, "UTF-8");
        System.out.println(decodedAssetId);

        Optional<Asset> optionalAsset = assetRepository.findById(decodedAssetId);

        if (optionalAsset.isPresent()) {
            // Update the Asset data
            Asset existingAsset = optionalAsset.get();
            existingAsset.setType(asset.getType());
            existingAsset.setStatus(asset.getStatus());
            existingAsset.setCategory(asset.getCategory());
            existingAsset.setTarget_id(asset.getTarget_id());
            // Update other fields as needed
            assetRepository.save(existingAsset);
            return ResponseEntity.ok("Asset updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findasset/{assetNumber}")
    public ResponseEntity<Asset> getAssetDetails(@PathVariable String assetNumber) throws UnsupportedEncodingException {
        String decodedAssetId = java.net.URLDecoder.decode(assetNumber, "UTF-8");
        System.out.println(decodedAssetId);

        Asset asset = assetService.getAssetDetails(decodedAssetId);
        return ResponseEntity.ok(asset);
    }
}

