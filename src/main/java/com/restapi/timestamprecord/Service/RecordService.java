package com.restapi.timestamprecord.Service;

import com.restapi.timestamprecord.Entity.User;
import com.restapi.timestamprecord.Entity.UserRecord;
import com.restapi.timestamprecord.Ripo.UserRecordRepository;
import com.restapi.timestamprecord.Ripo.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RecordService {
    private final UserRecordRepository  userRecordRepository;
    private final UserRepository userRepository;

    public RecordService(UserRecordRepository userRecordRepository, UserRepository userRepository) {
        this.userRecordRepository = userRecordRepository;
        this.userRepository = userRepository;
    }

    public String saveTimestamp(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserRecord userRecord = new UserRecord();
            userRecord.setUserId(userId);
            userRecord.setTimestamp(LocalDateTime.now());
            userRecordRepository.save(userRecord);
            return "Timestamp saved successfully for user ID: " + userId;
        } else {
            return "No user found with ID: " + userId;
        }
    }
}

