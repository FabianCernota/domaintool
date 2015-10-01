package de.fcernota.tools.domaintool.whois.nodes;

import java.util.List;

public class WhoisResponse {
	Registrar registrar;
	List<TechnicalContact> technical_contacts;
	List<Nameserver> nameservers;
	
	public List<Nameserver> getNameservers() {
		return nameservers;
	}

	public void setNameservers(List<Nameserver> nameservers) {
		this.nameservers = nameservers;
	}

	public List<TechnicalContact> getTechnical_contacts() {
		return technical_contacts;
	}

	public void setTechnical_contacts(List<TechnicalContact> technical_contacts) {
		this.technical_contacts = technical_contacts;
	}

	public Registrar getRegistrar() {
		return registrar;
	}

	public void setRegistrar(Registrar registrar) {
		this.registrar = registrar;
	}
}
