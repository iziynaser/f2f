package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceTypeDTO {

    private String name;
    private String description;
    private String type;

    public InvoiceTypeDTO() {
    }

    public InvoiceTypeDTO(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

}
