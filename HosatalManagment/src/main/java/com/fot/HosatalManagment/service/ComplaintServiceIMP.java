package com.fot.HosatalManagment.service;

import com.fot.HosatalManagment.entity.Complaint;
import com.fot.HosatalManagment.repository.ComplaintRepo;
import com.fot.HosatalManagment.user.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ComplaintServiceIMP implements ComplaintService{

    @Autowired
    private ComplaintRepo complaintRepo;

    @Transactional
    @Override
    public List<Complaint> getComplaintByStId(String ID) {

        return  complaintRepo.GetComplaintsByStudent(ID);
    }

    @Override
    public void saveComplaint(Complaint complaint) {
         complaintRepo.save(complaint);
    }


    public String uploadImage(MultipartFile file) throws IOException {

        Complaint complaint = complaintRepo.save(Complaint.builder()
                        .compalint_id(10)
                        .asset_id("404/TB/001")
                        .complaint("chaire broken")
                        .student_id("TG005")
                        .sub_warden_id("S002")
                        .warden_id("W001")
                        .date_and_time("2023-10-15 23:12:45")
                        .status("Open")
                .image(ImageUtils.compressImage(file.getBytes())).build());
        if (complaint != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

//    @Transactional
//    public byte[] downloadImage(int fileName){
//        Optional<Complaint> dbImageData = complaintRepo.GetComplaintDetails(fileName);
//        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImage());
//        return images;
//    }

    public Optional<Complaint> getComplaintDetails(int complaintId) {
        return complaintRepo.getComplaintDetails(complaintId);
    }

    public Iterable<Complaint> getAllComplained(){
        return complaintRepo.findAll();
    }
}
