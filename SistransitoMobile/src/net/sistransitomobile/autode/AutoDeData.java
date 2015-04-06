package net.sistransitomobile.autode;

import java.io.Serializable;

import net.sistransitomobile.appconstant.AppConstants;
import net.sistransitomobile.database.AutoInfracaoDatabaseHelper;
import net.sistransitomobile.main.R;

import android.content.Context;
import android.database.Cursor;

public class AutoDeData implements Serializable {

	private boolean isStoreFullData;

	private static final String Auto_de_id = "auto_de_id";
	private static final long serialVersionUID = 14393745L;
	private String id_field, plate, model, cor_do_veiculo, especie, categoria,
			identification_do_conductor, cnh_ppd, cpf, infracao, enquadra,
			desdob, art, codigo_do_municipio, municipio, uf, local, data, hora,
			descricao, marca, modelo, numero_de_serie, medico_realizada,
			valor_considerada, n_da_amostra, clrv, cnh, ppd, retencao, remocao,
			observacao, idetificacao_embracador, cnpj_cpf_embracador,
			identificacao_do_transportadfor, cnpj_cpf_transportadfor,
			numero_auto;

	public AutoDeData() {
		super();
		initializedAllDAta();
	}

	public boolean isStoreFullData() {
		return isStoreFullData;
	}

	public void setStoreFullData(boolean isStoreFullData) {
		this.isStoreFullData = isStoreFullData;
	}

	public String getId_field() {
		return id_field;
	}

