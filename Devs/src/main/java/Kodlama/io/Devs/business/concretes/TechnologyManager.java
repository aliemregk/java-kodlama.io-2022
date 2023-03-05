package Kodlama.io.Devs.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.technologyResponses.GetAllTechnologyResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetByIdTechnologyResponse;
import Kodlama.io.Devs.core.utils.mapper.MapperService;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService {

    private TechnologyRepository technologyRepository;
    private MapperService mapperService;

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        return mapperService.mapAllForResponse(technologyRepository.findAll(), GetAllTechnologyResponse.class);
    }

    @Override
    public GetByIdTechnologyResponse getById(int id) {
        Technology result = this.technologyRepository.findById(id).orElseThrow();
        return mapperService.mapForResponse(result, GetByIdTechnologyResponse.class);
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) {
        // TODO business rule
        if (this.CheckIfSameNamedTechnologyExists(createTechnologyRequest.getName())
                && this.CheckTechnologyName(createTechnologyRequest.getName())) {
            Technology technologyToAdd = mapperService.mapForRequest(createTechnologyRequest, Technology.class);
            this.technologyRepository.save(technologyToAdd);
        }
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

    /*
     * @param {String} name
     * Checks if there is any technology with the given name parameter.
     * If there is, returns false otherwise returns true.
     */
    private boolean CheckIfSameNamedTechnologyExists(String name) {
        if (this.getAll().stream().anyMatch(pl -> pl.getName().equals(name))) {
            return false;
        }
        return true;
    }

    /*
     * @param {String} name
     * Checks if the given name parameter is empty or blank.
     * If it is, returns false otherwise returns true.
     */
    private boolean CheckTechnologyName(String name) {
        if (name.isEmpty() || name.isBlank()) {
            return false;
        }
        return true;
    }

}
