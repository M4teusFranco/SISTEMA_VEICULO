package ex1;

class ex1 {

	// Declaração da Classe Veículo
	public static class Veiculo {
		private String modelo;	// Atributos da Classe Veículo
		private String anofabri;
		private String cor;
		
		public String getModelo() {
			return modelo; // Acessa Modelo privado para as Classes herdeiras
		}
		
		public void setModelo(String modelo) {
			this.modelo = modelo; // Permite a modificação do Modelo privado para as Classes herdeiras
		}
		
		public String getCor() {
			return cor; // Acessa Cor privada para as Classes herdeiras
		}
		
		public void setCor(String cor) {
			this.cor = cor; // Permite a modificação da Cor privada para as Classes herdeiras
		}
		
		
		public String getAnoFabri() {
			return anofabri; // Acessa Ano de Fabricação privado para as Classes herdeiras
		}
		
		public void setAnoFabri(String anofabri) {
			this.anofabri = anofabri; // Permite a modificação do Ano de Fabricação privado para as Classes herdeiras
		}

		// Método para gerar comando Insert no SQL 
		public String gerarInsert() {
			return String.format("INSERT INTO Veiculo (modelo, anofabri, cor) VALUES ('%s', '%s', '%s');", 
			modelo, anofabri, cor);
		}
	}
	
	// Declaração da Classe Automotor herdando a Classe Veículo
		public static class Automotor extends Veiculo {
			private String montadora;	// Atributos da Classe Automotor
			private String cor;
			private double km;
		
			public String getMontadora() {
				return montadora; // Acessa Montadora privada para as Classes herdeiras
			}
			
			public void setMontadora(String montadora) {
				this.montadora = montadora; // Permite a modificação da Montadora privada para as Classes herdeiras
			}
			
			
			public double getKM() {
				return km; // Acessa kilometragem privada para as Classes herdeiras
			}
			
			public void setKM(double km) {
				this.km = km; // Permite a modificação da kilometragem privada para as Classes herdeiras
			}
			
			// Método para gerar comando Insert Automotor no SQL
			@Override
			public String gerarInsert() {
				return String.format("INSERT INTO Automotor (modelo, anofabri, cor, montadora, km) VALUES ('%s', '%s', '%s', '%s', %.2f);",
					getModelo(), getAnoFabri(), getCor(), montadora, km);
			}
		}
		
		// Declaração da Classe de Veículos não-automotores herdando a Classe Veículo
		public static class Nao_Automotor extends Veiculo {
			private String marca;	// Atributo da Classe Não-Automotores
		
			public String getMarca() {
				return marca; // Acessa Marca privada para as Classes herdeiras
			}
			
			public void setMarca(String marca) {
				this.marca = marca; // Permite a modificação da Marca privada para as Classes herdeiras
			}
			
			// Método para gerar comando Insert Não Automotor no SQL
			public String gerarInsert() {
				return String.format("INSERT INTO Nao_Automotor (modelo, anofabri, cor, marca) VALUES ('%s', '%s', '%s', '%s');",
					getModelo(), getAnoFabri(), getCor(), marca);
			}
		}
		
		
		// Declaração da Classe Veículo Doméstico herdando a Classe Automotor
		public static class Veiculo_Domestico extends Automotor{
			private int qtd_passageiros;	// Atributos da Classe Veículo Doméstico
			private String freio;
			private String airbag;
		
			// Construtor da Classe Veículo Doméstico 
			public Veiculo_Domestico(String modelo, String anofabri, String montadora, String cor, double km, int qtd_passageiros, String freio, String airbag) {
				setModelo(modelo); // Inicializa o Modelo pela Classe Pai "Automotor"
	 			setAnoFabri(anofabri); // Inicializa o Ano de Fabricação pela Classe Pai "Automotor"
				setMontadora(montadora); // Inicializa a Montadora de Fabricação pela Classe Pai "Automotor"
				setCor(cor); // Inicializa a Cor de Fabricação pela Classe Pai "Automotor"
				setKM(km); // Inicializa a Kilometragem pela Classe Pai "Automotor"
				this.qtd_passageiros=qtd_passageiros; // Inicializa a Qtd. de Passageiros da Classe Veículo Doméstico
				this.freio=freio; // Inicializa o Freio da Classe Veículo Doméstico
				this.airbag=airbag; // Inicializa o Airbag da Classe Veículo Doméstico
			}
			
