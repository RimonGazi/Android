package net.sistransitomobile.database;

import android.provider.BaseColumns;

public final class SisTransitoContract {

	public SisTransitoContract() {
		// TODO Auto-generated constructor stub
	}
	
	public static abstract class UsuarioEntry implements BaseColumns{
		public static final String TABLE_NAME = "usuario";
		public static final String COLUMN_NOME = "nome";
		public static final String COLUMN_MATRICULA = "matricula";
		public static final String COLUMN_NOME_ORGAO = "nome_orgao";
		public static final String COLUMN_CODIGO_ORGAO = "codigo_orgao";
	}
	
	public static abstract class VeiculoEntry implements BaseColumns{
		public static final String TABLE_NAME = "off_veiculos";
		public static final String COLUMN_PLACA = "placa";
		public static final String COLUMN_MODELO = "modelo";
		public static final String COLUMN_COR = "cor";
		public static final String COLUMN_TIPO = "tipo";
		public static final String COLUMN_ANO_LICENCIAMENTO = "ano_licenciamento";
		public static final String COLUMN_DATA_LICENCIAMENTO = "data_licenciamento";
		public static final String COLUMN_STATUS_LICENCIAMENTO = "status_licenciamento";
		public static final String COLUMN_IPVA = "ipva";
		public static final String COLUMN_SEGURO = "seguro";
		public static final String COLUMN_STATUS = "status";
		public static final String COLUMN_INFRACOES = "infracoes";
		public static final String COLUMN_RESTRICOES = "restricoes";
	}
	
	public static abstract class AutoInfracaoEntry implements BaseColumns{
		public static final String TABLE_NAME = "auto_infracao";
		public static final String COLUMN_NUMERO_AUTO = "numero_auto";
		public static final String COLUMN_PLACA = "placa";
		public static final String COLUMN_ESPECIE = "especie";
		public static final String COLUMN_CATEGORIA = "categoria";
		public static final String COLUMN_NOME_CONDUTOR = "nome_condutor";
		public static final String COLUMN_TIPO_DOC = "tipodoc";
		public static final String COLUMN_CNH_CONDUTOR = "cnh_condutor";
		public static final String COLUMN_PPD_CONDUTOR = "ppd_condutor";
		public static final String COLUMN_CPF_CONDUTOR = "cpf_condutor";
		public static final String COLUMN_INFRACAO = "infracao";
		public static final String COLUMN_ENQUADRAMENTO = "enquadramento";
		public static final String COLUMN_DESDOBRAMENTO = "desdobramento";
		public static final String COLUMN_ARTIGO = "artigo";
		public static final String COLUMN_MUNICIPIO = "municipio";
		public static final String COLUMN_CODIGO_MUNICIPIO = "codigo_municipio";
		public static final String COLUMN_UF = "uf";
		public static final String COLUMN_LOCAL = "local";
		public static final String COLUMN_DATA = "data";
		public static final String COLUMN_HORA = "hora";
		public static final String COLUMN_DESCRICAO_EQUIPAMENTO = "descricao_equipamento";
		public static final String COLUMN_MARCA_EQUIPAMENTO = "marca_equipamento";
		public static final String COLUMN_MODELO_EQUIPAMENTO = "modelo_equipamento";
		public static final String COLUMN_NUMERO_SERIE_EQUIPAMENTO = "numero_serie_equipamento";
		public static final String COLUMN_MEDICAO_ALCOOL_REALIZADA = "medicao_alcool_realizada";
		public static final String COLUMN_MEDICAO_ALCOOL_CONSIDERADA = "medicao_alcool_considerada";
		public static final String COLUMN_NUMERO_AMOSTRA_TESTE = "numero_amostra_teste";
		public static final String COLUMN_CLRV = "crlv";
		public static final String COLUMN_CNH = "cnh";
		public static final String COLUMN_PPD = "ppd";
		public static final String COLUMN_RETENCAO = "retencao";
		public static final String COLUMN_REMOCAO = "remocao";
		public static final String COLUMN_OBSERVACAO = "observacao";
		public static final String COLUMN_EMBARCADOR = "embarcador";
		public static final String COLUMN_CNPJ_EMBARCADOR = "cnpj_embarcador";
		public static final String COLUMN_TRANSPORTADOR = "transportador";
		public static final String COLUMN_CNPJ_TRANSPORTADOR = "cnpj_transportador";
		public static final String COLUMN_STATUS = "status";
		public static final String COLUMN_MOTIVO = "motivo";
		
		
	}
	
//	public static abstract class AutoEquipamentoEntry implements BaseColumns{
//		public static final String TABLE_NAME = "auto_equipamento";
//		public static final String COLUMN_DESCRICAO = "descricao";
//		public static final String COLUMN_MARCA = "marca";
//		public static final String COLUMN_MODELO = "modelo";
//		public static final String COLUMN_VALIDADE = "validade";
//		
//
//	}
	
	public static abstract class InfracoesCTBEntry implements BaseColumns{
		public static final String TABLE_NAME = "infracoes_ctb";
		public static final String COLUMN_CODIGO_INFRACAO = "codigo_infracao";
		public static final String COLUMN_DESDOBRAMENTO = "desdobramento";
		public static final String COLUMN_DESCRICAO = "descricao";
		public static final String COLUMN_AMPARO_LEGAL = "amparo_legal";
		public static final String COLUMN_RESPONSAVEL = "responsavel";
		public static final String COLUMN_PONTOS = "pontos";
		public static final String COLUMN_GRAVIDADE = "gravidade";
		public static final String COLUMN_COMPETENCIA = "competencia";

	}
	
	
	public static abstract class MunicipioEntry implements BaseColumns{
		public static final String TABLE_NAME = "municipios";
		public static final String COLUMN_CODIGO = "cod";
		public static final String COLUMN_MUNICIPIO = "municipio";
		public static final String COLUMN_UF = "uf";
		
	}
	
}
