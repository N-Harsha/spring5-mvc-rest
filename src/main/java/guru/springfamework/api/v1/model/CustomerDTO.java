package guru.springfamework.api.v1.model;

import lombok.Data;

@Data
public class CustomerDTO {
    Long id;
    String firstName,lastName;
    String customerUrl;
}
