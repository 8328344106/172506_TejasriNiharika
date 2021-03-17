package com.ct.CertificateTracker.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ct.CertificateTracker.model.Admin;
import com.ct.CertificateTracker.model.Certificate;
import com.ct.CertificateTracker.model.CoreCertificationDetails;
import com.ct.CertificateTracker.model.Employee;
import com.ct.CertificateTracker.model.EmployeeDetailsCertificationDetails;
import com.ct.CertificateTracker.model.ExamTest;
import com.ct.CertificateTracker.model.InternalTest;
import com.ct.CertificateTracker.model.PlannedCertification;
import com.ct.CertificateTracker.model.PlannedTraining;
import com.ct.CertificateTracker.model.Tower;
import com.ct.CertificateTracker.model.TrainingRegistrations;
import com.ct.CertificateTracker.model.Trainings;
import com.ct.CertificateTracker.model.voucher;
import com.ct.CertificateTracker.model.voucherInfo;
import com.ct.CertificateTracker.repository.AdminRepo;
import com.ct.CertificateTracker.repository.CertifiacationDetailsRepo;
import com.ct.CertificateTracker.repository.CertificateRepo;
import com.ct.CertificateTracker.repository.EmployeeRepo;
import com.ct.CertificateTracker.repository.InternalTestRepo;
import com.ct.CertificateTracker.repository.PlannedCerRepo;
import com.ct.CertificateTracker.repository.PlannedTrainingRepo;
import com.ct.CertificateTracker.repository.TrainingRepo;
import com.ct.CertificateTracker.repository.VoucherRepo;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@Service
public class AdminService {
	
	@Autowired
	private EmployeeRepo empRepository;
	
	@Autowired
	private CertificateRepo certificateRepo;
	
	@Autowired
	private CertifiacationDetailsRepo detailsRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	

	@Autowired
	private InternalTestRepo internalTestRepo;
	
	
	@Autowired
	private PlannedCerRepo plannedCerRepo;
	@Autowired
	private TrainingRepo trainingRepo;
	
	@Autowired
	private PlannedTrainingRepo plannedTrainingRepo;

	
	@Autowired
	private VoucherRepo voucherRepo;
	

	
	public List<Tower> getTowers() {
//		System.out.println("in admin service\\n\n\n\n");
		List<Employee> temp= empRepository.findAll();
		
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		  Map<String, List<Employee>> groupByTower = 
					temp.stream().collect(Collectors.groupingBy(Employee::getGlobalPractice));
                 System.out.println("details"+groupByTower.keySet());
		        
		  
		  
		  
		  Set set=groupByTower.entrySet();//Co enverting to Set so that we can traverse  
		    Iterator itr=set.iterator(); 
		    List<Tower> towers=new ArrayList<>();
		    while(itr.hasNext()){  
		    	Tower tower=new Tower();
		        //Converting to Map.Entry so that we can get key and value separately  
		    	Map.Entry entry=(Map.Entry)itr.next();  
		        tower.setTowerName((String)entry.getKey());
		        System.out.println(entry.getKey());
		        
		        
		        tower.setEmplist((List<Employee>) entry.getValue());
		        towers.add(tower);
		        
		        
		    }
		    
		    List<Certificate> allCertificates=certificateRepo.findAll();
		    List<CoreCertificationDetails> coreDetails=detailsRepo.findAll();
		    System.out.println(allCertificates);
		    for(Tower t:towers) {
		    	int count=0,ccount=0;
		    	
		    	List<Employee> employees=t.getEmplist();
		    	
		    	for(Employee e:employees)
		    	{	
		    		boolean havingCertification=false, havingCoreCertification=false;
		    	     for(Certificate c:allCertificates) {
		    	    	 if(e.getEmpId().equals((c.getEmpId()))) {
		    	    		 havingCertification=true;
		    	    		 for(CoreCertificationDetails cd:coreDetails)
		    	    		 {
		    	    			 if(c.getCerName().equalsIgnoreCase(cd.getCertificationName()))
		    	    			 {
		    	    				 if(cd.getCoreCeritification().equalsIgnoreCase("yes")) 
		    	    				 {
		    	    					 havingCoreCertification=true;
		    	    					 break;
		    	    				 }
		    	    			 }
		    	    		 }
		    	    		  
		    	    		 
		    	    	 }
		    	    		 
		    	    	 }
		    	     if(havingCertification)
		    	    	 count++;
		    	     if(havingCoreCertification)
		    	    	 ccount++;
		    	     }
		    	t.setTotalEmp(employees.size());
		    	t.setCertifiedEmp(count);
		    	t.setCoreCertified(ccount);
		    	t.setNonCoreCertified(count-ccount);
		    	double y=(((double)t.getCoreCertified()/t.getTotalEmp())*100);
		    	t.setCorePercentage((double)Math.round(y));
		    	double x=(((double)t.getCertifiedEmp()/t.getTotalEmp())*100);
		    	
		    	 t.setPercentage((double) Math.round(x));
		      
		    }
		    
		    
		    
		    
		    for(Tower t:towers) {
		    	System.out.println(t.getTowerName()+"  "+t.getTotalEmp()+"   "+t.getCertifiedEmp()+"    "+t.getCoreCertified()+"  "+t.getNonCoreCertified()+"   "+t.getPercentage()+"   "+t.getCorePercentage());
		    }
		    
		   
		    
		    
		    
		    return towers;
		        
	}
	
	
	
