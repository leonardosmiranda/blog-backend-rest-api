package br.com.leonardo.blog.view.controller;

import br.com.leonardo.blog.model.entidade.Categoria;
import br.com.leonardo.blog.model.servico.CategoriaServico;
import br.com.leonardo.blog.view.dto.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller de categoria
 */
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServico servico;

    @GetMapping
    public List<CategoriaDTO> listarTodas() {
        return servico.listarTodos()
                .stream()
                .map(cat ->
                        new CategoriaDTO(
                                cat.getId(),
                                cat.getNome(),
                                cat.getBase().getCriadoEm().toString(),
                                cat.getBase().getAlteradoEm().toString()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public CategoriaDTO inserir(@Valid @RequestBody Categoria categoria) {
        Categoria cat = servico.inserir(categoria);

        return new CategoriaDTO(cat.getId(),
                cat.getNome(),
                cat.getBase().getCriadoEm().toString(),
                cat.getBase().getAlteradoEm().toString());
    }

    @GetMapping("/{id}")
    public CategoriaDTO recuperaPorId(@PathVariable Long id) {

        Categoria cat = servico.buscarPorId(id);

        return new CategoriaDTO(cat.getId(),
                cat.getNome(),
                cat.getBase().getCriadoEm().toString(),
                cat.getBase().getAlteradoEm().toString());
    }

    @PutMapping("/{id}")
    public CategoriaDTO alterar(@Valid @RequestBody Categoria novaCategoria, @PathVariable Long id) {

        Categoria categoria = servico.buscarPorId(id);
        categoria.setNome(novaCategoria.getNome());
        categoria = servico.atualizar(categoria);

        return new CategoriaDTO(categoria.getId(),
                categoria.getNome(),
                categoria.getBase().getCriadoEm().toString(),
                categoria.getBase().getAlteradoEm().toString());
    }

    @DeleteMapping("/{id}")
    void excluir(@PathVariable Long id) {
        servico.excluir(id);
    }


}
