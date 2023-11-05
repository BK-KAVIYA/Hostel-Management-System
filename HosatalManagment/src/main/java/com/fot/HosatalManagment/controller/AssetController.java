package com.fot.HosatalManagment.controller;

import com.fot.HosatalManagment.entity.Asset;
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

    @PutMapping("/update")
    public ResponseEntity<String> updateAsset(@RequestParam String assetId, @RequestBody Asset asset) throws UnsupportedEncodingException {

        Optional<Asset> optionalAsset = assetRepository.findById(assetId);

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

    @GetMapping("/findasset")
    public ResponseEntity<Asset> getAssetDetails(@RequestParam String assetNumber) throws UnsupportedEncodingException {
        String decodedAssetId = java.net.URLDecoder.decode(assetNumber, "UTF-8");


        Asset asset = assetService.getAssetDetails(decodedAssetId);
        return ResponseEntity.ok(asset);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAsset(@RequestParam String assetId) {
        // Check if the student with the given stId exists
        if (assetRepository.existsById(assetId)) {
            // Delete the Asset
            assetRepository.deleteById(assetId);
            return ResponseEntity.ok("Asset deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

