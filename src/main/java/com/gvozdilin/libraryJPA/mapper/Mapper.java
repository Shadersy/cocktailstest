package com.gvozdilin.libraryJPA.mapper;

public interface Mapper<E, D> {
    default D toDto(E entity) {
        throw new UnsupportedOperationException();
    }

    default E toEntity(D dto) {
        throw new UnsupportedOperationException();
    }

    default E mergeEntity(E from, E to) {
        throw new UnsupportedOperationException();
    }
}
