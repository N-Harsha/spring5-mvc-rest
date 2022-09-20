package guru.springfamework.services;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorListDTO;

import java.util.List;

public interface VendorService {
    List<VendorDTO> getAll();
    VendorDTO getById(Long id);

    VendorDTO saveVendor(VendorDTO vendorDTO,Long id);

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO patchVendor(VendorDTO vendorDTO,Long id);

    void deleteVendor(Long id);
}
