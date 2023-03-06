package Kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.core.utils.exceptions.BusinessException;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyBusinessRules {

    private TechnologyRepository technologyRepository;
    private LanguageRepository languageRepository;

    public void checkIfTechnologyExists(String technologyName) {
        if (technologyRepository.existsByName(technologyName)) {
            throw new BusinessException("Technology already exists.");
        }
    }

    public void checkIfTechnologysLanguageExists(int languageId) {
        if (languageRepository.findById(languageId).isEmpty()) {
            throw new BusinessException("Given language does not exist.");
        }
    }
}
