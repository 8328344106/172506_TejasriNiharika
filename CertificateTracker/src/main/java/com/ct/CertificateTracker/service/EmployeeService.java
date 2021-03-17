package com.ct.CertificateTracker.service;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ct.CertificateTracker.model.Certificate;
import com.ct.CertificateTracker.model.CoreCertificationDetails;
import com.ct.CertificateTracker.model.Employee;
import com.ct.CertificateTracker.model.ExamTest;
import com.ct.CertificateTracker.model.PlannedCertification;
import com.ct.CertificateTracker.model.PlannedTraining;
import com.ct.CertificateTracker.model.TrainingRegistrations;
import com.ct.CertificateTracker.model.Trainings;
import com.ct.CertificateTracker.model.VoucherExcelGenerator;
import com.ct.CertificateTracker.repository.CertifiacationDetailsRepo;
import com.ct.CertificateTracker.repository.CertificateRepo;
import com.ct.CertificateTracker.repository.EmployeeRepo;
import com.ct.CertificateTracker.repository.PlannedCerRepo;
import com.ct.CertificateTracker.repository.PlannedTrainingRepo;
import com.ct.CertificateTracker.repository.TrainingRepo;

@Service
public class EmployeeService {
	
	private static final String RETRIEVE_FOLDER = "C:/Users/swkundu/Downloads";

	@Autowired 
	private EmployeeRepo empRepository;
	
	@Autowired
	private CertificateRepo certificateRepo;
	
	@Autowired
	private CertifiacationDetailsRepo certifiacationDetailsRepo;
	
	@Autowired
	private PlannedCerRepo plannedCerRepo;
	@Autowired
	private TrainingRepo trainingRepo;
	
	@Autowired
	private PlannedTrainingRepo plannedTrainingRepo;
	
	 int flag=0;

	
	public List<Certificate> getCertificateDetails(String currentUserId){
		List<Certificate> allCertificates=certificateRepo.findAll();
		List<Certificate> empCertificates=new ArrayList<Certificate>();
		
		
		for(Certificate c:allCertificates) {
			if(c.getEmpId()!=null)
			{
				if(c.getEmpId().equals(currentUserId)) {
					empCertificates.add(c);
				}
				
			}
			
		}
		
		
		return empCertificates;
		
	}
	
	public Certificate addCertificate(Certificate certificate){
		List<Certificate> allCer=certificateRepo.findAll();
		for(Certificate index:allCer){
			if((index.getCerCategory().equals(certificate.getCerCategory())) && (index.getCerName().equals(certificate.getCerName()))){
				return null;
			}
		}

		    return certificateRepo.save(certificate);
		}
	
	public void addPdf(String cerId,MultipartFile file) throws IOException 
	{
		List<Certificate> allCer=certificateRepo.findAll();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        System.out.println(fileName);
		for(Certificate c:allCer)
		{
			if(c.get_id().contentEquals(cerId))
			{
				c.setFile(file.getBytes());
				c.setFileName(fileName);
				certificateRepo.save(c);
			}
		}
		
	}
//	public byte[] getPdf(String cerId)
//	{
//		List<Certificate> allCer=certificateRepo.findAll();
//		for(Certificate c:allCer)
//		{
//			if(c.get_id().contentEquals(cerId))
//			{
//				byte[] document=c.getFile();
//				 return document;
//
//							}
//		}
//		return null;
//	}
		
	 public Certificate updatecertificate(Certificate certificate) {
		List<Certificate> allCertifiactes=certificateRepo.findAll();
		 for(Certificate c:allCertifiactes)
		 {
				if(c.getEmpId()!=null)
				{
			 if((c.getEmpId().equals(certificate.getEmpId()))&&(c.getCerName().equals(certificate.getCerName())))
			{
				 certificate.setId(c.getId());
			 }
				}		 
		
	     }
		 return certificateRepo.save(certificate);
		 
		 
	}
		 
		 
		 
	 public Set<String> getCerCatigory(){
			 List<CoreCertificationDetails> cerValues=certifiacationDetailsRepo.findAll();
			 Set<String> collect = cerValues.stream().map(x -> x.getCertificationCategory()).collect(Collectors.toSet());
			 return collect;
			 
			 
		 }
	 
	 
	 public List<String> getCertificatesOfCategory(String category){
		 List<CoreCertificationDetails> allCer=certifiacationDetailsRepo.findAll();
		 List<String> certificates=new ArrayList<String>();
		 for(CoreCertificationDetails c:allCer) {
			 if(c.getCertificationCategory().equalsIgnoreCase(category))
				 certificates.add(c.getCertificationName());

		 }
		 
		 return certificates;
		 
		 
	 }
	 
	
	
	public Employee validate(Employee e){
			List<Employee> employees= empRepository.findAll();
			for(Employee emp:employees) {
				if(emp.getEmpId().contentEquals(e.getEmpId()))
					return emp;
			}
			
			return null;
			
		} 
	public List<PlannedCertification> getPlannedCertificates(String empId){
		 //System.out.println(empId);
		 List<PlannedCertification> allCer=plannedCerRepo.findAll();
		 System.out.println(allCer);
		 List<PlannedCertification> plannedCertifications=new ArrayList<PlannedCertification>();
		 for(PlannedCertification pC:allCer) {
			// System.out.println(pC.getEmpID());
			 if(pC.getEmpID().contentEquals(empId))
				 plannedCertifications.add(pC);
		 }
		 
		 return plannedCertifications;
		 
		 
	 }		 

