package com.ct.CertificateTracker.controller;

import java.awt.PageAttributes.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.catalina.connector.Response;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.ct.CertificateTracker.model.Certificate;
import com.ct.CertificateTracker.model.Employee;
import com.ct.CertificateTracker.model.ExamTest;
import com.ct.CertificateTracker.model.PlannedCertification;
import com.ct.CertificateTracker.model.PlannedTraining;
import com.ct.CertificateTracker.model.TrainingRegistrations;
import com.ct.CertificateTracker.model.Trainings;
import com.ct.CertificateTracker.repository.CertificateRepo;
import com.ct.CertificateTracker.service.EmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	@Autowired
	private CertificateRepo certificateRepo;

	
	
	@PostMapping("/update")
	public Certificate updateCertificate(@RequestBody Certificate certificate) {
		return service.updatecertificate(certificate);
	}
	

	@PostMapping("/add")
	public Certificate addCertificate(@RequestBody Certificate certificate) {
				return service.addCertificate(certificate);
	}
	
	@PostMapping("/savePdf/{id}")
	public void saveData(@PathVariable String id,@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("file"+file);
		service.addPdf(id, file);
			}
	
	@GetMapping("/Downloadpdf/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String id) 
		{
		System.out.println("hi");
		System.out.println(id);
		byte[] document = null;
		String name=null;
		List<Certificate> allCer=certificateRepo.findAll();
		for(Certificate c:allCer)
		{
			if(c.get_id().contentEquals(id))
			{
				 document=c.getFile();
				 name=c.getEmpName()+"_"+c.getFileName();			

			}
		}	
	        return ResponseEntity.ok()
	        		
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + name + "\"")
	                .body(new ByteArrayResource(document));
	    }	

	
	@GetMapping(value = "/viewPdf/{id}", produces = "application/pdf")
	public byte[] getDownload(@PathVariable String id) {
		byte[] document = null;
		String name=null;
		List<Certificate> allCer=certificateRepo.findAll();
		for(Certificate c:allCer)
		{
			if(c.get_id().contentEquals(id))
			{
				 document=c.getFile();
				 name=c.getEmpName()+"_"+c.getFileName();			

			}
		}	
	   return document;
	}

		
	@GetMapping("/view/{currentUserId}")
	public List<Certificate> getCertificates(@PathVariable String currentUserId){
		return service.getCertificateDetails(currentUserId);
		
	}
	
	@GetMapping("/category")
	public Set<String> getCerCatagory(){
		return service.getCerCatigory();
		
	}
	
	@PostMapping("/validate")
	public Employee validate(@RequestBody Employee employe) {
		return service.validate(employe);
	} 
 

	
	@GetMapping("/certificates/{category}")
	public List<String> getCertificatesOfCategory(@PathVariable String category){
		return service.getCertificatesOfCategory(category);
		
	}
	
	@GetMapping("/plannedCertificates/{empId}")
	public List<PlannedCertification> getPlannedCertificates(@PathVariable String empId){
		//System.out.println(service.getPlannedCertificates(empId));
		return service.getPlannedCertificates(empId);
		
	}
	
	@PostMapping("/savePlannedCertificates")
	public PlannedCertification addPlannedcertifiaction(@RequestBody PlannedCertification certification){
		
//		return service.savePlannedCertificate(certification);
		return service.savePlannedCertificate(certification);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{_id}")
    public void delete(@PathVariable String _id)
    {
		System.out.println("delete");
		// List<PlannedCertification> list= service.getPlannedCertificates(_id);
		PlannedCertification cer = service.findById(_id);
		System.out.println(cer);
	 	service.deletePlannedCertification(cer);

	    
   }
	
	@PostMapping("/addMarks")
	public PlannedCertification addMarks(@RequestBody PlannedCertification certification){
		
		System.out.println(certification);
		//List<Integer> markList=new ArrayList<Integer>();
//		System.out.println("marks");
		return service.insertMarks(certification);
		
		
	}
   
	@PostMapping("/requestVoucher")
	public PlannedCertification requestVoucher(@RequestBody PlannedCertification certificate){
		return service.requestingVoucher(certificate);
	}

	@PostMapping("/deleteCertificate")
	public boolean deleteCertificate(@RequestBody Certificate cer) {
		System.out.println("In emp controller");

	     service.deleteCertificate(cer);
	     return true;
	}
	
	
	@PostMapping("/registerTraining")
	public TrainingRegistrations registerForTraining(@RequestBody TrainingRegistrations pTraining) {
		return service.registerForTraining(pTraining);
		
	}
	
	
	@GetMapping("/viewPlannedTrainings/{empId}")
	public List<PlannedTraining> viewPlannedTrainings(@PathVariable String empId){
		return service.getAllPlannedTrainings(empId);
		
	}
	
	@GetMapping("/getTrainings/{empId}")
	public List<Trainings> getTrainingDetails(@PathVariable String empId){
		return service.getTrainingDetails();
		
	}
	
	
	@GetMapping("/getEmployeeScores/{examName}")
	public ArrayList<ExamTest> getEmployeeScores(@PathVariable String examName) {
		System.out.println(examName);
		return service.getEmployeeScores(examName);
	}
	
	

}
