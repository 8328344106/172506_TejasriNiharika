package com.ct.CertificateTracker.model;

public class voucherInfo {
	

	private String stream;
	private String certificationName;
	private int blockedCount;
	private int utilizedCount;
	private int totalVouchers;
	private int expiredCount;
	private int availableCount;
	/**
	 * @return the stream
	 */
	public String getStream() {
		return stream;
	}
	/**
	 * @param stream the stream to set
	 */
	public void setStream(String stream) {
		this.stream = stream;
	}
	/**
	 * @return the certificationName
	 */
	public String getCertificationName() {
		return certificationName;
	}
	/**
	 * @param certificationName the certificationName to set
	 */
	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}
	/**
	 * @return the blockedCount
	 */
	public int getBlockedCount() {
		return blockedCount;
	}
	/**
	 * @param blockedCount the blockedCount to set
	 */
	public void setBlockedCount(int blockedCount) {
		this.blockedCount = blockedCount;
	}
	/**
	 * @return the utilizedCount
	 */
	public int getUtilizedCount() {
		return utilizedCount;
	}
	/**
	 * @param utilizedCount the utilizedCount to set
	 */
	public void setUtilizedCount(int utilizedCount) {
		this.utilizedCount = utilizedCount;
	}
	/**
	 * @return the totalVouchers
	 */
	public int getTotalVouchers() {
		return totalVouchers;
	}
	/**
	 * @param totalVouchers the totalVouchers to set
	 */
	public void setTotalVouchers(int totalVouchers) {
		this.totalVouchers = totalVouchers;
	}
	/**
	 * @return the expiredCount
	 */
	public int getExpiredCount() {
		return expiredCount;
	}
	/**
	 * @param expiredCount the expiredCount to set
	 */
	public void setExpiredCount(int expiredCount) {
		this.expiredCount = expiredCount;
	}
	/**
	 * @return the availableCount
	 */
	public int getAvailableCount() {
		return availableCount;
	}
	/**
	 * @param availableCount the availableCount to set
	 */
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	public voucherInfo(String stream, String certificationName,
			int blockedCount, int utilizedCount, int totalVouchers,
			int expiredCount, int availableCount) {
		super();
		this.stream = stream;
		this.certificationName = certificationName;
		this.blockedCount = blockedCount;
		this.utilizedCount = utilizedCount;
		this.totalVouchers = totalVouchers;
		this.expiredCount = expiredCount;
		this.availableCount = availableCount;
	}
	public voucherInfo() {
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "voucherInfo [stream=" + stream + ", certificationName="
				+ certificationName + ", blockedCount=" + blockedCount
				+ ", utilizedCount=" + utilizedCount + ", totalVouchers="
				+ totalVouchers + ", expiredCount=" + expiredCount
				+ ", availableCount=" + availableCount + "]";
	}

}