	public PlannedCertification savePlannedCertificate(PlannedCertification certification){
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
			String date = sdf.format(new Date());
			certification.setRegDate(date);
			
			List<PlannedCertification> allCer=plannedCerRepo.findAll();
			for(PlannedCertification index: allCer) {
				if(index.getExamName().equals(certification.getExamName())) {
					return null;
				}
			}
			
			
			
			 return plannedCerRepo.save(certification);
			 
		 
	}
		 
		 

	public PlannedCertification insertMarks(PlannedCertification certification){
		 
		 List<PlannedCertification> allCer=plannedCerRepo.findAll();
//		 System.out.println(allCer);
		System.out.println("insert");
		 for(PlannedCertification pc:allCer) {
			if(pc.getEmpID()!=null && pc.getExamName()!=null)
			{
				System.out.println("marks:"+pc.getTestMarks());
				 if(pc.getEmpID().contentEquals(certification.getEmpID())&&pc.getExamName().contentEquals(certification.getExamName()))
					 certification.set_id(pc.get_id());
				 
				
			}
			
		 }
		 
		 return plannedCerRepo.save(certification);
		 
		 
	 }
	 
	 public PlannedCertification findById(String _id)
		{
		 //System.out.println(plannedCerRepo.findBy_id(_id));
	     return plannedCerRepo.findBy_id(_id);
	   }
	 public  void deletePlannedCertification(PlannedCertification certification)
	   {
   
		 plannedCerRepo.delete(certification);
	   }

	 
	 
	 public PlannedCertification requestingVoucher(PlannedCertification pC){
		 List<PlannedCertification> allCer=plannedCerRepo.findAll();
		 
		 for(PlannedCertification p:allCer){
			 if(p.getEmpID().contentEquals(pC.getEmpID()) && p.getEmpID().contentEquals(pC.getEmpID())){
				 pC.set_id(p.get_id());
				 pC.setVoucherStatus("Requested");
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
					String date = sdf.format(new Date());
					pC.setVoucherReqDate(date);
			 }

		 }
		 
		 return plannedCerRepo.save(pC);
		 
		 
	 }
		
	 public boolean deleteCertificate(Certificate certificate) {
		  
			certificateRepo.delete(certificate);
			
			
			return true;
		}
	 
	 public TrainingRegistrations registerForTraining(TrainingRegistrations pTraining) {
		 
		 
		 List<Trainings> all=trainingRepo.findAll();
		 
		 Trainings temp=null;
		 boolean existed=false;
		 
		 List<TrainingRegistrations> allR=plannedTrainingRepo.findAll();
		 for(TrainingRegistrations tr:allR) {
			 if(tr.getEmpId().contentEquals(pTraining.getEmpId()) && (tr.getTrainingId().contentEquals(pTraining.getTrainingId()))) {
				 existed=true;
				 
			 }
			 
		 }
		 
		 
		 if(!existed) {
		 
		 
		 for(Trainings t:all) {
			 if(t.getTrainingId().contentEquals(pTraining.getTrainingId())) {
				 temp=t;
				 
			 }
		 }
		 
		 temp.setInterestsReceived(temp.getInterestsReceived()+1);
		 trainingRepo.save(temp);
		 
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
			String date = sdf.format(new Date());
		    pTraining.setRequestDate(date);
		    pTraining.setNominationStatus("Requested");
		 return plannedTrainingRepo.save(pTraining);
		 
		 }
		 return null;
		 
		 
	 }
	 
	 public List<PlannedTraining> getAllPlannedTrainings(String empId){
		 
		 List<TrainingRegistrations> allTrainings=plannedTrainingRepo.findAll();
		 List<Trainings> all=trainingRepo.findAll();
		 String status=null,location=null,startDate=null,endDate=null;
		 List<PlannedTraining> requiredTraining=new ArrayList<PlannedTraining>();
		 for(TrainingRegistrations p:allTrainings) {
			 if(p.getEmpId()!=null) {
				
			 
			 if(p.getEmpId().contentEquals(empId)) {
				 
				 
				 
				 for(Trainings t:all) {
					 if(t.getTrainingId().contentEquals(p.getTrainingId())) {
						 status=t.getStatus();
						 location=t.getLocation();
						 startDate=t.getStartDate();
						 endDate=t.getEndDate();
					 }
				 }
				 
				 PlannedTraining temp=new PlannedTraining(empId, p.getEmpName(), p.getTrainingId(),p.getTrainingName(), status, p.getNominationStatus(), p.getRequestDate(), startDate, endDate, location);
			     requiredTraining.add(temp);
			 }
				 
		 }
			 
		 }
		 
		 return requiredTraining;
		 
	 }
	 
	 
	public List<Trainings> getTrainingDetails() {
		/*
		 * 
		 * List<Trainings> all=trainingRepo.findAll(); List<PlannedTraining>
		 * pTraining=getAllPlannedTrainings(empId); List<Trainings> showTrainings=new
		 * ArrayList<Trainings>();
		 * 
		 * 
		 * for(Trainings t:all) {
		 * 
		 * for(PlannedTraining p:pTraining) {
		 * 
		 * if(!(p.getTrainingId().equals(t.getTrainingId())))
		 * 
		 * { showTrainings.add(t); } } } return showTrainings;
		 * 
		 */
	   return trainingRepo.findAll();
	}
	 
		 
	public ArrayList<ExamTest> getEmployeeScores(String certificationName) {
    	List<PlannedCertification> temp=plannedCerRepo.findAll();
    	for(PlannedCertification index:temp){
    	if(index.getExamName().contentEquals(certificationName)) {
    		return (ArrayList<ExamTest>) index.getTestMarks();
    	}
 
    	}
    	return null;
    }
	 
		
	 
}
	
	
	
	
		
