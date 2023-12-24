package com.hackathon.diasporadialog.domain.repositories;

import com.hackathon.diasporadialog.domain.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

}
