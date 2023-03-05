package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.languageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.languageResponses.GetAllLanguageResponse;
import Kodlama.io.Devs.business.responses.languageResponses.GetByIdLanguageResponse;
import Kodlama.io.Devs.core.utils.mapper.MapperService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;
    private MapperService mapperService;

    @Override
    public List<GetAllLanguageResponse> getAll() {
        return mapperService.mapAllForResponse(languageRepository.findAll(), GetAllLanguageResponse.class);
    }

    @Override
    public GetByIdLanguageResponse getById(int id) {
        Language result = this.languageRepository.findById(id).orElseThrow();
        return mapperService.mapForResponse(result, GetByIdLanguageResponse.class);
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) {

        // TODO add business rule engine

        if (this.CheckIfSameNamedLanguageExists(createLanguageRequest.getName())
                && this.CheckLanguageName(createLanguageRequest.getName())) {
            Language languageToAdd = mapperService.mapForRequest(createLanguageRequest, Language.class);
            this.languageRepository.save(languageToAdd);
        }
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) {
        Language languageToUpdate = mapperService.mapForRequest(updateLanguageRequest, Language.class);
        this.languageRepository.save(languageToUpdate);
    }

    @Override
    public void delete(int id) {
        this.languageRepository.deleteById(id);
    }

    /*
     * @param {String} name
     * Checks if there is any language with the given name parameter.
     * If there is, returns false otherwise returns true.
     */
    private boolean CheckIfSameNamedLanguageExists(String name) {
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
    private boolean CheckLanguageName(String name) {
        if (name.isEmpty() || name.isBlank()) {
            return false;
        }
        return true;
    }
}
