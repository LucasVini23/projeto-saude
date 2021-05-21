package br.com.portifolio.lucasvini.projectsaude.builder;

import java.util.ArrayList;

import br.com.portifolio.lucasvini.projectsaude.dto.DocumentoDto;
import br.com.portifolio.lucasvini.projectsaude.dto.EspecialidadeDoProfissionalDto;
import br.com.portifolio.lucasvini.projectsaude.dto.ProfissionalDto;
import br.com.portifolio.lucasvini.projectsaude.factory.DocumentoFactory;
import br.com.portifolio.lucasvini.projectsaude.factory.EspecialidadeDoProfissionalFactory;
import br.com.portifolio.lucasvini.projectsaude.factory.PerfilFactory;
import br.com.portifolio.lucasvini.projectsaude.model.Documento;
import br.com.portifolio.lucasvini.projectsaude.model.EspecialidadeDoProfissional;
import br.com.portifolio.lucasvini.projectsaude.model.Perfil;
import br.com.portifolio.lucasvini.projectsaude.model.Usuario;

public class ProfissionalDtoBuilder extends UsuarioDtoBuilder {
	
	private Usuario usuarioBean;
	
	public ProfissionalDtoBuilder(Usuario usuario) {
		this.usuarioBean = usuario;
		this.dto = new ProfissionalDto(null, null, null, null, null, null, null, null, null);
	}
	
	@Override
	public void buildId() {
		this.dto.setId(this.usuarioBean.getId());
	}

	@Override
	public void buildName() {
		this.dto.setNome(this.usuarioBean.getNome());
	}

	@Override
	public void buildSobrenome() {
		this.dto.setSobrenome(this.usuarioBean.getSobrenome());
	}


	@Override
	public void buildEmail() {
		this.dto.setEmail(this.usuarioBean.getEmail());
	}

	@Override
	public void buildDataNascimento() {
		this.dto.setDataNascimento(this.usuarioBean.getDataNascimento());
	}
	
	@Override
	public void buildDataCadastro() {
		this.dto.setDataCadastro(this.usuarioBean.getDataCadastro());
	}

	@Override
	public void buildStatus() {
		this.dto.setStatus(this.usuarioBean.getStatus());
	}

	@Override
	public void buildListaEspecialidades() {
		var listaEspecialidas = this.usuarioBean.getListaEspecialidades();
		ArrayList<EspecialidadeDoProfissionalDto> listDto = new ArrayList<>();
		for (EspecialidadeDoProfissional especialidadeDoProfissional : listaEspecialidas) {
			EspecialidadeDoProfissionalDto dto = EspecialidadeDoProfissionalFactory.create(especialidadeDoProfissional);
			listDto.add(dto);
		}
		this.dto.setListaEspecialidades(listDto);
	}

	@Override
	public void buildPerfil() {
		var listaPerfis = this.usuarioBean.getListaPerfis();
		for (Perfil perfilUnico : listaPerfis) {
			this.dto.setPerfil(PerfilFactory.create(perfilUnico));
		}
	}

	@Override
	public void buildDocumentos() {
		var listaDocumentosBean = this.usuarioBean.getDocumentos();
		ArrayList<DocumentoDto> listDto = new ArrayList<>();
		for (Documento documento : listaDocumentosBean) {
			DocumentoDto dto = DocumentoFactory.create(documento);
			listDto.add(dto);
		}
		this.dto.setDocumentos(listDto);
	}
	
	@Override
	public ProfissionalDto get() {
		return (ProfissionalDto) dto;
	}


}