	public void setId_field(String id_field) {
		this.id_field = id_field;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCor_do_veiculo() {
		return cor_do_veiculo;
	}

	public void setCor_do_veiculo(String cor_do_veiculo) {
		this.cor_do_veiculo = cor_do_veiculo;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getIdentification_do_conductor() {
		return identification_do_conductor;
	}

	public void setIdentification_do_conductor(
			String identification_do_conductor) {
		this.identification_do_conductor = identification_do_conductor;
	}

	public String getCnh_ppd() {
		return cnh_ppd;
	}

	public void setCnh_ppd(String cnh_ppd) {
		this.cnh_ppd = cnh_ppd;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getInfracao() {
		return infracao;
	}

	public void setInfracao(String infracao) {
		this.infracao = infracao;
	}

	public String getEnquadra() {
		return enquadra;
	}

	public void setEnquadra(String enquadra) {
		this.enquadra = enquadra;
	}

	public String getDesdob() {
		return desdob;
	}

	public void setDesdob(String desdob) {
		this.desdob = desdob;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public String getCodigo_do_municipio() {
		return codigo_do_municipio;
	}

	public void setCodigo_do_municipio(String codigo_do_municipio) {
		this.codigo_do_municipio = codigo_do_municipio;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumero_de_serie() {
		return numero_de_serie;
	}

	public void setNumero_de_serie(String numero_de_serie) {
		this.numero_de_serie = numero_de_serie;
	}

	public String getMedico_realizada() {
		return medico_realizada;
	}

	public void setMedico_realizada(String medico_realizada) {
		this.medico_realizada = medico_realizada;
	}

	public String getValor_considerada() {
		return valor_considerada;
	}

	public void setValor_considerada(String valor_considerada) {
		this.valor_considerada = valor_considerada;
	}

	public String getN_da_amostra() {
		return n_da_amostra;
	}

	public void setN_da_amostra(String n_da_amostra) {
		this.n_da_amostra = n_da_amostra;
	}

	public String getClrv() {
		return clrv;
	}

	public void setClrv(String clrv) {
		this.clrv = clrv;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getPpd() {
		return ppd;
	}

	public void setPpd(String ppd) {
		this.ppd = ppd;
	}

	public String getRetencao() {
		return retencao;
	}

	public void setRetencao(String retencao) {
		this.retencao = retencao;
	}

	public String getRemocao() {
		return remocao;
	}

	public void setRemocao(String remocao) {
		this.remocao = remocao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getIdetificacao_embracador() {
		return idetificacao_embracador;
	}

	public void setIdetificacao_embracador(String idetificacao_embracador) {
		this.idetificacao_embracador = idetificacao_embracador;
	}

	public String getCnpj_cpf_embracador() {
		return cnpj_cpf_embracador;
	}

	public void setCnpj_cpf_embracador(String cnpj_cpf_embracador) {
		this.cnpj_cpf_embracador = cnpj_cpf_embracador;
	}

	public String getIdentificacao_do_transportadfor() {
		return identificacao_do_transportadfor;
	}

	public void setIdentificacao_do_transportadfor(
			String identificacao_do_transportadfor) {
		this.identificacao_do_transportadfor = identificacao_do_transportadfor;
	}

	public String getCnpj_cpf_transportadfor() {
		return cnpj_cpf_transportadfor;
	}

	public void setCnpj_cpf_transportadfor(String cnpj_cpf_transportadfor) {
		this.cnpj_cpf_transportadfor = cnpj_cpf_transportadfor;
	}

	public String getNumero_auto() {
		return numero_auto;
	}

	public void setNumero_auto(String numero_auto) {
		this.numero_auto = numero_auto;
	}

	public static String getAutoDeId() {
		return Auto_de_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private void initializedAllDAta() {
		local = data = hora = id_field = plate = model = cor_do_veiculo = especie = categoria = identification_do_conductor = cnh_ppd = cpf = infracao = enquadra = desdob = art = codigo_do_municipio = municipio = uf = local = data = hora = descricao = marca = modelo = numero_de_serie = medico_realizada = valor_considerada = n_da_amostra = clrv = cnh = ppd = retencao = remocao = observacao = idetificacao_embracador = cnpj_cpf_embracador = identificacao_do_transportadfor = cnpj_cpf_transportadfor = numero_auto = "";
	}

	public void setAutoDeDataFromCursor(Cursor myCursor) {

		this.setPlate(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.PLATE)));

		this.setModel(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.MODEL)));

		this.setCor_do_veiculo(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.COR_DO_VEICULO)));
		this.setEspecie(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.ESPECIE)));

		this.setCategoria(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.CATEGORIA)));

		this.setIdentification_do_conductor(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.IDENTIFICATION_DO_CONDUCTOR)));

		this.setCnh_ppd(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.CNH_PPD)));

		this.setCpf(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.CPF)));

		this.setInfracao(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.INFRACAO)));

		this.setEnquadra(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.ENQUADRA)));
		this.setDesdob(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.DESDOB)));

		this.setArt(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.ART)));

		this.setCodigo_do_municipio(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.CODIGO_DO_MUNICIPIO)));

		this.setMunicipio(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.MUNICIPIO)));

		this.setUf(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.UF)));
		this.setLocal(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.LOCAL)));
		this.setData(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.DATA)));
		this.setHora(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.HORA)));
		this.setDescricao(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.DESCRICAO)));
		this.setMarca(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.MARCA)));

		this.setModel(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.MODEL)));
		this.setNumero_de_serie(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.NUMERO_DE_SERIE)));

		this.setMedico_realizada(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.MEDICO_REALIZADA)));

		this.setValor_considerada(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.VALOR_CONSIDERADA)));

		this.setN_da_amostra(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.N_DA_AMOSTRA)));

		this.setClrv(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.CLRV)));
		this.setCnh(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.CNH)));

		this.setPpd(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.PPD)));

		this.setRetencao(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.RETENCAO)));

		this.setRemocao(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.REMOCAO)));

		this.setObservacao(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.OBSERVACAO)));

		this.setIdetificacao_embracador(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.IDETIFICACAO_EMBRACADOR)));

		this.setCnpj_cpf_embracador(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.CNPJ_CPF_EMBRACADOR)));

		this.setIdentificacao_do_transportadfor(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.IDENTIFICACAO_DO_TRANSPORTADFOR)));
		this.setCnpj_cpf_transportadfor(myCursor.getString(myCursor
				.getColumnIndex(AutoInfracaoDatabaseHelper.CNPJ_CPF_TRANSPORTADFOR)));
		this.setStoreFullData(true);

	}

	public String getAutoDeViewData(Context context) {
		String autode = context.getResources().getString(R.string.placa)
				+ getNewline()
				+ plate
				+ getNewline_2()
				+ context.getResources().getString(R.string.model)
				+ getNewline()
				+ model
				+ getNewline_2()
				+ context.getResources().getString(
						R.string.auto_de_cor_do_veiculo)
				+ getNewline()
				+ cor_do_veiculo
				+ getNewline_2()
				+ context.getResources().getString(R.string.especie)
				+ getNewline()
				+ especie
				+ getNewline_2()
				+ context.getResources().getString(R.string.categoria)
				+ getNewline()
				+ categoria
				+ getNewline_2()
				+ context.getResources().getString(
						R.string.identificacao_do_condutor)
				+ getNewline()
				+ identification_do_conductor
				+ getNewline_2()
				+ context.getResources().getString(R.string.CNH_PPD)
				+ getNewline()
				+ cnh_ppd
				+ getNewline_2()
				+ context.getResources().getString(R.string.cpf)
				+ getNewline()
				+ cpf
				+ getNewline_2()
				+ context.getResources().getString(R.string.infracao)
				+ getNewline()
				+ infracao
				+ getNewline_2()
				+ context.getResources().getString(R.string.enquadra)
				+ getNewline()
				+ enquadra
				+ getNewline_2()
				+ context.getResources().getString(R.string.desdob)
				+ getNewline()
				+ desdob
				+ getNewline_2()
				+ context.getResources().getString(R.string.art)
				+ getNewline()
				+ art
				+ getNewline_2()
				+ context.getResources().getString(R.string.auto_de_muni)
				+ getNewline()
				+ codigo_do_municipio
				+ getNewline_2()
				+ context.getResources().getString(
						R.string.auto_de_codigo_do_municipio)
				+ getNewline()
				+ municipio
				+ getNewline_2()
				+ context.getResources().getString(R.string.auto_de_UF)
				+ getNewline()
				+ uf
				+ getNewline_2()
				+ context.getResources().getString(R.string.local)
				+ getNewline()
				+ local
				+ getNewline_2()
				+ context.getResources().getString(R.string.data)
				+ getNewline()
				+ data
				+ getNewline_2()
				+ context.getResources().getString(R.string.hora)
				+ getNewline()
				+ hora
				+ getNewline_2()
				+ context.getResources().getString(
						R.string.descricao_da_infracao)
				+ getNewline()
				+ descricao
				+ getNewline_2()
				+ context.getResources().getString(R.string.auto_de_marca)
				+ getNewline()
				+ marca
				+ getNewline_2()

				+ context.getResources().getString(R.string.auto_de_modelo)
				+ getNewline()
				+ modelo
				+ getNewline_2()
				+ context.getResources().getString(
						R.string.auto_de_numero_de_serie)
				+ getNewline()
				+ numero_de_serie
				+ getNewline_2()
				+ context.getResources().getString(R.string.medicao_realizada)
				+ getNewline()
				+ medico_realizada
				+ getNewline_2()
				+ context.getResources().getString(
						R.string.auto_de_valor_considerado)
				+ getNewline()
				+ valor_considerada
				+ getNewline_2()
				+ context.getResources().getString(
						R.string.auto_de_n_da_amostra)
				+ getNewline()
				+ n_da_amostra
				+ getNewline_2()
				+ context.getResources().getString(R.string.CLRV)
				+ getNewline()
				+ clrv
				+ getNewline_2()
				+ context.getResources().getString(R.string.CNH)
				+ getNewline()
				+ cnh
				+ getNewline_2()
				+ context.getResources().getString(R.string.PPD)
				+ getNewline()
				+ ppd
				+ getNewline_2()
				+ context.getResources().getString(R.string.retencao)
				+ getNewline()
				+ retencao
				+ getNewline_2()
				+ context.getResources().getString(R.string.remocao)
				+ getNewline()
				+ remocao
				+ getNewline_2()
				+ context.getResources().getString(R.string.observacao)
				+ getNewline()
				+ observacao
				+ getNewline_2()
				+ context.getResources().getString(
						R.string.identificacao_do_embarcador)
				+ getNewline()
				+ idetificacao_embracador
				+ getNewline_2()
				+ context.getResources().getString(R.string.CNPJ_CPF)
				+ getNewline()
				+ cnpj_cpf_embracador
				+ getNewline_2()
				+ context.getResources().getString(
						R.string.identificacao_do_transportador)
				+ getNewline()
				+ identificacao_do_transportadfor
				+ getNewline_2()
				+ context.getResources().getString(R.string.CNPJ_CPF)
				+ getNewline()
				+ cnpj_cpf_transportadfor
				+ getNewline_2()
				+ context.getResources().getString(
						R.string.auto_de_n_da_amostra) + getNewline()
				+ numero_auto + getNewline_2();

		return autode;

	}

	private String getNewline() {
		return AppConstants.NEW_LINE;
	}

	private String getNewline_2() {
		return AppConstants.NEW_LINE + AppConstants.NEW_LINE;
	}

}
