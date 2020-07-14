package br.com.cnes.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;

import br.com.cnes.entity.ArquivoCNES;
import br.com.cnes.repository.ArquivoRepositorio;

/**
 * 
 * @author jaircavalcante
 *
 */
@Service
public class ArquivoService {

	@Autowired
	private ArquivoRepositorio arquivoRepositorio;

	public List<ArquivoCNES> listar() {
		return arquivoRepositorio.findAll();
	}

	public void importar(MultipartFile file2) {
		try {

			List<ArquivoCNES> dados = new ArrayList<ArquivoCNES>();

			File fileName = convertMultiPartToFile(file2);

			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

				String linha = "";

				// PULAR HEADER DO ARQUIVO
				br.readLine();

				while ((linha = br.readLine()) != null) {

					String[] registros = linha.split(",");

					ArquivoCNES entidade = new ArquivoCNES();

					entidade.setCodigoCNES(registros[0].replaceAll("\"", ""));
					entidade.setCodigoIBGE(registros[1].replaceAll("\"", ""));
					entidade.setNomeFantasia(registros[2].replaceAll("\"", ""));
					entidade.setDescricaoTipoUnidade(registros[3].replaceAll("\"", ""));
					entidade.setTipoGestao(registros[4].replaceAll("\"", ""));
					entidade.setNumeroLogradouro(registros[5].replaceAll("\"", ""));
					entidade.setNumeroEndereco(registros[6].replaceAll("\"", ""));
					entidade.setNomeBairro(registros[7].replaceAll("\"", ""));
					entidade.setCodigoCEP(registros[8].replaceAll("\"", ""));
					entidade.setSiglaEstado(registros[9].replaceAll("\"", ""));
					entidade.setMunicipio(registros[10].replaceAll("\"", ""));
					entidade.setNumeroTelefone(registros[11].replaceAll("\"", ""));

					dados.add(entidade);
				}

				List<List<ArquivoCNES>> lotes = Lists.partition(dados, 10000);

				// Armazenando arquivos em lote
				for (List<ArquivoCNES> item : lotes)
					arquivoRepositorio.saveAll(item);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public List<ArquivoCNES> listarPorTipo(String tipo) {
		return arquivoRepositorio.findByTipoGestao(tipo);
	}

	public List<ArquivoCNES> listarPorEstado(String estado) {
		return arquivoRepositorio.findAllBySiglaEstado(estado);
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
}