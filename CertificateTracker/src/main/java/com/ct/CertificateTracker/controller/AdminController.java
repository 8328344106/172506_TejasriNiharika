package com.ct.CertificateTracker.controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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

import com.ct.CertificateTracker.model.Admin;
import com.ct.CertificateTracker.model.Certificate;
import com.ct.CertificateTracker.model.CoreCertificationDetails;
import com.ct.CertificateTracker.model.Employee;
import com.ct.CertificateTracker.model.EmployeeDetailsCertificationDetails;
import com.ct.CertificateTracker.model.ExamTest;
import com.ct.CertificateTracker.model.ExcelGeneratorEmpCertifications;
import com.ct.CertificateTracker.model.InternalTest;
import com.ct.CertificateTracker.model.PlannedCertification;
import com.ct.CertificateTracker.model.PlannedTraining;
import com.ct.CertificateTracker.model.Tower;
import com.ct.CertificateTracker.model.TrainingRegistrations;
import com.ct.CertificateTracker.model.Trainings;
import com.ct.CertificateTracker.model.VoucherExcelGenerator;
import com.ct.CertificateTracker.model.voucher;
import com.ct.CertificateTracker.model.voucherInfo;
import com.ct.CertificateTracker.service.AdminService;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/towers")
	public List<Tower> getDetails() {
		return service.getTowers();
	}
	
	
	
	@GetMapping("/getCertificates")
	public List<CoreCertificationDetails> getCertificateDetails(){
		return service.getCertificateDetails();
		
	}
	
	@PostMapping("/addCertificate")
	public CoreCertificationDetails addNewCertificate(@RequestBody CoreCertificationDetails certificate ) {
		System.out.println(certificate.getCertificationCategory());
		return service.addnewCertificate(certificate);
		
	}
	
	@GetMapping("/voucherinfo")
	public List<voucherInfo> getVoucherInfo(){
		return service.getVoucherInfo();
		
	}
	
	@PostMapping("/login")
	public Admin loginValidate(@RequestBody Admin admin) {
		System.out.println(admin);
		return service.loginValidate(admin);
		
	}
	
	@PostMapping("/register")
	public Admin register(@RequestBody Admin admin) {
		return service.register(admin);
		
		
	}

	
	@GetMapping("/getrequestlist")
	public List<PlannedCertification> getVoucherRequestedList(){
		System.out.println("in service controller");
		return service.getVoucherRequestedList();
		
	}
	
	
	@PostMapping("/voucherassigned")
	public PlannedCertification assigningVoucher(@RequestBody PlannedCertification pC){
		System.out.println("in controller");
		System.out.println(pC);
		return service.checkVoucherAvailability(pC);
		
	}
	
	
	@GetMapping("/getallvouchers")
	public List<voucher> getAllVouchers(@RequestParam("examName") String examName){
		return service.getAllVouchers(examName);
	}
	
	
	
	@GetMapping("/allvouchers")
	public List<voucher> allVouchers(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(new Date());
		System.out.println(date); //Prints 26/10/2015
		return service.allVouchers();
		
	}
	
	@GetMapping("/getTrainings")
	public List<Trainings> getTrainingDetails(){
		return service.getTrainingDetails();
		
	}
	@PostMapping("/addTraining")
	public Trainings addNewTraining(@RequestBody Trainings training ) {

		return service.addnewTraining(training);
		
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteTraining/{_id}")
    public void delete(@PathVariable String _id)
    {
		System.out.println("delete");
		// List<PlannedCertification> list= service.getPlannedCertificates(_id);
		Trainings training = service.findById(_id);
		System.out.println(training);
	 	service.deleteTraining(training);;

	    
   } 
		@PostMapping("/editcertificationdetails")
			public CoreCertificationDetails editCertificationDetails(@RequestBody CoreCertificationDetails c){
				return service.updateCertificationDetails(c);
			} 
			
			@PostMapping("/editvoucher")
			public voucher editVoucher(@RequestBody voucher v) {
				return service.updateVoucher(v);
			}  
			
			
			@RequestMapping(method=RequestMethod.DELETE, value="/deleteCertificationDetails/{_id}")
			public void removeCertificationDetails(@PathVariable String _id) {
				service.deleteCertificationDetails(_id);
				
				
			} 
			
			@GetMapping("/getAllEmployee")
			public List<Employee> allEmployee(){
				return service.getAllEmployee();
				
			}
		 
			
			
			@GetMapping("/viewRegisterTrainings")
			public List<PlannedTraining> viewRegistrationsOfTrainings(){
				return service.viewingOfRegistrationsOfTrainings();
			}
			
			
			@PostMapping("/approveTrainingRequest")
			public TrainingRegistrations approvingTrainingRegistration(@RequestBody TrainingRegistrations x) {
			  return service.approveTrainingReg(x);	
			
			}
			
			@RequestMapping(method=RequestMethod.GET, value="/viewTrainingById/{id}")

			public List<Trainings> findByTrainingId(@PathVariable String id){
				return service.findByTrainingId(id);
			}
			
			@PostMapping("/updateTraining")
			public Trainings editTraining(@RequestBody Trainings t) {
				return service.updateTraining(t);
			}  
			
		
			
			@PostMapping("/saveExcelFile")
			public int saveDataOfExcel(@RequestParam("file") MultipartFile file) {
				try {
					return service.saveDataOfExcel(file);
				} catch (Exception e) {
					System.out.println(e.getMessage());

				}

				return 0;

			}
			

			

			@GetMapping("/getAllCertificatesAdmin")
			public List<EmployeeDetailsCertificationDetails> allCertificatesAdmin(){
				return service.allCertificatesEmp();
				
			}
			
			 @GetMapping(value = "/downloadEmpCertifications")
			    public ResponseEntity<InputStreamResource> excelCertReport() throws IOException 
			    {
					List<EmployeeDetailsCertificationDetails> emp=service.allCertificatesEmp();

			    ByteArrayInputStream in = ExcelGeneratorEmpCertifications.employeeToExcel(emp);
			    
			    HttpHeaders headers = new HttpHeaders();
		        headers.add("Content-Disposition", "attachment; filename=EmployeeCertifications.xlsx");
		        //headers.add("Content-Disposition", "inline; filename=EmployeeDetails.xlsx");

			     return ResponseEntity
			                  .ok()
			                  .headers(headers)
			                  .body(new InputStreamResource(in));
			    }

			 @GetMapping(value = "/downloadVoucherinfo")
			    public ResponseEntity<InputStreamResource> excelVoucherReport() throws IOException 
			    {
					List<voucher> v=service.allVouchers();

			    ByteArrayInputStream in = VoucherExcelGenerator.vToExcel(v);
			    HttpHeaders headers = new HttpHeaders();
		        headers.add("Content-Disposition", "attachment; filename=VoucherMaster.xlsx");
		        //headers.add("Content-Disposition", "inline; filename=EmployeeDetails.xlsx");

			     return ResponseEntity
			                  .ok()
			                  .headers(headers)
			                  .body(new InputStreamResource(in));
			    }
					
						@GetMapping("/getInternalTests/{certificationName}")
						public InternalTest getTests(@PathVariable String certificationName) {
							return service.getTests(certificationName);
							
						}
						
						@GetMapping("/getOnlyInternalTests/{certificationName}")
						public ArrayList<ExamTest> getOnlyTests(@PathVariable String certificationName) {
							return service.getOnlyTests(certificationName);
							
						}
						
						
						
						@PostMapping("/addTest")
						public InternalTest addTest(@RequestBody InternalTest c) {
							System.out.println(c);
							return service.addTest(c);
						}

			
}
