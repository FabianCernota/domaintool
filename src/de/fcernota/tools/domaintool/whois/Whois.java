package de.fcernota.tools.domaintool.whois;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

import de.fcernota.tools.domaintool.utils.Domain;
import de.fcernota.tools.domaintool.whois.nodes.Nameserver;
import de.fcernota.tools.domaintool.whois.nodes.WhoisResponse;

/**
 * Abfrage von Domain Besitzer
 * 
 * @author cernota
 *
 */
public class Whois {
	public Whois(Domain domain) {
		try {
			URL whoisURL = new URL(
					"http://whoiz.herokuapp.com/lookup.json?url="
							+ domain.getDomain());

			StringBuilder sb = new StringBuilder();
			BufferedReader r = new BufferedReader(new InputStreamReader(
					new DataInputStream(whoisURL.openStream())));
			for (String line = r.readLine(); line != null; line = r.readLine()) {
				sb.append(line);
			}
			Gson g = new Gson();
			WhoisResponse wr = g.fromJson(sb.toString(), WhoisResponse.class);

			// Ausgabe
			//Registry
			System.out.println("===================");
			System.out.println("Registrierungsstelle:");
			System.out.println("Name: " + wr.getRegistrar().getName());
			System.out.println("Organisation: "
					+ wr.getRegistrar().getOrganization());
			System.out.println("===================");
			//Tech-C
			System.out.println("TECH-C: ");
			System.out.println("Name: "
					+ wr.getTechnical_contacts().get(0).getName());
			System.out.println("Organisation: "
					+ wr.getTechnical_contacts().get(0).getOrganization());
			System.out.println("Adresse:\n "
					+ wr.getTechnical_contacts().get(0).getAddress() + "\n "
					+ wr.getTechnical_contacts().get(0).getZip() + "\n "
					+ wr.getTechnical_contacts().get(0).getCity() + "\n "
					+ wr.getTechnical_contacts().get(0).getCountry_code());
			System.out.println("===================");
			System.out.println("Nameserver: ");
			//Nameservers
			for(Nameserver n : wr.getNameservers()){
				System.out.println("Name: " + n.getName());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
