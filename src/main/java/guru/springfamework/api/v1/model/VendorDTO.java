package guru.springfamework.api.v1.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class VendorDTO {
    Long id;
    String name, vendorUrl;
}
