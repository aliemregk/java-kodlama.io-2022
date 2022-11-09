package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.languageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.DeleteLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.languageResponses.GetAllLanguageResponse;
import Kodlama.io.Devs.business.responses.languageResponses.GetByIdLanguageResponse;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllLanguageResponse> getAll() {
        List<Language> programmingLangs = this.languageRepository.findAll();
        List<GetAllLanguageResponse> pLangsResponse = new ArrayList<GetAllLanguageResponse>();

        for (Language programmingLang : programmingLangs) {
            GetAllLanguageResponse response = new GetAllLanguageResponse(programmingLang.getId(),
                    programmingLang.getName());
            pLangsResponse.add(response);
        }
        return pLangsResponse;
    }

    @Override
    public GetByIdLanguageResponse getById(int id) {
        Optional<Language> result = this.languageRepository.findById(id);

        if (result.isPresent()) {
            return new GetByIdLanguageResponse(result.get().getName());
        } else {
            return null;
        }
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) {

        // TODO add business rule engine

        if (this.CheckIfSameNamedLanguageExists(createLanguageRequest.getName())
                && this.CheckLanguageName(createLanguageRequest.getName())) {
            Language languageToAdd = new Language(0, createLanguageRequest.getName(), null);
            this.languageRepository.save(languageToAdd);
        }
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) {
        if (this.getById(updateLanguageRequest.getId()) != null
                && this.CheckIfSameNamedLanguageExists(updateLanguageRequest.getName())) {
            Language languageToUpdate = new Language(updateLanguageRequest.getId(), updateLanguageRequest.getName(),
                    null);
            this.languageRepository.save(languageToUpdate);
        }
    }

    @Override
    public void delete(DeleteLanguageRequest deleteLanguageRequest) {
        if (this.getById(deleteLanguageRequest.getId()) != null) {
            this.languageRepository.delete(new Language(deleteLanguageRequest.getId(), null, null));
        }
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
