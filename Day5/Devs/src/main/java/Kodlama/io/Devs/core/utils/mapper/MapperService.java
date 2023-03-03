package Kodlama.io.Devs.core.utils.mapper;

import java.util.List;

public interface MapperService {

    <D, T> D mapForResponse(final T entity, Class<D> outClass);

    <D, T> List<D> mapAllForResponse(final List<T> entityList, Class<D> outCLass);

    <D, T> D mapForRequest(final T entity, Class<D> outClass);

    <D, T> List<D> mapAllForRequest(final List<T> entityList, Class<D> outCLass);

}
