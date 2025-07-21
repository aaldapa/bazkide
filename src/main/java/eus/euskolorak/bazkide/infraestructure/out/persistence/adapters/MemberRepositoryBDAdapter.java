package eus.euskolorak.bazkide.infraestructure.out.persistence.adapters;

import eus.euskolorak.bazkide.domain.model.Member;
import eus.euskolorak.bazkide.domain.ports.out.MemberRepository;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.MemberJpaRepository;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.MemberEntity;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.mappers.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * @author BICUGUAL
 */
@Slf4j
@RequiredArgsConstructor
@Repository
public class MemberRepositoryBDAdapter implements MemberRepository {

    private final MemberJpaRepository jpaRepository;
    private final MemberMapper mapper;

    @Override
    public List<Member> findByNameOrSurname1(String term) {
        return mapper.toModels(jpaRepository.findMembersByTerm(term));
    }

    @Override
    public Optional<Member> findById(Long idMember) {
        return jpaRepository.findById(idMember)
                .map(mapper::toModel);
    }

    @Override
    public Optional<Member> findByMemberNumber(Long memberNumber) {
        return jpaRepository.findByMemberNumber(memberNumber)
                .map(mapper::toModel);
    }

    @Override
    public List<Member> findByDni(String dni) {
        return mapper.toModels(jpaRepository.findByDniContainingIgnoreCase(dni));
    }

    @Override
    public Member save(Member member) {
        MemberEntity memberEntity = jpaRepository.save(mapper.toEntity(member));
        return mapper.toModel(memberEntity);
    }

    @Override
    public Optional<Long> findMaxMemberNumber() {
        return jpaRepository.findMaxMemberNumber();
    }

    @Override
    public void deleteById(Long idMember) {
        jpaRepository.deleteById(idMember);
    }

}
