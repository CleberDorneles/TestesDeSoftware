package com.dorneles.selenium.telas.brasileirao;

import com.dorneles.selenium.SeleniumWebDriver;

public class TelaTabelaBrasileirao {

	private SeleniumWebDriver selenium;
	private static final String URL = "http://esporte.uol.com.br/futebol/campeonatos/brasileiro/2012/serie-a/classificacao/classificacao.htm";

	public TelaTabelaBrasileirao(SeleniumWebDriver selenium) {
		this.selenium = selenium;
	}

	public void abrir() {
		selenium.driver.get(URL);
		selenium.assertTitle("Classificação do Campeonato Brasileiro 2012 de Futebol - UOL Esporte");
	}

	public void getTimesClassificadoresLibertadores2013() {
		getClassificadosLibertadores();
	}

	public void getTimesRebaixadosSerieB() {
		getRebaixadosSerieB();
	}

	public void getPalmeirasSeraRebaixadoSerieB() {
		if (getPalmeirasSeraRebaixado())
			System.out.println("O Palmeiras será rebaixado para a série B!");
		else
			System.out
					.println("O Palmeiras não será rebaixado para a série B!");
	}

	public void getClassificacaoCorinthians() {
		getDadosCorinthians();
	}

	public void getDadosAtleticoPR() {
		if (getAtleticoPRSeriaA() == true)
			System.out.println("O Atlético-PR está na primeira divisão!");
		else
			System.out.println("O Atlético-PR não está na primeira divisão!");
	}

	private void getClassificadosLibertadores() {
		System.out
				.println("Pontuação dos times classificados para a libertadores!");
		System.out.println("Pos Time          PG  J  V  E  D GP GC  SG (%)");
		System.out.println("--- ------------- -- -- -- -- -- -- -- --- ---");
		for (int i = 1; i <= 4; i++) {
			String pos = getPosicao(i, 1);
			String time = getTime(i, 1);
			String pg = getCelulaTabelaClassificacao(i, 2);
			String j = getCelulaTabelaClassificacao(i, 3);
			String v = getCelulaTabelaClassificacao(i, 4);
			String e = getCelulaTabelaClassificacao(i, 5);
			String d = getCelulaTabelaClassificacao(i, 6);
			String gp = getCelulaTabelaClassificacao(i, 7);
			String gc = getCelulaTabelaClassificacao(i, 8);
			String sg = getCelulaTabelaClassificacao(i, 9);
			String perc = getCelulaTabelaClassificacao(i, 10);

			System.out.printf("%2s", pos + "   ");
			System.out.printf("%14s", time + " ");
			System.out.printf("%3s", pg + " ");
			System.out.printf("%3s", j + " ");
			System.out.printf("%3s", v + " ");
			System.out.printf("%3s", e + " ");
			System.out.printf("%3s", d + " ");
			System.out.printf("%3s", gp + " ");
			System.out.printf("%3s", gc + " ");
			System.out.printf("%4s", sg + " ");
			System.out.printf("%2s%n", perc);
		}
	}

	private void getRebaixadosSerieB() {
		System.out.println("Times Rebaixados para a série B!");
		for (int i = 17; i <= 20; i++) {
			String pos = getPosicao(i, 1);
			String time = getTime(i, 1);
			System.out.println(pos + " - " + time);
		}
	}

	private Boolean getPalmeirasSeraRebaixado() {
		for (int i = 17; i <= 20; i++) {
			String time = getTime(i, 1);
			if (time.equalsIgnoreCase("palmeiras"))
				return true;
		}
		return false;
	}

	private void getDadosCorinthians() {
		String pos = new String();
		String pg = new String();
		for (int i = 1; i <= 20; i++) {
			pos = getPosicao(i, 1);
			String time = getTime(i, 1);
			pg = getCelulaTabelaClassificacao(i, 2);
			if (time.equalsIgnoreCase("corinthians"))
				i = 21;
		}
		System.out.println("O Corinthians está na " + pos + "o. posição com "
				+ pg + " pontos ganhos!");
	}

	private Boolean getAtleticoPRSeriaA() {
		for (int i = 1; i <= 20; i++) {
			String time = getTime(i, 1);
			if (time.equalsIgnoreCase("atlético-pr"))
				return true;
		}
		return false;
	}

	private String getCelulaTabelaClassificacao(int nLinha, int nColuna) {
		return selenium.getText(localizarCelulaTabelaClassificacao(nLinha,
				nColuna));
	}

	private String getPosicao(int nLinha, int nColuna) {
		return selenium.getText(localizarPosicao(nLinha, nColuna));
	}

	private String getTime(int nLinha, int nColuna) {
		return selenium.getText(localizarTime(nLinha, nColuna));
	}

	public String localizarCelulaTabelaClassificacao(int nLinha, int nColuna) {
		return "table#classificationTable.gameTable.has-js tbody tr:nth-of-type("
				+ nLinha + ") td:nth-of-type(" + nColuna + ")";
	}

	public String localizarPosicao(int nLinha, int nColuna) {
		return "table#classificationTable.gameTable.has-js tbody tr:nth-of-type("
				+ nLinha + ") td:nth-of-type(" + nColuna + ") span";
	}

	public String localizarTime(int nLinha, int nColuna) {
		return "table#classificationTable.gameTable.has-js tbody tr:nth-of-type("
				+ nLinha + ") td:nth-of-type(" + nColuna + ") a";
	}
}
