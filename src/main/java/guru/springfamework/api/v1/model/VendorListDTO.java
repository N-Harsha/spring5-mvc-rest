package guru.springfamework.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class VendorListDTO {
    List<VendorDTO> vendorDTOS;

}