			// Método para Exibir os Dados da Classe Veículo Doméstico
			public void DescricaoVD() {
				System.out.println("====== Inserção dos objetos ======\n");
				System.out.println("- Veículo Doméstico -");
				System.out.println("Modelo: "+getModelo()); // Exibe o Modelo do Veículo
				System.out.println("Ano de Fabricação: "+getAnoFabri()); // Exibe o Ano de Fabricação do Veículo
				System.out.println("Montadora: "+getMontadora()); // Exibe a Montadora do Veículo
				System.out.println("Cor: "+getCor()); // Exibe a Cor do Veículo
				System.out.println("Kilometragem: "+getKM()+" KM"); // Exibe a Kilometragem do Veículo
				System.out.println("Qtd. de Passageiros: "+qtd_passageiros); // Exibe a Qtd. de Passageiros do Veículo
				System.out.println("Freio: "+freio); // Exibe o Tipo de Freio do Veículo
				System.out.println("Airbag: "+airbag); // Exibe o Tipo de Airbag do Veículo
			}
		
			
			// Método para gerar comando Insert Veículo Doméstico no SQL
			@Override
			public String gerarInsert() {
				return String.format("\nINSERT INTO Veiculo_Domestico (modelo, anofabri, cor, montadora, km, qtd_passageiros, freio, airbag) VALUES ('%s', '%s', '%s', '%s', %.2f, %d, '%s', '%s');\n",
					getModelo(), getAnoFabri(), getCor(), getMontadora(), getKM(), qtd_passageiros, freio, airbag);
			}
		}
		
		// Declaração da Classe Moto herdando a Classe Automotor
		public static class Moto extends Automotor{
			private int cilindrada;	// Atributos da Classe Moto
			private double torque;
		
			// Construtor da Classe Motocicleta
			public Moto(String modelo, String anofabri, String montadora, String cor, double km, int cilindrada, double torque) {
				setModelo(modelo); // Inicializa o Modelo pela Classe Pai "Automotor"
				setAnoFabri(anofabri); // Inicializa o Ano de Fabricação pela Classe Pai "Automotor"
				setMontadora(montadora); // Inicializa a Montadora de Fabricação pela Classe Pai "Automotor"
				setCor(cor); // Inicializa a Cor de Fabricação pela Classe Pai "Automotor"
				setKM(km); // Inicializa a Kilometragem pela Classe Pai "Automotor"
				this.cilindrada=cilindrada; // Inicializa a Cilindrada da Classe Motocicleta
				this.torque=torque; // Inicializa o Torque da Classe Motocicleta
			}
						
			// Método para Exibir os Dados da Classe Motocicleta
			public void DescricaoMoto() {
				System.out.println("\n- Motocicleta -");
				System.out.println("Modelo: "+getModelo()); // Exibe o Modelo da Motocicleta
				System.out.println("Ano de Fabricação: "+getAnoFabri()); // Exibe o Ano de Fabricação da Motocicleta
				System.out.println("Montadora: "+getMontadora()); // Exibe a Montadora da Motocicleta
				System.out.println("Cor: "+getCor()); // Exibe a Cor da Motocicleta
				System.out.println("Kilometragem: "+getKM()+" KM"); // Exibe a Kilometragem da Motocicleta
				System.out.println("Cilindrada: "+cilindrada); // Exibe a Cilindrada da Motocicletao
				System.out.println("Torque: "+torque); // Exibe o Torque da Motocicleta
			}
		
			// Método para gerar comando Insert Moto no SQL
			@Override
			public String gerarInsert() {
				return String.format("INSERT INTO Moto (modelo, anofabri, cor, montadora, km, cilindrada, torque) VALUES ('%s', '%s', '%s', '%s', %.2f, %d, %.2f);\n",
					getModelo(), getAnoFabri(), getCor(), getMontadora(), getKM(), cilindrada, torque);
			}
		}
	
