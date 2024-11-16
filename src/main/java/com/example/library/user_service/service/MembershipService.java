package com.example.library.user_service.service;

import com.example.library.user_service.model.Membership;
import com.example.library.user_service.repository.MembershipRepository;
import com.example.library.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<Membership> getMembershipById(int membershipId) {
        return membershipRepository.findById(membershipId);
    }

    public Boolean getMembershipStatusByUserId(int userId) {
        return userRepository.findById(userId)
                .map(user -> membershipRepository.findById(user.getUserId())
                        .map(Membership::isActiveStatus).orElse(false))
                .orElse(false);
    }
}
