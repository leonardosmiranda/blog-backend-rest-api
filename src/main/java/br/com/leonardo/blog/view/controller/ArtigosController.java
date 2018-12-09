package br.com.leonardo.blog.view.controller;

import br.com.leonardo.blog.model.entidade.Artigo;
import br.com.leonardo.blog.model.servico.ArtigoServico;
import br.com.leonardo.blog.view.dto.ArtigoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller de tags
 */
@RestController
@RequestMapping("/artigos")
public class ArtigosController {

    @Autowired
    private ArtigoServico servico;

    @GetMapping
    public List<ArtigoDTO> listarTodas() {
        return servico.listarTodos()
                .stream()
                .map(artigo -> new ArtigoDTO(artigo))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ArtigoDTO inserir(@Valid @RequestBody Artigo artigoNovo) {
        Artigo artigo = servico.inserir(artigoNovo);

        return new ArtigoDTO(artigo);
    }

    @GetMapping("/{id}")
    public ArtigoDTO recuperaPorId(@PathVariable Long id) {

        Artigo artigo = servico.buscarPorId(id);

        return new ArtigoDTO(artigo);
    }

    @PutMapping("/{id}")
    public ArtigoDTO alterar(@Valid @RequestBody Artigo artigoNovo, @PathVariable Long id) {

        Artigo artigo = servico.buscarPorId(id);
        artigo.setTitulo(artigoNovo.getTitulo());
        artigo.setTexto(artigoNovo.getTexto());
        artigo.setCategoria(artigoNovo.getCategoria());
        artigo.setStatus(artigoNovo.getStatus());
        artigo.setTags(artigoNovo.getTags());
        artigo = servico.atualizar(artigo);

        return new ArtigoDTO(artigo);
    }

    @DeleteMapping("/{id}")
    void excluir(@PathVariable Long id) {
        servico.excluir(id);
    }


}
