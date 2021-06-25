package com.cakedeliver.cakedeliver.enums;

public enum ClassificacaoAvaliacao {

	HORRIVEL(1,"Horrível"), RUIM(2,"Ruim"), RAZOAVEL(3,"Razoável"), MUITO_BOM(4,"Muito Bom"), EXCELENTE(5,"Excelente");
	
	
	// Classificação em estrelas de 1-Horrivel, 2- Ruim, 3- Razoavel, 4- Muito bom e 5- Excelente 
	
	private int cod;
	private String desc;
	
	private ClassificacaoAvaliacao(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}
	
	
	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}



	public static ClassificacaoAvaliacao toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (ClassificacaoAvaliacao x : ClassificacaoAvaliacao.values())
			if (cod.equals(x.getCod())) {
				return x;
			}
		throw new IllegalAccessError("código inválido" + cod);
	}
}
