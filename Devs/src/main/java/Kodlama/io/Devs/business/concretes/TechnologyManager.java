package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.technologyResponses.GetAllTechnologyResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetByIdTechnologyResponse;
import Kodlama.io.Devs.business.rules.TechnologyBusinessRules;
import Kodlama.io.Devs.core.utils.mapper.MapperService;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService {

    private TechnologyRepository technologyRepository;
    private MapperService mapperService;
    private TechnologyBusinessRules technologyBusinessRules;

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        return mapperService.mapAllForResponse(technologyRepository.findAll(Sort.by(Sort.Direction.ASC, "id")),
                GetAllTechnologyResponse.class);
    }

    @Override
    public GetByIdTechnologyResponse getById(int id) {
        Technology result = this.technologyRepository.findById(id).orElseThrow();
        return mapperService.mapForResponse(result, GetByIdTechnologyResponse.class);
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) {

        technologyBusinessRules.checkIfTechnologyExists(createTechnologyRequest.getName());
        technologyBusinessRules.checkIfTechnologysLanguageExists(createTechnologyRequest.getLanguageId());

        Technology technologyToAdd = mapperService.mapForRequest(createTechnologyRequest, Technology.class);
        technologyToAdd.setId(0);
        this.technologyRepository.save(technologyToAdd);
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) {
        Technology technologyToUpdate = mapperService.mapForRequest(updateTechnologyRequest, Technology.class);
        this.technologyRepository.save(technologyToUpdate);
    }

    @Override
    public void delete(int id) {
        this.technologyRepository.deleteById(id);
    }

}
