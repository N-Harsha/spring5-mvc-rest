package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.VendorMapper;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.controllers.v1.VendorController;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService{

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public List<VendorDTO> getAll() {
        return vendorRepository.findAll()
                .stream()
                .map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendorUrl("api/v1/vendor/"+vendor.getId());
                    return vendorDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO getById(Long id) {
        return vendorRepository.findById(id).map(vendorMapper::vendorToVendorDTO).orElseThrow(RuntimeException::new);
    }

    @Override
    public VendorDTO saveVendor(VendorDTO vendorDTO, Long id) {
        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
        vendor.setId(id);
        return saveAndReturnDTO(vendor);
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
        return saveAndReturnDTO(vendor);
    }


    private VendorDTO saveAndReturnDTO(Vendor vendor) {
        Vendor savedVendor =  vendorRepository.save(vendor);
        VendorDTO retVendor = vendorMapper.vendorToVendorDTO(savedVendor);
        retVendor.setVendorUrl(VendorController.URL_PATH+"/"+savedVendor.getId());
        return retVendor;
    }

    @Override
    public VendorDTO patchVendor(VendorDTO vendorDTO, Long id) {
        return vendorRepository.findById(id).map(vendor -> {
            VendorDTO savedVendorDTO = vendorMapper.vendorToVendorDTO(vendor);
            if(vendorDTO.getName()!=null)
                savedVendorDTO.setName(vendorDTO.getName());
            return savedVendorDTO;
        }).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