		// Declaração da Classe Caminhão herdando a Classe Automotor
		public static class Caminhao extends Automotor{
			private int eixo;	// Atributos da Classe Caminhao
			private double peso;
		
			// Construtor da Classe Caminhão
			public Caminhao(String modelo, String anofabri, String montadora, String cor, double km, int eixo, double peso) {
				setModelo(modelo); // Inicializa o Modelo pela Classe Pai "Automotor"
				setAnoFabri(anofabri); // Inicializa o Ano de Fabricação pela Classe Pai "Automotor"
				setMontadora(montadora); // Inicializa a Montadora de Fabricação pela Classe Pai "Automotor"
				setCor(cor); // Inicializa a Cor de Fabricação pela Classe Pai "Automotor"
				setKM(km); // Inicializa a Kilometragem pela Classe Pai "Automotor"
				this.eixo=eixo; // Inicializa a Qtd. de Passageiros da Classe Veículo Doméstico
				this.peso=peso; // Inicializa o Freio da Classe Veículo Doméstico
			}
									
			// Método para Exibir os Dados da Classe Caminhão
			public void DescricaoCaminhao() {
				System.out.println("\n- Caminhão -");
				System.out.println("Modelo: "+getModelo()); // Exibe o Modelo do Caminhão
				System.out.println("Ano de Fabricação: "+getAnoFabri()); // Exibe o Ano de Fabricação do Caminhão
				System.out.println("Montadora: "+getMontadora()); // Exibe a Montadora do Caminhão
				System.out.println("Cor: "+getCor()); // Exibe a Cor do Caminhão
				System.out.println("Kilometragem: "+getKM()+" KM"); // Exibe a Kilometragem do Caminhão
				System.out.println("Eixos: "+eixo); // Exibe a Cilindrada do Caminhão
				System.out.println("Peso Bruto: "+peso+" Kg"); // Exibe o Torque do Caminhão
			}
		
			// Método para gerar comando Insert Caminhão no SQL
			@Override
			public String gerarInsert() {
				return String.format("INSERT INTO Caminhao (modelo, anofabri, montadora, cor, km, eixo, peso) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s');\n",
					getModelo(), getAnoFabri(), getMontadora(), getCor(), getKM(), eixo, peso);
			}
		}
		
		// Declaração da Classe Bicicleta herdando a Classe Não-Automotor
		public static class Bicicleta extends Nao_Automotor{
			private String material;	// Atributos da Classe Bicicleta
			private int qtd_marcha;
			private String amortecedor;
		
			// Construtor da Classe Bicicleta
			public Bicicleta(String modelo, String marca, String cor, String material, int qtd_marcha, String amortecedor) {
				setModelo(modelo); // Inicializa o Modelo pela Classe Pai "Automotor"
				setMarca(marca); // Inicializa a Marca pela Classe Pai "Não-Automotor"
				setCor(cor); // Inicializa a Cor pela Classe Pai "Não-Automotor"
				this.material=material; // Inicializa o Material da Classe Bicicleta
				this.qtd_marcha=qtd_marcha; // Inicializa a Qtd de Marcha da Classe Bicicleta
				this.amortecedor=amortecedor; // Inicializa o Amortecedor da Classe Bicicleta
			}
												
			// Método para Exibir os Dados da Classe Bicicleta
			public void DescricaoBicicleta() {
				System.out.println("\n- Bicicleta -");
				System.out.println("Modelo: "+getModelo()); // Exibe o Modelo da Bicicleta
				System.out.println("Marca: "+getMarca()); // Exibe a Montadora da Bicicleta
				System.out.println("Cor: "+getCor()); // Exibe a Cor da Bicicleta
				System.out.println("Material: "+material); // Exibe o Material da Bicicleta
				System.out.println("Qtd. de Marchas: "+qtd_marcha); // Exibe a Qtd. de Marchas da Bicicleta
				System.out.println("Amortecedor: "+amortecedor); // Exibe o Amortecedor da Bicicleta
			}
		
