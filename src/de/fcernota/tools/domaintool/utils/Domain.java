package de.fcernota.tools.domaintool.utils;
/**
 * Eine Domain z.B. chamaeleon.de
 * @author cernota
 *
 */
public class Domain {
	private String domain;
	
	public Domain(String domain){
		String[] givenDomain = domain.split("\\.");
		
		this.tld = givenDomain[givenDomain.length -1];
		this.domain = domain;
		this.domainWithoutTLDAndSubdomain = givenDomain[(givenDomain.length -2)];

		
	}
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getTld() {
		return tld;
	}
	public void setTld(String tld) {
		this.tld = tld;
	}
	public String getDomainWithoutTLDAndSubdomain() {
		return domainWithoutTLDAndSubdomain;
	}
	public void setDomainWithoutTLDAndSubdomain(String domainWithoutTLDAndSubdomain) {
		this.domainWithoutTLDAndSubdomain = domainWithoutTLDAndSubdomain;
	}
	private String tld;
	private String domainWithoutTLDAndSubdomain;
}
