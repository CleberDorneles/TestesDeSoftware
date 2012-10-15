package com.dorneles.selenium.telas.brasileirao;

import com.dorneles.selenium.SeleniumWebDriver;

public class TelaArtilheirosBrasileiro {

	private SeleniumWebDriver selenium;

	public TelaArtilheirosBrasileiro(SeleniumWebDriver selenium) {
		this.selenium = selenium;
	}

	public void getArtilheiros() {
		selenium.clickByLinkText(localizarArtilharia());

		System.out.println("Artilheiros do Campeonato Brasileiro Série A");
		for (int i = 1; i <= 50; i++) {
			System.out.println(getCelulaTabelaClassificacao(i, 3) + "("
					+ getCelulaTabelaClassificacao(i, 2) + ")");
		}
	}

	private String localizarArtilharia() {
		return "Artilharia";
	}

	private String localizarCelulaTabelaArtilheiros(int nLinha, int nColuna) {
		return "table#marcados tbody tr:nth-of-type(" + nLinha
				+ ") td:nth-of-type(" + nColuna + ")";
	}

	private String getCelulaTabelaClassificacao(int nLinha, int nColuna) {
		return selenium.getText(localizarCelulaTabelaArtilheiros(nLinha,
				nColuna));
	}
}