			// Método para gerar comando Insert Bicicleta no SQL
			@Override
			public String gerarInsert() {
				return String.format("INSERT INTO Bicicleta (modelo, marca, cor, material, qtd_marcha, amortecedor) VALUES ('%s', '%s', '%s', '%s', '%s', '%s');\n",
					getModelo(), getMarca(), getCor(), material, qtd_marcha, amortecedor);
			}
		}
		
		// Declaração da Classe Skate herdando a Classe Não-Automotor
		public static class Skate extends Nao_Automotor{
			private String tipo_roda;	// Atributos da Classe Skate
		
			// Construtor da Classe Bicicleta
		public Skate(String modelo, String marca, String cor, String tipo_roda) {
			setModelo(modelo); // Inicializa o Modelo pela Classe Pai "Automotor"
			setMarca(marca); // Inicializa a Marca pela Classe Pai "Não-Automotor"
			setCor(cor); // Inicializa a Cor pela Classe Pai "Não-Automotor"
			this.tipo_roda=tipo_roda; // Inicializa o Tipo de Rodas da Classe Skate
		}
															
		// Método para Exibir os Dados da Classe Bicicleta
		public void DescricaoSkate() {
			System.out.println("\n- Skate -");
			System.out.println("Modelo: "+getModelo()); // Exibe o Modelo do Skate
			System.out.println("Marca: "+getMarca()); // Exibe a Montadora do Skate
			System.out.println("Cor: "+getCor()); // Exibe a Cor do Skate
			System.out.println("Tipo de Rodas: "+tipo_roda); // Exibe o Tipo de Rodas do Skate
		}
		
		// Método para gerar comando Insert Skate no SQL
		@Override
		public String gerarInsert() {
			return String.format("INSERT INTO Skate (modelo, marca, cor, tipo_rodas) VALUES ('%s', '%s', '%s', '%s');\n",
				getModelo(), getMarca(), getCor(), tipo_roda);
		}
		
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		// Atribuição de parâmetros do Carro 1
		Veiculo_Domestico carro1 = new Veiculo_Domestico("Golf GTI", "2014", "Volkswagen", "Branco", 20000.00, 5, "A disco", "Duplo frontal");		

		// Atribuição de parâmetros da Moto 1
		Moto moto1 = new Moto("CG 160 Titan", "2024", "Honda", "Preta", 5000.00, 160, 1.60);			

		// Atribuição de parâmetros do Caminhão 1
		Caminhao caminhao1 = new Caminhao("Daily", "2021", "Iveco", "Cinza", 103000.00, 2, 44000);			
			
		// Atribuição de parâmetros da Bicleta 1
		Bicicleta bicicleta1 = new Bicicleta("Bicicleta Aro 29", "KRW", "Vermelha", "Alumínio", 5, "Mola");			
		
		// Atribuição de parâmetros do Skate 1
		Skate skate1 = new Skate("Matilha 8.0", "Matilha", "Preto", "Roda Brutus 53mm");			
		
		carro1.DescricaoVD(); // Método que puxa os dados do Carro 1
		moto1.DescricaoMoto(); // Método que puxa os dados da Moto 1
		caminhao1.DescricaoCaminhao(); // Método que puxa os dados do Caminhão 1
		bicicleta1.DescricaoBicicleta(); // Método que puxa os dados da Bicicleta 1	
		skate1.DescricaoSkate(); // Método que puxa os dados do Skate 1
	
		System.out.println("\n\n====== Inserção dos objetos em SQL ======");
		System.out.println(carro1.gerarInsert());  // Comando SQL de inserção do Carro 1
		System.out.println(moto1.gerarInsert()); // Comando SQL de inserção do Moto 1
		System.out.println(caminhao1.gerarInsert()); // Comando SQL de inserção do Caminhão 1
		System.out.println(bicicleta1.gerarInsert()); // Comando SQL de inserção do Bicicleta 1
		System.out.println(skate1.gerarInsert()); // Comando SQL de inserção do Skate 1

	}

}