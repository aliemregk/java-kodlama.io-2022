package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.model.CreateModelRequest;
import kodlama.io.rentACar.business.responses.model.GetAllModelsResponse;

public interface ModelService {

    List<GetAllModelsResponse> getAll();

    void add(CreateModelRequest createBrandRequest);

}
