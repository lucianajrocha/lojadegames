package com.generation.lojadegames.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo titulo é de preenchimento obrigatório")
    @Size(min = 5, max = 100, message = "O atributo titulo tem no minino 5 caracteres e no máximo 100 caracteres")
    private String titulo;

    @NotBlank(message = "O atributo descrição é de preenchimento obrigatório")
    @Size(min = 5, max = 100, message = "O atributo descrição tem no minino 5 caracteres e no máximo 100 caracteres")
    private String descricao;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull(message = "Preço é obrigatório!")
    @Positive(message = "O preço deve ser maior do que zero!")
    private BigDecimal preco;

    @UpdateTimestamp
    private LocalDateTime data;

    @ManyToOne
    @JsonIgnoreProperties ("produto")
    private Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String texto) {
        this.descricao = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}


