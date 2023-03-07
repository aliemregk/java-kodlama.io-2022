package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.languageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.languageResponses.GetAllLanguageResponse;
import Kodlama.io.Devs.business.responses.languageResponses.GetByIdLanguageResponse;
import Kodlama.io.Devs.business.rules.LanguageBusinessRules;
import Kodlama.io.Devs.core.utils.exceptions.NotFoundException;
import Kodlama.io.Devs.core.utils.mapper.MapperService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;
    private MapperService mapperService;
    private LanguageBusinessRules languageBusinessRules;

    @Override
    public List<GetAllLanguageResponse> getAll() {
        return mapperService.mapAllForResponse(languageRepository.findAll(Sort.by(Sort.Direction.ASC, "id")),
                GetAllLanguageResponse.class);
    }

    @Override
    public GetByIdLanguageResponse getById(int id) {
        Language result = languageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Language not found with given ID."));
        return mapperService.mapForResponse(result, GetByIdLanguageResponse.class);
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) {
        languageBusinessRules.checkIfLanguageExists(createLanguageRequest.getName());

        Language languageToAdd = mapperService.mapForRequest(createLanguageRequest, Language.class);
        languageToAdd.setId(0);
        languageRepository.save(languageToAdd);
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) {
        languageBusinessRules.checkIfLanguageExistsById(updateLanguageRequest.getId());
        languageBusinessRules.checkIfLanguageExists(updateLanguageRequest.getName());

        Language languageToUpdate = mapperService.mapForRequest(updateLanguageRequest, Language.class);
        languageRepository.save(languageToUpdate);
    }

    @Override
    public void delete(int id) {
        languageBusinessRules.checkIfLanguageExistsById(id);
        languageRepository.deleteById(id);
    }

}
