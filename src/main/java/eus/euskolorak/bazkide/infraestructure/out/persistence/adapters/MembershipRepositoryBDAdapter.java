package eus.euskolorak.bazkide.infraestructure.out.persistence.adapters;

import eus.euskolorak.bazkide.domain.model.Membership;
import eus.euskolorak.bazkide.domain.ports.out.MembershipRepository;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.MembershipJpaRepository;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.mappers.MembershipMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author BICUGUAL
 */
@Slf4j
@RequiredArgsConstructor
@Repository
public class MembershipRepositoryBDAdapter implements MembershipRepository {

    private final MembershipJpaRepository jpaMembershipRepository;
    private final MembershipMapper membershipMapper;

    @Override
    public List<Membership> findAll() {

        return membershipMapper.toModels(
                jpaMembershipRepository.findAll(Sort.by("idMembership")));
    }

    @Override
    public Optional<Membership> findById(Long idMembership) {

        return jpaMembershipRepository.findById(idMembership)
                .map(membershipMapper::toModel);
    }

    @Override
    public Membership save(Membership membership) {

        return membershipMapper.toModel(
                jpaMembershipRepository.save(membershipMapper.toEntity(membership)));
    }

    @Override
    public boolean isOrphanMembership(Long idMembership) {

        Long countMembers = jpaMembershipRepository.countMembersInMembership(idMembership);
        return (null == countMembers || countMembers.longValue() <= 0);
    }

    @Override
    public void deleteById(Long idMembership) {

        jpaMembershipRepository.deleteById(idMembership);
    }
}