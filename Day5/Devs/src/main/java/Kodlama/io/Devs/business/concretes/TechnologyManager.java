package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.technologyRequests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.DeleteTechnologyRequest;
import Kodlama.io.Devs.business.requests.technologyRequests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.languageResponses.GetByIdLanguageResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetAllTechnologyResponse;
import Kodlama.io.Devs.business.responses.technologyResponses.GetByIdTechnologyResponse;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyRepository technologyRepository;
    private LanguageService languageService;

    @Autowired
    public TechnologyManager(TechnologyRepository technologyRepository, LanguageService languageService) {
        this.technologyRepository = technologyRepository;
        this.languageService = languageService;
    }

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<Technology> technologies = this.technologyRepository.findAll();
        List<GetAllTechnologyResponse> technologyResponses = new ArrayList<GetAllTechnologyResponse>();

        for (Technology technology : technologies) {
            GetAllTechnologyResponse response = new GetAllTechnologyResponse(technology.getId(), technology.getName(),
                    technology.getLanguage());
            technologyResponses.add(response);
        }
        return technologyResponses;
    }

    @Override
    public GetByIdTechnologyResponse getById(int id) {
        Optional<Technology> result = this.technologyRepository.findById(id);

        if (result.isPresent()) {
            return new GetByIdTechnologyResponse(result.get().getName(), result.get().getLanguage());
        } else {
            return null;
        }
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) {
        if (this.CheckIfSameNamedTechnologyExists(createTechnologyRequest.getName())
                && this.CheckTechnologyName(createTechnologyRequest.getName())) {

            Technology technologyToAdd = new Technology(0, createTechnologyRequest.getName(),
                    this.getLanguageOfTechnology(createTechnologyRequest.getLanguageId()));
            this.technologyRepository.save(technologyToAdd);
        }
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) {
        if (this.getById(updateTechnologyRequest.getId()) != null) {

            Technology technologyToUpdate = new Technology(updateTechnologyRequest.getId(),
                    updateTechnologyRequest.getName(),
                    this.getLanguageOfTechnology(updateTechnologyRequest.getLanguageId()));
            this.technologyRepository.save(technologyToUpdate);
        }

    }

    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
        if (this.getById(deleteTechnologyRequest.getId()) != null) {
            Technology technologyToDelete = new Technology(deleteTechnologyRequest.getId(), null, null);
            this.technologyRepository.delete(technologyToDelete);
        }
    }

    /*
     * returns the language according to given id
     */
    private Language getLanguageOfTechnology(int languageId) {
        GetByIdLanguageResponse languageResponse = this.languageService.getById(languageId);
        return new Language(languageId, languageResponse.getName(), null);
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
