package br.com.leonardo.blog.view.controller;

import br.com.leonardo.blog.model.entidade.Tag;
import br.com.leonardo.blog.model.servico.TagServico;
import br.com.leonardo.blog.view.dto.TagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller de tags
 */
@RestController
@RequestMapping("/tags")
public class TagsController {

    @Autowired
    private TagServico servico;

    @GetMapping
    public List<TagDTO> listarTodas() {
        return servico.listarTodos()
                .stream()
                .map(cat ->
                        new TagDTO(
                                cat.getId(),
                                cat.getNome()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public TagDTO inserir(@Valid @RequestBody Tag tagNova) {
        Tag tag = servico.inserir(tagNova);

        return new TagDTO(tag.getId(),
                tag.getNome());
    }

    @GetMapping("/{id}")
    public TagDTO recuperaPorId(@PathVariable Long id) {

        Tag tag = servico.buscarPorId(id);

        return new TagDTO(tag.getId(),
                tag.getNome());
    }

    @PutMapping("/{id}")
    public TagDTO alterar(@Valid @RequestBody Tag tagNova, @PathVariable Long id) {

        Tag tag = servico.buscarPorId(id);
        tag.setNome(tagNova.getNome());
        tag = servico.atualizar(tag);

        return new TagDTO(tag.getId(),
                tag.getNome());
    }

    @DeleteMapping("/{id}")
    void excluir(@PathVariable Long id) {
        servico.excluir(id);
    }


}
