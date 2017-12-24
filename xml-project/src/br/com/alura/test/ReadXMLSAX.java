package br.com.alura.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.handler.ProdutoHandler;

public class ReadXMLSAX {

	public static void main(String[] args) throws SAXException, FileNotFoundException, IOException {
		XMLReader xmlReader = XMLReaderFactory.createXMLReader();
		ProdutoHandler produtoHandler = new ProdutoHandler();
		xmlReader.setContentHandler(produtoHandler);
		xmlReader.parse(new InputSource(new FileInputStream("src/venda.xml")));
		System.out.println(produtoHandler.getProdutos());
	}
}
