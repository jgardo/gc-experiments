package com.jgardo.gc.presentation;

import javax.inject.Inject;
import java.util.Optional;
import java.util.logging.Logger;

public class YoungOldGenerationServiceExample {
    public static final Logger LOGGER = Logger.getLogger("nana");

    private final SomeRepository someRepository;
    private final SomeNotifier someNotifier;

    @Inject
    public YoungOldGenerationServiceExample(SomeRepository someRepository, SomeNotifier someNotifier) {
        this.someRepository = someRepository;
        this.someNotifier = someNotifier;
    }

    public Optional<Some> getByParams(Params params) {
        validate(params);

        Some some = someRepository.getByParams(params);

        someNotifier.notify(new SomeEvent("Some event occurs", "Some description of event"));

        return Optional.ofNullable(some);
    }

    private void validate(Params params) {
        if (params.getId() == null) {
            throw new IllegalArgumentException("Params doesn't contain id!");
        }
        if (params.getName() == null) {
            throw new IllegalArgumentException("Params doesn't contain name!");
        }
    }
}

class SomeNotifier {

    void notify(SomeEvent someEvent) {

    }
}


class SomeRepository {

    public Some getByParams(Params params) {
        return new Some();
    }
}


class Params {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Some {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class SomeEvent {
    private final String name;
    private final String description;

    SomeEvent(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
