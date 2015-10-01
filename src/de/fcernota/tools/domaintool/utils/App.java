package de.fcernota.tools.domaintool.utils;

import com.github.lalyos.jfiglet.FigletFont;

import de.fcernota.tools.domaintool.whois.Whois;

/**
 * Hauptklasse
 * 
 * @author cernota
 *
 */
public class App {

	public static void main(String[] args) {
		Domain domain = new Domain(args[0]);
		String asciiArt = FigletFont.convertOneLine("Domaintool");
		System.out.println(asciiArt);
		if(App.class.getPackage().getImplementationVersion() == null){
			System.out.println("Entwicklerversion");
		}else{
			System.out.println("Version: " + App.class.getPackage().getImplementationVersion());
		}
		
		System.out.println("============================");
		System.out.println("Domaintool gestartet für: " + domain.getDomainWithoutTLDAndSubdomain());
		System.out.println("============================");
		
		System.out.println("WHOIS");
		Whois whois = new Whois(domain);
		
		
	}

}
