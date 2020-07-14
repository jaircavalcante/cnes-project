package br.com.cnes.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.cnes.entity.ArquivoCNES;
import br.com.cnes.enums.Mensagens;
import br.com.cnes.exception.NegocioException;
import br.com.cnes.services.ArquivoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author jaircavalcante
 *
 */
@RestController
@RequestMapping(path = "/arquivos")
@Api(value = "Responsável por realizar a importação dos arquivos na base de dados!")
public class ArquivoController {

	@Autowired
	private ArquivoService arquivoService;

	@GetMapping
	@ApiOperation(value = "Recupera todos os registros importados na base de dados referente ao CNES")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna a lista de CNES por Estado"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Retornou uma Exceção"),
	})
	public ResponseEntity<List<ArquivoCNES>> listarTodos() throws Exception {
		List<ArquivoCNES> dados = arquivoService.listar();

		try {	
			if(dados.isEmpty()) {
				throw new NegocioException(Mensagens.NENHUM_REGISTRO_ENCONTRADO.getMensagem());
			}
			
			return new ResponseEntity<List<ArquivoCNES>>(dados, HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dados);
		}
	}
	
	@GetMapping("/{estado}")
	@ApiOperation(value = "Recupera todos os registros importados na base sobre o CENS filtrando por Estado!")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Lista de CNES por Estado"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 400, message = "Retornou uma Exceção"),
	})
	public ResponseEntity<Object> listarPorEstado(@Valid @PathVariable String estado) {
		List<ArquivoCNES> dados = arquivoService.listarPorEstado(estado);

		try {
			if(dados.isEmpty()) {
				throw new NegocioException(Mensagens.NENHUM_REGISTRO_ENCONTRADO_POR_ESTADO.getMensagem());
			}
			
			return new ResponseEntity<Object>(dados, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/orgaos/{tipo}")
	@ApiOperation(value = "Recupera todas as informações da base de dados dos registros do CNES filtrando por Tipo de Gestão e E(Estadual),(M) Municipal")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna todos registros da CNES importados na base"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Retornou uma Exceção"),
	})
	public ResponseEntity<Object> listarPorTipo(@Valid @PathVariable String tipo) {
		List<ArquivoCNES> dados = arquivoService.listarPorTipo(tipo);

		try {
			if(dados.isEmpty()) {
				throw new NegocioException(Mensagens.NENHUM_REGISTRO_ENCONTRADO_POR_TIPO_GESTAO.getMensagem());
			}
			
			return new ResponseEntity<Object>(dados, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping
	@ApiOperation(value = "Método utilizado para realizar a importação do arquivo na base de dados!")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Arquivo importado com sucesso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 404, message = "Formato do arquivo não suportado!"),
	    @ApiResponse(code = 500, message = "Ocorreu problema na importação do arquivo!"),
	})
	public ResponseEntity<String> salvar(@RequestParam("file") @Valid MultipartFile arquivo) {
		try {
			arquivoService.importar(arquivo);

			return ResponseEntity.status(HttpStatus.OK).body(Mensagens.ARQUIVO_IMPORTADO.getMensagem());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}