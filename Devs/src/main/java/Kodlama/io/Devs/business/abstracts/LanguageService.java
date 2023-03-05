package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.languageRequests.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.languageRequests.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.languageResponses.GetAllLanguageResponse;
import Kodlama.io.Devs.business.responses.languageResponses.GetByIdLanguageResponse;

public interface LanguageService {

    List<GetAllLanguageResponse> getAll();

    GetByIdLanguageResponse getById(int id);

    void add(CreateLanguageRequest createLanguageRequest);

    void update(UpdateLanguageRequest updateLanguageRequest);

    void delete(int id);
}
