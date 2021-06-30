package torukobyte.hrms.core.dtoConverter;

import java.util.List;

public interface DtoConverterService {
    <S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass);

    <T> Object dtoClassConverter(Object source, Class<T> baseClass);
}
