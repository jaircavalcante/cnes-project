package br.com.cnes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cnes.entity.ArquivoCNES;

/**
 * 
 * @author jaircavalcante
 *
 */
@Repository
public interface ArquivoRepositorio extends JpaRepository<ArquivoCNES, String> {

	List<ArquivoCNES> findByTipoGestao(String tipoGestao);
	
	List<ArquivoCNES> findAllBySiglaEstado(String estado);

}