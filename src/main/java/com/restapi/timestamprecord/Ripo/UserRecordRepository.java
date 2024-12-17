package com.restapi.timestamprecord.Ripo;

import com.restapi.timestamprecord.Entity.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {
}
