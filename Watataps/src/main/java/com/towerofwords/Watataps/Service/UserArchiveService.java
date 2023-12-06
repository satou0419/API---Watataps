package com.towerofwords.Watataps.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.towerofwords.Watataps.Entity.UserArchiveEntity;
import com.towerofwords.Watataps.Entity.UserEntity;
import com.towerofwords.Watataps.Entity.WordEntity;
import com.towerofwords.Watataps.Repository.UserRepository;
import com.towerofwords.Watataps.Repository.WordRepository;

@Service
public class UserArchiveService {

    private final UserRepository userRepository;
    private final WordRepository wordRepository;

    public UserArchiveService(UserRepository userRepository, WordRepository wordRepository) {
        this.userRepository = userRepository;
        this.wordRepository = wordRepository;
    }
    
    @Transactional
    public UserEntity addWordToUserArchive(int userId, int wordId) {
        if (userRepository == null || wordRepository == null) {
            return null;
        }

        UserEntity user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            WordEntity word = wordRepository.findById(wordId).orElse(null);

            if (word != null && !user.getUserArchive().getWords().contains(word)) {
                user.getUserArchive().getWords().add(word);
                return userRepository.save(user);
            }
        }

        return null;
    }

    
    @Transactional(readOnly = true)
    public UserArchiveEntity getUserArchive(int userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);

        return user != null ? user.getUserArchive() : null;
    }


}

