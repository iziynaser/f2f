package ir.verjik.entity.other;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Organization {
    private String name;
    private String type; // LEGAL,INFORMAL(TEAM,FAMILY,OTHER INFORMAL)
    private String brandings;
    private String govermentalAgency;
    private String taxId;
    private Organization parentOrg;
}
