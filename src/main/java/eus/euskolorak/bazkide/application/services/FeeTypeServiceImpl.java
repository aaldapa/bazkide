package eus.euskolorak.bazkide.application.services;

import eus.euskolorak.bazkide.application.exceptions.NotFoundException;
import eus.euskolorak.bazkide.application.utils.Messages;
import eus.euskolorak.bazkide.domain.model.FeeType;
import eus.euskolorak.bazkide.domain.ports.in.FeeTypeService;
import eus.euskolorak.bazkide.domain.ports.out.FeeTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author BICUGUAL
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class FeeTypeServiceImpl implements FeeTypeService {

    private static final String ERROR_NOT_FOUND = "error.resource.not.found";

    private final Messages messages;
    private final FeeTypeRepository repository;


    @Override
    public List<FeeType> findAll() {
        return repository.findAll();
    }

    @Override
    public FeeType findById(Long idFeeType) {
        return repository.findById(idFeeType)
                .orElseThrow(() ->
                        new NotFoundException(messages.get(ERROR_NOT_FOUND,new Object[]{ FeeType.class.getSimpleName(), idFeeType })));
    }

    @Override
    public FeeType create(FeeType feeType) {
        return repository.save(feeType);
    }

    @Override
    public FeeType update(FeeType feeType) {

        this.findById(feeType.getIdFeeType());
        return repository.save(feeType);

    }

    @Override
    public void delete(Long idFeeType) {

        Optional.of(this.findById(idFeeType))
                .ifPresent(repository::delete);

    }

}