	public List<CoreCertificationDetails> getCertificateDetails(){
		return detailsRepo.findAll();
		
	}
	
	public CoreCertificationDetails addnewCertificate(CoreCertificationDetails c) {
		List<CoreCertificationDetails> allCer=detailsRepo.findAll();
		boolean existed=false;

		for(CoreCertificationDetails cer:allCer) {
			if((cer.getCertificationCategory().equalsIgnoreCase(c.getCertificationCategory() )) && (cer.getCertificationName().equalsIgnoreCase(c.getCertificationName()))) {
				System.out.println("its already thereeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				existed=true;
			}
			
		}

		if(existed)
			return null;
		else
		return detailsRepo.save(c);
		
		
	}
	
	public Admin loginValidate(Admin admin) {
		Optional<Admin> available=adminRepo.findById(admin.getEmpId());
		if(available.isPresent()) {
			Admin isThere= available.get();
			if(isThere.getPassword().contentEquals(admin.getPassword())){
				return isThere;
			}
		}
		
		return null;
		
		
	}
	
	public Admin register(Admin admin) {
		return adminRepo.save(admin);
		
	}
	
	
			 
		 
		public List<voucherInfo> getVoucherInfo(){
				List<voucher> allVouchers = voucherRepo.findAll();
				
				Map<String, List<voucher>> groupByCertificationName = allVouchers.stream().collect(
						Collectors.groupingBy(voucher::getExamName));
				// System.out.println("details"+groupByTower.keySet());

				Set set = groupByCertificationName.entrySet();
				Iterator itr = set.iterator();
				List<voucherInfo> displayedVouchers=new ArrayList<voucherInfo>();
				
				while (itr.hasNext()) {
					Map.Entry entry = (Map.Entry) itr.next();
					voucherInfo voucherInfo=new voucherInfo();
					voucherInfo.setCertificationName((String)entry.getKey());
					List<voucher> vo=(List<voucher>)entry.getValue(); 
					int availableCount=0,blockedCount=0,utilizedCount=0,expiredCount=0,totalCount=0;
					String stream=null;
					
					for(voucher v:vo){
						stream=v.getStream();
						if(v.getStatus().equalsIgnoreCase("Available"))
								availableCount++;
						else if(v.getStatus().equalsIgnoreCase("Blocked"))
							blockedCount++;
						else if(v.getStatus().equalsIgnoreCase("Utilized"))
							utilizedCount++;
						else if(v.getStatus().equalsIgnoreCase("Expired"))
							expiredCount++;
						
						totalCount++;
					}
					
					voucherInfo.setStream(stream);
					voucherInfo.setBlockedCount(blockedCount);
					voucherInfo.setTotalVouchers(totalCount);
					voucherInfo.setUtilizedCount(utilizedCount);
					voucherInfo.setExpiredCount(expiredCount);
					voucherInfo.setAvailableCount(availableCount);
					
					
					displayedVouchers.add(voucherInfo);
					
					
					
					 
						
					}
				
				/*for(VoucherInfo v:displayedVouchers)
				System.out.println(v);
				return null;
				*/	
					
				return displayedVouchers;
				
			} 
		 

	
	public List<PlannedCertification> getVoucherRequestedList(){
		List<PlannedCertification> allCer=plannedCerRepo.findAll();
		List<PlannedCertification> requestedCer=new ArrayList<PlannedCertification>();
		for(PlannedCertification p:allCer){
			if(p.getVoucherStatus()!=null) {
				if(p.getVoucherStatus().contentEquals("Requested")){
					requestedCer.add(p);
				}
				
			}
			
		}
		
		return requestedCer;
		
		
		
	}
	public List<voucher> getAllVouchers(String examName){
	  List<voucher> allVouchers= voucherRepo.findAll();
	 
	  List<voucher> requiredVouchers=new ArrayList<voucher>();
	  for(voucher v:allVouchers)
	  {
		  if(v.getExamName().contentEquals(examName) && !((v.getStatus().equalsIgnoreCase("Utilized"))) && !((v.getStatus().equalsIgnoreCase("Expired"))))
		  {
			  requiredVouchers.add(v);
		  }
	  }
	  return requiredVouchers;
	}
	
	public PlannedCertification checkVoucherAvailability(PlannedCertification pC){
		List<voucher> allVoucher=voucherRepo.findAll();
		List<PlannedCertification> allPlannedCert=plannedCerRepo.findAll();
		
		for(voucher v:allVoucher){
			if(v.getExamName().contentEquals(pC.getExamName())  &&(v.getVoucherCode().contentEquals(pC.getVoucherCode())))
			{
				if(v.getStatus().equalsIgnoreCase("Blocked"))
				{
					String empId=v.getEmpId();
					for(PlannedCertification p:allPlannedCert)
					{

					if(p.getEmpID().equals(empId))
					{
						p.setVoucherStatus("Requested");
						p.setVoucherCode(null);
						p.setVoucherAssignedDate(null);
						plannedCerRepo.save(p);

					}
					}
				}
				
				v.setEmpId(pC.getEmpID());
				v.setEmpName(pC.getEmpName());
				v.setStatus("Blocked");
			
				
				voucherRepo.save(v);
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
					String date = sdf.format(new Date());
					pC.setVoucherAssignedDate(date);
				plannedCerRepo.save(pC);
				
				System.out.println(pC);
				return pC;
			}
			
		}
		return null;
		
		
	}
	public List<Trainings> getTrainingDetails(){
		return trainingRepo.findAll();
		
	}
	public List<Employee> getAllEmployee(){
		return empRepository.findAll();
		
	}

	
	
	public Trainings  addnewTraining(Trainings t) 
	{	
		t.setConfirmedOrApproved(0);
		t.setSeatsRemaining(t.getCapacity());
		return trainingRepo.save(t);
			
	}
	 public Trainings findById(String _id)
		{
	     return trainingRepo.findBy_id(_id);
	   }
	 public  void deleteTraining(Trainings training)
	   {

		 trainingRepo.delete(training);
	   }
	 
	 
	 public List<voucher> allVouchers(){
		 return voucherRepo.findAll();
		 
	 }
	 public CoreCertificationDetails updateCertificationDetails(CoreCertificationDetails c){
	 			List<CoreCertificationDetails> details=detailsRepo.findAll();
	 			for(CoreCertificationDetails index:details){
	 				
	 				if(index.get_id().equals(c.get_id())){
	 					c.set_id(index.get_id());
	 				}
	 			}
	 			return detailsRepo.save(c);
	 		} 
	 		
	 		public voucher updateVoucher(voucher v){
	 			List<voucher> allvoucher=voucherRepo.findAll();
	 			for(voucher index:allvoucher){
	 				
	 				if((index.getVoucherCode().equals(v.getVoucherCode()))){
	 					v.set_id(index.get_id());
	 				}
	 			}
	 			return voucherRepo.save(v);
	 		} 
	 		
	 		
	 		
	 		public void deleteCertificationDetails(String id) {
	 			Optional<CoreCertificationDetails> details=detailsRepo.findById(id);
	 			detailsRepo.delete(details.get());
	 			
	 		} 
	  
	 		 public List<EmployeeDetailsCertificationDetails> allCertificatesEmp(){
	 			 
	 			 List<Certificate> cer= certificateRepo.findAll();
	 			 List<EmployeeDetailsCertificationDetails> certList=new ArrayList<EmployeeDetailsCertificationDetails>();
	 			 List<Employee> emp=empRepository.findAll();
	 			 System.out.println("count:"+empRepository.count());
				 String globalPractice=null,location=null,localGrade=null;

	 			 for(Certificate c:cer)
	 			 {
	 				 for(Employee em:emp)
	 				 {
	 					 if(em.getEmpId().contentEquals(c.getEmpId()))
	 					 {
	 						 globalPractice=em.getGlobalPractice();
	 						 location=em.getLocation();
	 						 localGrade=em.getLocalGrade();
	 					 
	 				 
	 				 EmployeeDetailsCertificationDetails d=
	 						 new EmployeeDetailsCertificationDetails(c.get_id(),c.getEmpId(),c.getEmpName(), 
	 								 c.getCerCategory(), c.getCerName(), c.getCerDate(), c.getExpDate(), 
	 								 c.getCerMonth(), c.getExamScore(), c.getVoucherCode(), localGrade, 
	 								 location, globalPractice,c.getFileName(),c.getFile());
	 				 certList.add(d);
	 					 }
	 				 }
	 				
	 			 }
	 			 
	 			 
	 			 return certList;
	 			 
	 		 }
	 		
	 		 
	 	public List<PlannedTraining> viewingOfRegistrationsOfTrainings (){
	 		
	 		List<TrainingRegistrations> all=plannedTrainingRepo.findAll();
	 		
	 		List<TrainingRegistrations> requestedList=new ArrayList<TrainingRegistrations>();
	 		for(TrainingRegistrations t:all) {
	 			if(t.getNominationStatus().contentEquals("Requested"))
	 				requestedList.add(t);
	 			
	 		}
	 		
	 		//return requestedList;
	 		List<PlannedTraining> reqPlannedTrainings=new ArrayList<>();
	 		List<Trainings> allT=trainingRepo.findAll();
			 String status=null,location=null,startDate=null,endDate=null;
	 		
	 		for(TrainingRegistrations t:requestedList) {
	 			
	 			
	 			for(Trainings tr:allT) {
					 if(tr.getTrainingId().contentEquals(t.getTrainingId())) {
						 status=tr.getStatus();
						 location=tr.getLocation();
						 startDate=tr.getStartDate();
						 endDate=tr.getEndDate();
					 }
				 }
	 			 PlannedTraining temp=new PlannedTraining(t.getEmpId(), t.getEmpName(), t.getTrainingId(),t.getTrainingName(), status, t.getNominationStatus(), t.getRequestDate(), startDate, endDate, location);
	 			 temp.set_id(t.get_id());
	 			 reqPlannedTrainings.add(temp);	
	 			
	 		}
	 		
	 		return reqPlannedTrainings;
	 		
	 		
	 		
	 	}
	 	
	 	public TrainingRegistrations approveTrainingReg(TrainingRegistrations t) {
	 		
	 		
	 		List<Trainings> all=trainingRepo.findAll();
	 		Trainings temp=null;
	 		for(Trainings ta:all) {
	 			if(ta.getTrainingId().contentEquals(t.getTrainingId())) {
	 				temp=ta;
	 				break;
	 				
	 			}
	 		}
	 		
	 		temp.setSeatsRemaining(temp.getSeatsRemaining()-1);
	 		temp.setInterestsReceived(temp.getInterestsReceived()-1);
	 		temp.setConfirmedOrApproved(temp.getConfirmedOrApproved()+1);
	 		
	 		trainingRepo.save(temp);
	 		
	 		t.setNominationStatus("Approved");
	 		return plannedTrainingRepo.save(t);
	 		
	 		
	 	}
  
		 public List<Trainings> findByTrainingId(String trainingId){
 			 return trainingRepo.findByTrainingId(trainingId);
 			 
 		 }

		 
		 public Trainings updateTraining(Trainings t){
	 			List<Trainings> trainings=trainingRepo.findAll();
	 			for(Trainings index:trainings){
	 				
	 				if((index.getTrainingId().equals(t.getTrainingId()))){
	 					
	 					t.set_id(index.get_id());
	 				}
	 			}
					t.setSeatsRemaining(t.getCapacity()-t.getConfirmedOrApproved());

	 			return trainingRepo.save(t);
	 		} 

		 
			public int saveDataOfExcel(MultipartFile file)
					throws IOException, InvalidFormatException,
					EncryptedDocumentException,
					org.apache.poi.openxml4j.exceptions.InvalidFormatException {
				//SAMPLE_XLSX_FILE_PATH = "C:\\Users\\surmitra\\Desktop\\ExcelData\\VoucherMaster.xls";

				File tempFile = File.createTempFile("temp","xlsx");
				tempFile.deleteOnExit();
			     
			     file.transferTo(tempFile);
			     
			     
			     
			     
				
				
				FileInputStream fip=new FileInputStream(tempFile);
				
				
				
				Workbook workbook = WorkbookFactory.create(fip);

				int dataInserted = 0;

				// Retrieving the number of sheets in the Workbook
				System.out.println("Workbook has " + workbook.getNumberOfSheets()
						+ " Sheets : ");

				// 2. Or you can use a for-each loop
				System.out.println("Retrieving Sheets using for-each loop");
				for (Sheet sheet : workbook) {
					System.out.println("=> " + sheet.getSheetName());
				}
				// Getting the Sheet at index zero
				Sheet sheet = workbook.getSheetAt(0);

				// Create a DataFormatter to format and get each cell's value as String
				DataFormatter dataFormatter = new DataFormatter();

				System.out
						.println("\n\nIterating over Rows and Columns using for-each loop\n");
				int i = 0;
				boolean rightFile=false;

				int colNum = sheet.getRow(0).getLastCellNum();
				
				
				if(colNum==53){
					String firstClName=dataFormatter.formatCellValue(sheet.getRow(0).getCell(0));
					String lastClName=dataFormatter.formatCellValue(sheet.getRow(0).getCell(52));
					
					if(firstClName.contentEquals("Employee no") && lastClName.contentEquals("Actual billed on account"));
					 rightFile=true;
					
					
					
				}
				
				
				
				if(rightFile){
					empRepository.deleteAll();
				
				
				for (Row row : sheet) {
					List<Employee> allAvailableEmployees = empRepository.findAll();
					

					
					if (i > 0) {

						Employee temp=new Employee();
						ArrayList<String> data = new ArrayList<String>();

						for (int cl = 0; cl < colNum; cl++) {

							String cellValue = dataFormatter.formatCellValue(row
									.getCell(cl));
							data.add(cellValue);

						}

						int count = 0;
						for (String s : data) {
							if (s.equals("")) {
								count++;
							}

						}

						if (count == data.size())
							break;

						System.out.println(data);

						temp.setEmpId(data.get(0));
						temp.setEmpName(data.get(1));
						temp.setLocalGrade(data.get(2));
						temp.setGrade(data.get(3));
						temp.setMode(data.get(4));
						temp.setFresherOrlateral(data.get(5));
						temp.setCloudDoj(data.get(6));
						temp.setJoiningDate(data.get(7));
						temp.setOffice(data.get(8));
						temp.setLocation(data.get(9));
						temp.setSeat(data.get(10));
						temp.setEmail(data.get(11));
						temp.setBenchStartDate(data.get(12));
						temp.setAgingDays(data.get(13));
						temp.setAgingStatus(data.get(14));
						temp.setStatusSince(data.get(15));
						temp.setAgeofStatus(data.get(16));
						temp.setLevel1(data.get(17));
						temp.setLevel3EngagementRole(data.get(18));
						temp.setGlobalPractice(data.get(19));
						temp.setResignedLwd(data.get(20));
						temp.setLoanedOut(data.get(21));
						temp.setCurrentWeekStatus(data.get(22));
						temp.setStaffingAvailable(data.get(23));
						temp.setFinalStaffingAvailable(data.get(24));
						temp.setBillability(data.get(25));
						temp.setComments(data.get(26));
						temp.setFinalStatus(data.get(27));
						temp.setProposedOrPendedTo(data.get(28));
						temp.setProjectedStartDate(data.get(29));
						temp.setProjectedEndDate(data.get(30));
						temp.setCurrentAccount(data.get(31));
						temp.setProjectCode(data.get(32));
						
						temp.setProjectName(data.get(33));
						
						
						temp.setStartDate(data.get(34));
						temp.setEndDate(data.get(35));
						temp.setCodeIssue(data.get(36));
						temp.setSectorAreaMarketUnit(data.get(37));
						temp.setPrimarySkill(data.get(38));
						temp.setSkill1Dasboarding(data.get(39));
						temp.setFresherType(data.get(40));
						temp.setBatch(data.get(41));
						temp.setPromotedOn(data.get(42));
						temp.setStatus(data.get(43));
						temp.setTrainingStartDate(data.get(44));
						temp.setTrainingEndDate(data.get(45));
						temp.setTrainingStream(data.get(46));
						temp.setShadowProject(data.get(47));
						temp.setShadowStart(data.get(48));
						temp.setShadowEnd(data.get(49));
						temp.setProjectedBillling(data.get(50));
						temp.setActualBillingDate(data.get(51));
						temp.setActualBilledOnAccount(data.get(52));

						boolean existed = false;

						for (Employee e : allAvailableEmployees) {
							if (e.getEmpId().contentEquals(temp.getEmpId())
									&& e.getEmpName()
											.contentEquals(temp.getEmpName())) {
								existed = true;

							}
						}

						if (!existed) {

							empRepository.save(temp);
							dataInserted++;

						}

						System.out.println(temp);
						System.out.println();

					}
					i++;

				}

				// Closing the workbook
				workbook.close();
				
				}

				return dataInserted;
			}
			
			public InternalTest getTests(String certificationName) {
		    	Optional<InternalTest> temp=internalTestRepo.findById(certificationName);
		    	if(temp.isPresent()) {
		    		return temp.get();
		    	}
		    	else
		    		return  null;
		    	
		    	
		    }
		    
		    public ArrayList<ExamTest> getOnlyTests(String certificationName) {
		    	List<InternalTest> temp=internalTestRepo.findAll();
		    	for(InternalTest index:temp){
		    	if(index.getCertificationName().contentEquals(certificationName)) {
		    		System.out.println(index.getTests());
		    		return index.getTests();
		    	}
		 
		    	}
		    	return null;
		    }
		    

			 public InternalTest addTest(InternalTest c) {
				return internalTestRepo.save(c);
				 
			 }

		 
}
