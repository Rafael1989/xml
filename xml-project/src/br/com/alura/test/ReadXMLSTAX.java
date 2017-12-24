package br.com.alura.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import br.com.alura.model.Produto;

public class ReadXMLSTAX {
	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		XMLInputFactory fabrica = XMLInputFactory.newInstance();
		XMLEventReader eventos = fabrica.createXMLEventReader(new FileInputStream("src/venda.xml"));
		System.out.println(getProdutos(eventos));
	}

	private static List<Produto> getProdutos(XMLEventReader eventos)
			throws XMLStreamException {
		Produto produto = null;
		List<Produto> produtos = new ArrayList<>();
		while(eventos.hasNext()) {
			
			XMLEvent evento = eventos.nextEvent();
			
			if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("produto")) {
				produto = new Produto();
			}else if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("nome")) {
				evento = eventos.nextEvent();
				String nome = evento.asCharacters().getData();
				produto.setNome(nome);
			}else if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("preco")) {
				evento = eventos.nextEvent();
				double preco = Double.parseDouble(evento.asCharacters().getData());
				produto.setPreco(preco);
			}else if(evento.isEndElement() && evento.asEndElement().getName().getLocalPart().equals("produto")) {
				produtos.add(produto);
			}
		}
		return produtos;
	}
}
