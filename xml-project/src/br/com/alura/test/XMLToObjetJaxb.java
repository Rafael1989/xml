package br.com.alura.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.alura.model.Produto;
import br.com.alura.model.Venda;

public class XMLToObjetJaxb {
	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/venda.xml"));
		
		System.out.println(venda);
		
		Venda venda2 = new Venda();
		
		venda2.setFormaDePagamento("Débito");
		List<Produto> produtos = new ArrayList<>();
		Produto produto = new Produto();
		produto.setNome("Tênis");
		produto.setPreco(24.69);
		produtos.add(produto);
		venda2.setProdutos(produtos);
		
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(venda2, new File("src/xmlGerado.xml"));
	}
}
