package br.com.fiap.financaspro.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.financaspro.model.Categoria;
import br.com.fiap.financaspro.model.Movimentacao;
import br.com.fiap.financaspro.repository.CategoriaRepository;
import br.com.fiap.financaspro.repository.MovimentacaoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @Override
    public void run(String... args) throws Exception {
        categoriaRepository.saveAll(
            List.of(
                Categoria.builder().id(1L).nome("alimentação").icone("apple").build(),
                Categoria.builder().id(2L).nome("educação").icone("book").build(),
                Categoria.builder().id(3L).nome("transporte").icone("bus").build()
            )
        );

        movimentacaoRepository.saveAll(
            List.of (
                Movimentacao.builder()
                    .id(1L)
                    .descricao("Mc Donalds")
                    .valor(new BigDecimal(55))
                    .data(LocalDate.now())
                    .categoria(categoriaRepository.findById(1L).get())
                    .tipo("SAIDA")
                    .build(),
                Movimentacao.builder()
                    .id(2L)
                    .descricao("Livros")
                    .valor(new BigDecimal(150))
                    .data(LocalDate.now().minusWeeks(1))
                    .categoria(categoriaRepository.findById(2L).get())
                    .tipo("SAIDA")
                    .build(),
                Movimentacao.builder()
                    .id(3L)
                    .descricao("Gasolina")
                    .valor(new BigDecimal(200))
                    .data(LocalDate.now().minusMonths(1))
                    .categoria(categoriaRepository.findById(3L).get())
                    .tipo("SAIDA")
                    .build(),
                Movimentacao.builder()
                    .id(4L)
                    .descricao("Gasolina")
                    .valor(new BigDecimal(200))
                    .data(LocalDate.now().minusMonths(1))
                    .categoria(categoriaRepository.findById(3L).get())
                    .tipo("SAIDA")
                    .build(),
                Movimentacao.builder()
                    .id(5L)
                    .descricao("Gasolina")
                    .valor(new BigDecimal(200))
                    .data(LocalDate.now().minusMonths(1))
                    .categoria(categoriaRepository.findById(3L).get())
                    .tipo("SAIDA")
                    .build(),
                Movimentacao.builder()
                    .id(6L)
                    .descricao("Gasolina")
                    .valor(new BigDecimal(200))
                    .data(LocalDate.now().minusMonths(1))
                    .categoria(categoriaRepository.findById(3L).get())
                    .tipo("SAIDA")
                    .build(),
                Movimentacao.builder()
                    .id(7L)
                    .descricao("Gasolina")
                    .valor(new BigDecimal(200))
                    .data(LocalDate.now().minusMonths(1))
                    .categoria(categoriaRepository.findById(3L).get())
                    .tipo("SAIDA")
                    .build(),
                Movimentacao.builder()
                    .id(8L)
                    .descricao("Gasolina")
                    .valor(new BigDecimal(200))
                    .data(LocalDate.now().minusMonths(1))
                    .categoria(categoriaRepository.findById(3L).get())
                    .tipo("SAIDA")
                    .build()
            )
        );
    }
    
}
