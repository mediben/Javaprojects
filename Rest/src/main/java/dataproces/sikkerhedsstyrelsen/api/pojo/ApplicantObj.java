package dataproces.sikkerhedsstyrelsen.api.pojo;

public class ApplicantObj {


	private int id ;
	private String fullName = null;
	private String PrivateAddress= null;
	private String ZipCode= null;
	private String City= null;
	private String Country= null;
	private String MobileNumber= null;
	private String EmailAddress= null;
	private String PyroNumber= null;
	private String PassportFilePath= null;
	private boolean HasCertificate;
	private String CvOrCertificateFilePath= null;
	private boolean IsEducated;
	private String InsuranceFilePath= null;
	private boolean Status;
	private boolean SceneFireworker;
	
	
	public ApplicantObj() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ApplicantObj(int id, String fullName, String privateAddress, String zipCode, String city, String country,
			String mobileNumber, String emailAddress, String pyroNumber, String passportFilePath,
			boolean hasCertificate, String cvOrCertificateFilePath, boolean isEducated, String insuranceFilePath,
			boolean status, boolean sceneFireworker) {
		super();
		this.id = id;
		this.fullName = fullName;
		PrivateAddress = privateAddress;
		ZipCode = zipCode;
		City = city;
		Country = country;
		MobileNumber = mobileNumber;
		EmailAddress = emailAddress;
		PyroNumber = pyroNumber;
		PassportFilePath = passportFilePath;
		HasCertificate = hasCertificate;
		CvOrCertificateFilePath = cvOrCertificateFilePath;
		IsEducated = isEducated;
		InsuranceFilePath = insuranceFilePath;
		Status = status;
		SceneFireworker = sceneFireworker;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getPrivateAddress() {
		return PrivateAddress;
	}


	public void setPrivateAddress(String privateAddress) {
		PrivateAddress = privateAddress;
	}


	public String getZipCode() {
		return ZipCode;
	}


	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getCountry() {
		return Country;
	}


	public void setCountry(String country) {
		Country = country;
	}


	public String getMobileNumber() {
		return MobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}


	public String getEmailAddress() {
		return EmailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}


	public String getPyroNumber() {
		return PyroNumber;
	}


	public void setPyroNumber(String pyroNumber) {
		PyroNumber = pyroNumber;
	}


	public String getPassportFilePath() {
		return PassportFilePath;
	}


	public void setPassportFilePath(String passportFilePath) {
		PassportFilePath = passportFilePath;
	}


	public boolean isHasCertificate() {
		return HasCertificate;
	}


	public void setHasCertificate(boolean hasCertificate) {
		HasCertificate = hasCertificate;
	}


	public String getCvOrCertificateFilePath() {
		return CvOrCertificateFilePath;
	}


	public void setCvOrCertificateFilePath(String cvOrCertificateFilePath) {
		CvOrCertificateFilePath = cvOrCertificateFilePath;
	}


	public boolean isIsEducated() {
		return IsEducated;
	}


	public void setIsEducated(boolean isEducated) {
		IsEducated = isEducated;
	}


	public String getInsuranceFilePath() {
		return InsuranceFilePath;
	}


	public void setInsuranceFilePath(String insuranceFilePath) {
		InsuranceFilePath = insuranceFilePath;
	}


	public boolean isStatus() {
		return Status;
	}


	public void setStatus(boolean status) {
		Status = status;
	}




	public boolean isSceneFireworker() {
		return SceneFireworker;
	}


	public void setSceneFireworker(boolean sceneFireworker) {
		SceneFireworker = sceneFireworker;
	}

	
	
}
