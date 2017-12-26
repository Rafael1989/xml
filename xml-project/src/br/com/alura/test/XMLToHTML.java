package br.com.alura.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLToHTML {
	public static void main(String[] args) throws FileNotFoundException, TransformerFactoryConfigurationError, TransformerException {
		InputStream xsl = new FileInputStream("src/xmlToHtml.xsl");
		StreamSource xslSource = new StreamSource(xsl);
		InputStream xml = new FileInputStream("src/venda.xml");
		StreamSource xmlSource = new StreamSource(xml);
		Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSource);
		StreamResult streamResult = new StreamResult("src/venda.html");
		transformer.transform(xmlSource, streamResult);
	}
}
