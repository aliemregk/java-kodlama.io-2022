package Kodlama.io.Devs.core.utils.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MapperUtil implements MapperService {

    private final ModelMapper mapper;

    @Override
    public <D, T> D mapForResponse(final T entity, Class<D> outClass) {
        return mapperForResponse().map(entity, outClass);
    }

    @Override
    public <D, T> List<D> mapAllForResponse(final List<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> mapForResponse(entity, outCLass))
                .collect(Collectors.toList());
    }

    @Override
    public <D, T> D mapForRequest(final T entity, Class<D> outClass) {
        return mapperForRequest().map(entity, outClass);
    }

    @Override
    public <D, T> List<D> mapAllForRequest(final List<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> mapForRequest(entity, outCLass))
                .collect(Collectors.toList());
    }

    private ModelMapper mapperForResponse() {
        mapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return mapper;
    }

    private ModelMapper mapperForRequest() {
        mapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper;
    }
}
