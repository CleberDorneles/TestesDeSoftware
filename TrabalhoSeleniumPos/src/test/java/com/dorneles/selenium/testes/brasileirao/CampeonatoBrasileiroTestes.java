package com.dorneles.selenium.testes.brasileirao;

import org.junit.Before;
import org.junit.Test;

import com.dorneles.selenium.SeleniumTest;
import com.dorneles.selenium.SeleniumWebDriver;
import com.dorneles.selenium.telas.brasileirao.TelaArtilheirosBrasileiro;
import com.dorneles.selenium.telas.brasileirao.TelaTabelaBrasileirao;

public class CampeonatoBrasileiroTestes extends SeleniumTest {

	TelaTabelaBrasileirao telaBrasileirao;
	SeleniumWebDriver selenium;

	@Before
	public void iniciar() {
		this.selenium = new SeleniumWebDriver(driver);
		this.telaBrasileirao = new TelaTabelaBrasileirao(selenium);
		this.telaBrasileirao.abrir();
	}

	@Test
	public void testeTimesClassificadosLibertadores2013() {
		telaBrasileirao.getTimesClassificadoresLibertadores2013();
		selenium.takeScreenshot();
	}

	@Test
	public void testeTimeRebaixadosSerieB2013() {
		telaBrasileirao.getTimesRebaixadosSerieB();
		selenium.takeScreenshot();
	}

	@Test
	public void testePalmeirasSeraRebaixado() {
		telaBrasileirao.getPalmeirasSeraRebaixadoSerieB();
		selenium.takeScreenshot();
	}

	@Test
	public void testeClassificacaoCorinthians() {
		telaBrasileirao.getClassificacaoCorinthians();
		selenium.takeScreenshot();
	}

	@Test
	public void testeAtleticoPRSeriaA() {
		telaBrasileirao.getDadosAtleticoPR();
		selenium.takeScreenshot();
	}

	@Test
	public void testeVerificarArtilheirosBrasileirao() {
		TelaArtilheirosBrasileiro telaArtilheiros = new TelaArtilheirosBrasileiro(
				selenium);

		telaArtilheiros.getArtilheiros();

		selenium.takeScreenshot();
	}

}
