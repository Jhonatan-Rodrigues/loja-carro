package br.com.jrodrigues.test;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.jrodrigues.dao.AcessorioDao;
import br.com.jrodrigues.dao.CarroDao;
import br.com.jrodrigues.dao.IAcessorioDao;
import br.com.jrodrigues.dao.ICarroDao;
import br.com.jrodrigues.dao.IMarcaDao;
import br.com.jrodrigues.dao.MarcaDao;
import br.com.jrodrigues.domain.Acessorio;
import br.com.jrodrigues.domain.Carro;
import br.com.jrodrigues.domain.Marca;

public class TestCarros {

	private ICarroDao carroDao;
	private IMarcaDao marcaDao;
	private IAcessorioDao acessorioDao;

	public TestCarros() {
		carroDao = new CarroDao();
		marcaDao = new MarcaDao();
		acessorioDao = new AcessorioDao();
	}

	@Test
	public void cadastrar() {
		Carro carro = new Carro();
		carro.setCodigo("A1");
		carro.setNome("208");
		carro.setAno(2024);
		carro = carroDao.cadastrar(carro);

		
		Marca marca = new Marca();
		marca.setCodigo("A1");
		marca.setNome("Peugeot");
		marca.setCarro(carro);
		marca = marcaDao.cadastrar(marca);
	
		Acessorio acess = new Acessorio();
		acess.setCodigo("A1");
		acess.setNome("Step");
		acess.setValor(350d);
		acess.setCarro(carro);
		acess =  acessorioDao.cadastrar(acess);
		


		assertNotNull(carro);
		assertNotNull(carro.getId());
		
		assertNotNull(acess);
		assertNotNull(acess.getId());
		
		assertNotNull(marca);
		assertNotNull(marca.getId());

	}



}
