package kodlama.io.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brand.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brand.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService mapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = this.brandRepository.findAll();
        return brands.stream()
                .map(brand -> mapperService.forResponse().map(brand, GetAllBrandsResponse.class))
                .toList();
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        return mapperService.forResponse().map(brand, GetByIdBrandResponse.class);
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brandToAdd = mapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brandToAdd);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brandToAdd = mapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brandToAdd);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }

}
