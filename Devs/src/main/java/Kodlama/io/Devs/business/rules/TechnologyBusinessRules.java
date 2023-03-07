package Kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.core.utils.exceptions.BusinessException;
import Kodlama.io.Devs.core.utils.exceptions.NotFoundException;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.entities.concretes.Technology;
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
            throw new NotFoundException("Given language does not exist.");
        }
    }

    public void checkIfTechnologyExistsById(int technologyId) {
        if (technologyRepository.findById(technologyId).isEmpty()) {
            throw new NotFoundException("Technology not found with given ID.");
        }
    }

    public void checkIfTechnologyNameChanged(int technologyId, String technologyName) {
        Technology result = technologyRepository.findById(technologyId).orElseThrow();
        if (!result.getName().equals(technologyName)) {
            checkIfTechnologyExists(technologyName);
        }
    }

}
