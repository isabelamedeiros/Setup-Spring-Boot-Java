package com.api.clientesconsulta.dtos;

import javax.validation.constraints.NotBlank;

public class ClienteConsultaDto {
//validation
    @NotBlank
    private String xxxxNumber;

    public String getXxxxNumber() {
        return xxxxNumber;
    }

    public void setXxxxNumber(String xxxxNumber) {
        this.xxxxNumber = xxxxNumber;
    }
}
