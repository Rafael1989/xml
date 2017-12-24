package br.com.alura.test;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.alura.model.Produto;

public class ReadXMLTest {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		fabrica.setValidating(true);
		fabrica.setNamespaceAware(true);
		fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		Document document = builder.parse("src/venda.xml");
		Element venda = document.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		System.out.println(moeda);
		NodeList element = document.getElementsByTagName("formaDePagamento");
		System.out.println(element.item(0).getTextContent());
		NodeList produtos = document.getElementsByTagName("produto");
		for(int i = 0;i < produtos.getLength();i++) {
			Element produto = (Element)produtos.item(i);
			Produto prod = new Produto(produto.getElementsByTagName("nome").item(0).getTextContent(), Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent()));
			System.out.println(prod);
		}
	}
}
