package br.com.gerenciadorproposta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import br.com.caelum.stella.bean.validation.CNPJ;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;

@ApiModel(description = "Representa um cliente no sistema.")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    @ApiModelProperty(value = "Código do cliente", example = "1", accessMode = AccessMode.READ_ONLY, readOnly = true)
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(value = "CNPJ sem pontuação.", example = "09211531000106")
    @CNPJ
    @NotEmpty
    private String cnpj;

    @ApiModelProperty(value = "Razão social", example = "Exemplo de Empresa LTDA")
    @NotEmpty
    private String razaoSocial;

    @ApiModelProperty(value = "Telefone com DDD (2 dígitos) e sem pontuação", dataType = "string", example = "51912345678")
    @Pattern(message = "O campo deve conter um telefone válido.", regexp = "[0-9]{11}")
    @NotEmpty(message = "O campo é obrigatório.")
    private String telefone;

    @ApiModelProperty(value = "E-mail", example = "exemplo@empresa.com.br")
    @Email(message = "O campo deve conter um e-mail válido.")
    @NotEmpty(message = "O campo é obrigatório.")
    private String email;
}
