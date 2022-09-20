package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorListDTO;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.VendorRepository;
import guru.springfamework.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class VendorController {
    public static final String URL_PATH="/api/v1/vendor";
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping({URL_PATH + "s",URL_PATH+"s/"})
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getAllVendors(){
        return new VendorListDTO(vendorService.getAll());
    }

    @GetMapping(URL_PATH+"/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorById(@PathVariable Long id){
        return vendorService.getById(id);
    }

    @PostMapping({URL_PATH,URL_PATH+"/"})
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO){
        return vendorService.createNewVendor(vendorDTO);
    }

    @PutMapping(URL_PATH+"/{id}")
    public VendorDTO updateVendor(@RequestBody VendorDTO vendorDTO,@PathVariable Long id){
        return vendorService.saveVendor(vendorDTO,id);
    }

    @PatchMapping(URL_PATH+"/{id}")
    public VendorDTO pathVendor(@RequestBody VendorDTO vendorDTO,@PathVariable Long id){
        return vendorService.patchVendor(vendorDTO,id);
    }

    @DeleteMapping(URL_PATH+"/{id}")
    public String deleteVendor(@PathVariable Long id){
        vendorService.deleteVendor(id);
        return "Deleted : "+id;
    }
}
